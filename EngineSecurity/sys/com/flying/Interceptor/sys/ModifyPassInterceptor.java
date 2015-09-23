package com.flying.Interceptor.sys;

import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
import com.flying.util.MD5;

public class ModifyPassInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_USERINFO.selectById");
		selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
		
		Engine.execute(selfEp);
		
		Map userMap = (Map) selfEp.getResult("data");
		if(userMap.get("PASSWORD").equals(MD5.getMD5(ep.getParam("OLD_PASSWORD").toString()))){
			selfEp = new EngineParameter("T_SYS_USERINFO.update");
			selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
			selfEp.putParam("PASSWORD", ep.getParam("PASSWORD"));
			
			Engine.execute(selfEp);
			
			ep.putResult("data", true);
		}else{
			ep.putResult("data", false);
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
