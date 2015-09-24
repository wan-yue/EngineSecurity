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
	private static Map<String,Object> sysUserinfoMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysUserinfoMap.put("USER_NAME", "批神庙渊滤炒慑雏苏夏傈域急歌帝腾匣莉势承爸掂刹敖枷元游藏僚抠蹄溅辙缓窘宇纳腿对好碱狂用柠虏酬汗荫音埃");
sysUserinfoMap.put("LOGIN_NAME", "信胰席盯呜休豆楷亩内档烧斑蹭送却途骡炯水");
sysUserinfoMap.put("PASSWORD", "争矽措捌痞忿粘齐炽勘袒春停监钵蔬赋能迭妥缉粕咯憋打掏罐娟跃色贪忽产试裁闰镀夺矢豁掇昏局题觅敏西散琳础");
sysUserinfoMap.put("EXPIRED", new Date());
sysUserinfoMap.put("BE_USE", -1698346516);
sysUserinfoMap.put("MODIFY_TIME", new Date());
sysUserinfoMap.put("DEPARTMENT_ID", 1917016305);
sysUserinfoMap.put("STATE", -1189430990);

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
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserinfoMap.get("USER_NAME"), ((Map)ep.getResult("data")).get("USER_NAME"));
Assert.assertEquals(sysUserinfoMap.get("LOGIN_NAME"), ((Map)ep.getResult("data")).get("LOGIN_NAME"));
Assert.assertEquals(sysUserinfoMap.get("PASSWORD"), ((Map)ep.getResult("data")).get("PASSWORD"));
Assert.assertTrue(((Date)sysUserinfoMap.get("EXPIRED")).getTime() - ((Date)((Map)ep.getResult("data")).get("EXPIRED")).getTime() < 1000);Assert.assertEquals(sysUserinfoMap.get("BE_USE"), ((Map)ep.getResult("data")).get("BE_USE"));
Assert.assertTrue(((Date)sysUserinfoMap.get("MODIFY_TIME")).getTime() - ((Date)((Map)ep.getResult("data")).get("MODIFY_TIME")).getTime() < 1000);Assert.assertEquals(sysUserinfoMap.get("DEPARTMENT_ID"), ((Map)ep.getResult("data")).get("DEPARTMENT_ID"));
Assert.assertEquals(sysUserinfoMap.get("STATE"), ((Map)ep.getResult("data")).get("STATE"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.update");
		sysUserinfoMap.put("USER_ID", USER_ID);
		sysUserinfoMap.put("USER_NAME", "藏委跨玛旨焙垂甜侠衙摔助嘲髓盟涧迂牟矮擅锅眉寇坦骤蹬况看推葱肪仁祈啡慧圃暴汕孩嫌恳若铡挨溶百业梨绷板");
sysUserinfoMap.put("LOGIN_NAME", "遂脸棉娄坚讼绩朗雹拿鉴饶坛徊雁缝狞底锣佩");
sysUserinfoMap.put("PASSWORD", "民硅霞灯玩释跳驴揣韶釜沦藏狼斡轮蒋雁戮菱贿肄霉壕乙力撇胖侗妹刑君陋补神迢文页拎执崎纠骇咆孔闷础乔伏列");
sysUserinfoMap.put("EXPIRED", new Date());
sysUserinfoMap.put("BE_USE", -669587296);
sysUserinfoMap.put("MODIFY_TIME", new Date());
sysUserinfoMap.put("DEPARTMENT_ID", 408858926);
sysUserinfoMap.put("STATE", 2009889856);

		
		ep.setParamMap(sysUserinfoMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.selectById");
		ep.putParam("USER_ID", USER_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserinfoMap.get("USER_NAME"), ((Map)ep.getResult("data")).get("USER_NAME"));
Assert.assertEquals(sysUserinfoMap.get("LOGIN_NAME"), ((Map)ep.getResult("data")).get("LOGIN_NAME"));
Assert.assertEquals(sysUserinfoMap.get("PASSWORD"), ((Map)ep.getResult("data")).get("PASSWORD"));
Assert.assertTrue(((Date)sysUserinfoMap.get("EXPIRED")).getTime() - ((Date)((Map)ep.getResult("data")).get("EXPIRED")).getTime() < 1000);Assert.assertEquals(sysUserinfoMap.get("BE_USE"), ((Map)ep.getResult("data")).get("BE_USE"));
Assert.assertTrue(((Date)sysUserinfoMap.get("MODIFY_TIME")).getTime() - ((Date)((Map)ep.getResult("data")).get("MODIFY_TIME")).getTime() < 1000);Assert.assertEquals(sysUserinfoMap.get("DEPARTMENT_ID"), ((Map)ep.getResult("data")).get("DEPARTMENT_ID"));
Assert.assertEquals(sysUserinfoMap.get("STATE"), ((Map)ep.getResult("data")).get("STATE"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERINFO.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysUserinfoMap.get("&ROLE_NAME&") + "%'";
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
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
