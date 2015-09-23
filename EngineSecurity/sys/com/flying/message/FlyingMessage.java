package com.flying.message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.flying.init.StaticVariable;
import com.flying.logging.Log;
import com.flying.logging.LogCache;
import com.flying.logging.LogFactory;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
/**
 * 
 * <B>描述：</B>发送消息类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class FlyingMessage {	
	
	private static Log log = LogFactory.getLog(FlyingMessage.class);// 日志
	/**
	 * 发送消息
	 * 
	 * @author zdf
	 * 
	 * @param title 标题
	 * @param addr 链接地址
	 * @param addrParam 链接地址参数
	 * @param senderId 发送人
	 * @param recipientId 接收人
	 * @param shortSysName 系统简称
	 * @param token 发给同一角色的相同消息
	 */
	public static void send(final String threadId,final String title,final String addr,final Map addrParam,final String senderId,final String recipientId,final String shortSysName,final int isView,final String token){
		Thread t = new Thread(new Runnable(){
			@Override
			public void run(){
				try {
					String newSenderId = senderId;
					if(StaticVariable.LOG){
						if(!LogCache.THREAD_INFO.containsKey(threadId)){
							log.error("日志线程池中，没有ID是 " + threadId +" 的线程！");
							return;
						}else{
							Map userLog = LogCache.THREAD_INFO.get(threadId);
							if(newSenderId == null){
								newSenderId = userLog.get("USER_ID").toString();
							}
						}
					}
					FlyingMessage.addMessage(title,addr,addrParam,newSenderId,recipientId,shortSysName,isView,token);
				} catch (Exception e) {
					log.error("添加消息出错", e);
				}
			}
		});
		
		t.start();
	}
	
	private static boolean addMessage(String title,String addr,Map addrParam,String senderId,String recipientId,String shortSysName,int isView,String token) throws Exception{
		boolean mark = true;
		
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.insert");
		ep.putParam("MSG_TITLE", title);
		ep.putParam("MSG_ADDR", addr);
		ep.putParam("MSG_RECIPIENT", recipientId);
		ep.putParam("MSG_SENDER", senderId);
		ep.putParam("SEND_DATE", new Date());
		ep.putParam("SYS_NAME",shortSysName);
		ep.putParam("IS_VIEW", isView);
		ep.putParam("MSG_TOKEN",token);
		
		if(addr == null){
			isView = 1;//无需查看详情
		}
		
		if(addrParam == null){
			addrParam = new HashMap();
		}
		
		JSONObject jsonObj = JSONObject.fromObject(addrParam);
		ep.putParam("MSG_ADDR_PARAM", jsonObj.toString());
		
		Engine.execute(ep);
		
		if(ep.getResult("data") == null || "".equals(ep.getResult("data").toString())){
			mark = false;
		}
		
		return mark;
	}
}
