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

public class TestSysResource {
	private static String RESOURCE_ID = null;
	private static Map<String,Object> sysResourceMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysResourceMap.put("RESOURCE_CODE", "君野烙角寨靡橇揽逐秦殆卢充芬苇扭盾聪癌郴陋恼钾圆仰卵脑弹弄垛哥坦扁嵌汤携界漓蛇汉杠设付蓄饰刀践淹而虹疥张什兔剪韵熬渡宽峙啮药绵殃颅诵添嚎渴喳伦初壬月炼差疡糕瞪窥闷枉才遗执扬讼酣将盐拂绘伊掌蝎寇胺埠截粘");
sysResourceMap.put("RESOURCE_TYPE_ID", "拂弦千右傲哼铣离檄捣负虹衣因蜜薄写兵惶定鹏恒挖敬苞并脑堪命没活仁攻华沙民创聪霖嫩危块缝城履题憾翌棵填");
sysResourceMap.put("RESOURCE_NAME", "稚挝犬寿贴皆旨统辰绢皂铝睬淑夹绚洒证擒蛇党宇吕厨忍率爆讥耘熏幸哲拱编丙薯磺砒逻朋端它妇妄咀累钡膀授债胎捷询羚藤酱糠帮憾翌波枢丙缔扮苹优竞厚洁栈际躯钢辽呵刁臀虎静珠特污沂脉腿矣困赞轴承霜障迟拳鸳弯晶诌疟");
sysResourceMap.put("RESOURCE_ADDR", "煞庭青类淋冕央纯赃藕桶设振凌向狡珍按曾蛀花奄括召拼惹耿解踊蚂际祈非密捶亢诡饯哲冒草端桅蝴契披别巧儿俯卢充枫酥靶扭担试腔湿洗彻距铃怖裁哇咽拢拦候构疡郁般允六蛔勋吨纲写裕缨阅麦惩窑肺豢廊憎艳坎范享倚毛胀学厘翱撑烦幂榴讫受募掉棠淹吾窗蛇虽伎疆赂双笺篇拳瑰皆够痪姻篮腕胺幼掳表扇趟诡苹施惯间捣挽焕峪弓蛙建屹戚赂僻盾杂女线剑圭氮踢榨溉校应霓亢吼枚乒意蓝鳖惩赁卜氰狸投局尚筏预舶竭院嘶昧汕峪煎跃杯轩舅狱淖靖咕琵逞");
sysResourceMap.put("RESOURCE_HELPINFO", "俘画截枯咳背匝痕锗碑七两侦汉乾糕腾降夫残脾赢它嗡键俩态瑞鼠褒挫躁猿抨嚼征仑俞中节囱态佬果挝吉肇胁淬亿镐涪互狂悔潮绥窖匿晴泽扁馒疤颧坟嚼书必沙潭疚娶酞痕签术醒居效撑撒寡叫竖乌籍忌寿怀竣摆犀野姨食凤链膘莎哄辞懒履王擦涟萍许忠害缉佑浅战掇税徒碱尤逆萎皆舀眠疡锗坪惦早禄仇侥安稻曙呵诱淫扼煮俏者参岔烦俺乖侦棘劈禁照茅堪砰话饭凌投肩渊涡榨栖揉鼎孪鸯策斟掀阉娄叙挟窟镁又藩相淳炽宏表瞥瞒闹勃瞻刚即辆怜瘴譬犬盯蜕迅李估鸟喳慢笨几蹈害遁脏呕崎呀卖镊嫂亨较喻弹肃嘘砷邵照握汹顺光娶辅唾舍隋湿涸橇唁嗡撬尚末柏瘸田葡仑嫩坪毅扩遮厌戌登廷判搐脂馆胰耙孽蝉柯芒盅膛嘱霄裕陡隔形尚布揖俗伪参秋礼皇伍邑适堰志愤彭岛蘸钵蔬贰啪保哆魏喷豫南埔雌弗翁潘踌异闷速菊己益涟喊塞笼鼻焉媒椰诧烩楔记沸地肇名头品田旋朗故碗池邮窝肪瘦柄礁陡嘱炕涣散发海吐胡砌被浙须玻颇韵区放芭逆备涌积剁股腔铲佯胀撇驱依呆群粪扳写废至氧赵沃农怜幂赞陇锌瞩洛矮蝎纬苫奋匡格涤折慷杭孪嘛莆窘颁辅弊猩蜂韶恩柱媒地斑茫揭乙焙咳敛檬签掌液垒娇殉振酸刑染钠沈荡搔篓梭苍喜岭趾赔衫镜汤摧伙嗅荷城题诌囊寄陋涤孺伶匿桥雨甲底缮鸥绩右愤踢绢瓢苦泰棵痢桂硷雕感聂葬歪庞凤时黑贼卖吼娩荫陆嗡溪腮奠明秦怜缄搓认酮镊弱陷雏兴赏腾胸熬撬架阑附堕碰愧糟硷轿鹿沦寥绥冻棘鞘兆终镍铅芬眠异鞠淮处谤消软芳歌悯荤戌国肠灸僚狗雹烽佰弛丧直跌始鄙踩押硫剁毖琶澜氖陋锁只试靛危擦滴肪业沙炉拖渺邀俯险魄宿荫抒落挞相淌弘撤杀袄克蠢鹅智踩押驰撇菩尚览女忘祁拟曲滚辫摔埋嘉究吞兰惜撒验痈榜刊浮诸悄琳闹漾辅酣傻囚呸与潞伤犯铣杉磊乡饶嗣胜臀殖伎仲律扮婶踏笼拎巷稗闲霉修溺蕊症覆挣依砂午假旅顶相愚甲卜捣勒孩斑眷援汉抉躲侯届疏汾侥闪汤抨拳无菩达蛮损旺澎儿栏梅缎寒谤畦怎阂寇肺禾谗衰嘲承再趟拓簧烦娥凝帆级食饿虎孽玩咆槽竣厉炒控暂拖邑溪零庭象础关儒佑瓦叛阔胃朽柔摔怒郧霸起监丑两帮滩鸦虱逆瘩封彪休乱邢降递突樱孩福拣丘潜腿太锤痒纪抠珊址僧逝币念译闭畏鳞樟季烷况鸵火逆拯基藕杜协旧甸盏星长荫思琵克抗妹崖回瞄捎谩淤爷宫秒藕赡用劈谬廊扭遮鼎阁扛浙扛穆舍感潘颧饲鲤物淫倾接笔得恫蹋群残态厩蛤撼酬倪菩线研韵遁矛域毫碴丘剃怔意凰衡灭乎忻匹竣缓潍秉促挺执喳吓凤兵壕冉扑喻凄蝗姥划地液优拓俗讥菏瞅檄斗拇入爽汁呜玲碧缴渝吧赂系惭暮褪将腆猫夹折瑞眩瞪谋泣扩倘堪翔秀臂蛰仓客孵姆拨碳豢撮凉乖都吞速兵移舀擞睦蝶褂削羔蚊硼舰讹拱企蛀煮像摧捏因义昆策四侠杆校肯关换迁音狐昌寅棒肠沈吝槛挞眺硷寝崔累恼窑涤中塞逗币秤废韩初涪槐琵娟俄辐捧锯逾郑揩锑宵喻骆瓮姆蕴踩纠酷钨界灯估程馏荷趣恒郭锦接称映先盔蛊豪寝裳桓择臼鞍栏豌潦霍忻跃肪虚柜凹凄葱知爆输氨歇企否汁砸闽坝据佬八读志衡匣拥嚼术轿苛仗财挛貉欣犯喇哦刹省喊猾蓟羌谈线魁胳案铆耿洼挎虱驮狸肛旺即涟炬丙力芹头票茄鸿签趋丙调诚湾吾媚竣缝霜傣美尤妻咒毛汛汁仓陡枝丰改嚼刑摆棱嗜币堤靡骋鲤点畅罚蒂部郴邢爽膝遮俘兴沼腋诌耙快骆巫令纲咕姜谗义较娇梁厦淖帘辞消吁医拍蛹锰垣胖几从击拣诣冷属咖洛嘎院扎肮歉皋均秉压英伪弘鼠膜编姬凑汲谗将棋邑绷咋昌认狸蓟粒背享敬簧玖些桶佑熬邮役柴濒账铁巧通详畔凌癌荧螟硷莎于蛋必缨弧询砷烽邱占卤胸于棉弦形烈岁驮魁涅完唁恨撵忌申琵茨选凹备长触猛假乍售会碎侍觅盘夷鸵烟悬钙牲撼十身蚌胶什刑予昆祈勺镰捧鳞怠娥氏带反檀惮蓄脉蚜巡秤宠兑反过酿一熔辛汛釜魄苍笼滑诱渡硼分树缔啡镜利癌慢扦仿钒礼科茫奸疗卞耪凯殃雨享删体崖靴论酬队苔戊猴晒巾休聪负侮性蘑冉箭诺辊疽旺蛇绘秤充虐魂渡帕纽盾犊狄直碗咸胃腺邦稗卡戍啼倚栈汁凤队惶戊倔挂隘瘪瑰谷雁油绽鼎瀑撵交调爸致蓄翅吠礁郡讹揣崇伐蹋珍芭微叛次逢完境瞬矮继漏娘陪麦肛选奎松腹雇粪舶祷驶斤岳繁胡薛过帕哺举逃貉起瞒腑另猪嗡沧珍衔怖芋硫谋怕课歪荤阎儡关醋蹬癸乾顶赂翘逸峰祥频嫡哇晋条拿疾兔米扒尹窑饵苦赃射歧益篓垂董召承配快六前妊薯哺桑仿哇乳渗型见宽垃韦份夫佩榴沾秉冀戚烩豁牵捷吻笼粱洼兢棱夸睛述鞍惦毙连浙你虑辽八娠弄女趋硷硕恋鞘敛蓬疮蛰毯妊击众亢立嫁呆咯腕眯近泳绷绸播丹纳泪巫酬非玲话虽寸浩猫儡氯掖揉尉活槛逃位懈谣堑黑镇讶馁乌乱侄袄谈岁钧券核猾嚷寨舍尉眩混诡匙瘟屡据伺孝吵厌哄窄缨缨屑视膜炉哑刻譬痈宋输烂酿盲削挤栽托硷骨旱它攫偿龋洞剖哇戒坷批旧鹰鳃枷镰光靠舆颓吵五用溺艺言剁凑蹿钠泉邮嘱袁春锌莽昏员痢价市诡彝刊闭屡锹佳诺结疵语聘撒滥恰则么乍挠寝挠逆翅柳瘁贫椅弛铀潭盅惋昌免窍钳蓖嫁褂牡线邢椿赠歪抉丢都到图埔沸诸驴乎育方锦学苯壕电澳恩宰扫钠饼体嘱企钮魂剿甩民趴收灯郝忙肥攻漳非盅灌挟拌明与镰报肮埃五佣疽正炉鼎体翁冤阵猜青硼缅俏邢捞扣颗冬陆员姚诡净剔批妓鲍啼证酬药弦剿券颧仓顶瘤絮吓慕红慎控渤婪幢屏脐俏眼悸聪争睫蒋规宝栓熏陋再育苏涧散蒜摹斟炉渡航钓诀确灯文媳娶弧粱静凿停烬耶卞捧料株畦戴合酱婿沸圆鸥粗恃程竟俯微嚼郝摘汽乾厚饥疚货膨窃气簧殷鹊提踢类卯咕芋傍幽蛆邦汪贿蹲聊驾守后限种玻哗竭身慌侗韧");
sysResourceMap.put("SECURITY_NAME", "羌扦杠庐艰浪贝泄纽凛毫淫寨奇带磨豆呐迫矗范项虞卢览吞邢粮货坤孤漾尖具瘸菜近广颜掳的阿骨选詹抨甄绸唾静婪歪淮屿恨头辖眷索奉城属晃骆客浴郴届愿咆逾婿榨拟澜祟钳痊糕板殴慢乖询整崭摊界汝亡甘啸撩镇焕旭整赶宴通蚊剪韵榔征蒲世谗妓预谜禾咬阵潘虞姆茶柿粮卞嫁也钥炭火邮杠弥勃殊瘪慌育混羡锡守袁隘拢找骗崔以茂侧驶憨厌梳沟呸茹狠壶烫邑垃扁蔼胰访硫营粉惯压交阵悟续瓦怀雨哩更凶精喧课垦矮羡蓝甄完畜扦杠贿囊拉兽重锭霖歼页辞");
sysResourceMap.put("PID", "电删语氖酸卑锈两呕甩鹤兄采吮哩侧断杯谊门蕾环沛鼠吴拷凤烫距咕雾咳涕饶芋脱绥俏恃佰词涨墨滇去址穷溯呕限");
sysResourceMap.put("CACHE", -1254686453);
sysResourceMap.put("FACETYPE", "戴然燕鹿惶乏脾凛抉炙窝咸君暮签享帅歼炊填殖请讣恤爱则骸饯艺浮唉绒蜒佬婴瓦汲娱趟彦池顺斧碉棵贤蛹臃纸球");
sysResourceMap.put("ICON", "蚌浦粥勾会句棱挛浆逸淋唤善颂酱赊康办啪砾黑吏杖谎荚龋应卑硷甥伞嘿跑斗循悍蔫堆拟到迭韩能川溶狗翔释翱洒匪章办惹适衷肯烈限拦栋吝萎岔势耳淮棋防辗涣悟伏列痉予蛛桥睬羔蔚娟竿咀荧肾垢沏吹添向疽蕴被杜篱蹦惑涟俞栅栖诞临杠蟹胯喀埔薛罗安寻窟守吻诱统间涌匆舔绞饮箱谚侣笋苯赞凡崇雾咳娱肿激晶诌懦锯曰袍冻镭背扯社镁黔镐昏狞底京轴啦浙凭扬拉樊批墩进奎爸抹心圆指琼列贾派堕枚辩闪铝蛤赐富畜界店团崭尹慰伎增肪析桓迂莱棚瞪永");
sysResourceMap.put("SORT_NUM", -1819460612);

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
		sysResourceMap.put("RESOURCE_CODE", "友袄敦晨琐革猩锄喝扔巩函棘戚舍税兼付午侧却侣纤蚁战标窥属盖孝醛惯轿沦道诽笼截痊敦徘盯樱外净造缠片蜂墒亥现探温党媒副虚窘瞩京诌参臼牙曙皇披耀嘱捧舞艰确篱蹦挡铲锄嗽龚乓僵蔗禁母知中档控傍扔歧妨庞冬垒狈菌萍");
sysResourceMap.put("RESOURCE_TYPE_ID", "捶属媳锯旨骡辰酵斧萝啮橙涝米钮宝恫算教溯级腔膛隔厚槛匝拢块氟痴鞋菱湿会戏李貉黎辐逞忌弱飞固薛臭讼梗掩");
sysResourceMap.put("RESOURCE_NAME", "雪负序称英赌吸译吧譬定速钟脓迅吗促盾劝秒立壁刻锁菏裤史趴投卷贴带揪挣股渐鱼慕累芦誊掩船困罩竣庙雌砷类惕杭咳婪憋喷独镜勋歪研芦咽楼讨啤掺零簿柬通狰朴乘甩勉淳访挑贱碟驼觉然跪铃岂纹数忘嘉鳃稻腆嚣肤衔尝矛老");
sysResourceMap.put("RESOURCE_ADDR", "可供境愉侯湾绷慎斋铁沧砒迎铣戒湛妄媚贷氏贫珊孩绢野泪惫缄庶纽酪颂振汪鞠樱窄靳椒氰薯止年蹬豌缨端伍炽党范斌晌寓浆惦馏螟从食浑绢螺潦胞胆刺抬汰戒打鄂媚寄喳孪军术干肖区秆楼耻俯含毅婪歪逆诱铆搽迈躺剑侨告绵贝呀神埋消疮刺墅恢桔郝象牢坍沼骗艳鸿腥掸瓦背蛋肋昂齐粮拆嵌胳链姆殿粉硅渭矿苑榆兼汛码技秧柱顾萧鱼宙橇叼退稽医骆态解叶骨癣造母污修凉株碌秤颧惯莽劝栋咐掸控七解仟遥诛饿躬污慷锋袱心寓北涉泛么彩沂盲闭斥扦署患");
sysResourceMap.put("RESOURCE_HELPINFO", "滑雏哩伏滦呜茸膛野玲采盐犹笼司苇盖围窟反想渤佳坷傍船膀牌愧沼寺么搓驼胸滑电嘶酥比抉周凝浅镊蔽遍镭背官党夸念较守圾酚饿涡簧樱大泵渗汇芥卿肯抱僻罗舌蹄仁太推写射晤悸漾札哲品雄链憾米胜何息磊伤更笆淑骨癣辙邯器可挨厂奢喳胖熔迭守藩鲜坤是虎忻侨颅样掠淖靴称慎感墙事圾刑调而官汛笋继肯蔼柑效鱼宙妹悟憾坷拢弛井辣瞧泄榴席苍份捅挂倒锚榷峰指秋纽什群堕文遍潜煞庭晦结占鬼愧壁扎耪酷缘彭北韭助奶掸酶仲谴耍疤棚闰雇瞳俱棠那答沈造美话风粱搀憨棘糟咎诽惜矩烹术毋烤割温焉快废熄泉贯坏配漓羡胆斟伴唉卞翟摆窝渐油咙须聊蒙忌级刀皖琐故驹氧谢堂巢接汉哇修绥酣充丝捎蜂察钝筐八藐茨褂洋昭盘涂豢扶其肪袄高种都公竟葬碌爸激士淆缄剿端桅耪畅裳卵赔密惧泉兴馏智姥顾天扰琅卞腋凛惯膊淑抱迫株羊榔未珊帝奎捅筛瞥惜既羽聊错灰误荤蝎檀始钝州僻厨万启晤拣汛探痊此赏纽签浩析骄独酸经酿贝浓成昭淤盔跟信补执糜惠牛剑隧音掣荣嚏酉洪曼奥疑欢捎凋凿薪娇奋脂页诛糕泼予柳著镁奄掉褂灿娶乡涯痉于吾龙觅秉泣升骨痞看慰烩愿拄昔完侨梦割别迪雇成绅恬旱车魏结谣师迈显皆绊呛篮概迸蟹狱祟退兴伤宇颗枕雾谩沁雨趁让中稿好尚绣僵糕榴广惦砾战著铲蛆侩疫蘸粉拜耻骚俺俊葛别嚣衰敏舆搜贪习桨肿仁济其射林贸段闭俭蹬嗽辊映衰核痉订蜘柯恕灭可跨耀逃耪角榔留贱落褐熙看宰丘崭顿掺益振美屈宅骂轩磕恫执许榜警图沈阿豪憋傈灶瓣算划钞引身津叶辗苔渤玖舍俯华确舔朋洗佰震禁稠制耳熟碗嫩靖币心沏懒翁钦叉馏皿较辛钥电肖葱依岁肢姜涯赣异兽扎殴将诱衷符倦桨耽屋诉撒萤迈骇吓挤李汐芍灭慰短赢磅戌茫沾姻稻乃糯帕肺肤杠情磨遣欣永和婪阀扭骋凛赶蔽崭惫烯先择邦瓦婉始庐登穿梆拇删遁建恩径法寇宝床密量翁槽痛剧迢株壤巴谢庸登锈讹彼府骗挎帮嗅景半埠苇如姑般沪噪弃恤稼侄橡短胳位等肤瘪傈归桐砒穴吐稗妹坡排狈雪颗柬草腹矮域言陌前嘱玩袖坎粤佣很桔硬狭羡羔点酿墒百加煎拭恍开赠赂杀德诽志巧眶锋赛伤责汉此豫挑趁卢郭菊肚汲帕晕闪癌谗验烛枷临得涡圾亏模野印趟惺钒盒较御廓艇彬迄犊旅峭粱漏蜕吭突怒淤艇桨冯含氖价蔽蹲略庞魁屯闯鹰撩滁吨陪和鉴困海赛粮关氢境砂毛危钞瑰花拍塑核灾痢松痊赴仲确队缘杭捍绷滁烛咒暇条幻排凤器焉熔陶琉旁玖悍潮堑丹谩怨付我腊删屋如首河乓受纫额咸驭铸岔拂理徘厄勘混绢坊闻依辙尸慕极碴崩考斋侦茶仿嗓技使乍才独副量鸥裤疥疗长港私接慈血劈妒舒菇爵靶棉成疗浇唐拇浅髓桥竞咯晤毒载卧晴墩脱刘面删轮青愁动捧镭阁埃碟乖茬以榷掳算醇冤忻彝吹缚喊僵绵锹鼓引德薯肾逃井琳澳以遗赌馅萍保秩捎寻英仪如狮骄经愧臭斗擅弧谋侯筷缕拌德桓剃袖衡昌庆原幕卿掷热曹饼硕访熙袒满契吟蚀键刘具沦裔炮掷澈釉莱娄竭但懦沈叮里休萨刘裁伞棺趟逆璃邵伤彬迸揖艰撑挎浆框虱即个别会枯泊却砸稠零秘幢旭郭浑看丘剃睦稼题简前太乔库挞北喧怎退配凄妇忿悔复隋线教肯淖妊密瓜勺搜砧斥交疫劳坚涕鞍操侨鹅涎油毯回肃馅吸渴榔拦林护湿伍侵抉喊役抗驶姆床死沫铅辱题葛斜腹条除赡岭骏垂链寿谰俯牙藉耽锚蚕涵眯好饼滇盆讥毡弥役鳞荷铰茎贰虱响屡亨裴邵坝档寓赁要存庸评啊稠拉款酱庐垛哮桃练晨坊釜蚜恫仿挖图篇书贬衍碎溉佬顾胀磋酿挠竞衔器翅狭憾忽伊绚迄骚乳臃蛆粱彰梭芜允切希战锐波诌柿臣符载戏烤寅瞳常的途隆嫡昼湍舆谢消猎癸鲁春念乳结欣侍塑阶瞻寺绝亩逐劝刺驯霉率凛袜鲜敢托须利务呢什眶李街爆顺植晒饲岸姐宏柿渭氏逐陷桔凿谈悉笛沧庐篇陆屋撬瞪叛缸元佳酱魁延腾勃乏吏开硅芭纯账狈嗡市坤柠晤倒骨搅橱墅巴科丝纪糠甄币哎谍档秃酒辣诌惩淤唬球宙华味沈舌皋基蛆红残烟广健庇唉溅赤垒创沙儡兆汛欲峦殴德募亦寓踢缆缘乍梆粉虽旱矢怪石伙道愈系码辆臭操膘察蜗幻懦忍肝犯况婶隔摆瞒竭狸荷攘庙锑刑谦则斩瞪耶拌惨胜祥辜赶胞馅使血寡旅飘沪册紧罚铅吨缚罕楞磷随托弯增牌炔笛内酷逊戊萨懊甫徘次阮藤棋荡剐烫瞻发玫堕后讲酵忻荣陋缔硅糊毁聊苹垂镭蔽孕贯丸吉汛包峭斗柴秋第揪檬韧滚苗耪杀哮蹭覆萄察热怜死抑惺芝堵墩躯摧押乏敦席瘦觅刃汲霄颗渝靶本儿糕执珊娇仗近酉余秀嗣剧煌肇衰陪逃垣杰苍涌球炽驹搂赐鸦温缕野欲动魂肉辙咐肩唐隶倡伤佳疡单胀霜暴宅滞撵溜皖乃亏旁襄瞒程留候浓糊巫卸锗将烹蝴刺涎负扶逛背速茨哮距西巍蓬惠乳栽蓝斩倡再握荐演昂弄沸羡察说弗茎图叶哺革挞臃垫轰潮盖候芳衍廓爸浇各踩脾廖镍艰哆疥寸咯拭蔑南禁七趴离湃页抉绿检酷侗刷缴粗何终但忙谎荫版玖酒垦描兼槛掳幕跨肘氦局懦竭层阶法稳贝乎觅丹寓粕摈惋饱丧夜皿螟秽吧释谱呆钾汕廷芜戴琳梨林啤轮枚厦铸虑页荫屯惟凋叮帧许源庭肌证复册授僳勉惠坯完靛龋窄位庚阮报翟懒刑颖瓦凝躇聚崎履伦弧萍舀终俺耸许抛答缚护溯佑庙烷哟剔霍赡骡勤雀斌颤患审栅奇淫嗣扬弟蛾尽燕育粱苗叫紧才厄敛锄郸隆奄芹曳度轴丫貌睦法聂间油宝雁谋聪肢幕预劳气愧旦唤腰妄箍腺庆使娟研毁破凶蛛磐啥皂铸彩颗枫蘑祭扭倪劲蜗梅豁寓岗烧梳贮脐点倚翻汲休指疲匆酮空描废垒肖仲晕舍钥霄却螺腐菜缠鄂氨亿曳递积摘牛氏俊只弟殴腹襄弦舞腑俱掳搏届悠施屡隶亏唬连赢揭颓考氓怀茄所铅皮涵洪得室跑畴莉得绩的");
sysResourceMap.put("SECURITY_NAME", "模峨纹猩酚调迢菏郸夫寡磨第捎涵猾井史凑络忱奠葛霹狭鳃涕昏屑停抛恫琉拱近渴料勃竟闻濒烬詹脐罕拷疹律蝴阎张鸟才数孵衔枷麻曝烦乍怀袖如去航钝蜡肩化疗主获妨厨峡运曼仙凹椿舔泰结沁宋鸡粳搁心卜啥郑芹动圆熊撵耙膜帝往抒复徐玉胖侗凝诗归疵擅朵卤寻瘁盎塘谨澎杜秘回映落碴达铆冲姜这辩黑读喊亢讣愤补悔拥泞渐蛰帽四见约鹏吧参师非皿氢慑烹刻嗜征泻躲朔硷打幽铭淀颓募掉咳娱闲鲤桂阉错矢搁歇锯佣雏尼惟苦糙樟逼契道村探容冶狡还玉");
sysResourceMap.put("PID", "妮晒她渗蘑眼奥企叼杂挟解院硒戎藩厢阳读挣路尝版查栗勉斥扒夺说柬彝坞戴萄砷沟面桑吩舔酵印悼损熬像所暮溃");
sysResourceMap.put("CACHE", -1143814095);
sysResourceMap.put("FACETYPE", "皂邪兴行侍拱宴杉纽裙硬零布衙蔓盒要淫岛孰笑孔衰缸床哆亮弧早剃脚崎僚糯海溅轨艺肇矛献扫悦肤惨硬年簿肛案");
sysResourceMap.put("ICON", "毋掉嗜币泛拍碉狐易十乞灯句筛骸也讣庙届抢酮嘿儒功叛尹盛爱戚尼鸯颅呢党邵憾襄需拢弛锁推槛疑历忠沃李陷凄犬腻她兼液秘叼退衔劲炯冗陆片蜂拂弦颜堆矿烛评辐烫叶垮袄撑姚幂淮屿绿络撵蹬拇羞肉抖吕行联碰堆匀泞悟客狙馈橱谍律当夯撵狼下仪臀滔柄待特锨爱纬唉绒遥隘贷淘贫谤仍法相且斧蛙糊棘眼露匹靳沼镀巍殉完胆抠吱潦菠日募弟哲怪名从焚喝矾隘华经切斧槛隶幼钓虎朴朵际躯夜瘤抛梳旅躇赏殿譬蹿坛肠泅缆阵莆喇嗡诱漏馏扒问圣章气伎芽");
sysResourceMap.put("SORT_NUM", 1484712188);

		
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
