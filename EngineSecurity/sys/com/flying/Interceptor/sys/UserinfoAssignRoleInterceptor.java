package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineIface;
import com.flying.service.EngineParameter;
/**
 * 
 * <B>描述：</B>给用户分配角色<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class UserinfoAssignRoleInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep) throws Exception{
		EngineParameter selfEp = new EngineParameter("T_SYS_USERROLE.selectByFk");
		selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
		Engine.execute(selfEp);
		
		List<Map> olderRoles = (List<Map>) selfEp.getResult("data");
		String[] newRoles = new String[0];
		
		String roleIds = ep.getParam("ROLE_ID") == null?"":ep.getParam("ROLE_ID").toString();
		if(roleIds.length()>0){
			newRoles = roleIds.split(",");
		}
		
		List<String> addRoles = new ArrayList();//增加的用户
		List<String> deleteRoles = new ArrayList();//减少的用户
		
		for(int m = 0;m<newRoles.length;m++){
			int mark = 0;
			for(int n = 0;n<olderRoles.size();n++){
				if(olderRoles.get(n).get("ROLE_ID").toString().equals(newRoles[m])){
					break;
				}else{
					mark++;
				}
			}
			
			if(mark == olderRoles.size()){
				addRoles.add(newRoles[m]);
			}
		}
		
		for(int i = 0;i<olderRoles.size();i++){
			int mark = 0;
			for(int j = 0;j<newRoles.length;j++){
				if(olderRoles.get(i).get("ROLE_ID").toString().equals(newRoles[j])){
					break;
				}else{
					mark++;
				}
			}
			
			if(mark == newRoles.length){
				deleteRoles.add(olderRoles.get(i).get("ROLE_ID").toString());
			}
		}
		
		selfEp = new EngineParameter("T_SYS_USERRESOURCE.selectResourceByUserIdByGroup");
		selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
		Engine.execute(selfEp);
		
		List<Map> addUserResources = (List<Map>) selfEp.getResult("data");
		Map resourceFaceMap = new HashMap();
		
		for(int t =0; t < addUserResources.size() ;t++){
			resourceFaceMap.put(addUserResources.get(t).get("RESOURCE_ID"), addUserResources.get(t).get("FACETYPE"));
		}
		
		List<EngineParameter> list1Ep = new ArrayList<EngineParameter>();
		for(int m =0;m<addRoles.size();m++){
			selfEp = new EngineParameter("T_SYS_USERROLE.insert");
			selfEp.putParam("ROLE_ID", addRoles.get(m));
			selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
			Engine.execute(selfEp);
			
			selfEp = new EngineParameter("T_SYS_ROLE.update");
			selfEp.putParam("ROLE_ID", addRoles.get(m));
			Engine.execute(selfEp);
			
			
			selfEp = new EngineParameter("T_SYS_RESOURCE.selectByRoleId");
			selfEp.putParam("ROLE_ID", addRoles.get(m));
			Engine.execute(selfEp);
			
			List<Map> resourceMaps = (List<Map>) selfEp.getResult("data");
			for(int i=0;i<resourceMaps.size();i++){
				EngineParameter sub1Ep = new EngineParameter("T_SYS_USERRESOURCE.insert");
				sub1Ep.putParam("USER_ID", ep.getParam("USER_ID"));
				sub1Ep.putParam("RESOURCE_ID", resourceMaps.get(i).get("RESOURCE_ID"));
				sub1Ep.putParam("ROLE_ID", addRoles.get(m));
				if(resourceFaceMap.containsKey(resourceMaps.get(i).get("RESOURCE_ID"))){
					sub1Ep.putParam("FACETYPE", resourceFaceMap.get(resourceMaps.get(i).get("RESOURCE_ID")));
				}else{
					sub1Ep.putParam("FACETYPE", resourceMaps.get(i).get("FACETYPE"));
				}
				sub1Ep.putParam("DESKTOP", 0);
				sub1Ep.putParam("ICON", resourceMaps.get(i).get("ICON"));
				sub1Ep.putParam("SORT_NUM",1);
				
				list1Ep.add(sub1Ep);
			}
		}
		
		if(list1Ep.size() > 0){
			Engine.batchExecute(list1Ep, EngineIface.INSERT);
		}
		
		for(int m =0;m<deleteRoles.size();m++){
			selfEp = new EngineParameter("T_SYS_USERROLE.delete");
			selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
			selfEp.putParam("ROLE_ID", deleteRoles.get(m));
			Engine.execute(selfEp);
			
			selfEp = new EngineParameter("T_SYS_ROLE.update");
			selfEp.putParam("ROLE_ID", deleteRoles.get(m));
			Engine.execute(selfEp);
			
			selfEp = new EngineParameter("T_SYS_USERRESOURCE.delete");
			selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
			selfEp.putParam("ROLE_ID", deleteRoles.get(m));
			Engine.execute(selfEp);
		}
	}
	@Override
	public void after(EngineParameter ep) throws Exception{
		//修改用户的状态
		EngineParameter selfEp = new EngineParameter("T_SYS_USERINFO.update");
		selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
		Engine.execute(selfEp);
	}
}
