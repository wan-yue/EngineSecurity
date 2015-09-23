package com.flying.Interceptor.sys;

import java.util.List;
import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class DeleteSubResourceByAddrInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.selectByAddr");
		selfEp.putParam("RESOURCE_ADDR", ep.getParam("RESOURCE_ADDR"));
		Engine.execute(selfEp);
		
		List<Map>  resourceList = (List<Map>) selfEp.getResult("data");
		for(int i=0;i<resourceList.size();i++){
			Map resource = resourceList.get(i);
			String resourceCode = resource.get("RESOURCE_CODE").toString();
			selfEp = new EngineParameter("T_SYS_RESOURCE.deleteByCode");
			selfEp.putParam("RESOURCE_CODE", resourceCode+"_%");
			Engine.execute(selfEp);
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
