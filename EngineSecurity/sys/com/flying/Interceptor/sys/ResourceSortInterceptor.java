package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.List;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineIface;
import com.flying.service.EngineParameter;

public class ResourceSortInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		String nodeId = ep.getParam("nodeId") == null ? "" : ep.getParam("nodeId").toString();
		String oldNodeId = ep.getParam("oldNodeId") == null ? "" : ep.getParam("oldNodeId").toString();
		String newNodeId = ep.getParam("newNodeId") == null ? "" : ep.getParam("newNodeId").toString();
		String beforeNodeId = ep.getParam("beforeNodeId") == null ? "" : ep.getParam("beforeNodeId").toString();
		String afterNodeId = ep.getParam("afterNodeId") == null ? "" : ep.getParam("afterNodeId").toString();
		int sortNum = ep.getParam("SORT_NUM") == null ? 0 : Integer.parseInt(ep.getParam("SORT_NUM").toString());
		
		//节点调整了父节点
		if(!oldNodeId.equals(newNodeId)){
			EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.update");
			selfEp.putParam("RESOURCE_ID", nodeId);
			selfEp.putParam("PID", newNodeId);
			Engine.execute(selfEp);
		}
		
		List<EngineParameter> listEp = new ArrayList<EngineParameter>();
		if(!"".equals(beforeNodeId)){
			String[] beforeNodeArray = beforeNodeId.split("-");
			for(int i = 0;i<beforeNodeArray.length;i++){
				EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.updateSort");
				selfEp.putParam("RESOURCE_ID", beforeNodeArray[i]);
				selfEp.putParam("SORT_NUM", sortNum - beforeNodeArray.length + i);
				listEp.add(selfEp);
			}
		}
		
		if(!"".equals(afterNodeId)){
			String[] afterNodeArray = afterNodeId.split("-");
			for(int i = 0;i<afterNodeArray.length;i++){
				EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.updateSort");
				selfEp.putParam("RESOURCE_ID", afterNodeArray[i]);
				selfEp.putParam("SORT_NUM", sortNum + i + 1);
				listEp.add(selfEp);
			}
		}
		
		Engine.batchExecute(listEp, EngineIface.UPDATE);
		
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}

}
