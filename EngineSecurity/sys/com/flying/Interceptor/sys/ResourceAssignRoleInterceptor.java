package com.flying.Interceptor.sys;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

/**
 * 
 * <B>描述：</B>给资源分配角色<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class ResourceAssignRoleInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep){
	}
	@Override
	public void after(EngineParameter ep)throws Exception{
		//修改角色的状态
		EngineParameter selfEp = new EngineParameter("Sys_Role.update");
		selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
		Engine.execute(selfEp);
	}
}
