package com.flying.Interceptor.sys;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class PersonDeleteInterceptor extends AbstractInterceptor {

	@Override
	public void after(EngineParameter ep) throws Exception {		
		EngineParameter myEp = new EngineParameter("T_SYS_USERINFO.delete");
		myEp.putParam("USER_ID", ep.getParam("PERSON_ID"));
		
		Engine.execute(myEp);
	}

	@Override
	public void before(EngineParameter ep) throws Exception {
		
	}

}
