package com.flying.Interceptor.sys;

import java.util.HashMap;
import java.util.List;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.EngineParameter;
/**
 * <B>描述：</B>部门处理拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class DepartmentInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep){
		
	}
	@Override
	public void after(EngineParameter ep){
		String query = ep.getParam("query")==null?null:ep.getParam("query").toString();
		String mark = ep.getParam("mark")==null?null:ep.getParam("mark").toString();
		List<HashMap> resultList = (List<HashMap>) ep.getResult("data");
		if(mark != null &&(query == null || "".equals(query)) && resultList != null){
			//添加全部和未分配部门
			HashMap hm1 = new HashMap();
			hm1.put("DEPARTMENT_ID", "0");
			hm1.put("DEPARTMENT_NAME", "全部");
			resultList.add(0,hm1);
			HashMap hm2 = new HashMap();
			hm2.put("DEPARTMENT_ID", "-1");
			hm2.put("DEPARTMENT_NAME", "未分配");
			resultList.add(1,hm2);
			ep.putResult("data", resultList);
		}
	}
}
