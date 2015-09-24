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

public class TestSysGb18030 {
	private static String ID = null;
	private static Map<String,Object> sysGb18030Map  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysGb18030Map.put("PINYIN", "娥眼静皂豁暴姥绕惭芬铬圃陇盖仇啥剁绘灵范右涡垣脐他镊萍符玛软");
sysGb18030Map.put("HANZI", "猫谗督盟喧弥胀窜惯毙既纬告讶拷掏昆特欺睁肢顷挑剪诣令摇褐绊厩");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysGb18030Map = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB18030.insert");
		ep.setParamMap(sysGb18030Map);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		ID = (String) ep.getResult("data");
		Assert.assertTrue(ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB18030.selectById");
		ep.putParam("ID", ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysGb18030Map.get("PINYIN"), ((Map)ep.getResult("data")).get("PINYIN"));
Assert.assertEquals(sysGb18030Map.get("HANZI"), ((Map)ep.getResult("data")).get("HANZI"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB18030.update");
		sysGb18030Map.put("ID", ID);
		sysGb18030Map.put("PINYIN", "刹豁闽圣儿峦首飞弥唱累铜弧千哼非扶炽绸编向周济咬酞淑馆篡研级");
sysGb18030Map.put("HANZI", "鄂信僚睁嚣访混剪芥眼鲁召纫邮汛烧缄丛涸晰吁侗凤梆黍龚慷毕唯醋");

		
		ep.setParamMap(sysGb18030Map);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB18030.selectById");
		ep.putParam("ID", ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysGb18030Map.get("PINYIN"), ((Map)ep.getResult("data")).get("PINYIN"));
Assert.assertEquals(sysGb18030Map.get("HANZI"), ((Map)ep.getResult("data")).get("HANZI"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB18030.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysGb18030Map.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_GB18030.delete");
		ep.putParam("ID", ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB18030.selectById");
		ep.putParam("ID", ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
