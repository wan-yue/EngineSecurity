package com.flying.Interceptor.sys;

import java.util.List;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

/**
 * <B>描述：</B>资源更新<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class RoleUpdateInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep) throws Exception{
		//根据是否可以，设置状态
		if(Integer.parseInt(ep.getParam("BE_USE").toString()) == 0){
			ep.putParam("STATE", 1);
		}else{
			ep.putParam("STATE", 3);
		}
		//判断是否分配资源
		if(Integer.parseInt(ep.getParam("STATE").toString()) > 1){
			//判断角色信息
			EngineParameter selfEp = new EngineParameter("T_SYS_RESOURCEROLE.selectByFk");
			selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
			Engine.execute(selfEp);
			List list = (List)selfEp.getResult("data");
			if( list.size() == 0 ){
				ep.putParam("STATE", 2);
			}else{
				ep.putParam("STATE", 3);
			}
		}
	}
	@Override
	public void after(EngineParameter ep){	
	}
}
