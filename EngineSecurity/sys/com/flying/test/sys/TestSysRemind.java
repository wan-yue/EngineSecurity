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

public class TestSysRemind {
	private static String REMIND_ID = null;
	private static Map<String,Object> sysRemindMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysRemindMap.put("SYS_NAME", "搽壳扬碾部咏探侯喷浙愁嚷国美好秽诞湾戴萄唬缔长塑菜盐驳兼岳叔直除俗哇歇戌幌营倘婆傣萄互趟站砌贩儡尖肩");
sysRemindMap.put("LINK_ADDR", "辈申隧太很睹牡淀柿奶涂诀绎檬瞪柑效侗应贡脖浚攒掳帛扛阑哭丸全广厦利泽鬼瘟忍袒襟况谷乓董桑痕辰曾绿偿来卫捡圆州席井肌蚤皂徘佣怖板绢献辣肘稿喂友姻醚匡擅乃销鸽明曝凡处首徊秀枢拖惊屹莲训存塘融活飞瘴蠕梨恼蛇婆卤叔订吾滨磺列趴鲁酬飞额消勒撒呸捷楞暖浓挎酿冗矗廖铸船袁缉秒粒挂循劝蔫熄兵顶林丈皮赦幕鞘错倘基桥这帅末另盘锭真劳抱靛碧铺栈玩悔女嫡拴霹柯鼠煌酿津曼齐扼煮那尚拢骑骗主且烧萤乖敲堕诡衔收供燕创啥侯欣吓匡棉撤假漾蜘内亮谬毖钝氏眨期曳淆遥诉爱胚粟衷叉益美瘪桨岿慢采柠抵罩垢沏裤苑咯遮止蹬剧隅下插仗猾蝎耶纲几责缆席栈突拜仟属幌鼓硝锦剐郑秦斯嗡撬弗安赫递占销灸斑怀葡稍略贸厉恼蛋嗓刚忘船惦奉填滑捐燃厦影滩爆澈呻苟哺粒眠乳弟盛悔矽僚纽掇搜则乃捐冉铁扦粕应孟枷野掺哦仅更吐坡职命鄂书矾扯谱倪竭冤满示群懒输父欢谎胀屯搔娄涨即造挽徊垫真忆孔症悉懊核翟术予楷骑舌婴踏概滁凉周措沙务校灸雇稀嘉鲁蠢却琉沾瞪釜豹匈怠事鞭骑匡蘸肺笔应宪积虱袒很靛骚务辣百固晚烟贬绢望瞻掠杨灾椭棍查孔惠校澄番墓看格轴写蛙袍痒交阁尽娥秸蔫稼索讨氯仇瑞惯惭吼冕坚深吕蔗陀澡氢冷情聊妓烁撑奇馅伶忍痪胚造蛀牧绣寡泵揖湛罗搏棠翅尽盗樟恍温牟涎切毡簿逻貉敦误驼普诡汽受犊顽敲红廷虎君帐厄掇招罐萨狸呼稽旦味挠迸螺碱拧三泰磕阎诉编枯菌暴睡肆繁虐韶束沼褥哭沸畅逾室巾潜腺妈黑社互娩树搁砌渊釉夫后洽撅馁彼淘幼谢森逼捎玉孙冕毯纲鸣气元终巳泉连铆刨剿赋崖急堪诵缨孪毫娇冗股涧脯津寨碑盔锋宝思俘骗晋祟满玲术黎蔓心兵硷吼坊泰琅侵嫡褒芍陇柜森汉染舵蜡渭膝床婴目奖葡鸿酋芝缨俺壤猫只埠狼男拣庶呢琴旧热娄邪般芽汁贼窃试贬款原己汕侣沼阮侄虞玖胳稗涡稗尺离汗降舜消琼据霉泪读另惯鸿谷秸谢芜逐畔搅莲约器赌踌泞三屿康捎锑闲犬葵暴逾疯慰员侗冒呀螟址烯旅烫促徒版普栽孪蔡体台玻儡晕媳痒温绿刊去焕慑疚召魔隙以援听扑逛香柔烙果夜苟毋排搁肩属颧爬殴皑依瞬刮袄实猜碘承脂村蛤赵骄弟硝报诀滞狮男悸撂育货");
sysRemindMap.put("USER_ID", "惊菩娩纯仿奈家原谤易饶娄末讹问诛鞘瞒谈洪溅易貌颁汲恕湛葛森鸽信决挂钡朴效赁鸟临汁卿罩振阜豺瞧庚前各兼");
sysRemindMap.put("REMIND_SIZE", 1965730681);

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysRemindMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.insert");
		ep.setParamMap(sysRemindMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		REMIND_ID = (String) ep.getResult("data");
		Assert.assertTrue(REMIND_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.selectById");
		ep.putParam("REMIND_ID", REMIND_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysRemindMap.get("SYS_NAME"), ((Map)ep.getResult("data")).get("SYS_NAME"));
Assert.assertEquals(sysRemindMap.get("LINK_ADDR"), ((Map)ep.getResult("data")).get("LINK_ADDR"));
Assert.assertEquals(sysRemindMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));
Assert.assertEquals(sysRemindMap.get("REMIND_SIZE"), ((Map)ep.getResult("data")).get("REMIND_SIZE"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.update");
		sysRemindMap.put("REMIND_ID", REMIND_ID);
		sysRemindMap.put("SYS_NAME", "篙如漂巧碟爸撑爱脖肉顾酸蓟开蜘内捕垂履梭像靠蚌衔痰烘海僵栗土或傈诵曝鹃帜静兽玲暗化惜屉馅赖酶香椒杀舜");
sysRemindMap.put("LINK_ADDR", "安贩宵揽滨拾法相欠讽朵活寇联茂魏锌灯厉辊操什路狭伞纶碑慑纶桅悔拥伶莆耽挖享廊申号铲梢貌燃太解协铃岿霸烯笺预谜淳堑赢观稗赐卞虚撩拄嚎搀释渭吩通菇酝脆诉钩央卢框阅缚佳赛倚晤可诈痰稼绪锋筹凋春恬好愁麻衬悠迈或衅道汞裸郴伸呵溯产试龚奠葛毖彪黔稿昏偶蹋霸息讽泪奔请眺那嵌硒崩牙馒附眺墟娱哪玩娠氢茫块搁心初鸯跺模累窄棉设逗躁拍初袱测疲粉菏慈声河秤馒居肝廷少翻刻翠赣驼森且誊障检褂围垦猎述毫景骤出儿馏智拣拾坛诫童编蛾县铂勾勉坏与漠毕钧酉卖叭蜀淆榆盯督令艺会械袒债发弛逗趾鼻硅魏狂边袖穗轨膘汕台惭已弱刘睫柏瘸郸俺展姨汁殉笋羞保淤芦涵艺势庸坦今得棉垂渔连汲碘芒至赐竖命醋棠浙五景革骗嫡施秘具菱聊藻趴究绎蝉抵鸳呸侈冶碍胸韶藩艾奉盅吗均医铁圈赦虏淮臆宿贺汤应丽始霍怯吝爬狼绍兵简凋胚逗蘸碎弓刀摹铅肋拈汀弧哭院镍槛阅陡呼炔捂艾鞋邵匿屏翠八控缸摘柒肠莹别幅拐蚂办芬力外皑楔宿霓平快乎驹尤驭盼疚突唤义眶隔涎知莫墟竟目吴氢搀晕啮标邓藩窘余锑牟芽羚虹驹吩氓滁盂梯怒凑抿荒茨佣罗必掩葵瞩蹦衣孙仆猎涉糖徘遭淘机澡麻碍叶抒钱迪它妙哺街链功瞒悸归布肚设迢纠伏机尉帝纲夕繁洲机代氟闻诺窟裕话该烬抚依点佑念渤掖文悄匝亭朋狈弘刁刚获氓巡羡嚣粥债射漂烟台悯鼻癸物涸邑素襟恕嘎帅擒阀依刹队项朝菩演戈丑恶丧撵冬他良巩撬谢拳寿方堑咖氛赔宇戮卞凶绣茫吼痛痹遍袍妓代侣筷凌黑竟渝候扁揖乃巧详擒缅劝伙绢奉劈腹恩钮铅殖蛔空骡达捷严碾少若缩苗辣丹扰脓碴值缕劝愧被汐轿感戚挎坟棋儒觉防晰谨骚饿诞塌发竹佑耙微冬斋旺趟池源瘤告窍鸿糙刑远通盗猿八诬一谁舰雕葛乒僵什陇斜纬粟锰纱亚安枷寇镣衙傻檀盖犹珠仅笆则啼斌你铱勘渭兼术彬橇奖伏迅高铡挠粮哦氢吭戊妻怒颤澳躬徽契缠殃驰油恤曙叹陌堤篱误棋州惋暇浆斩篓骨味宿宪泉树韦当晕呜夸驭荔朝明婚剐酋如临猫沪什壤慧麦法增惑批冀驰仁篷送怜漠借帜控尼杨赃育农脱肃芜蒲脓备读似酶秋瘁敞婚礁缨芒帝陌堕燕锹滞汞底惧臻掖掉勇卤兆变宙攘咙所馋鲍梗舜堤跃宾");
sysRemindMap.put("USER_ID", "豹痴旅凤卵逸亦府摔架饰恭铱章帮琶绕拭畸犹钙拨去吨贝沏涌舜粒衷巡孙际就岸硝让晴嘎慌乓颊辕基阉代霸酣学隋");
sysRemindMap.put("REMIND_SIZE", 1369615686);

		
		ep.setParamMap(sysRemindMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.selectById");
		ep.putParam("REMIND_ID", REMIND_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysRemindMap.get("SYS_NAME"), ((Map)ep.getResult("data")).get("SYS_NAME"));
Assert.assertEquals(sysRemindMap.get("LINK_ADDR"), ((Map)ep.getResult("data")).get("LINK_ADDR"));
Assert.assertEquals(sysRemindMap.get("USER_ID"), ((Map)ep.getResult("data")).get("USER_ID"));
Assert.assertEquals(sysRemindMap.get("REMIND_SIZE"), ((Map)ep.getResult("data")).get("REMIND_SIZE"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysRemindMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.delete");
		ep.putParam("REMIND_ID", REMIND_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_REMIND.selectById");
		ep.putParam("REMIND_ID", REMIND_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
