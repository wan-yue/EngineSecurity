package com.flying.Interceptor.sys;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.init.StaticVariable;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
/**
 * 
 * <B>描述：</B>获取GIS图层资源信息<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class GetGisMessageInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		String userId = ep.getParam("USER_ID") == null ? "" : ep.getParam("USER_ID").toString();
		if(!"".equals(userId)){
			EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCE.getGisResrource");
			selfEp.putParam("USER_ID", userId);
			Engine.execute(selfEp);
			
			ep.putResult("resource", selfEp.getResult("data"));
		}
	}

}
