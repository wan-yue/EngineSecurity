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

public class TestSysGb2312 {
	private static String ID = null;
	private static Map<String,Object> sysGb2312Map  = new HashMap<String,Object>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sysGb2312Map.put("HANZI", "软积酉栅犯恋倘盼框谦怠历愁私参羊汕圃彻苇芹胀扳讥蚤醇锡读淌硬");
sysGb2312Map.put("FIRST", "码辰享弯谣吝漂疵贯巧历薯缔怎姜醇揽忱敦腊秉湛懦坤牵试阳惶誓袖");
sysGb2312Map.put("SECOND", "锤担敝擅俊执剑豪胀雪年羞冲辅奴裕幅弛派吻鸦砷昏毛峰兄蒂竟供辞");
sysGb2312Map.put("THIRD", "答拟嵌卫烙洗墙且瞩帧赠凳秸狰稼枕祈可髓表勒闲弧呆郎挝穿松蕊劣");
sysGb2312Map.put("FOURTH", "腔靠搽摩短基阶逢叶心炕乒危胜雾漓殆池任庚普纹吊寂路曳撤嚏植绚");

	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sysGb2312Map = null;
	}
	
	@Test
	public void testInsert() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB2312.insert");
		ep.setParamMap(sysGb2312Map);

		Engine.execute(ep);

		Assert.assertNotNull(ep.getResult("data"));
		Assert.assertTrue(ep.getResult("data") instanceof String);
		ID = (String) ep.getResult("data");
		Assert.assertTrue(ID.length() > 0);
	}

	@Test
	public void testFirstSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB2312.selectById");
		ep.putParam("ID", ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysGb2312Map.get("HANZI"), ((Map)ep.getResult("data")).get("HANZI"));
Assert.assertEquals(sysGb2312Map.get("FIRST"), ((Map)ep.getResult("data")).get("FIRST"));
Assert.assertEquals(sysGb2312Map.get("SECOND"), ((Map)ep.getResult("data")).get("SECOND"));
Assert.assertEquals(sysGb2312Map.get("THIRD"), ((Map)ep.getResult("data")).get("THIRD"));
Assert.assertEquals(sysGb2312Map.get("FOURTH"), ((Map)ep.getResult("data")).get("FOURTH"));

	}
	
	@Test
	public void testUpdate() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB2312.update");
		sysGb2312Map.put("ID", ID);
		sysGb2312Map.put("HANZI", "察暑审变獭魔呕回倦膨立柒怎版椿叭槐惧钞逊袭逊箱移挣阁常宝含蹈");
sysGb2312Map.put("FIRST", "来沾心榜意结困泊物掘婆婴忽抿从骆中窄娃员钓圆病樟卖疟溃琶徽但");
sysGb2312Map.put("SECOND", "葡敞琐蟹父舀推佩兑凄媚赦氯孕榴请呕秋侠饯馏巧棵药禾惧嫌矛伞收");
sysGb2312Map.put("THIRD", "窥键鸽膊鞘缔报抬酮古盼逼勿鞘西希梯怨操颗肿哨扬告比灶形笔闪吼");
sysGb2312Map.put("FOURTH", "蓉殴眷挚踩线羚哗龙征简菲呕迷疏拱秤冕绣砾寺镣李琐诣矗猫殴盾漆");

		
		ep.setParamMap(sysGb2312Map);
		
		Engine.execute(ep);
	}
	
	@Test
	public void testSecondSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB2312.selectById");
		ep.putParam("ID", ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() > 0);
		Assert.assertEquals(sysGb2312Map.get("HANZI"), ((Map)ep.getResult("data")).get("HANZI"));
Assert.assertEquals(sysGb2312Map.get("FIRST"), ((Map)ep.getResult("data")).get("FIRST"));
Assert.assertEquals(sysGb2312Map.get("SECOND"), ((Map)ep.getResult("data")).get("SECOND"));
Assert.assertEquals(sysGb2312Map.get("THIRD"), ((Map)ep.getResult("data")).get("THIRD"));
Assert.assertEquals(sysGb2312Map.get("FOURTH"), ((Map)ep.getResult("data")).get("FOURTH"));

	}
	
	@Test
	public void testSelectAll() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB2312.selectAll");
		String filter = "&ROLE_NAME& LIKE '%" + sysGb2312Map.get("&ROLE_NAME&") + "%'";
		Engine.execute(ep);
		
		Assert.assertNotNull(ep.getResult("data"));
		List<Map> listMap = (List<Map>) ep.getResult("data");
		Assert.assertTrue(listMap.size() > 0);
	}
	
	@Test
	public void testDelete() throws Exception {	
		EngineParameter ep = new EngineParameter("T_SYS_GB2312.delete");
		ep.putParam("ID", ID);
		Engine.execute(ep);
	}
	
	@Test
	public void testThirdSelectById() throws Exception {
		EngineParameter ep = new EngineParameter("T_SYS_GB2312.selectById");
		ep.putParam("ID", ID);

		Engine.execute(ep);
		
		Assert.assertTrue(((Map)ep.getResult("data")).size() == 0);
	}
}
