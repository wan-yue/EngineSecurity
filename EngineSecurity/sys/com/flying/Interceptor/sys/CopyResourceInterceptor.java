package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class CopyResourceInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		String templateRoleIds = ep.getParam("PKVALUES") == null ? "" : ep.getParam("PKVALUES").toString();
		
		String[] templateRoleIdArray = templateRoleIds.split(",");
		List<Map> newResources = new ArrayList();
		
		EngineParameter selfEp = null;
		for(int i =0;i<templateRoleIdArray.length;i++){
			selfEp = new EngineParameter("T_SYS_RESOURCEROLE.selectByFk");
			selfEp.putParam("ROLE_ID", templateRoleIdArray[i]);
			Engine.execute(selfEp);
			newResources.addAll((List<Map>) selfEp.getResult("data"));
		}
		
		StringBuilder resourceIds = new StringBuilder();
		for(int j =0;j<newResources.size();j++){
			resourceIds.append(newResources.get(j).get("RESOURCE_ID")+",");
		}
		
		
		selfEp = new EngineParameter("T_SYS_RESOURCEROLE.insertByTree");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		selfEp.putParam("resourceIds", resourceIds.toString());
		
		Engine.execute(selfEp);
	}

	@Override
	public void after(EngineParameter ep) throws Exception {

	}

}
