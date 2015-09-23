package com.flying.Interceptor.sys;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class DepartmentGetTreeForRoleInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_DEPARTMENT.selectAllList");
		
		Engine.execute(selfEp);
		
		JSONArray arr = (JSONArray) selfEp.getResult("data");
		
		JSONObject obj1 = new JSONObject();
		obj1.put("id", "39A03AE81AED4CE08D7E4F9F52BF7BF1");
		obj1.put("text", "未分配部门");
		obj1.put("orderId","100");
		obj1.put("leaf",true);
		obj1.put("draggable",false);
		
		JSONObject obj2 = new JSONObject();
		obj2.put("id", "AEEFA72B530A46A9B2A4D5386B05F1E8");
		obj2.put("text", "角色模板");
		obj2.put("orderId","101");
		obj2.put("leaf",true);
		obj2.put("draggable",false);
		
		arr.add(obj1);
		arr.add(obj2);
		
		ep.putResult("data", arr);
		
		
	}	
}
