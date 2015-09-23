package com.flying.Interceptor.sys;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class GroupUserInsertInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {
		
		if( ep.getParam("userIds") != null ){
			String groupId = ep.getParam("GROUP_ID").toString();
			EngineParameter selfEp = new EngineParameter("T_SYS_GROUP_USER.deleteByGroupId");
			selfEp.putParam("GROUP_ID", groupId);
			Engine.execute(selfEp);
			
			String userIds = ep.getParam("userIds").toString();
			String[] userArray = userIds.split(",");
			selfEp = new EngineParameter("T_SYS_GROUP_USER.insert");
			for(int i =0;i<userArray.length;i++){
				selfEp.putParam("GROUP_ID", groupId);
				selfEp.putParam("USER_ID", userArray[i]);
				Engine.execute(selfEp);
			}
			ep.setBreak(true);
		}
	}

	@Override
	public void after(EngineParameter ep) throws Exception {

	}

}
