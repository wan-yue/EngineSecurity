package com.flying.message;

import java.util.Map;

import com.flying.logging.Log;
import com.flying.logging.LogFactory;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
/**
 * <B>描述：</B>提醒操作类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class FlyingTask {
	
	private static Log log = LogFactory.getLog(FlyingTask.class);// 日志
	/**
	 * 添加任务,当“任务名称”，“任务对应的页面地址”相同时，认为是同一任务
	 * 
	 * @author zdf
	 * 
	 * @param name 任务名称
	 * @param addr 任务对应的页面地址
	 * @param userId 任务接受人
	 */
	public static void send(final String name,final String addr,final String userId){
		Thread t = new Thread(new Runnable(){
			@Override
			public void run(){
				try {
					FlyingTask.addTask(name,addr,userId);
				} catch (Exception e) {
					log.error("添加提醒出错", e);
				}
			}
		});
		
		t.start();
	}
	/**
	 * 删除任务，当“任务名称”，“任务对应的页面地址”相同时，认为是同一任务
	 * 
	 * @param name 任务名称
	 * @param addr 任务对应的页面地址
	 * @param userId 任务接受人
	 */
	public static void delete(final String name,final String addr,final int userId){
		Thread t = new Thread(new Runnable(){
			@Override
			public void run(){
				try {
					FlyingTask.removeTask(name,addr,userId);
				} catch (Exception e) {
					log.error("删除提醒出错", e);
				}
			}
		});
		
		t.start();
	}
	
	private static synchronized void addTask(String name,String addr,String userId) throws Exception{
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.selectByUserIdAndAddr");
		ep.putParam("SYS_NAME", name);
		ep.putParam("LINK_ADDR", addr);
		ep.putParam("USER_ID", userId);

		Engine.execute(ep);
		
		Map result = (Map) ep.getResult("data");
		if(result.size()>0){//如果已经存在，待办任务数量++
			ep = new EngineParameter("T_SYS_REMIND.update");
			ep.putParam("SYS_NAME", name);
			ep.putParam("LINK_ADDR", addr);
			ep.putParam("USER_ID", userId);
			ep.putParam("REMIND_ID", result.get("REMIND_ID"));
			ep.putParam("REMIND_SIZE", Integer.parseInt(result.get("REMIND_SIZE").toString())+1);
			
		}else{//如果不存在，添加待办任务，待办任务数量为1
			ep = new EngineParameter("T_SYS_REMIND.insert");
			ep.putParam("SYS_NAME", name);
			ep.putParam("LINK_ADDR", addr);
			ep.putParam("USER_ID", userId);
			ep.putParam("REMIND_SIZE", 1);
			ep.setCommandType(null);
		}
		
		Engine.execute(ep);
	}
	
	private static synchronized void removeTask(String name,String addr,int userId) throws Exception{
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.selectByUserIdAndAddr");
		ep.putParam("SYS_NAME", name);
		ep.putParam("LINK_ADDR", addr);
		ep.putParam("USER_ID", userId);
		//根据用户及地址查询待办任务
		Engine.execute(ep);
		
		Map result = (Map) ep.getResult("data");
		if(result.size()>0){//如果存在，执行下面操作
			int remindSize = Integer.parseInt(result.get("REMIND_SIZE").toString());
			
			if(remindSize > 1){//如果待办任务数量大于1，则待办数量--
				ep = new EngineParameter("T_SYS_REMIND.update");
				ep.putParam("SYS_NAME", name);
				ep.putParam("LINK_ADDR", addr);
				ep.putParam("USER_ID", userId);
				ep.putParam("REMIND_ID", result.get("REMIND_ID"));
				ep.putParam("REMIND_SIZE", remindSize - 1 );
				ep.setCommandType(null);
			}else{//如果待办任务数量不大于1，则删除待办任务
				ep = new EngineParameter("T_SYS_REMIND.delete");
				ep.putParam("SYS_NAME", name);
				ep.putParam("LINK_ADDR", addr);
				ep.putParam("USER_ID", userId);
				ep.putParam("REMIND_ID", result.get("REMIND_ID"));
				ep.setCommandType(null);
			}
			
			Engine.execute(ep);
		}
	}
}
