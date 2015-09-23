package com.flying.Interceptor.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.service.EngineParameter;
import com.flying.util.MD5;
/**
 * <B>描述：</B>webservice登陆拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * 
 * @author zdf
 *
 */
public class WsLoginInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep)throws Exception{
		
	}
	@Override
	public void after(EngineParameter ep) throws Exception{
		
		int flag = 1;
		Map resultObject = (Map)ep.getResult("data");
		if(resultObject.size() == 0){
			throw new FlyingException("无效用户名或者密码，请重新输入！");
		}else if(Integer.parseInt(resultObject.get("BE_USE").toString()) == 0){
			throw new FlyingException("用户名被禁用！");
		}else if(resultObject.get("EXPIRED") != null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date expired = format.parse(resultObject.get("EXPIRED").toString());
			if(expired.getTime()< (new Date()).getTime()){
				throw new FlyingException("用户名已经过期！");
			}
		}
	}
}
