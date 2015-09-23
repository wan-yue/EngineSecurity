package com.flying.Interceptor.sys;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class SyncUserInfoInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		if(ep.getParam("USER_NAME") != null && ep.getParam("SYSC_STOP") == null){
			EngineParameter selfEp = new EngineParameter("T_SYS_PERSON.update");
			selfEp.putParam("PERSON_ID", ep.getParam("USER_ID"));
			selfEp.putParam("PERSON_NAME", ep.getParam("USER_NAME"));
			selfEp.putParam("SYSC_STOP", true);
			
			Engine.execute(selfEp);
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
