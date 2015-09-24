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

public class TestSysDepartment {
	private static String DEPARTMENT_ID = null;
	private static Map<String,Object> sysDepartmentMap  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysDepartmentMap.put("DEPARTMENT_CODE", "治履憾轨辑炮娄家月至菌蜕持糙秤索测持丧栖与引继脉释酋午颐痔埋屈抛疼撩姬锅嘻喘熟柱蔡累鸡奈灿点插谭燥掳");
sysDepartmentMap.put("DEPARTMENT_NAME", "块氓茄皋棠浴沁弗询薛箔膊镣惠伙斟婆新掳拔绷腥缚寥恭屁囊恢爵硕鸵娩纲琴旱纫普唐唤哨蝗锡硝虚扛怪这甜乾取来柠净玻皂烦币哺抒像到箩引蠕驯岂还鳃虞庆删陌慨动哗验柯甜噬提项巡撵嫁奋泣鳞吸镣利邢送繁朴侦犯酱笋失钮剔篱婚涸舶位煞沟颅巍未固曲丘渺了搜矗偶宛赢寝杀徽蚜杂微骑估痕芥论虫抑坝歹轴崔福橡粹粥兢怜呼暑食斜亮练姬顶乍坎樟小游指疼遏配荐挞烩摆澳花睛沟碘囚屏蛰蛙厂角蝎爬惨汁船塞治泼堪占融腹郧僻椅交酵菠槽腔妒鱼岂恿");
sysDepartmentMap.put("PID", "锻嵌核摘处酋债赦诞矮枝沸继泳碍聪丝蔡君泌莆澜饼屿助辰员享枯函悲屈旺羔魁狐外咙汹值赠凶饲先腔功脊愿硝品");
sysDepartmentMap.put("LEVEL_ID", 1846781905);
sysDepartmentMap.put("ORDER_ID", -1087084989);

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysDepartmentMap = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_DEPARTMENT.insert");
		ep.setParamMap(sysDepartmentMap);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		DEPARTMENT_ID = (String) ep.getResult("data");
		Assert.assertTrue(DEPARTMENT_ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_DEPARTMENT.selectById");
		ep.putParam("DEPARTMENT_ID", DEPARTMENT_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysDepartmentMap.get("DEPARTMENT_CODE"), ((Map)ep.getResult("data")).get("DEPARTMENT_CODE"));
Assert.assertEquals(sysDepartmentMap.get("DEPARTMENT_NAME"), ((Map)ep.getResult("data")).get("DEPARTMENT_NAME"));
Assert.assertEquals(sysDepartmentMap.get("PID"), ((Map)ep.getResult("data")).get("PID"));
Assert.assertEquals(sysDepartmentMap.get("LEVEL_ID"), ((Map)ep.getResult("data")).get("LEVEL_ID"));
Assert.assertEquals(sysDepartmentMap.get("ORDER_ID"), ((Map)ep.getResult("data")).get("ORDER_ID"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_DEPARTMENT.update");
		sysDepartmentMap.put("DEPARTMENT_ID", DEPARTMENT_ID);
		sysDepartmentMap.put("DEPARTMENT_CODE", "憨诡逗袒彩外怕矣涛愈除锰岛蚊遣泊满壬夏吻伪茫谰屯项贷钾树栋懈临辨簧睫挪擂懊朗凉稳扫判级科已惜隘衬眺陆");
sysDepartmentMap.put("DEPARTMENT_NAME", "额兢班须深杆猿留她衷渐熊教挨堕弘畔锈阎慷戈脱瞩葫默耗酞魂牢挽请缺豁式丁赫嫩钩曳舰晚样灸竞毁力敌登练雕煞变雌酚匹义桃锨雨拼痒第谱赦刚凑舜痞甩闪窑扰氯绕如钠辽佩恢执触漳课弟哥聘售临氮面质盏笑舱钢舍茬播婶劳网撒踊毛胎烽肩稿呼棋诈倍淫凶铲钙翱程占诫羌吻眼权趾列伶间昂韩穿嘱普慎长雌耗简咽毯浓褒芦碗人撂仰书宾垂含阐控矽雪迢墒逗记口楷爵腮盔蘑君蛋巧律栈垂硝瓜随槽娩衙惶便讽钧蓄蔗陷炯励遏沉敷菠青机涂肥艰问乌墒伸诀");
sysDepartmentMap.put("PID", "杂瘟夫域黄堵皂脱刃玉戚数毅妖粤输例钎截非躁鸳致痛页宵擞站凭桅赴休搐粪柔苦氓老隆癣垄衷兄终颇穿肛锐动她");
sysDepartmentMap.put("LEVEL_ID", 2094799776);
sysDepartmentMap.put("ORDER_ID", -1450674596);

		
		ep.setParamMap(sysDepartmentMap);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_DEPARTMENT.selectById");
		ep.putParam("DEPARTMENT_ID", DEPARTMENT_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysDepartmentMap.get("DEPARTMENT_CODE"), ((Map)ep.getResult("data")).get("DEPARTMENT_CODE"));
Assert.assertEquals(sysDepartmentMap.get("DEPARTMENT_NAME"), ((Map)ep.getResult("data")).get("DEPARTMENT_NAME"));
Assert.assertEquals(sysDepartmentMap.get("PID"), ((Map)ep.getResult("data")).get("PID"));
Assert.assertEquals(sysDepartmentMap.get("LEVEL_ID"), ((Map)ep.getResult("data")).get("LEVEL_ID"));
Assert.assertEquals(sysDepartmentMap.get("ORDER_ID"), ((Map)ep.getResult("data")).get("ORDER_ID"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_DEPARTMENT.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysDepartmentMap.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_DEPARTMENT.delete");
		ep.putParam("DEPARTMENT_ID", DEPARTMENT_ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_DEPARTMENT.selectById");
		ep.putParam("DEPARTMENT_ID", DEPARTMENT_ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
