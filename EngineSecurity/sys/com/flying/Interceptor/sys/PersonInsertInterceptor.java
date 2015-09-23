package com.flying.Interceptor.sys;

import java.util.Date;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class PersonInsertInterceptor extends AbstractInterceptor {

	@Override
	public void after(EngineParameter ep) throws Exception {
		
		String personId = ep.getResult("data").toString();
		
		String personName = ep.getParam("PERSON_NAME").toString();
		EngineParameter selfEp = new EngineParameter("T_SYS_PERSON.getPinyin");
		selfEp.putParam("PERSON_NAME", personName);
		Engine.execute(selfEp);
		String loginName = selfEp.getResult("data").toString();
		
		EngineParameter myEp = new EngineParameter("T_SYS_USERINFO.insert");
		myEp.putParam("USER_ID", personId);
		myEp.putParam("USER_NAME", personName);
		myEp.putParam("LOGIN_NAME", loginName);
		myEp.putParam("PASSWORD", "123456");
		if(ep.getParam("DEPARTMENT_ID") != null){
			myEp.putParam("DEPARTMENT_ID", ep.getParam("DEPARTMENT_ID").toString());
		}
		myEp.putParam("MODIFY_TIME", new Date());
		myEp.putParam("BE_USE", 1);
		myEp.putParam("session", ep.getParam("session"));
		Engine.execute(myEp);
	}

	@Override
	public void before(EngineParameter ep) throws Exception {
		
	}

}
