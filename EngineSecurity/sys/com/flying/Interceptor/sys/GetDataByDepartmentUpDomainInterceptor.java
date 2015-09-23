package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class GetDataByDepartmentUpDomainInterceptor extends AbstractInterceptor {
	
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
				
				sql.append(" LEFT JOIN RYJBQK B ON A.USER_ID = B.RYBM ");
				
				EngineParameter selfEp = new EngineParameter("ZZJGXX.selectById");
				selfEp.putParam("ZZJGDM", userInfo.get("ZZJGDM").toString());
				Engine.execute(selfEp);
				
				List<Map> departments = getParentDepartment((Map)selfEp.getResult("data"));
				departments.add((Map)selfEp.getResult("data"));
				
				StringBuilder deptStr = new StringBuilder();
				for(int i = 0; i < departments.size();i++){
					deptStr.append("'" + departments.get(i).get("ZZJGDM") + "',");
				}
				
				sql.append("WHERE B.ZZJGDM IN ("+deptStr.substring(0,deptStr.length()-1)+")");
				
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
	
	private List<Map> getParentDepartment(Map deptMap) throws Exception{
		List<Map> parentDepts = new ArrayList<Map>();
		
		if("0".equals(deptMap.get("SJZZJGDM"))){
			parentDepts.add(deptMap);
		}else{
			EngineParameter selfEp = new EngineParameter("ZZJGXX.selectById");
			selfEp.putParam("ZZJGDM", deptMap.get("SJZZJGDM"));
			Engine.execute(selfEp);
			
			parentDepts.add((Map) selfEp.getResult("data"));
			parentDepts.addAll(getParentDepartment((Map) selfEp.getResult("data")));
		}
		
		return parentDepts;
	}
}