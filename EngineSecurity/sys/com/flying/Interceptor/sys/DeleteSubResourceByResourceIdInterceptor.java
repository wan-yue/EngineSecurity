package com.flying.Interceptor.sys;

import java.util.List;
import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class DeleteSubResourceByResourceIdInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.selectById");
		selfEp.putParam("RESOURCE_ID", ep.getParam("RESOURCE_ID"));
		Engine.execute(selfEp);
		
		Map  resourceMap = (Map) selfEp.getResult("data");
		String resourceCode = resourceMap.get("RESOURCE_CODE").toString();
		selfEp = new EngineParameter("T_SYS_RESOURCE.deleteByCode");
		selfEp.putParam("RESOURCE_CODE", resourceCode+"_%");
		Engine.execute(selfEp);
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
