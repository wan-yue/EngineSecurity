package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineIface;
import com.flying.service.EngineParameter;

public class ResourceRoleInsertByTreeInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCEROLE.selectByFk");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		Engine.execute(selfEp);
		List<Map> oldResources = (List<Map>) selfEp.getResult("data");
		
		String resourceIds = ep.getParam("resourceIds") == null?"":ep.getParam("resourceIds").toString();
		String[] newResources = new String[0];
		if(resourceIds.length()>0){
			newResources = resourceIds.split(",");
		}
		
		List<String> addResources = new ArrayList();//增加的资源
		List<String> deleteResources = new ArrayList();//减少的资源
		
		for(int m = 0;m<newResources.length;m++){
			int mark = 0;
			for(int n = 0;n<oldResources.size();n++){
				if(oldResources.get(n).get("RESOURCE_ID").toString().equals(newResources[m])){
					break;
				}else{
					mark++;
				}
			}
			
			if(mark == oldResources.size()){
				addResources.add(newResources[m]);
			}
		}
		
		for(int i = 0;i<oldResources.size();i++){
			int mark = 0;
			for(int j = 0;j<newResources.length;j++){
				if(oldResources.get(i).get("RESOURCE_ID").toString().equals(newResources[j])){
					break;
				}else{
					mark++;
				}
			}
			
			if(mark == newResources.length){
				deleteResources.add(oldResources.get(i).get("RESOURCE_ID").toString());
			}
		}
		
		selfEp = new EngineParameter("T_SYS_USERROLE.selectByFk");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		Engine.execute(selfEp);
		
		List<Map> userList = (List<Map>) selfEp.getResult("data");
		
		List<EngineParameter> list1Ep = new ArrayList<EngineParameter>();
		List<EngineParameter> list2Ep = new ArrayList<EngineParameter>();

		for(int m = 0;m<addResources.size();m++){
			selfEp = new EngineParameter("T_SYS_RESOURCE.selectById");
			selfEp.putParam("RESOURCE_ID", addResources.get(m));
			Engine.execute(selfEp);
			Map resourceMap = (Map) selfEp.getResult("data");
			
			EngineParameter sub1Ep = new EngineParameter("T_SYS_RESOURCEROLE.insert");
			sub1Ep.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
			sub1Ep.putParam("RESOURCE_ID", addResources.get(m));
			
			list1Ep.add(sub1Ep);
			
			for(int i=0;i<userList.size();i++){
				EngineParameter sub2Ep = new EngineParameter("T_SYS_USERRESOURCE.insert");
				sub2Ep.putParam("USER_ID", userList.get(i).get("USER_ID"));
				sub2Ep.putParam("RESOURCE_ID", addResources.get(m));
				sub2Ep.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
				sub2Ep.putParam("FACETYPE", resourceMap.get("FACETYPE"));
				sub2Ep.putParam("DESKTOP", 0);
				sub2Ep.putParam("ICON", resourceMap.get("ICON"));
				sub2Ep.putParam("SORT_NUM",1);
				
				list2Ep.add(sub2Ep);
			}
		}
		
		if(list1Ep.size() > 0){
			Engine.batchExecute(list1Ep, EngineIface.INSERT);
		}
		
		if(list2Ep.size() > 0){
			Engine.batchExecute(list2Ep, EngineIface.INSERT);
		}
		
		list1Ep.clear();
		list2Ep.clear();
		for(int m = 0;m<deleteResources.size();m++){
			EngineParameter sub1Ep = new EngineParameter("T_SYS_RESOURCEROLE.delete");
			sub1Ep.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
			sub1Ep.putParam("RESOURCE_ID", deleteResources.get(m));
			
			list1Ep.add(sub1Ep);
			
			for(int i=0;i<userList.size();i++){
				EngineParameter sub2Ep = new EngineParameter("T_SYS_USERRESOURCE.delete");
				sub2Ep.putParam("USER_ID", userList.get(i).get("USER_ID"));
				sub2Ep.putParam("RESOURCE_ID", deleteResources.get(m));
				sub2Ep.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
				
				list2Ep.add(sub2Ep);
			}
		}
		
		if(list1Ep.size() > 0){
			Engine.batchExecute(list1Ep, EngineIface.DELETE);
		}
		
		if(list2Ep.size() > 0){
			Engine.batchExecute(list2Ep, EngineIface.DELETE);
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_ROLE.update");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		Engine.execute(selfEp);
	}

}
