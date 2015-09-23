package com.flying.Interceptor.sys;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
import com.flying.util.MD5;
/**
 * 
 * <B>描述：</B>用户更新<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class UserinfoUpdateInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep) throws Exception{
		//获取原来的用户
		EngineParameter selfEp = new EngineParameter("T_SYS_USERINFO.selectById");
		selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
		Engine.execute(selfEp);
		Map oldUser = (Map)selfEp.getResult("data");

		//修改部门
		if(ep.getParam("DEPARTMENT_ID") != null && !ep.getParam("DEPARTMENT_ID").toString().matches("\\d*")){
			ep.putParam("DEPARTMENT_ID",null);
		}
		//将界面不处理的属性进行赋值
		ep.putParam("MODIFY_TIME", new Timestamp(System.currentTimeMillis()));
		//处理密码:与原来不同，说明进过了修改，之后加密存入
		if(ep.getParam("PASSWORD")!= null){
			String password = ep.getParam("PASSWORD").toString();
			if(oldUser.get("PASSWORD") == null){
				ep.putParam("PASSWORD", MD5.getMD5(password));
			}else if(!password.equals(oldUser.get("PASSWORD").toString())){
				ep.putParam("PASSWORD", MD5.getMD5(password));
			}
		}
		
		//当用户选择不可用时
		if(ep.getParam("BE_USE")!= null){
			int beUse = Integer.parseInt(ep.getParam("BE_USE").toString());
			if(beUse ==  0){
				ep.putParam("STATE", 1);
			}else{
				ep.putParam("STATE", 4);
			}
		}
		//过去时间
		if(Integer.parseInt(ep.getParam("STATE").toString()) > 2 && ep.getParam("EXPIRED")!= null && !"".equals(ep.getParam("EXPIRED").toString())){
			Date expired = (Date)ep.getParam("EXPIRED");
			
			if(expired.getTime()<(new Date()).getTime())
	   		 {
				ep.putParam("STATE", 3);
	   		 }else {
	   			ep.putParam("STATE", 4);
			}
		}
		
		if(Integer.parseInt(ep.getParam("STATE").toString()) > 2){
			//判断角色信息
			selfEp = new EngineParameter("T_SYS_ROLE.getAllRolesByUserId");
			selfEp.putParam("USER_ID", ep.getParam("USER_ID"));
			Engine.execute(selfEp);
			List list = (List)selfEp.getResult("data");
			if(list.size() == 0){
				ep.putParam("STATE", 2);
			}
		}
	}
	@Override
	public void after(EngineParameter ep){	
	}
}
