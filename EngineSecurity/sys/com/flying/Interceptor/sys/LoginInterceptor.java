package com.flying.Interceptor.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.init.StaticVariable;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
import com.flying.util.MD5;
/**
 * <B>描述：</B>登陆拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class LoginInterceptor extends AbstractInterceptor {
	//用户sesion关系
	private static final Map<String,String> UserSessionMap = new Hashtable();
	
	@Override
	public void before(EngineParameter ep)throws Exception{
		String loginName = ep.getParam("LOGIN_NAME")==null?null:ep.getParam("LOGIN_NAME").toString();
		EngineParameter selfEp = new EngineParameter("T_SYS_USERINFO.validateLoginName");
		selfEp.putParam("LOGIN_NAME", loginName);
		Engine.execute(selfEp);
		
		int num = (Integer)selfEp.getResult("data");
		
		if(num == 0){
			throw new FlyingException("不存在的用户名，请重新输入！");
		}
		
		String password = ep.getParam("PASSWORD")==null?null:ep.getParam("PASSWORD").toString();
		if(password != null && !"".equals(password)){
			password = MD5.getMD5(password);
		}	
		ep.putParam("PASSWORD", password);
		
	}
	@Override
	public void after(EngineParameter ep) throws Exception{
		
		String initPasswd = "1234567";//prop.get("user.initPassword").toString();
		initPasswd = MD5.getMD5(initPasswd);
		
		int flag = 1;
		Map resultObject = (Map)ep.getResult("data");
		if(resultObject.size() == 0){
			throw new FlyingException("密码错误，请重新输入！");
		}else if(Integer.parseInt(resultObject.get("BE_USE").toString()) == 0){
			throw new FlyingException("用户名被禁用！");
		}else if(resultObject.get("PASSWORD").equals(initPasswd)){
			throw new FlyingException("密码为初始密码，请进行进行密码修改！");
		}else if(resultObject.get("EXPIRED") != null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date expired = format.parse(resultObject.get("EXPIRED").toString());
			if(expired.getTime()< (new Date()).getTime()){
				throw new FlyingException("用户名已经过期！");
			}else{
				HttpSession session = ep.getParam("session") == null ?null:(HttpSession)ep.getParam("session");
				if(session != null){
					session.setAttribute("USERINFO", resultObject);
					ep.setRedirectPageName("desktop.html");
					//ep.setRedirectPageName("viewport.html");
				}else{
					throw new FlyingException("paramMap没有session信息！");
				}
			}
		}else{
			HttpSession session = ep.getParam("session") == null ?null:(HttpSession)ep.getParam("session");
			if(session != null){
				session.setAttribute("USERINFO", resultObject);
				ep.setRedirectPageName("desktop.html");
				//ep.setRedirectPageName("viewport.html");
			}else{
				throw new FlyingException("paramMap没有session信息！");
			}
		}
	}
}
