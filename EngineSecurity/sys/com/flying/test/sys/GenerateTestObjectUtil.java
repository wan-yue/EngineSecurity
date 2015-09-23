package com.flying.test.sys;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.flying.exception.FlyingException;
import com.flying.init.Item;
import com.flying.init.StaticVariable;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;
import com.flying.test.FlyingJunitInit;
import com.flying.util.FileUtil;

public class GenerateTestObjectUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlyingJunitInit.init();
		
		Item item = new Item();
		item.setName("T_SYS_ROLE");
		item.setAlias("角色管理");
		
		try {
			commonGenerate(item,null);
			registerConfig(item,null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	 /**
     * 获取指定长度随机简体中文
     * @param len int 长度
     * @return String
     */
    public static String getRandomJianHan(int len)
    {
        String ret="";
          for(int i=0;i<len;i++){
              String str = null;
              int hightPos, lowPos; // 定义高低位
              Random random = new Random();
              hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
              lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
              byte[] b = new byte[2];
              b[0] = (new Integer(hightPos).byteValue());
              b[1] = (new Integer(lowPos).byteValue());
              try
              {
                  str = new String(b, "GBk"); //转成中文
              }
              catch (UnsupportedEncodingException ex)
              {
                  ex.printStackTrace();
              }
               ret+=str;
          }
      return ret;
    }
    
	/**
	 * 通用方式，通过自主建立的表，进行生成工作
	 * 
	 * @param item
	 * @throws Exception 
	 */
	public static void commonGenerate(Item item,String dir) throws Exception {
		String tableName = item.getName();// 表名

		String chineseName = item.getAlias();// 表中文名
		
		String[] tableFragment = tableName.split("_");
		
		String sub = tableFragment[1].toLowerCase();
		
		String Sub = sub.substring(0, 1).toUpperCase() + sub.substring(1);
		
		String table = tableFragment[2].toLowerCase();		

		String Table = table.substring(0, 1).toUpperCase() + table.substring(1);
		
		String ID = "";//主键

		EngineParameter ep = null;
				
		if("oracle".equals(StaticVariable.DB)){
			ep = new EngineParameter("oracle.selectFieldByBmc");
		}else if("mysql".equals(StaticVariable.DB)){
			ep = new EngineParameter("mysql.selectFieldByBmc");
		}
		
		ep.setCommandType("list");
		ep.putParam("BMC", tableName);
		Engine.execute(ep);
		
		List<Map> listColumn = ep.getResult("data") == null ? null
				: (List<Map>) ep.getResult("data");// 获取列数据
		
		//在列中，去掉主键限制重复列
		if("oracle".equals(StaticVariable.DB)){
			Map column = null;
			boolean mark = false;
			
			for(int m = 0; m < listColumn.size(); m++){
				column = listColumn.get(m);
				if (column.get("ZDXZ") != null && "P".equals(column.get("ZDXZ").toString())){
					ID = column.get("ZDMC").toString();
					break;
				}
			}
			
			for(int m = 0; m < listColumn.size(); m++){
				column = listColumn.get(m);
				if (column.get("ZDXZ") != null && "C".equals(column.get("ZDXZ").toString()) && ID.equals(column.get("ZDMC").toString())){
					mark = true;
					break;
				}
			}
			
			if(mark){
				listColumn.remove(column);
			}
		}
		
		StringBuffer tableMapInitStr = new StringBuffer();
		StringBuffer tableMapUpdateStr = new StringBuffer();
		StringBuffer assertEqualsTableMapStr = new StringBuffer();
		for (int i = 0; i < listColumn.size(); i++) {//遍历构造数据结构
			Map column = listColumn.get(i);
			if ((column.get("SFZJ") != null && ("true".equals(column.get("SFZJ").toString())|| "1".equals(column.get("SFZJ").toString()))) 
					|| (column.get("ZDXZ") != null && "P".equals(column.get("ZDXZ").toString())) || (column.get("NULL") != null && column.get("KEY") != null && "PRI".equals(column.get("KEY").toString()))) {
					ID = column.get("ZDMC").toString().toUpperCase();
			
			}else if(column.get("ZDLX").toString().contains("int") || "NUMBER".equals(column.get("ZDLX").toString())){
				Random ra = new Random();
				tableMapInitStr.append( sub + Table + "Map.put(\"" + column.get("ZDMC").toString().toUpperCase() + "\", " + ra.nextInt() + ");\n");
				tableMapUpdateStr.append( sub + Table + "Map.put(\"" + column.get("ZDMC").toString().toUpperCase() + "\", " + ra.nextInt() + ");\n");
				assertEqualsTableMapStr.append("Assert.assertEquals(" + sub + Table + "Map.get(\""+ column.get("ZDMC").toString().toUpperCase() +"\"), ((Map)ep.getResult(\"data\")).get(\""+column.get("ZDMC").toString().toUpperCase()+"\"));\n");
			
			}else if(column.get("ZDLX").toString().toLowerCase().contains("varchar")){
				int len = 0;
				if(column.get("ZDCD") != null){
					len = Integer.parseInt(column.get("ZDCD").toString());
				}else{
					len = Integer.parseInt(column.get("ZDLX").toString().substring(column.get("ZDLX").toString().indexOf("(")+1,column.get("ZDLX").toString().indexOf(")")));
				}
				tableMapInitStr.append( sub + Table + "Map.put(\"" + column.get("ZDMC").toString().toUpperCase() + "\", \"" + getRandomJianHan(len) + "\");\n");
				tableMapUpdateStr.append( sub + Table + "Map.put(\"" + column.get("ZDMC").toString().toUpperCase() + "\", \"" + getRandomJianHan(len) + "\");\n");
				assertEqualsTableMapStr.append("Assert.assertEquals(" + sub + Table + "Map.get(\""+ column.get("ZDMC").toString().toUpperCase() +"\"), ((Map)ep.getResult(\"data\")).get(\"" + column.get("ZDMC").toString().toUpperCase() + "\"));\n");
			
			}else if(column.get("ZDLX").toString().toLowerCase().contains("date")){
				tableMapInitStr.append( sub + Table + "Map.put(\"" + column.get("ZDMC").toString().toUpperCase() + "\", new Date());\n");
				tableMapUpdateStr.append( sub + Table + "Map.put(\"" + column.get("ZDMC").toString().toUpperCase() + "\", new Date());\n");
				assertEqualsTableMapStr.append("Assert.assertTrue(((Date)" + sub + Table + "Map.get(\"" + column.get("ZDMC").toString().toUpperCase() + "\")).getTime() - ((Date)((Map)ep.getResult(\"data\")).get(\"" + column.get("ZDMC").toString().toUpperCase() + "\")).getTime() < 1000);");
			}

		}
		// 将模板文件变成String
		String template = FileUtil.streamToString(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/TestObject.vm"));
		
		/**
		 * 进行替换 1.前缀 sub Sub
		 * 2.表名称 table Table
		 * 3.主键 ID
		 * 4.对应的Table
		 * 5.初始化TableMap
		 * 6.断言TableMap 
		 */ 
		// 前缀 sub Sub
		template = template.replaceAll("&sub&", sub);
		template = template.replaceAll("&Sub&", Sub);
		// 表名称 table Table
		template = template.replaceAll("&table&", table);
		template = template.replaceAll("&Table&", Table);
		//主键 ID
		template = template.replaceAll("&ID&", ID);
		//对应的Table
		template = template.replaceAll("&T_SUB_TABLE&", tableName.toUpperCase());
		//初始化TableMap
		template = template.replaceAll("&tableMap_init&", tableMapInitStr.toString());
		//修改TableMap
		template = template.replaceAll("&tableMap_update&", tableMapUpdateStr.toString());
		//断言TableMap
		template = template.replaceAll("&Assert.assertEquals.tableMap&", assertEqualsTableMapStr.toString());
		//创建测试文件
		if(dir == null){
			dir = StaticVariable.PATH + sub + "/com/flying/test/" + sub + "/Test" + Sub + Table + ".java";
		}else{
			dir = dir + "/Test" + Sub + Table + ".java";
		}
		
		FileUtil.stringToFile(template, FileUtil.createFile(dir));
	}
	
	/**
	 * 将生产的测试类在junit-sub.xml文件中进行注册
	 * @param item
	 * @param dir
	 * @throws FlyingException
	 */
	public static void registerConfig(Item item,String dir) throws FlyingException{
		String tableName = item.getName();// 表名
		
		String[] tableFragment = tableName.split("_");
		
		String sub = tableFragment[1].toLowerCase();
		
		String Sub = sub.substring(0, 1).toUpperCase() + sub.substring(1);
		
		String table = tableFragment[2].toLowerCase();		

		String Table = table.substring(0, 1).toUpperCase() + table.substring(1);
		
		//将文件注册到junit-sys.xml文件
		String junitConfig = null;
		if(dir == null){
			junitConfig = StaticVariable.PATH + "src/config/junit-" + sub + ".xml"; 
		}else{
			junitConfig =dir + "scr/config/junit-" + sub + ".xml"; 
		}
		
		File junitConfigFile = FileUtil.createFile(junitConfig);
		// 构建Dom树
		Document junitDocument = FileUtil.readXml(junitConfigFile);
		/**
		 * 判断junit-sub.xml底下是否有此表的junit测试类
		 * 如果有，则不注册
		 * 如果无，则注册
		 * 
		 */
		String junitName = "com.flying.test."  + sub + ".Test" + Sub + Table;
		// 标记true，则表示没有，false，则表示有
		boolean mark = true;
		/**
		 * 判断junit-sub.xml底下是否已经有属性是class的节点 如果有,不添加节点 如果无，添加节点
		 */
		//获取sqlMapConfig标签底下的sqlMap标签的属性resourse
		List junitList = junitDocument
				.selectNodes("/suite/test/@class");
		Iterator junitIter = junitList.iterator();
		while (junitIter.hasNext()) {
			Attribute attribute = (Attribute) junitIter.next();
			if (junitName.equals(attribute.getValue())) {
				mark = false;
				break;
			}
		}
		// 如果没有相同的resource，则新加入节点
		if (mark) {
			// 根元素sqlMapConfig
			Element junitConfigRoot = (Element) junitDocument.getRootElement();
			// 构建新增节点
			Element junitEl = junitConfigRoot.addElement("test");
			junitEl.addAttribute("alias", item.getAlias());
			junitEl.addAttribute("class", junitName);
		}

		// 保持到文件
		FileUtil.writeXml(junitDocument,junitConfigFile);
	}
}
