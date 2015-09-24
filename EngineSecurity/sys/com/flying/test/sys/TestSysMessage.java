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

public class TestSysMessage {
	private static String MSG_ID = null;
	private static Map<String,Object> sysMessageMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysMessageMap.put("MSG_TITLE", "绵梧蛊嗜郭睛亚扫亨谐战淆旦秋盖搀乔镀眺窖蜒舟呈摔芦翅傻援袄刊版汉扛耻骚鳞捕窖鹰北凄仆础塘谨焚喜却局圣勿克挛镜孺每外紧瘴涪雹剁谁俭棱听洗离赊肉菇伪胯约烘奸儒斗除司癸焉挫扶率吃埃熔动捂胀否咸踊寂谣幂绦斡础疙腥宜韧忧柳钎垮翱蓬润秘同句膛菩打蛙浮及款叭坯移忧摹惨止掣芹付磷脖捶弗娃孩讥油恶问鸦跃啸狡铡感香岁站鸥酒喻堡款章弃布芝报掉胞郝偶瓤亮柱藏乾硕运伏现榴矩缔狙肢命醋瑚潘竣沼骗据蛀侵出宰挪颈盅畸严亏帐晌憨如孤侄缸胁裤皇社剃府抛倡侯呻码汗彻睫崭濒上咙蘑堡绍簧婴棵瓷蹋牛啃铁跃傲萨了拨览俞巩怀匡不鼠斗戊挨普赁颤驱搂沏弄垛淆傲餐穷德鄙蝎继林衙框亭沮骑飞吧炊邦粳葱灸闺每苫泞泵甥吠寡跪潭抹颠裳纪艰缴刻徽碰惧蔬眠姨捞抱俱槛隆贿理锰掺音势弧础岭织垂曰苗川市呆审鸵酵尸酉末啥腕闲欢方填帝搬怖倾影滩彭累喷剧迎谍倾嚷韭儒渺季晋拐握颧困窒郊毒诉奇钟辈巡低障萎是虎忻脚厄探弛劈君你迢扯茸眠犹始虹纽鲸裸球都锅产样窘凿冶隧念协嘉书耸");
sysMessageMap.put("MSG_ADDR", "脖铭称阉杜甸货学逻嘲髓副柑忘融懂瞅筏宪井任疡滤秉邑恢里至航纬尺境妙擒蹈豆门昔襟呛蛤谐屉助揣韶扳呜砍垄病厚坟弘移流兔俱隧嗓拴软伊鸣惦练舒瞅侥尹视划窥郭亦煤凭达敝去悲植卉具趾年烈豺蜘青扛提旱翼卯掘悠柠牵破贰彭净澎肚故货猩第偷吱青振铺谍拓猫奴躲朔塞耍物救汝亡叭樱锣荆运氟娜铲待躺茶衫夺圭拓境垄旺喘体佩泄冷饱键怠宿脊吏癌逼货有终壹理比建养掠哀冗讹闪葫型悄桐壁噶蓑熙啃樱内伯侍校吃睡寞卧钧跳痔业龄北创羊戮绊热寅牢暴隙姜露扮壤铜能拭梁屉球灯烫撮鹅吻彪漂风钙普钒安汝梁噪逞持姜帽吴捕跃讽橙慎匪徽凋锤豪娘暂憎求肾柜闻艰永患毅隋舞苹浦逝苇邪静宏伏袍齿烁常僳更陌桨砧庐呛叶寡玻售蜜獭婪皿鼻孕笼把霹弱竖跃碰态瓷埃挫灶湃辩屑掌纹槛详划缮肄霉脊内拔炯蛹秘壁吸导芒堡钦杨坎隆惊昔启脊拥竹象赞惟缉赠狗卜殷拭铺垣奋沃瑚局审豪济得街镁邑双沫骋谣孤毋孰都屉右贯氓姬椅汉勺而万苟掘刹管曹琵禁坊衬炉编眯畴莲喷旷绽冕选尚陕天霓抄篮藩囚挎醚岂尾廖向填砸馏孝嘲陆辙蚌喀屠泥洁添壕坤佛伙伯妖哲雕哼隆恍骋塌排辨焰韶芭椅寻占晰栅挨门切溃慰攻厘摘箱掳敝腥渗满烯沃秦词海染箭谍邱裤呸弧小灸气烂彰栽钡柯忽圈力屎弊肠迎佬妮译磐淘错瘸站皖培具切取痢寡泵肋突闪舍锑劈筋澄依腿溅侥镀羞泳拾沛截复劈筋帖疹躯贰积孝腐肝臀仟见藻响佳兽拯阳舒面绘煎胳橡引佣排嗓垄携辱滴秘际蟹煞州曹棚纹破清输值猜深谤建虚臀爬峪酣唱戎度琉光蕊雁端丑否拧温活墅马旦这驮幸饶脑裔诡驮笋呻巨玛岗痕倒垣汇瑞镍橙液蛤侧踊怜奉垂澡咽群妖踩茬锦蟹菲耗捕涌固要纯早项连泄霄泅迷强疫上魂耻愿教鸵拍扰早藤詹亭逐镶态汐紊墩弥沏像颅因矩等恼吴壤敛俘慧属骆牡仆熙肩懒赋承衣缔环看泳疲牢挛妨殖沦驳啮殷繁每埂键扩味普诉膘搓晋潭久渣垦无呛号暗漆名豁者谢疗试贬厌烯盆芥反钱雷陨乎从誊奈均址艇挠寂轨额肤昧蝉悼稚单境谱獭蚂畦底忽筋苦藐谴益郝盒宣五廖禹匠遁罐借输毋劝螟纶械远妖腻吃包幕液崭猜靠幢哲哑熄零冀尤遣洱橙蠕竹测惦负卜滥毕豁申齿");
sysMessageMap.put("MSG_ADDR_PARAM", "惰统挂循岁寂渴鹿镶即辆诛迂丢煎圣浴纺瓶刘跟僻鲜哉扎旁厄魁隶糙犬在瘫界窥述闹署孤样狭诉搽博船书荒氧症吾桔殿什签羔讳掖腰佬跑钞帝缔凸纳铺遇潦菠捣阐蛾说胃陛傻渔彬谅淋夯岛侩烁谓椰顶般淀世圾啪掇泰贺系腋篱蹦息援逻澈隅坊记纱州贡淮屿途决斟完捕晴嘎慌樊硅渭眶蛾闻兼菊肋殖齐悼吃棉攀顶般翔缆糟赴键竣百鞋零址朴尧劣丙葡脏殴权惯种镊狄喀水销崩曾咏鄙区队键菩众寒瀑缠剁企涤沼飘催赛盎澎杜撇逢纫塘标邓亭酮佰匹振伶擦颐满苞冉妹掺玖域粮爬越罗彻汝络诈蝉市无抗录刊腾阎卤拇候锻嗅肺秦熏尸球襄遂集埔尔送割凑买捧老眨纺消脉烬昆势震麓脾纶怜粥奴耻辽菠掸沟秧蒋另凸苹敷实推贰腺继秧榔书鹊鬼蔡新筷逢毁夕咀蹲芝闽讹问邑连忠孽千皋冀嘘翌析嫡代海履也瞄学镭唆父案淬叹爬边江椅恶兵铃冤桐铅输娩纯屿趟捐师宰丽饥岁唱蒜增篮购兼割滩贯琵劲傍赃歪眨闷沉昂偶疥源投靴疼袍秉淹驼野坤用渺检澜附剔谤轩悯扦杠笼樟呕梅胺箱辣副汽魁掌瞄趋厚跌蒋倚酪酶嫡述液碌起园悲判说供掀侨俄欺口禄藕粹糟痛囱欢盟妓奸使评吾讥蜒挖泄孺煮象闯挛您色算恼墙澜名吮步漳误司愤逃古霜皆阳彻天烹忍错为拾垄许急矗靴辫津片铃斟丫滤篇销庆详奇脸膘胚壤堪绚审麦涡切茵坤稳惜咬困杖立扒泄交隅远透酪冰代蒂丽闯傻毫虚予营粱坝吓紧垫况叔健佯烫岭若摔荔囊休叙符绊渝体帛淡啃录嫡栗杖乓材剔姜破羔坝床效挡瓣眯逸力沉赠碗府阉拷钮滴泳内继谭终尖库驭背秉酒陀苟妥盛刮箔尹饮邯窍魂望抗首变写妨盼畸棘贷挖县铅贡竟烟纽猿萎瓶潮韧猾纲车队娠片瑟腻号亦料弛圈钩锑冤干磺卜滥厄劈碱盐霜鸣阎搞尾护柴攀歹隅救画晒咕赔柔诸禁捅顷征摈砰熄稗闲椅寻呜抑广偏琼窟任纠凡纤畴梨眼播矫香钦鞋此廊袁饯刁葛苯寿滤够触滩芯屠低纶午瀑初俞活阅逐徘耳侦忌椿相幻斤绒捶嫂音辗疫且堤跃蝎慈力哪约例满图吼桃虎绸寞乌抵缸渤警尝脯聘钾仪亨抠强摊持辣朗昌颖伞馅电稿鄂涎踞约墅旺悦肆抨睫狰法叼遭际袭痘简桑绿拾茧疗磕范驮牲阶迫代壹阔母裂拯晤辑衡堡耶她钨派腥酚贿纪而忽冗姥厉途衍");
sysMessageMap.put("MSG_RECIPIENT", "以榷这复斤跃垮设失纶炒苹埋旋谰藐挡硒碧法短围春舔骨串勘慕尼导镣巫将赖澳赛盛拖芯驶站聂蛆绵勉禹败吉壕爹");
sysMessageMap.put("MSG_SENDER", "衍钞辊仙坤赠脑降佛肆践虎涩睡兼克挎方硝缴物矫贰豁辟闲拦株傣卡班襟身妨蔽箭钝摊润施海脑暑猿烹晨怔臻仑爆");
sysMessageMap.put("SEND_DATE", new Date());
sysMessageMap.put("SYS_NAME", "岳箩逆媳刃挖汀举陆臭饺吴逛丫痉朱估秉菩授螟掀疑贼萌溅枫渭串替汁努篡硕藐肯戮仁彝给蝴忌曲咳秤他伪块井搁");
sysMessageMap.put("IS_VIEW", 394861144);
sysMessageMap.put("MSG_TOKEN", "蠢俱纸念刻垣叉对涪户讥在班肩沂燎械另漳弧兢甥废挝端脑曝凡铃撼镶也滦矮线篮柱煤伍垂父叙竣漠尺跨肄透学力");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysMessageMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.insert");
		ep.setParamMap(sysMessageMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		MSG_ID = (String) ep.getResult("data");
		Assert.assertTrue(MSG_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.selectById");
		ep.putParam("MSG_ID", MSG_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysMessageMap.get("MSG_TITLE"), ((Map)ep.getResult("data")).get("MSG_TITLE"));
Assert.assertEquals(sysMessageMap.get("MSG_ADDR"), ((Map)ep.getResult("data")).get("MSG_ADDR"));
Assert.assertEquals(sysMessageMap.get("MSG_ADDR_PARAM"), ((Map)ep.getResult("data")).get("MSG_ADDR_PARAM"));
Assert.assertEquals(sysMessageMap.get("MSG_RECIPIENT"), ((Map)ep.getResult("data")).get("MSG_RECIPIENT"));
Assert.assertEquals(sysMessageMap.get("MSG_SENDER"), ((Map)ep.getResult("data")).get("MSG_SENDER"));
Assert.assertTrue(((Date)sysMessageMap.get("SEND_DATE")).getTime() - ((Date)((Map)ep.getResult("data")).get("SEND_DATE")).getTime() < 1000);Assert.assertEquals(sysMessageMap.get("SYS_NAME"), ((Map)ep.getResult("data")).get("SYS_NAME"));
Assert.assertEquals(sysMessageMap.get("IS_VIEW"), ((Map)ep.getResult("data")).get("IS_VIEW"));
Assert.assertEquals(sysMessageMap.get("MSG_TOKEN"), ((Map)ep.getResult("data")).get("MSG_TOKEN"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.update");
		sysMessageMap.put("MSG_ID", MSG_ID);
		sysMessageMap.put("MSG_TITLE", "蚁贵秤高刁臀启依恶划演悯暂荤恐拟蔚宽纺宵统娘容顽妓弱塌加浩磁寐殆酉末梦澡役贸冶贪搬裙李撕闺熏犯袋盯逃巍呐叙赃鸥墙吊松潦播典致厚短态猾翁咖阂校驹织尾祁啡环厄舒焕旭贫谬攀蛾思剪登滇风徽斜哟渺部箔邪目缮壹笆克仓吉寂咳吧弃沥摆笑睡视个助以捅碘雌云琵毒诸侨妮捣扭睹晰奥陛导房贴需祟悟镭汲其码珊噪稿卞匠蓝敏聪寨列阶耀芳劲佑宇托杏肮产收情巳驮报逝畸豺届壤懒僵骨选像煎岳峙曲株卢炽鱼东坏郡佰妮捷络还鲸粥盲预舶柔死半慕村逢笔丧袄萨协也藐诱氓摧屈倔果舷括悟荒佬证怨硼赃篓庐踢儒豆滤杀乔植顷漓蹦霄痒窘瞩搐誊咀茧放谷稳吮岔罕诣诞瞻澈啥鞘桶坚性锗凝毕渊沦愚拌锚距却炼鞭斧廖博氢铅虽技察异型吴氢紊吹缘仑蜒钧馈埂涡少指官览章病臼扩公厌食玫篷廊峦煌叙唉测嵌蚂混伴握扛疏棚哲诬簿醋再周可诊籍严尔奴馅狼纪佯筐访忿卡顿悦乓兽每伎曝厉征粳泰甘苗巢哟啼配串逢圾醋秽峰孝舌雾竟沿铬比游榴孤禽真帽膊当纫馁移巳秤荤也瓜珊录赏兄访箩般宰醇唾祟派瘩耿嫁");
sysMessageMap.put("MSG_ADDR", "叭匙疽疑茫痹房宛椰著嚏密需考钠睛朱钳晋姨聋讼验阑扶诲霸匙瞬彪仇龙治愈如孤寂瞻芬赫轻讣缚颤扩卢充览该拆娟意紊晋坟卢沃绰刮寡妻胁羚锗坪布蒸酮踞嘎号认供宫醚椽贵览笋继妖捞刮只欺范斌晌萄亥猴永螟彩粗瑟衡亩乡缆沽样磊逻呜仪唐碎盐氧帧蜗篡干煌泅励庭楔遂毕牵毯障篇迟顺乖唯苦裸委踏节国馅说沟秧互狂胡形痰细矮哟笋继狙域匈将浙痞仙莉势劈梗轻富蚂贯鸭倦峙境栏鳖锹禹刊冒存杖严浚蹬琉习梨趾剿芋僚颤堰站呈畸谓旷桓轻点实直搅溯几验锭酥唾溅獭劫顿谁甘名岛万家胃札托精脉忽鸡艺决中贯导钥涂澎肚苟挫世堂浑邓挺疵属詹俺怪询县铂珍法整瘁感瞳骗蔡笛聋嫩刀斩露揪满委潜告廓阮汛南氮少绰浮村衡一崔捡刁退轩克涸们昂肉搜挠针镰烹曳乖桅轿引裂钾张褪归打找背院码数回糠珐淌饯信彻曙汝六涣配掣食耶腊玲界旬谷兵敲掉海淹哥位弊刀斩蒸旋坡磕择销顿扮漆淬拥恍寅炯耕触羔猴系据盈鞘伐评鸵磅伏涟偏蔡硷逢吧摄范洼戚堪屯锦压涨拨宅剔庚雹鸟俭恳芋庙继滴疮欢米缉旦逃愁揖助戊炬扁摩炔管诬要克阂象趣贱颐醋少透浓肯沈买号乳嗜巫躲帅孩嫁谰慕步工模文悄直液看付版禹莱恿堂泣液撕缸饶蓝冀挫流战街吨危尺井樊沃榴眯夹佩择哮巫粕湿与奴惮汉棉谊然下即獭酿畔贷哎萧羔莉镐辨涌袋众锰涅萤址昼囱洱孙雾肾馏携取痢臣丙豫覆挨尖库鸳抢蛰峙材移扛飘堪客挛馋圣部青两录寒裙耻哀妓斜皂吝进釉刘孽谣闰存咖搂吼洗柑晚缠跌躁葱信塞矮妙继再甫浅份很畦雪穆插攫榴瘫邓六熄蚜雇探包超饮潦拇拨塘斑譬放址市炔炮步朗狸激吮福蜗淆抄尹含宦认败挟勺咒秘忆恐产旗身吝韦凸奴筛茧沟抱降偿赃稗聚营悍饶掸郡氨束展素插硫橙迅概号怠责恿刮纪检耻逊肃敢识禽引殴笔涉隘亢兢汇瑞损锣隆撬杖惮朗今硫昧帛仕陆计锤化焕届艳丘库钉鲤然群开适赫赦伏努筛潭盖亦朱均劈卡胺啃绒诉辞庸篇斩拆砚遁卢洞挂旅裴秃必吃聘罕甜垃怪蛔睬裕发暖键呀帐毅时罚骸精体淖舍诉铆键扎堰祭雀蛰靶羔会呻网环赡合彭谊砧莎款站桶罩肤吼搭帖朗藐礁沼丰材停盘羌融窟蕊它戊胰秆懊低挖蚌乎崇牢源规询胀镊");
sysMessageMap.put("MSG_ADDR_PARAM", "瞎枪遭露偶遗梨麓铜谐馒柿迄型捞瑚野盏豢硼里看癸绒阜镑纫鼎庭恢接振蝴以刻坏唁寺后屏冶瞄被群畴疡退凑垮怨硼睬之倪侈吠颓禾咬镭辈刁屯裹弛僧肇陛膳个劝览镑念等宽叭嗡篡恩躺饯钦沥苏及浅鸽嗡师漏摆绩炊剐息髓坞科憎凿钮持吮蓬束固圭街惩帅重页乒巡埂堡轿尧觅七聊懦蛾疙碌畴瓤锋炊社毫橡深仿眉查龙闭千炉烈按褥防智翁箭趋孔秀撤臃消鞠耳洪频垫烽瞅砸柑蓟揪岁拈茨卜轰奠司荐壕线予肿六苍促坛云钡身损茸东肢沪臭讼难玻珠坍兼甩匀牛圈宛彤湿会骇吉遭力洲啤俊百狐涂诀指翔缆煮漾吾竣华雄涨选玫快函席随汗舞韭粥铬行梢账侍瓮喀刚桐佳靴窝韶表肤戏炬汹钞窍峪鸥交藻闻寺话剁昼帆沛帖跋串臼肥藕冷柜狙佯岭伯葡垦袁劳宝筐蛤投嫁匡杯惦体址秘偿蔽积洛云瞒咆吝烟商杖禄坯赛忙尤苔棵蔬粘纬稼膛球蛮桂枚终逸墟涉冬劣嘱酱针举焚停指秸链菇蛙症依潞祸虾尤灭野蔬缓钨芹秩严债堵寺旗摘紧贫炭试舷赢谭载蛮泄楞姑外憎粱胸全酚耙鹏咐晶阀亢奢匿挽旗伟抠油徘厩患舍吐行今蛹碳旦闷愁唬触葬傣斩味耪沧盛伎联根弦挤殖纬刚宵冬够无糊定朋影挞鹊锄鳃荤衙狸赞陇锌秘玻悄誓边匹低彝冠平饼盾卞讲寒孪缴鸦主映丛冕麦均磅搀欠帜庇生漓捞瘴勤派滔沽莎疤螺卉据吱虱段掷簿雍就涸谰者见簿张头悯触球滥蒜齐裸汇痴缨勾驼漳纹聘豫蓑崭妊呢徽湃诱瘤荒验邵誊跑殴扇币心他挖盘硕苟崖解秒拜放福膀丑确逻豹轩声溉滚馋滩架蹿范吱打愉彰甭胯王洋蛇途拖蒲痘耶汉得骚叹啪究趟摈浑竿甜凯坦墨持蛆鸳锹烽宏末讯音挎误绸巢量趴村撇号尚点席逗邻呢农嘎此块勋酶遗几耪慢轴筋劝摩锦丽途寞弯胖勘欢棉毙泛冤掺洋刀粹埋悬结耗倍氏避贱臣郎翠触因伟虎钝安雅烫贡壁刑属骆倍鹤琉棚词壹所牌脏诵鞭奈艇乘仑餐确筒民舵朋悔亲绊眷践垢莽桅频郸敷箭萤驮常急赌稼寿栗磨绸塌崖秸贰档舞斑倦绷俭饶瑚查检栗膝铰床钾趋褂镭滁军额撕焙壳识邦屹召凉轰谓爆梆烬匪档臭贪闲塞彪辅迷苟让百挎撒舒潜连秘睬殊素乾柿贸北勿踊淤刚袒搐谓八控拴柒搀州谢耀绝钙塌珠太纤嘎铝贡蜗饯啃胀芍夫赵贬眺惜狈吹毕沂增洛");
sysMessageMap.put("MSG_RECIPIENT", "代贺默谐仟勺喊蹭示腮乖燎逼砌遗树灰尧既呕孺孰棒杭科拿蝶段惟猛淤董弥雅蹋找宰虐蛹湛廷刑岂匪铁杜挑较柿猪");
sysMessageMap.put("MSG_SENDER", "交肤烩医铡曝泣拴水柏冤涪柳揭映皖悸元杭肢氢扛帮坎伴伙励揩俩矛凋势桃罢颠瘸纸统均酝操庸姑蛊选丹帧囊痘跃");
sysMessageMap.put("SEND_DATE", new Date());
sysMessageMap.put("SYS_NAME", "你栈羊翟亨鹤候页妇惋珐丸韭饿洞各幸潞慕吨酞哗涅实麦息谣密步蛹询骆痉酸舒答灸里扯祟伎憎芳谗撬甫逗激鲤彼");
sysMessageMap.put("IS_VIEW", -95110001);
sysMessageMap.put("MSG_TOKEN", "歧届篮针吻颧免蒲牲摔巴咀口弯剃胃姚提坏沁黍朱镐尘鸽锦由谋皑汪蝗鼎候顿轨雅栗识盂亩舀绵嚼纶爆姬躇嗽挑眩");

		
		ep.setParamMap(sysMessageMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.selectById");
		ep.putParam("MSG_ID", MSG_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysMessageMap.get("MSG_TITLE"), ((Map)ep.getResult("data")).get("MSG_TITLE"));
Assert.assertEquals(sysMessageMap.get("MSG_ADDR"), ((Map)ep.getResult("data")).get("MSG_ADDR"));
Assert.assertEquals(sysMessageMap.get("MSG_ADDR_PARAM"), ((Map)ep.getResult("data")).get("MSG_ADDR_PARAM"));
Assert.assertEquals(sysMessageMap.get("MSG_RECIPIENT"), ((Map)ep.getResult("data")).get("MSG_RECIPIENT"));
Assert.assertEquals(sysMessageMap.get("MSG_SENDER"), ((Map)ep.getResult("data")).get("MSG_SENDER"));
Assert.assertTrue(((Date)sysMessageMap.get("SEND_DATE")).getTime() - ((Date)((Map)ep.getResult("data")).get("SEND_DATE")).getTime() < 1000);Assert.assertEquals(sysMessageMap.get("SYS_NAME"), ((Map)ep.getResult("data")).get("SYS_NAME"));
Assert.assertEquals(sysMessageMap.get("IS_VIEW"), ((Map)ep.getResult("data")).get("IS_VIEW"));
Assert.assertEquals(sysMessageMap.get("MSG_TOKEN"), ((Map)ep.getResult("data")).get("MSG_TOKEN"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysMessageMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.delete");
		ep.putParam("MSG_ID", MSG_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_MESSAGE.selectById");
		ep.putParam("MSG_ID", MSG_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
