package com.flying.Interceptor.sys;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
import com.flying.util.FlyingUtil;

public class UserResourceUpdateInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		HttpSession session = (HttpSession)ep.getParam("session");
		Map userinfo = session.getAttribute("USERINFO") == null?null:(Map)session.getAttribute("USERINFO");
		ep.putParam("USER_ID", userinfo.get("USER_ID"));
		
		EngineParameter selfEp = new EngineParameter("T_SYS_USERRESOURCE.selectByFk");
		selfEp.putParam("USER_ID", userinfo.get("USER_ID"));
		selfEp.putParam("RESOURCE_ID", ep.getParam("RESOURCE_ID"));
		Engine.execute(selfEp);
		
		List<Map> list = (List<Map>) selfEp.getResult("data");
		//相当深拷贝
		FlyingUtil.change(list.get(0),ep.getParamMap());
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
