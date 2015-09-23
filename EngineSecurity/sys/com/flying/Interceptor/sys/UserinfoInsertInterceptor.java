package com.flying.Interceptor.sys;

import java.util.Date;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.EngineParameter;
import com.flying.util.MD5;
/**
 * 
 * <B>描述：</B>插入用户,在添加一个用户的时候，对输入数据进行预处理（密码MD5加密，账号有效期，账号创建时间，用户状态）<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class UserinfoInsertInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep) throws Exception{
		//处理密码
		if(ep.getParam("PASSWORD")!= null){
			String password = ep.getParam("PASSWORD").toString();
			ep.putParam("PASSWORD", MD5.getMD5(password));
		}else{
			ep.putParam("PASSWORD", MD5.getMD5("123456"));
		}
		//处理过期时间
		if(ep.getParam("EXPIRED") != null && "".equals(ep.getParam("EXPIRED").toString())){
			ep.putParam("EXPIRED",null);
			
		}
		//添加修改时间
		if(ep.getParam("MODIFY_TIME") == null){
			ep.putParam("MODIFY_TIME", new Date());
		}

		//处理状态
		if(ep.getParam("BE_USE")!= null){
			int beUse = Integer.parseInt(ep.getParam("BE_USE").toString());
			if(beUse ==  0){
				ep.putParam("STATE", 1);
			}else{
				ep.putParam("STATE", 2);
			}
		}
	}
	@Override
	public void after(EngineParameter ep) throws Exception{	
	}
}
