package com.flying.Interceptor.sys;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class PersonUpdateInterceptor extends AbstractInterceptor {

	@Override
	public void after(EngineParameter ep) throws Exception {
		if(ep.getParam("PERSON_NAME") != null && ep.getParam("SYSC_STOP") == null){
			EngineParameter selfEp = new EngineParameter("T_SYS_USERINFO.update");
			selfEp.putParam("USER_ID", ep.getParam("PERSON_ID"));
			selfEp.putParam("USER_NAME", ep.getParam("PERSON_NAME"));
			selfEp.putParam("SYSC_STOP", true);
			
			Engine.execute(selfEp);
		}
	}

	@Override
	public void before(EngineParameter ep) throws Exception {
		
	}

}
