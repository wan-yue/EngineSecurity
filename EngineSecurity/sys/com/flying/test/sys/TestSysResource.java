package com.flying.test.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class TestSysResource {
	private static String RESOURCE_ID = null;
	private static Map<String,Object> sysResourceMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysResourceMap.put("RESOURCE_CODE", "测试数据");
		sysResourceMap.put("RESOURCE_TYPE_ID", "测试数据");
		sysResourceMap.put("RESOURCE_NAME", "测试数据");
		sysResourceMap.put("RESOURCE_ADDR", "测试数据");
		sysResourceMap.put("RESOURCE_HELPINFO", "测试数据");
		sysResourceMap.put("SECURITY_NAME", "测试数据");
		sysResourceMap.put("PID", "7FF2AD89BA194EBAA9C5B72D673EC371");
		sysResourceMap.put("CACHE", 1000);
		sysResourceMap.put("FACETYPE", "测试数据");
		sysResourceMap.put("ICON", "测试数据");
		sysResourceMap.put("SORT_NUM", 1000);

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysResourceMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCE.insert");
		ep.setParamMap(sysResourceMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		RESOURCE_ID = (String) ep.getResult("data");
		Assert.assertTrue(RESOURCE_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCE.selectById");
		ep.putParam("RESOURCE_ID", RESOURCE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysResourceMap.get("RESOURCE_CODE"), ((Map)ep.getResult("data")).get("RESOURCE_CODE"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_TYPE_ID"), ((Map)ep.getResult("data")).get("RESOURCE_TYPE_ID"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_NAME"), ((Map)ep.getResult("data")).get("RESOURCE_NAME"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_ADDR"), ((Map)ep.getResult("data")).get("RESOURCE_ADDR"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_HELPINFO"), ((Map)ep.getResult("data")).get("RESOURCE_HELPINFO"));
		Assert.assertEquals(sysResourceMap.get("SECURITY_NAME"), ((Map)ep.getResult("data")).get("SECURITY_NAME"));
		Assert.assertEquals(sysResourceMap.get("PID"), ((Map)ep.getResult("data")).get("PID"));
		Assert.assertEquals(sysResourceMap.get("CACHE"), ((Map)ep.getResult("data")).get("CACHE"));
		Assert.assertEquals(sysResourceMap.get("FACETYPE"), ((Map)ep.getResult("data")).get("FACETYPE"));
		Assert.assertEquals(sysResourceMap.get("ICON"), ((Map)ep.getResult("data")).get("ICON"));
		Assert.assertEquals(sysResourceMap.get("SORT_NUM"), ((Map)ep.getResult("data")).get("SORT_NUM"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCE.update");
		sysResourceMap.put("RESOURCE_ID", RESOURCE_ID);
		sysResourceMap.put("RESOURCE_CODE", "测试数据修改");
		sysResourceMap.put("RESOURCE_TYPE_ID", "测试数据修改");
		sysResourceMap.put("RESOURCE_NAME", "测试数据修改");
		sysResourceMap.put("RESOURCE_ADDR", "测试数据修改");
		sysResourceMap.put("RESOURCE_HELPINFO", "测试数据修改");
		sysResourceMap.put("SECURITY_NAME", "测试数据修改");
		sysResourceMap.put("PID", "测试数据修改");
		sysResourceMap.put("CACHE", 2000);
		sysResourceMap.put("FACETYPE", "测试数据修改");
		sysResourceMap.put("ICON", "测试数据修改");
		sysResourceMap.put("SORT_NUM", 2000);

		
		ep.setParamMap(sysResourceMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCE.selectById");
		ep.putParam("RESOURCE_ID", RESOURCE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysResourceMap.get("RESOURCE_CODE"), ((Map)ep.getResult("data")).get("RESOURCE_CODE"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_TYPE_ID"), ((Map)ep.getResult("data")).get("RESOURCE_TYPE_ID"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_NAME"), ((Map)ep.getResult("data")).get("RESOURCE_NAME"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_ADDR"), ((Map)ep.getResult("data")).get("RESOURCE_ADDR"));
		Assert.assertEquals(sysResourceMap.get("RESOURCE_HELPINFO"), ((Map)ep.getResult("data")).get("RESOURCE_HELPINFO"));
		Assert.assertEquals(sysResourceMap.get("SECURITY_NAME"), ((Map)ep.getResult("data")).get("SECURITY_NAME"));
		Assert.assertEquals(sysResourceMap.get("PID"), ((Map)ep.getResult("data")).get("PID"));
		Assert.assertEquals(sysResourceMap.get("CACHE"), ((Map)ep.getResult("data")).get("CACHE"));
		Assert.assertEquals(sysResourceMap.get("FACETYPE"), ((Map)ep.getResult("data")).get("FACETYPE"));
		Assert.assertEquals(sysResourceMap.get("ICON"), ((Map)ep.getResult("data")).get("ICON"));
		Assert.assertEquals(sysResourceMap.get("SORT_NUM"), ((Map)ep.getResult("data")).get("SORT_NUM"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysResourceMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCE.delete");
		ep.putParam("RESOURCE_ID", RESOURCE_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCE.selectById");
		ep.putParam("RESOURCE_ID", RESOURCE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
