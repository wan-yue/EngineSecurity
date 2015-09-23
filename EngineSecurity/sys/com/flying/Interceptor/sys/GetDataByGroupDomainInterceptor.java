package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class GetDataByGroupDomainInterceptor extends AbstractInterceptor {
	
	@Override
	public void before(EngineParameter ep) throws Exception {
		
		HttpSession session = ep.getParam("session") == null ?null:(HttpSession)ep.getParam("session");
		if(session != null){
			Map userInfo = (Map)session.getAttribute("USERINFO");
			
			String pk = "";
			boolean isDomain = false;
			String command = ep.getCommand();
			String tablename = command.substring(0, command.indexOf("."));
			
			if(ep.getResult("filterDomainName") != null){
				pk = ep.getResult("filterDomainName").toString();
				isDomain = true;
			}else{
				

				EngineParameter selfEp = new EngineParameter("oracle.selectFieldByBmc");
				selfEp.putParam("BMC", tablename);
				Engine.execute(selfEp);
				
				List<HashMap> fieldList = (List<HashMap>) selfEp.getResult("data");
				for(int i =0;i<fieldList.size();i++){
					Map fieldMap = fieldList.get(i);
					if("P".equals(fieldMap.get("ZDXZ"))){
						pk = fieldMap.get("ZDMC").toString();
					}
					
					if("USER_ID".equals(fieldMap.get("ZDMC"))){
						isDomain = true;
					}
				}
			}

			if(isDomain){
				StringBuilder sql = new StringBuilder( "SELECT A." + pk +" FROM " + tablename +" A ");
				
				sql.append(" LEFT JOIN T_SYS_GROUP_USER B ON A.USER_ID = B.USER_ID ");
				
				EngineParameter selfEp = new EngineParameter("T_SYS_GROUP_USER.selectByFk");
				selfEp.putParam("USER_ID", userInfo.get("USER_ID"));
				Engine.execute(selfEp);
				
				List<HashMap> groupList = (List<HashMap>) selfEp.getResult("data");
				
				List<HashMap> allGroupList = new ArrayList();
				
				for(int i =0;i<groupList.size();i++){
					Map groupMap = groupList.get(i);
					allGroupList.addAll(getAllGroup(groupMap.get("GROUP_ID").toString()));
				}
				
				allGroupList.addAll(groupList);
				
				StringBuilder groupStr = new StringBuilder();
				
				for(int i = 0; i < allGroupList.size();i++){
					groupStr.append("'" + allGroupList.get(i).get("GROUP_ID") + "',");
				}
				
				String gstr = "";
				if(groupStr.length() > 0){
					gstr = groupStr.substring(0, groupStr.length() - 1);
				}
				
				sql.append(" WHERE B.GROUP_ID IN (" + gstr + ")");
				
				selfEp = new EngineParameter("init.execute");
				selfEp.setCommandType("list");
				selfEp.putParam("sql", sql.toString());
				Engine.execute(selfEp);
				
				List<Map> pkList = (List<Map>)selfEp.getResult("data");
				
				if(ep.getResult("filterDomainName") != null){
					pkList.addAll((List<Map>)ep.getResult("filterDomainList"));
				}else{
					ep.putResult("filterDomainName", pk);
				}
				
				ep.putResult("filterDomainList", pkList);
			}
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		
	}
	
	private List<HashMap> getAllGroup(String pid) throws Exception{
		List<HashMap> groups = new ArrayList<HashMap>();
		
		EngineParameter selfEp = new EngineParameter("T_SYS_GROUP.selectByPid");
		selfEp.putParam("PID", pid);
		Engine.execute(selfEp);
		
		List<HashMap> resultGroups = (List<HashMap>) selfEp.getResult("data");
		
		if(resultGroups.size() > 0){
			groups.addAll(resultGroups);
			for(int i = 0;i < resultGroups.size() ;i++){
				Map groupMap = resultGroups.get(i);
				groups.addAll(getAllGroup(groupMap.get("PID").toString()));
			}
		}
		
		return groups;
	}
}