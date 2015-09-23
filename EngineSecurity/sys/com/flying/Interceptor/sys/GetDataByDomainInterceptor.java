package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class GetDataByDomainInterceptor extends AbstractInterceptor {
	
	@Override
	public void before(EngineParameter ep) throws Exception {
		if(ep.getResult("filterDomainName") != null){
			String pk = ep.getResult("filterDomainName").toString();
			List<Map> domainList = (List<Map>)ep.getResult("filterDomainList");
			
			StringBuilder pstr = new StringBuilder();
			String p = "";
			
			for(int i=0;i<domainList.size();i++){
				Map domainMap = domainList.get(i);
				pstr.append("'" + domainMap.get(pk) + "',");
			}
			
			if(pstr.length() > 0){
				p = pstr.substring(0, pstr.length()-1);
			}
			String filter = null;
			if(ep.getParam("filter") != null && ep.getParam("filter").toString().length() > 0){
				filter = ep.getParam("filter").toString() + "AND " +  pk + " IN ("+ p +")";
			}else{
				filter =  pk + " IN ("+ p +")";
			}
			
			ep.putParam("filter", filter);
			
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		if(ep.getResult("filterDomainName") != null){
			ep.removeResult("filterDomainName");
			ep.removeResult("filterDomainList");
		}
	}
}
