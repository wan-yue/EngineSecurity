package com.flying.Interceptor.sys;

import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
/**
 * <B>描述：</B>读取消息拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class ReadMessageInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {

	}

	@Override
	public void after(EngineParameter ep) throws Exception {
		EngineParameter selfEp = new EngineParameter("T_SYS_MESSAGE.selectById");
		selfEp.putParam("MSG_ID", ep.getParam("MSG_ID"));
		Engine.execute(selfEp);
		
		Map msgObj = (Map) selfEp.getResult("data");
		
		String msgToken = msgObj.get("MSG_TOKEN")==null?"":msgObj.get("MSG_TOKEN").toString();
		if(!"".equals(msgToken)){
			selfEp = new EngineParameter("T_SYS_MESSAGE.readSameMessage");
			selfEp.putParam("MSG_TOKEN", msgToken);
			
			Engine.execute(selfEp);
		}
	}

}
