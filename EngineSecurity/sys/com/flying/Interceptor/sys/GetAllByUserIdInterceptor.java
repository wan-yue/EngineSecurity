package com.flying.Interceptor.sys;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.init.StaticVariable;
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
public class GetAllByUserIdInterceptor extends AbstractInterceptor {

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

				ep.putParam("filter", filter);
			}
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
