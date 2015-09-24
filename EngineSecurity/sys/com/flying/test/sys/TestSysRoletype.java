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

public class TestSysRoletype {
	private static String ROLE_TYPE_ID = null;
	private static Map<String,Object> sysRoletypeMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysRoletypeMap.put("ROLE_TYPE_NAME", "寒田珊啤匆攫幽销曲碎畜珠敲汕恬号谱凡豌避");
sysRoletypeMap.put("ROLE_TYPE_DESC", "拧顿铲室借纱凌裁若步冬力末臀睛尹弥桥童恨夜薯旨弘杜湾谐仑吵句淆兔钧玛腐吊怎畔矗赖表亨羞砍击兴拴硝晨的旺嘉赂涕饶夺首芝闹当源挽雄虎汾洱巫汹恋寻髓秒笨鹃咏逼档探侯今仗凤仙贤困重铱彰隔形切腾之习齐到王箱舍顶讨奖奉鉴阶荧冈通哟零函溢怔婆祥滥煮糯馒疤泅沂闪忽清妇佣羚部丘令蜜吹舒兵梢乏吞暖炔杠桶属匀氦堪捎寒倪柒盟楔吝轴抚奖逾粤蛮拧蹲双爸迟若瓜潮绥先瓶瀑扇海孰宛舅脐商骇吉熏勿寄谊仲托惊彝忙联碰德梭袄欣坚预谚涨稳");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysRoletypeMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLETYPE.insert");
		ep.setParamMap(sysRoletypeMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		ROLE_TYPE_ID = (String) ep.getResult("data");
		Assert.assertTrue(ROLE_TYPE_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLETYPE.selectById");
		ep.putParam("ROLE_TYPE_ID", ROLE_TYPE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysRoletypeMap.get("ROLE_TYPE_NAME"), ((Map)ep.getResult("data")).get("ROLE_TYPE_NAME"));
Assert.assertEquals(sysRoletypeMap.get("ROLE_TYPE_DESC"), ((Map)ep.getResult("data")).get("ROLE_TYPE_DESC"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLETYPE.update");
		sysRoletypeMap.put("ROLE_TYPE_ID", ROLE_TYPE_ID);
		sysRoletypeMap.put("ROLE_TYPE_NAME", "哪叙酞解佣捻引侦破瞎汕给醒抑辖熔勉公颊砒");
sysRoletypeMap.put("ROLE_TYPE_DESC", "奄兰换抨廊憎古酱凤土祭盯呜怒朵干钵蓉钩付恒弥深洼搏堰潞伴雏撮棠掘炙革惩健棺揽虾蓑干肖城贯略钞芦报琴复汗嫉现腊厕呛山奉坯锑碑历闭池甜奥滴升丈哺敷虑普钒砸怒兴苔末糙置幼贬敌瞳巴惨虱育斋记银糜瘤拍硝劳呈椅唯辟鸡亚搞软肺熄举袋朗墓叼肤篡莎逛酮臣唆敏稳误诱厩门濒上予汤爬乙铆情炕竹排劳瓦海奄凯哲欧琳帛郝捏傈招寅尖扭稳氏蛤会磋询莎虹寞艘钉找掩干医悯侨筐庭户虞睡肩善喻朝刃视划陛潜哥遍办吩朵慰旗款榴矩婪憋泼县宿裸岩");

		
		ep.setParamMap(sysRoletypeMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLETYPE.selectById");
		ep.putParam("ROLE_TYPE_ID", ROLE_TYPE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysRoletypeMap.get("ROLE_TYPE_NAME"), ((Map)ep.getResult("data")).get("ROLE_TYPE_NAME"));
Assert.assertEquals(sysRoletypeMap.get("ROLE_TYPE_DESC"), ((Map)ep.getResult("data")).get("ROLE_TYPE_DESC"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLETYPE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysRoletypeMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_ROLETYPE.delete");
		ep.putParam("ROLE_TYPE_ID", ROLE_TYPE_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLETYPE.selectById");
		ep.putParam("ROLE_TYPE_ID", ROLE_TYPE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
