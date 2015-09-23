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
 * <B>描述：</B>给角色分配用户<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class RoleAssignUserinfoInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep) throws Exception{
		EngineParameter selfEp = new EngineParameter("T_SYS_USERROLE.selectByFk");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		Engine.execute(selfEp);
		List<Map> olderUsers = (List<Map>) selfEp.getResult("data");
		String[] newUsers = new String[0];
		
		String userIds = ep.getParam("USER_ID") == null?"":ep.getParam("USER_ID").toString();
		if(userIds.length()>0){
			newUsers = userIds.split(",");
		}
		
		List<String> addUsers = new ArrayList();//增加的用户
		List<String> deleteUsers = new ArrayList();//减少的用户
		
		for(int m = 0;m<newUsers.length;m++){
			int mark = 0;
			for(int n = 0;n<olderUsers.size();n++){
				if(olderUsers.get(n).get("USER_ID").toString().equals(newUsers[m])){
					break;
				}else{
					mark++;
				}
			}
			
			if(mark == olderUsers.size()){
				addUsers.add(newUsers[m]);
			}
		}
		
		for(int i = 0;i<olderUsers.size();i++){
			int mark = 0;
			for(int j = 0;j<newUsers.length;j++){
				if(olderUsers.get(i).get("USER_ID").toString().equals(newUsers[j])){
					break;
				}else{
					mark++;
				}
			}
			
			if(mark == newUsers.length){
				deleteUsers.add(olderUsers.get(i).get("USER_ID").toString());
			}
		}
		
		List<EngineParameter> list1Ep = new ArrayList<EngineParameter>();
		
		selfEp = new EngineParameter("T_SYS_RESOURCE.selectByRoleId");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		Engine.execute(selfEp);
		
		List<Map> resourceMaps = (List<Map>) selfEp.getResult("data");
		
		for(int m =0;m<addUsers.size();m++){
			selfEp = new EngineParameter("T_SYS_USERROLE.insert");
			selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
			selfEp.putParam("USER_ID", addUsers.get(m));
			Engine.execute(selfEp);
			
			selfEp = new EngineParameter("T_SYS_USERINFO.update");
			selfEp.putParam("USER_ID", addUsers.get(m));
			Engine.execute(selfEp);
			
			selfEp = new EngineParameter("T_SYS_USERRESOURCE.selectResourceByUserIdByGroup");
			selfEp.putParam("USER_ID", addUsers.get(m));
			Engine.execute(selfEp);
			
			List<Map> addUserResources = (List<Map>) selfEp.getResult("data");
			Map resourceFaceMap = new HashMap();
			
			for(int t =0; t < addUserResources.size() ;t++){
				resourceFaceMap.put(addUserResources.get(t).get("RESOURCE_ID"), addUserResources.get(t).get("FACETYPE"));
			}
			
			for(int i=0;i<resourceMaps.size();i++){
				EngineParameter sub1Ep = new EngineParameter("T_SYS_USERRESOURCE.insert");
				sub1Ep.putParam("USER_ID", addUsers.get(m));
				sub1Ep.putParam("RESOURCE_ID", resourceMaps.get(i).get("RESOURCE_ID"));
				sub1Ep.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
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
		
		for(int m =0;m<deleteUsers.size();m++){
			selfEp = new EngineParameter("T_SYS_USERROLE.delete");
			selfEp.putParam("USER_ID", deleteUsers.get(m));
			selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
			Engine.execute(selfEp);
			
			selfEp = new EngineParameter("T_SYS_USERINFO.update");
			selfEp.putParam("USER_ID", deleteUsers.get(m));
			Engine.execute(selfEp);
			
			selfEp = new EngineParameter("T_SYS_USERRESOURCE.delete");
			selfEp.putParam("USER_ID", deleteUsers.get(m));
			selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
			Engine.execute(selfEp);
		}
	}
	@Override
	public void after(EngineParameter ep) throws Exception{
		//修改用户的状态
		EngineParameter selfEp = new EngineParameter("T_SYS_ROLE.update");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		Engine.execute(selfEp);
	}
}
