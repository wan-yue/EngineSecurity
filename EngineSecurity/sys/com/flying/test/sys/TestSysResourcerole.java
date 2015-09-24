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

public class TestSysResourcerole {
	private static String RESOURCE_ROLE_ID = null;
	private static Map<String,Object> sysResourceroleMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysResourceroleMap.put("RESOURCE_ID", "仇滚渐戎谋豢唇暑蝗昧盔召胺语蓑翱硼妒雇赞殴羌阁禄绸钓搞词墅喝劫骚载酶答招偏景砧腑溉磋考膀言洲牟犀入暑");
sysResourceroleMap.put("ROLE_ID", "谈位矿孺埋凄造诛氖泵生祈氯馅缆煮醒坎罕筏评邮柿吉葬昼三拼里妮蹈盈拎成许淘息缆阵仆搀饰育污彩圣通险钵婴");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysResourceroleMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCEROLE.insert");
		ep.setParamMap(sysResourceroleMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		RESOURCE_ROLE_ID = (String) ep.getResult("data");
		Assert.assertTrue(RESOURCE_ROLE_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCEROLE.selectById");
		ep.putParam("RESOURCE_ROLE_ID", RESOURCE_ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysResourceroleMap.get("RESOURCE_ID"), ((Map)ep.getResult("data")).get("RESOURCE_ID"));
Assert.assertEquals(sysResourceroleMap.get("ROLE_ID"), ((Map)ep.getResult("data")).get("ROLE_ID"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCEROLE.update");
		sysResourceroleMap.put("RESOURCE_ROLE_ID", RESOURCE_ROLE_ID);
		sysResourceroleMap.put("RESOURCE_ID", "邻驳孺龄捌三涝里嘘嗜郭性撬勾丸挺雕藏瓢剁袒殴带礼钡尺猛揣躯刚导蛙镜包郑旁动覆铡袜谊俄稳奄痛斌辛浴刨檄");
sysResourceroleMap.put("ROLE_ID", "胞欺范汗泼绣夸执达棵几窘史告襄侨匝爸瓤曼节侯疑瞄佩锤挂摩囊滚蜒婉缴碱干疤颊抖卧脆谈贡跑窗幸禄郡奥朋锻");

		
		ep.setParamMap(sysResourceroleMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCEROLE.selectById");
		ep.putParam("RESOURCE_ROLE_ID", RESOURCE_ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysResourceroleMap.get("RESOURCE_ID"), ((Map)ep.getResult("data")).get("RESOURCE_ID"));
Assert.assertEquals(sysResourceroleMap.get("ROLE_ID"), ((Map)ep.getResult("data")).get("ROLE_ID"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCEROLE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysResourceroleMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCEROLE.delete");
		ep.putParam("RESOURCE_ROLE_ID", RESOURCE_ROLE_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_RESOURCEROLE.selectById");
		ep.putParam("RESOURCE_ROLE_ID", RESOURCE_ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
