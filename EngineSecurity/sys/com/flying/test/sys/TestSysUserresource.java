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

public class TestSysUserresource {
	private static String USER_RESOURCE_ID = null;
	private static Map<String,Object> sysUserresourceMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysUserresourceMap.put("USER_ID", "疟氰术予除缝掀蛆忧柳愚宏颐物济喳孟节仆法先睡灌鸦跃虱认娘凳砾台百撇点刘蚕牵纲齐忆栏别千试尾笺幸食浆珍");
sysUserresourceMap.put("RESOURCE_ID", "聂迪恕钾辅赫效詹伐孟柒方猾罕溢窜痰毛淬敢檄肪荧镰稗鸭赠旁界章昧人饵巫撬贼啡侣徘录表劝规铆惜稽幼芦抛侗");
sysUserresourceMap.put("ROLE_ID", "室鲁酬飘锋塑购敖楷般宫镶另格壕础炭成耍渡隔葫圈蹲琼遂计霓宴绒构癣鸳饥在锻烫褒忌待特基建偏说烘撇汐棱涎");
sysUserresourceMap.put("FACETYPE", "难逸厌障搏架开怠铆翠孵沏祷燥攀酋眷跳禾楞茫迹遁瘫诬疆沁摈烯言告辛打胀蛤眼到濒图先谨刚桐苍盗贮宵练暮搽");
sysUserresourceMap.put("DESKTOP", -1830001272);
sysUserresourceMap.put("ICON", "也勒卑戳漓掷皋纪渊环语夫肌窃彝脏呕挫调怂浓匈姓腆蚊掺慢筒捐另汪抛粗湿烩撤禾每出稚货亚犹褐句去恬教引铁何咬少抖亥建锗应陷氦臆抛恫盏面写蜕乙至蛆临妮捶姜手霍椅立芥离山捧街骡俺入今其房涵揩绍悍湘何返外山晾碗冀枪始卜曙该据邱肥帖郊攻显蜡麓曼绦全顾傈颊蹿歹噬烛叶电秦洽肚柑蓟慑饭寄洋赡蝴娟闽图爵尤垫泞灶湃嚣起祷赎荒瞧氧驾虎唤韭凹裕略朝鹏橙铡岔嗜弊偏瞧帅靶瑞堵晰杰伐知仅事嘎销帕斌御拌岔亢役玫辨沾呸巢碎原缎勤噬前");
sysUserresourceMap.put("SORT_NUM", 12866050);

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysUserresourceMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERRESOURCE.insert");
		ep.setParamMap(sysUserresourceMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		USER_RESOURCE_ID = (String) ep.getResult("data");
		Assert.assertTrue(USER_RESOURCE_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERRESOURCE.selectById");
		ep.putParam("USER_RESOURCE_ID", USER_RESOURCE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserresourceMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));
Assert.assertEquals(sysUserresourceMap.get("RESOURCE_ID"), ((Map)ep.getResult("data")).get("RESOURCE_ID"));
Assert.assertEquals(sysUserresourceMap.get("ROLE_ID"), ((Map)ep.getResult("data")).get("ROLE_ID"));
Assert.assertEquals(sysUserresourceMap.get("FACETYPE"), ((Map)ep.getResult("data")).get("FACETYPE"));
Assert.assertEquals(sysUserresourceMap.get("DESKTOP"), ((Map)ep.getResult("data")).get("DESKTOP"));
Assert.assertEquals(sysUserresourceMap.get("ICON"), ((Map)ep.getResult("data")).get("ICON"));
Assert.assertEquals(sysUserresourceMap.get("SORT_NUM"), ((Map)ep.getResult("data")).get("SORT_NUM"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERRESOURCE.update");
		sysUserresourceMap.put("USER_RESOURCE_ID", USER_RESOURCE_ID);
		sysUserresourceMap.put("USER_ID", "挽喊钞满吃溅浆圈蹲会疵帖合家腹腾降帚化朽粱癸涵嘘谁卜曙铃参傲衬雕藏渗甘胖纪鹰林疾相骤辜伎画衍露持纸念");
sysUserresourceMap.put("RESOURCE_ID", "喇蔬呸商懦借岳否土或油灌押励涸熄当莹泥材肺卵礁阑斌魄刁某呀涎阎脆渝睦旦秃半棋压栏乎倚合要讫炸纲写怎畔");
sysUserresourceMap.put("ROLE_ID", "捐蛹比期反傅趴俊墨南氮褪先槛粒衷踊损际熏绥原配埠振蛾伺椒诊壶惋辖筋柑妄输坏钳厂又栅栖蛇涛贾跨奥企的矿");
sysUserresourceMap.put("FACETYPE", "潜啥稿行愤虾镀肚锁王硬零簿摇觅韩碑亢帚析垦法提赋憾攘郭啊荣翻辨墓痢盲询苦蹲侠澈低艇清旅挑任疵劳霞瓶猫");
sysUserresourceMap.put("DESKTOP", -2098399332);
sysUserresourceMap.put("ICON", "齿萝湘竞我逗悟氧螺焕利送禾每刨喘体沧茎列糜堰颈镍蔡失毯金鸦买帜孝窟缓咯连淖媚甲硬裸颈鸿若亏疆楷怜叉墩葛文葵得讽脸瓶十诲旧闸糜喘加跪泣散盆更节犬逛计列摔期究房派钉碌版堡普诉兜坞慨赃酝命泉钝陈侗勾详宴噪房霄肤三已异晾贩巷愚母胰妨庭爷匆汰续究旧商庞秦姻醚玻盐水兼呛纶夕阶英堆赔到宫典继殆淘花缝席犁萤段唯勋裸乱咆膨称它敷碉蜕枯桥臼症庞癣螟蔗苹支呢类噶斟评瘩户胸宰疟迈承有终陌庆杜髓逻彻借吱屿境弘想背设韩翁食逛");
sysUserresourceMap.put("SORT_NUM", -1356457868);

		
		ep.setParamMap(sysUserresourceMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERRESOURCE.selectById");
		ep.putParam("USER_RESOURCE_ID", USER_RESOURCE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysUserresourceMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));
Assert.assertEquals(sysUserresourceMap.get("RESOURCE_ID"), ((Map)ep.getResult("data")).get("RESOURCE_ID"));
Assert.assertEquals(sysUserresourceMap.get("ROLE_ID"), ((Map)ep.getResult("data")).get("ROLE_ID"));
Assert.assertEquals(sysUserresourceMap.get("FACETYPE"), ((Map)ep.getResult("data")).get("FACETYPE"));
Assert.assertEquals(sysUserresourceMap.get("DESKTOP"), ((Map)ep.getResult("data")).get("DESKTOP"));
Assert.assertEquals(sysUserresourceMap.get("ICON"), ((Map)ep.getResult("data")).get("ICON"));
Assert.assertEquals(sysUserresourceMap.get("SORT_NUM"), ((Map)ep.getResult("data")).get("SORT_NUM"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERRESOURCE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysUserresourceMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_USERRESOURCE.delete");
		ep.putParam("USER_RESOURCE_ID", USER_RESOURCE_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_USERRESOURCE.selectById");
		ep.putParam("USER_RESOURCE_ID", USER_RESOURCE_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
