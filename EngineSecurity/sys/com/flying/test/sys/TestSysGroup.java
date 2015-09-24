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

public class TestSysGroup {
	private static String GROUP_USER_ID = null;
	private static Map<String,Object> sysGroupMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysGroupMap.put("GROUP_ID", "司臻艰吏填郝淫樊恤救振庇僧愤娃符胡艺慈贤捆向浴膳桂说柬蚁肩恐槐柒傍纫鼎无联沫靛截胜酞结列痉篮守鳞觅闯");
sysGroupMap.put("USER_ID", "寅液越脉笆舀乱巍庞懂溯差窄凄稠攘穴哦靖寐潜躯迪赣谢亭惜芋疙隋丙止撼级晴骡潭刊腻畏呀卖毯津贩醚庭吴宇晾");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysGroupMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GROUP_USER.insert");
		ep.setParamMap(sysGroupMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		GROUP_USER_ID = (String) ep.getResult("data");
		Assert.assertTrue(GROUP_USER_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GROUP_USER.selectById");
		ep.putParam("GROUP_USER_ID", GROUP_USER_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysGroupMap.get("GROUP_ID"), ((Map)ep.getResult("data")).get("GROUP_ID"));
Assert.assertEquals(sysGroupMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GROUP_USER.update");
		sysGroupMap.put("GROUP_USER_ID", GROUP_USER_ID);
		sysGroupMap.put("GROUP_ID", "侍燥攀绵汝毒偿吏蔽脾赐伞嘿协父叙依彰范娘乞房患福酣泞杏傈涪祁飞懒冉缝僵亿乏掀缎摔葛残诗管喧银靡恼厂猪");
sysGroupMap.put("USER_ID", "鹏系胀含幽智洽黄酪属幌强明汐缘骆沉姐咋樟凰拘庸志捻等仁驼铁皆雷季秋镣虾存竞两纹谁统懊鳃犹笆跋泉俩邱兽");

		
		ep.setParamMap(sysGroupMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GROUP_USER.selectById");
		ep.putParam("GROUP_USER_ID", GROUP_USER_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysGroupMap.get("GROUP_ID"), ((Map)ep.getResult("data")).get("GROUP_ID"));
Assert.assertEquals(sysGroupMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GROUP_USER.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysGroupMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_GROUP_USER.delete");
		ep.putParam("GROUP_USER_ID", GROUP_USER_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GROUP_USER.selectById");
		ep.putParam("GROUP_USER_ID", GROUP_USER_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
