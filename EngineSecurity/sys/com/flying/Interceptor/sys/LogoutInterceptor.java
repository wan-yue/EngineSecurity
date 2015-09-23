package com.flying.Interceptor.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.init.StaticVariable;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
import com.flying.util.MD5;
/**
 * <B>描述：</B>登出拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class LogoutInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep)throws Exception{
		
	}
	@Override
	public void after(EngineParameter ep) throws Exception{
		Map map = StaticVariable.SESSIONS;
		HttpSession session = ep.getParam("session") == null ?null:(HttpSession)ep.getParam("session");
		if(session != null){
			session.invalidate();
			ep.setRedirectPageName("login.html");
		}else{
			throw new FlyingException("paramMap没有session信息！");
		}
	}
}
