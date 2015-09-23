package com.flying.Interceptor.sys;

import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class SelectSubMenuInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.selectById");
		selfEp.putParam("RESOURCE_ID", ep.getParam("RESOURCE_ID"));
		Engine.execute(selfEp);
		
		Map resMap = (Map) selfEp.getResult("data");
		
		String resCode = resMap.get("RESOURCE_CODE").toString()+"_%";
		
		ep.putParam("RESOURCE_CODE", resCode);
	}

	@Override
	public void after(EngineParameter ep) throws Exception {

	}

}
