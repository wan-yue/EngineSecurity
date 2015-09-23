package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineIface;
import com.flying.service.EngineParameter;
import com.flying.util.FlyingUtil;
/**
 * 
 * <B>描述：</B>插入资源拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class ResourceInsertInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		synchronized (this) {
			EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.selectById");
			selfEp.putParam("RESOURCE_ID", ep.getParam("PID"));
			Engine.execute(selfEp);
			
			String resourceCode = ((Map)selfEp.getResult("data")).get("RESOURCE_CODE").toString();
			
			if(resourceCode.length()>1){
				resourceCode += "___";
			}else{
				resourceCode = "___";
			}
			
			selfEp = new EngineParameter("T_SYS_RESOURCE.selectMaxCode");
			selfEp.putParam("RESOURCE_CODE", resourceCode);
			Engine.execute(selfEp);

			long maxCode;
			if(!(selfEp.getResult("data") instanceof Map)){
				maxCode = Long.parseLong(selfEp.getResult("data").toString()) + 1;
			}else{
				maxCode = Long.parseLong(resourceCode.substring(0,resourceCode.length()-3) + "100");
			}
			
			if(FlyingUtil.validateNull(ep.getParam("RESOURCE_ADDR"))){
				ep.putParam("RESOURCE_ADDR", ep.getParam("RESOURCE_ADDR").toString().trim());
			}
			
			if(FlyingUtil.validateNull(ep.getParam("SECURITY_NAME"))){
				ep.putParam("SECURITY_NAME", ep.getParam("SECURITY_NAME").toString().trim());
			}
			
			if(FlyingUtil.validateNull(ep.getParam("FACETYPE"))){
				ep.putParam("FACETYPE", ep.getParam("FACETYPE").toString().trim());
			}
			
			ep.putParam("RESOURCE_CODE", maxCode+"");
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
	}

}
