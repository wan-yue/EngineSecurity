package com.flying.Interceptor.sys;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.init.StaticVariable;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class GetAllMenuInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		HttpSession session = ep.getParam("session") == null ?null:(HttpSession)ep.getParam("session");

		if(StaticVariable.AUTHENTICATION){
			if(session == null){
				throw new FlyingException("无法获取session信息！");
			}else{
				Map userInfo = (Map)session.getAttribute("USERINFO");
				
				String filter = ep.getParam("filter") == null ? "":ep.getParam("filter").toString();
				if("".equals(filter)){
					filter = "USER_ID='" + userInfo.get("USER_ID") + "'";
				}else{
					filter +=  " AND USER_ID='" + userInfo.get("USER_ID") + "'";
				}

				String resourceId = ep.getParam("RESOURCE_ID") == null ? "":ep.getParam("RESOURCE_ID").toString();
				if(!"".equals(resourceId)){
					filter +=  " AND (PID='" + resourceId + "' OR RESOURCE_ID = '"+ resourceId +"')";
				}
				
				ep.putParam("filter", filter);
			}
		}else{
			if(session != null && session.getAttribute("USERINFO") != null){
				Map userInfo = (Map)session.getAttribute("USERINFO");
				
				String filter = ep.getParam("filter") == null ? "":ep.getParam("filter").toString();
				if("".equals(filter)){
					filter = "USER_ID='" + userInfo.get("USER_ID") + "'";
				}else{
					filter +=  " AND USER_ID='" + userInfo.get("USER_ID") + "'";
				}
				
				String resourceId = ep.getParam("RESOURCE_ID") == null ? "":ep.getParam("RESOURCE_ID").toString();
				if(!"".equals(resourceId)){
					filter +=  " AND (PID='" + resourceId + "' OR RESOURCE_ID = '"+ resourceId +"')";
				}
				
				ep.putParam("filter", filter);
			}else{
				ep.setSpace(true);
				
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
				for(int i = 0;i<allMenu.size();i++){
					allMenu.get(i).put("DESKTOP", 1);
				}
				
				allMenu.addAll(listRoot);
				
				ep.putResult("data", allMenu);
			}
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
