package com.flying.Interceptor.sys;

import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.init.StaticVariable;
import com.flying.logging.LogCache;
import com.flying.message.FlyingMessage;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class AddUserRoleMsgInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		
	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		if(StaticVariable.LOG){
			EngineParameter selfEp = new EngineParameter("T_SYS_ROLE.selectById"); 
			selfEp.putParam("ROLE_ID", ep.getParam("ROLE_ID"));
			Engine.execute(selfEp);
			
			Map roleMap = (Map) selfEp.getResult("data");
			
			String title = "你获得一个新角色("+roleMap.get("ROLE_NAME")+")";
			String recipientId = ep.getParam("USER_ID").toString();
			String shortSysName = "权限";
			
			FlyingMessage.send(Thread.currentThread().getId()+"",title, null, null, null, recipientId, shortSysName,1, null);
		}else{
			log.debug("日志未打开，无法获取发送人ID!");
		}
	}

}