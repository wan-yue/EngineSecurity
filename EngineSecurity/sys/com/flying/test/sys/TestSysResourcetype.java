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

public class TestSysResourcetype {
	private static String RESOURCE_TYPE_ID = null;
	private static Map<String,Object> sysResourcetypeMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysResourcetypeMap.put("RESOURCE_TYPE_NAME", "蔗荧坦岗谐浴吸夹垣萝寞电怪寻千困伪界届累雇穴参炸纷喜洲枪谊门汉炉充酚入谴戈伙崎携稚契彻褒叛邵伏诌枪店");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysResourcetypeMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCETYPE.insert");
		ep.setParamMap(sysResourcetypeMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		RESOURCE_TYPE_ID = (String) ep.getResult("data");
		Assert.assertTrue(RESOURCE_TYPE_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCETYPE.selectById");
		ep.putParam("RESOURCE_TYPE_ID", RESOURCE_TYPE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysResourcetypeMap.get("RESOURCE_TYPE_NAME"), ((Map)ep.getResult("data")).get("RESOURCE_TYPE_NAME"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCETYPE.update");
		sysResourcetypeMap.put("RESOURCE_TYPE_ID", RESOURCE_TYPE_ID);
		sysResourcetypeMap.put("RESOURCE_TYPE_NAME", "锭无堡绍窟猿粕烽悍额贼饭鲁变丁迄雷肢倾楔称慎未佯乡交屡褪湾观清赵搭宦颂煽瑚目递头斥宴芒把吃睡铜熏枯暗");

		
		ep.setParamMap(sysResourcetypeMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCETYPE.selectById");
		ep.putParam("RESOURCE_TYPE_ID", RESOURCE_TYPE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysResourcetypeMap.get("RESOURCE_TYPE_NAME"), ((Map)ep.getResult("data")).get("RESOURCE_TYPE_NAME"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCETYPE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysResourcetypeMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCETYPE.delete");
		ep.putParam("RESOURCE_TYPE_ID", RESOURCE_TYPE_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCETYPE.selectById");
		ep.putParam("RESOURCE_TYPE_ID", RESOURCE_TYPE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
