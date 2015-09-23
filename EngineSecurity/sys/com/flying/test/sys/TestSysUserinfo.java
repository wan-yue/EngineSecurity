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

public class TestSysUserinfo {
	private static String USER_ID = null;
	private static Map<String, Object> sysUserinfoMap = new HashMap<String, Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysUserinfoMap.put("USER_NAME",
				"芦挫盂柜账晕舅眩呕庇廖底沪妒烹祈碎霹寂玻恐丈恳短菜硼轻恶孽饯闲官逾讥卑棍叼驶楞氦螟顶耶宪秉氏揩胁辖肝");
		sysUserinfoMap.put("LOGIN_NAME", "扦诬僧盟项究猩嘱呵裔铣瞻挂账芥笋孽吩制渝");
		sysUserinfoMap.put("PASSWORD", "123456");
		sysUserinfoMap.put("EXPIRED", new Date());
		sysUserinfoMap.put("BE_USE", 1836394151);
		sysUserinfoMap.put("MODIFY_TIME", new Date());
		sysUserinfoMap.put("DEPARTMENT_ID", 407107827);
		sysUserinfoMap.put("STATE", -94974163);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysUserinfoMap = null;
	}

	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.insert");
		ep.setParamMap(sysUserinfoMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		USER_ID = (String) ep.getResult("data");
		Assert.assertTrue(USER_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.selectById");
		ep.putParam("USER_ID", USER_ID);

		Engine.execute(ep);

		Assert.assertTrue(((Map) ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserinfoMap.get("USER_NAME"),
				((Map) ep.getResult("data")).get("USER_NAME"));
		Assert.assertEquals(sysUserinfoMap.get("LOGIN_NAME"),
				((Map) ep.getResult("data")).get("LOGIN_NAME"));
		Assert.assertEquals(sysUserinfoMap.get("PASSWORD"),
				((Map) ep.getResult("data")).get("PASSWORD"));
		Assert.assertTrue(((Date) sysUserinfoMap.get("EXPIRED")).getTime()
				- ((Date) ((Map) ep.getResult("data")).get("EXPIRED"))
						.getTime() < 1000);
		Assert.assertEquals(sysUserinfoMap.get("BE_USE"),
				((Map) ep.getResult("data")).get("BE_USE"));
		Assert.assertTrue(((Date) sysUserinfoMap.get("MODIFY_TIME")).getTime()
				- ((Date) ((Map) ep.getResult("data")).get("MODIFY_TIME"))
						.getTime() < 1000);
		Assert.assertEquals(sysUserinfoMap.get("DEPARTMENT_ID"),
				((Map) ep.getResult("data")).get("DEPARTMENT_ID"));
		Assert.assertEquals(sysUserinfoMap.get("STATE"),
				((Map) ep.getResult("data")).get("STATE"));

	}

	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.update");
		sysUserinfoMap.put("USER_ID", USER_ID);
		sysUserinfoMap.put("USER_NAME",
				"褪割溉诵恨昼刀揉惺蒸纫封壶费伎契七抉喘起挚艾庙兴跺跪荡谎犬昏涨毯普募虐冤逝耀矗剔裁饰驴人凸偶抱氰道策");
		sysUserinfoMap.put("LOGIN_NAME", "欺瑰硫怜鹊辈伪褒肺社绢毁售诫拆色台婶共鸡");
		sysUserinfoMap.put("PASSWORD", "654321");
		sysUserinfoMap.put("EXPIRED", new Date());
		sysUserinfoMap.put("BE_USE", 490203794);
		sysUserinfoMap.put("MODIFY_TIME", new Date());
		sysUserinfoMap.put("DEPARTMENT_ID", -1812983772);
		sysUserinfoMap.put("STATE", -551601495);

		ep.setParamMap(sysUserinfoMap);

		Engine.execute(ep);
	}

	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.selectById");
		ep.putParam("USER_ID", USER_ID);

		Engine.execute(ep);

		Assert.assertTrue(((Map) ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserinfoMap.get("USER_NAME"),
				((Map) ep.getResult("data")).get("USER_NAME"));
		Assert.assertEquals(sysUserinfoMap.get("LOGIN_NAME"),
				((Map) ep.getResult("data")).get("LOGIN_NAME"));
		Assert.assertEquals(sysUserinfoMap.get("PASSWORD"),
				((Map) ep.getResult("data")).get("PASSWORD"));
		Assert.assertTrue(((Date) sysUserinfoMap.get("EXPIRED")).getTime()
				- ((Date) ((Map) ep.getResult("data")).get("EXPIRED"))
						.getTime() < 1000);
		Assert.assertEquals(sysUserinfoMap.get("BE_USE"),
				((Map) ep.getResult("data")).get("BE_USE"));
		Assert.assertTrue(((Date) sysUserinfoMap.get("MODIFY_TIME")).getTime()
				- ((Date) ((Map) ep.getResult("data")).get("MODIFY_TIME"))
						.getTime() < 1000);
		Assert.assertEquals(sysUserinfoMap.get("DEPARTMENT_ID"),
				((Map) ep.getResult("data")).get("DEPARTMENT_ID"));
		Assert.assertEquals(sysUserinfoMap.get("STATE"),
				((Map) ep.getResult("data")).get("STATE"));

	}

	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.selectAll");
		String filter = "&ROLE_NAME& LIKE '%"
				+ sysUserinfoMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}

	@Test
	public void testDelete() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.delete");
		ep.putParam("USER_ID", USER_ID);
		Engine.execute(ep);
	}

	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.selectById");
		ep.putParam("USER_ID", USER_ID);

		Engine.execute(ep);

		Assert.assertTrue(((Map) ep.getResult("data")).size() == 0);
	}
}
