package com.flying.test.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class TestSysUserrole {
	private static String USER_ROLE_ID = null;
	private static Map<String,Object> sysUserroleMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysUserroleMap.put("USER_ID", "味蜘赡咆侗题评例必登似怨逛蹭电吐悼凉眉表竟汝宾靛涪莉蓖键丑宋旺苫飘敏逼兑苔毙省征乃融枚辩闪嗽埃穆爹释");
sysUserroleMap.put("ROLE_ID", "速坝脓拾空痪玖怂补秸舵土捧承嗓孤哼情具映碾辰腻惑游盅门形俩省瀑纷锁加占敛帚巾金顾毅涉骆序哺该诌呛鸯各");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysUserroleMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERROLE.insert");
		ep.setParamMap(sysUserroleMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		USER_ROLE_ID = (String) ep.getResult("data");
		Assert.assertTrue(USER_ROLE_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERROLE.selectById");
		ep.putParam("USER_ROLE_ID", USER_ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserroleMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));
Assert.assertEquals(sysUserroleMap.get("ROLE_ID"), ((Map)ep.getResult("data")).get("ROLE_ID"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERROLE.update");
		sysUserroleMap.put("USER_ROLE_ID", USER_ROLE_ID);
		sysUserroleMap.put("USER_ID", "姬妊顶诬凄蜒联哲逊雄斟袁配锭谓碱柳疤减焉麻毋斜仿腆轿育铁虚刁个催时洪差滴寥所川刑屹阔拨橡间仿腆酵萝锄");
sysUserroleMap.put("ROLE_ID", "篱拌偶悠丈野泪被将勺断为假贩汪窟湛砌绕拷深傍阐膀混迎赁维氦亿廉婚回冶斩焕配滇实寨禽闷蝉筏陶我浦起食辖");

		
		ep.setParamMap(sysUserroleMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERROLE.selectById");
		ep.putParam("USER_ROLE_ID", USER_ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserroleMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));
Assert.assertEquals(sysUserroleMap.get("ROLE_ID"), ((Map)ep.getResult("data")).get("ROLE_ID"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERROLE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysUserroleMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_USERROLE.delete");
		ep.putParam("USER_ROLE_ID", USER_ROLE_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERROLE.selectById");
		ep.putParam("USER_ROLE_ID", USER_ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
