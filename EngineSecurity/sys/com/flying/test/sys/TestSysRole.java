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

public class TestSysRole {
	private static String ROLE_ID = null;
	private static Map<String,Object> sysRoleMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysRoleMap.put("ROLE_TYPE_ID", "雷尼翠弛版饶姚侧痕霓妒增腻艺门情磕强尸决苑昼封逻遮嫉掣唆你裂涕遂碧椭性格醒滴甲晨樊蛹峨爵秸纶胶糠涕丽");
sysRoleMap.put("ROLE_NAME", "俗啸拎畔喳岔传掣噬酶谚胎洁觅美是屁的稀蛋屋议兵掸壶衅祈卿助畴于汁芒庭债硷霍殆栈音泥劣哆蝴屑所茵眯历网");
sysRoleMap.put("PID", "诵乔己咆预妄暗阂改宵荧姓议狡首江瘦寺梨稳凑阔贰钉菩逐赢宠搞先跺买肖瓢蜘蓬枯备卷罢剂害晌戒勺泅鸳遣呆辖");
sysRoleMap.put("ROLE_DESC", "泪换归竞氮砚会苞否桓垫坏浮孤德娘枯和砌洱劫杉抢秆逐萤醚哮度恼照秤姜辅川邓焰侍滤帆盆飘连瞒诞咽毯脯筷薛糙谭匣烤踢拂磷鄙弓忘赐沫积苛珊但跑皱涵僳亲芍踢扶站辰陵彩拳泻纷玩窜烽集探沫虞寒慎焙庸狸灯霉初疗颇洞天奠疼腔饮等灵肩纷呼山宫撮饭几睁撤烫表与杭憎志侈运暮宙破泽瞅悲讣雨盈竟声布李盅曹趾蔡联业手笔溢茶飞叉稿郎须汉挤琳巢土锚嫂免灿踏浩犹比洼闽乒飞右套弥法皆哟伟育褒洪蹿闷月枚舞藻效赦搅涉恬赏侯蠢攀窗儒棵砸卫砂");
sysRoleMap.put("BE_USE", -1283416799);
sysRoleMap.put("ROLE_CODE", "痉喉水贴垃绩芒垦兄煌鸥椰府倒惕帖骨底碑侗墒摄享割盏霜舀营码缝芦纪卢奔另苯撅敏沈区军槐靴发饱丛路倚萄羔");
sysRoleMap.put("STATE", -85594426);

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysRoleMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLE.insert");
		ep.setParamMap(sysRoleMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		ROLE_ID = (String) ep.getResult("data");
		Assert.assertTrue(ROLE_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLE.selectById");
		ep.putParam("ROLE_ID", ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysRoleMap.get("ROLE_TYPE_ID"), ((Map)ep.getResult("data")).get("ROLE_TYPE_ID"));
Assert.assertEquals(sysRoleMap.get("ROLE_NAME"), ((Map)ep.getResult("data")).get("ROLE_NAME"));
Assert.assertEquals(sysRoleMap.get("PID"), ((Map)ep.getResult("data")).get("PID"));
Assert.assertEquals(sysRoleMap.get("ROLE_DESC"), ((Map)ep.getResult("data")).get("ROLE_DESC"));
Assert.assertEquals(sysRoleMap.get("BE_USE"), ((Map)ep.getResult("data")).get("BE_USE"));
Assert.assertEquals(sysRoleMap.get("ROLE_CODE"), ((Map)ep.getResult("data")).get("ROLE_CODE"));
Assert.assertEquals(sysRoleMap.get("STATE"), ((Map)ep.getResult("data")).get("STATE"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLE.update");
		sysRoleMap.put("ROLE_ID", ROLE_ID);
		sysRoleMap.put("ROLE_TYPE_ID", "姜求医瑚椿争草澳秃班饶悯篡腰其媳均炙节伦茶场闻忘钞森突魂复起缆奈岂掀快还雏甘查糕窑谴抄焊雁儒误星务徘");
sysRoleMap.put("ROLE_NAME", "石卉瓷贫哮郎润航渴弥哑兔豺懒残昂枫窗耪挡曙行嘶审拾赖试姨利练寇秤闭俱流高亮珊扩船嘛菱耗孩胎斯习柳休蕾");
sysRoleMap.put("PID", "碌波度诲莹擦裤氨恢婴蛊锯衡迪坯纯螺堪幅奋祁嘶查锹涟饥录央僳翔炙娄谐呆疟菠锻迭厨严伶研绊莉扰咙其窍沮届");
sysRoleMap.put("ROLE_DESC", "酞七廖馁阮黑犬矛惩府挟馆毙展诬冯唤巨蔫跑陈贫来坚震呜买种性玩旭渊吵耘趁沙律翁刚胃跌砒张珐怒兵观真掣肩狙章虞藕伺辫贩夷峭胃酿胳扫钠桓册捎烂匿蛙烛沂加同苑擎婪绰粥炯浚亥夕谋纫遥吗男伶必崩虑坎油磐素茹撑驯亨历僻庭拨挺刹云枚哉虑谚护膨鲤溯恿秽鸿埂迭贤拟葫儿恳惦邯故板慷狭惫泉壹识唯砰芳揣否拆宽周充臃铰钒殖到鞭肢哆龚轻詹竭懒表站换羚患槽汰峰岗懊廖汤仕胸次坎烟入想励巢置害嚎妈如裔颧风趋胰播拂亥档钡阶尼角甫丛豫橡");
sysRoleMap.put("BE_USE", -1851061034);
sysRoleMap.put("ROLE_CODE", "赛戍乘谰漠淡振粉枉度份殖廉魂册葛逝傅杆森计玲丘滩排舜呢望疤然钥衡姥级肾农抗熟这丧轰余哀栗浪雇虞秉柔蛊");
sysRoleMap.put("STATE", -1314416572);

		
		ep.setParamMap(sysRoleMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLE.selectById");
		ep.putParam("ROLE_ID", ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysRoleMap.get("ROLE_TYPE_ID"), ((Map)ep.getResult("data")).get("ROLE_TYPE_ID"));
Assert.assertEquals(sysRoleMap.get("ROLE_NAME"), ((Map)ep.getResult("data")).get("ROLE_NAME"));
Assert.assertEquals(sysRoleMap.get("PID"), ((Map)ep.getResult("data")).get("PID"));
Assert.assertEquals(sysRoleMap.get("ROLE_DESC"), ((Map)ep.getResult("data")).get("ROLE_DESC"));
Assert.assertEquals(sysRoleMap.get("BE_USE"), ((Map)ep.getResult("data")).get("BE_USE"));
Assert.assertEquals(sysRoleMap.get("ROLE_CODE"), ((Map)ep.getResult("data")).get("ROLE_CODE"));
Assert.assertEquals(sysRoleMap.get("STATE"), ((Map)ep.getResult("data")).get("STATE"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysRoleMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_ROLE.delete");
		ep.putParam("ROLE_ID", ROLE_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_ROLE.selectById");
		ep.putParam("ROLE_ID", ROLE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
