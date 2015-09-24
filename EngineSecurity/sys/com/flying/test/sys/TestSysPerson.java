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

public class TestSysPerson {
	private static String PERSON_ID = null;
	private static Map<String,Object> sysPersonMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysPersonMap.put("PERSON_NAME", "纳绘啃掉拖葡赂百慈挂留稀薛喀季增滨宅其抄");
sysPersonMap.put("IDCARD", "廖竹赤灵昂崎亥家菊赡裹昧韧贰乡儿窝漆芳什");
sysPersonMap.put("PEROSN_PIC", "宅峦畴嗽哦礼彰弃今赤僧澈均卡兆撇炬垂躲尉蜜腻奸该磐痰纬佬盛跑靠抛倡郡铬穆误裤钱荚翻澎哟显枉狙龄娃蔷督含忆识旱湘赤敷弛飞悉学婴压染捏肉淌该喧雾会犊换赡爸缺燕潞贡箭钢锚勇放封哄依数回捷盈蛾镊狄虫炮钞颂摈扑乏砷耗搐誊近倚艇私减厨拐询类抨卵把全镑抱贾削姥啡希语悔拥菌终末岩梦蒲鞘俗蒲世壶魏阉挺扒扯酸呢铂竭方猪瞧甩外输堡婆荫婶脉沧志锄嗽匀蛮蹦竣敞让勋负兵养彦福篡研让翁辣飘烁肠驹妮滦示垒织教攻花奄壬怎变飞废滔簧兴全谜围譬肃勾窍俯辟纱躇馅溶伐轮疵疤传于烫鸽衅咀咋挺沾邻喳添饺恩我淀独掷区丫羚效计浴搽央庐比基薪伺恩忽蠢抉纺销赛你坡膳惰么淮屿账靖诛巷罢磕贞咀第哲品芥血锣烩涣肥供陆牧狼洗樱滤包吼岛始嘱舆叹啪嫉舆贴滞菱毫序馁煞覆驼胸孵碧但嗽绰藉钒贪忠愈吻予惕星烂粥垄护误契稍啡烛平怂脚焰拎咋忙摊鹊兄诀译惨理姐咬帅戚扎榆塑沸靶潮好妒肢彻肿扦爬撅否渭昼帆荤裔困温宛起痘纸姜兴艘扭长褒汗彻杰盾镜港隆烛逞肿寄炊蛤玩奖快割晕醋壬肾宝蹦帘己翟抽娱惭愤辜瓦慑粮焊仅吏期口阮之胖雁晶萤鹏醇犬涟漾父梧荒郡事爱佣好秘必粤毙怕癌国闹街擎瞻桶疥异兽成找啊希鞠读卜药双漆翅肄擂躇四麓稀瑞莉挞裹处哉糖徘掖毫渤澡莹团类锗鸵桨付唾让撩嘛碴丽硅森普阳泽");
sysPersonMap.put("POST_DATE", new Date());
sysPersonMap.put("DEPARTMENT_ID", "共瓦滴通百曝宣速弓秀箩臣软缝屠辖牙瘤危悉秸瞻娄侈澳滴和舀狗扬棵骸返泥窍芦败悦巳各幸炔雾绷声爱茹凰琳哪");
sysPersonMap.put("SEX", "胞幕眠垂");
sysPersonMap.put("BIRTHDAY", new Date());
sysPersonMap.put("EMAIL", "裁囚乱证诣士挽雄珍折贫欠悦茫劲令际邀飞众褐激咖沙叛膝另糕幂偏犬趾镜栏别售瘩逝田桨砧纤搔墩伟驼瘸帧亲臻备斋吹涉置韭柱贮棘绽气甥吱午殃屡拄役锗魂抠钢为闻荐岿贝伸涵限船桔五惫恃检瘩聋坦腐梧炕陋拇冲具龄瘟拣猿");
sysPersonMap.put("PHONE", "信朽椒诊拿臻媒大洛楼倘匹抵瘫囱太锄掣净饭");
sysPersonMap.put("QQ", "邯决芬挺危薛罗伐潜较蕾儡挤暖奄砂虹有镁憋");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysPersonMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_PERSON.insert");
		ep.setParamMap(sysPersonMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		PERSON_ID = (String) ep.getResult("data");
		Assert.assertTrue(PERSON_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_PERSON.selectById");
		ep.putParam("PERSON_ID", PERSON_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysPersonMap.get("PERSON_NAME"), ((Map)ep.getResult("data")).get("PERSON_NAME"));
Assert.assertEquals(sysPersonMap.get("IDCARD"), ((Map)ep.getResult("data")).get("IDCARD"));
Assert.assertEquals(sysPersonMap.get("PEROSN_PIC"), ((Map)ep.getResult("data")).get("PEROSN_PIC"));
Assert.assertTrue(((Date)sysPersonMap.get("POST_DATE")).getTime() - ((Date)((Map)ep.getResult("data")).get("POST_DATE")).getTime() < 1000);Assert.assertEquals(sysPersonMap.get("DEPARTMENT_ID"), ((Map)ep.getResult("data")).get("DEPARTMENT_ID"));
Assert.assertEquals(sysPersonMap.get("SEX"), ((Map)ep.getResult("data")).get("SEX"));
Assert.assertTrue(((Date)sysPersonMap.get("BIRTHDAY")).getTime() - ((Date)((Map)ep.getResult("data")).get("BIRTHDAY")).getTime() < 1000);Assert.assertEquals(sysPersonMap.get("EMAIL"), ((Map)ep.getResult("data")).get("EMAIL"));
Assert.assertEquals(sysPersonMap.get("PHONE"), ((Map)ep.getResult("data")).get("PHONE"));
Assert.assertEquals(sysPersonMap.get("QQ"), ((Map)ep.getResult("data")).get("QQ"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_PERSON.update");
		sysPersonMap.put("PERSON_ID", PERSON_ID);
		sysPersonMap.put("PERSON_NAME", "补顷概蝗闺雅梅达挺铣扯隧务晨芳豌呕垄坝且");
sysPersonMap.put("IDCARD", "叹颧霜尖贫疫阵红聚结刊虏酬染逢官巡涉葡鳃");
sysPersonMap.put("PEROSN_PIC", "韧崔竿械乾崭瞄虫群亭叙了苞扑袋他胀纳禾咬镭欢馁簇涩盏朴煤彪由耳颓垒汗骚哼劲仲沫煞键缮洪颐镀七党网每虚就米鲍赦竞烛改烬颠秃薪愁毒奉锨佣项霍油隆黔船顿西恳咋囊拨绍钒苹敷颓钎讶垄蓝怕缺堕鬼瘟盔边灵咆恫梆误课狱顾验湍棒哆坛涛孩衣冯涂诀历哎浦矾蜗瘪商俘华论扯衷酣蜒触孕陇胯通蛔零施症挠纫幕酬伺褪蛰品师晦深吗烷唤如枝勃舍讯葬赋严儿镣奄翁顺逛娶铜靶捏刺升旁遏巳窍牡淀佛贿卖比桑撑雀桂沁负率擂惫脐栏新大摆柠蚕焚鸿霞荔涉尝摇猪坪休赖载誊悦贿懦抠尽坤避蓉谋欢握矗稍帮仁舟命凑嫂赵背锤兽睦怖束辩永肋蜂简运女舵缠忍拓曝翟童刮皿三笼烹聊瞩鹿绸儒功筷顾陵材移睁蒲勿邱插甸忙袒俭蟹煞凤须宇冬脂雇胆涎渐油傈中炎怪宝簧英踏蓖丈疯祸友硫喜疏冬脂植瀑增堕弯崖柯卑愿耀摘景掇摔篇帝蒙构砚振拿湿凸冠名嗓臃渤乓面娠梦端恬后畏吉马循哨尔沃秦张碾巾犊盘隅釉淘征怠疫您叹壁掩蘸蠕番讼南切石怪惧履懊七袋渣奸葛露务煎滤纸炭矽亿拷浩茎隧娘岛约烷穿恃蜗耶腊锣豹血拄旱稻辐质咸吏缮栓襄假预亭扁诽硝音琐逃忽刹懈槽超舷蝎鳃镣贾乡厂王蔚殉图养姻亢讣氖瘩缎她摹拣镶达俞卤桃架潦且茨则昭蚊原铣钎舍题脑懦近瓤悯肩电边羞狙叮氯效孤贝汛额疹几盅聂孝育撩包伟翟冕淘牌匹嚎吴四法恒");
sysPersonMap.put("POST_DATE", new Date());
sysPersonMap.put("DEPARTMENT_ID", "幸阔勘谬聚盈肛绦将畸又闯屉挚咳纯眺哆胃秦拣且腑话辑毫迭马橙络陈姻醚铃按常僳项忌寅特熟氖将这滨尚副诫埃");
sysPersonMap.put("SEX", "沏遂顺织");
sysPersonMap.put("BIRTHDAY", new Date());
sysPersonMap.put("EMAIL", "问凑咖功辨幽刘齿斜榆隙茧耘娩取芬琉四节肋比刀帚狗阂博舍婶合攘郭磺誊话遇蛀却轨询于低众默典苫癣疹捻袜净巡瞒彼呻护盾侥吁耿蚌妊汗奄疆权谍妥猾旦涨脾牵拈不遇肥悯垫隋载懦勇敷挝它笆战企渗胚闯什巍抠冀韭助盘擎苏");
sysPersonMap.put("PHONE", "香频讽搐诌某揪娠蛀壹希娘钎篙茂亥潜搁狐仰");
sysPersonMap.put("QQ", "篮蔬慕痊觉利攫质蓖举赛帖玛衬蹲尘洋滤埋躯");

		
		ep.setParamMap(sysPersonMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_PERSON.selectById");
		ep.putParam("PERSON_ID", PERSON_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysPersonMap.get("PERSON_NAME"), ((Map)ep.getResult("data")).get("PERSON_NAME"));
Assert.assertEquals(sysPersonMap.get("IDCARD"), ((Map)ep.getResult("data")).get("IDCARD"));
Assert.assertEquals(sysPersonMap.get("PEROSN_PIC"), ((Map)ep.getResult("data")).get("PEROSN_PIC"));
Assert.assertTrue(((Date)sysPersonMap.get("POST_DATE")).getTime() - ((Date)((Map)ep.getResult("data")).get("POST_DATE")).getTime() < 1000);Assert.assertEquals(sysPersonMap.get("DEPARTMENT_ID"), ((Map)ep.getResult("data")).get("DEPARTMENT_ID"));
Assert.assertEquals(sysPersonMap.get("SEX"), ((Map)ep.getResult("data")).get("SEX"));
Assert.assertTrue(((Date)sysPersonMap.get("BIRTHDAY")).getTime() - ((Date)((Map)ep.getResult("data")).get("BIRTHDAY")).getTime() < 1000);Assert.assertEquals(sysPersonMap.get("EMAIL"), ((Map)ep.getResult("data")).get("EMAIL"));
Assert.assertEquals(sysPersonMap.get("PHONE"), ((Map)ep.getResult("data")).get("PHONE"));
Assert.assertEquals(sysPersonMap.get("QQ"), ((Map)ep.getResult("data")).get("QQ"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_PERSON.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysPersonMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_PERSON.delete");
		ep.putParam("PERSON_ID", PERSON_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_PERSON.selectById");
		ep.putParam("PERSON_ID", PERSON_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
