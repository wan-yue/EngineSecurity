package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.init.StaticVariable;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
/**
 * 
 * <B>描述：</B>获取提醒任务拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class GetSecurityInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		HttpSession session = ep.getParam("session") == null ?null:(HttpSession)ep.getParam("session");
		if(StaticVariable.AUTHENTICATION){
			if(session == null){
				throw new FlyingException("无法获取session信息！");
			}else{
				Map userInfo = (Map)session.getAttribute("USERINFO");
				
				ep.putParam("USER_ID",userInfo.get("USER_ID"));
			}
		}else{
			if(session != null && session.getAttribute("USERINFO") != null){
				Map userInfo = (Map)session.getAttribute("USERINFO");
				
				ep.putParam("USER_ID",userInfo.get("USER_ID"));
			}else{
				EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.selectSome");
				selfEp.putParam("RESOURCE_ADDR", StaticVariable.MODULE);
				selfEp.putParam("FACETYPE", "subSystem");
				Engine.execute(selfEp);
				List<Map> listRoot = (List<Map>) selfEp.getResult("data");
				
				selfEp = new EngineParameter("T_SYS_RESOURCE.selectSome");
				selfEp.putParam("RESOURCE_TYPE_ID", "19AADE52436C4FA99BC3B9897E7B9408");
				selfEp.putParam("PID", listRoot.get(0).get("RESOURCE_ID"));
				Engine.execute(selfEp);
				
				List<Map> allMenu = (List<Map>) selfEp.getResult("data");
				
				StringBuilder menuIds = new StringBuilder();
				for(int i =0;i<allMenu.size();i++){
					Map menuMap = allMenu.get(i);
					menuIds.append("'"+menuMap.get("RESOURCE_ID")+"',");
				}
				
				if(menuIds.length() > 0){
					String filter = " PID IN ("+ menuIds.substring(0, menuIds.length() - 1 )+")";
					ep.putParam("filter", filter);
				}
			}
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		List<Map> securityList = (List<Map>) ep.getResult("data");
		
		List<String> securityButtons = new ArrayList();
		List<String> securityColumns = new ArrayList();
		
		for(int i=0;i<securityList.size();i++){
			Map securityMap = securityList.get(i);
			if("61505B4AD5A443CD8D230F95B21012BB".equals(securityMap.get("RESOURCE_TYPE_ID").toString()) ){
				securityButtons.add(securityMap.get("SECURITY_NAME").toString());
			}else if("AEFA83E468A84650BCDF6A10464FEEA2".equals(securityMap.get("RESOURCE_TYPE_ID").toString()) ){
				securityColumns.add(securityMap.get("SECURITY_NAME").toString());
			}
		}
		
		ep.removeResult("data");
		ep.putResult("buttons", securityButtons);
		ep.putResult("columns", securityColumns);
	}

}
