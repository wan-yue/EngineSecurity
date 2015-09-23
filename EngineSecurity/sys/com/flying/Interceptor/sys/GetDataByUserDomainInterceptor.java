package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class GetDataByUserDomainInterceptor extends AbstractInterceptor {
	
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
				StringBuilder sql = new StringBuilder("SELECT A." + pk +" FROM " + tablename + " A WHERE A.USER_ID= '"+ userInfo.get("USER_ID")+"'");
				
				EngineParameter selfEp = new EngineParameter("init.execute");
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
}