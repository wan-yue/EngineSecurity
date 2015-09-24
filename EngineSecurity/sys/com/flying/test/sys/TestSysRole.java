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
		sysRoleMap.put("ROLE_TYPE_ID", "歼结援忌惺隶种掂康州犬莹顽纠僚嘱蹦局瞻罚羡厢拦赎骗易粪轰母咙中阎溉稿芦漠垫民绚震煤搽喻了拨茸摩旋狙晕");
sysRoleMap.put("ROLE_NAME", "杨挑咆冻凿绥捡煽烈搏堰亢搭吧圾佑寿徊雁肆佛促赢啮蛆肾肥荚抛恫哪惮垒戌檄蹈兰闻宾筒别伤笼吞果迟森轰硅衙");
sysRoleMap.put("PID", "另至材攫幽垛挠衍砚滤盼订甫呻磅翠埂侈斯庙慈斑将眺汛靛继驱鳞匡雇箔叔网居赋须哎容障壶刑宙暮豺弓唁沼爸渐");
sysRoleMap.put("ROLE_DESC", "枯褒合抄迹莎拾被藉炸挥脓泉郝养上憨嚣壳渴脑波示土均虞辩拜雀驶峙啸织阐邓肺鸣天咬地食互虞繁炸属晃狙吕晶梁豺绕唁椽题行遮撵灯非息鼻伞嚎人卢汞蛀销勒扮今扰毙罚羡艳疯潍女舵代陶虫丝伟垮盾蔫焙辰挨答趟挝躇检郧笆壳阿叛瘦今山割斜涕寥裸蔫因锤特绒鱼纤刑力白鸡阅迈诚认哇隘愉瞩骨津瞧铆厕福汹锡郴牙脉米瞧绦乓露愁嚷臀渡韦好萧神放颜陕胡烬领接恤廖秽柯语鲜醛措棠翅荚距粪檀届速唆西蜂版潜她页藐尉啡爸颗士噶抨缮宋诀神概程金业");
sysRoleMap.put("BE_USE", 535503340);
sysRoleMap.put("ROLE_CODE", "昭圃茸帅尝定帽撮修坎伴杰好柬倔耘刮芭三天粕廓抡咆性录粘饥在怜洪呕污江斟忽俞脸瓶淳琐菏奠泛缅畦醇蓝后竣");
sysRoleMap.put("STATE", -1661814598);

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
		sysRoleMap.put("ROLE_TYPE_ID", "嚏夯象区俗庭残刹壶盘虞亩崖耘逐榴钱哆魏邓抡癌惹径蔬弯客浴氨予刽瑚扦亚忍捍异佯者呢脱精刃卢陛筛拟到暑潘");
sysRoleMap.put("ROLE_NAME", "赎铝躇韧柑铂溅碌酬疾康塘谨双奋系情改琵龋以罐尼儿卧歧防淑宦绘创罚疼项狼耕田雏掣酥扁颐掌钱锋辣颂匣甚干");
sysRoleMap.put("PID", "筋啪胰芒互氖酋郊镇栖矛械挎陵梅颂篇嫡谓迪觅吵乾鹰凳烩垦函锑交谐淡咐拈蓉钩辩瘴涪屠榜忍皋哑戴伏械幸诱帜");
sysRoleMap.put("ROLE_DESC", "拥榜排州谋垫氟悯蜕艺订貌涯语稗船据施冠爵云携漆芳逐撬秧氯乃洞倔烂拄摈梢弱瓜蚜流嫩档梨皱墓雁闰苇嫁氯冰稍法唉谜燕愉木军种操事锻感歇篡凌撕简称焉夫唐健坤缄厨擞囊簧婴琳拖甥赶歇举钢酮监老梧炕熟磺苯椒苔睫贬频讽吼寒差嗜退稽枫头赔裳整南埔番挽侥堂禁屏辐狐男簇们刃列栗毙皮客考霍躇人增檬胺处剔评让烯徒茶蹲岗饰耿掩妙刊哄殴榴孩抿赛屉惯压筷聂赎荒蛇题北柒芳赃抽嗣逛胃粹靛钙悬原佩泄假底钠渐洪辖句凌故囱圣菲挂亭锈粱诉奇");
sysRoleMap.put("BE_USE", 1963370574);
sysRoleMap.put("ROLE_CODE", "顾锰戎丢愁郸蛙话峨潮骤购歹垮咒垢扬嵌责寐烬岭接阉楼缩巡凑税并寿暮彻棘缕眺济啦豁辛览闪华江斟颓升隶甚沸");
sysRoleMap.put("STATE", 552455128);

		
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
