package com.flying.Interceptor.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flying.Interceptor.AbstractInterceptor;
import com.flying.exception.FlyingException;
import com.flying.service.Engine;
import com.flying.service.EngineParameter;

public class DepartmentGetTreeInterceptor extends AbstractInterceptor {

	@Override
	public void before(EngineParameter ep) throws Exception {

	}

	@Override
	public void after(EngineParameter ep) throws Exception {

		//1 获取部门列表
		List<Map> departmentList = (List<Map>)ep.getResultMap().get("data");
		
		//根据数组构建json树格式
		Map root = new HashMap();
		root.put("DEPARTMENT_ID", 0);
		root.put("DEPARTMENT_NAME","根目录");
		root.put("ORDER_ID", 1);
		JSONObject tree = getJsonTree(departmentList,root);
		ep.getResultMap().put("data", tree.getJSONArray("children"));
		//将部门列表json返回
		ep.getResultMap().put("listdata",departmentList);

	}
	
	/**
	 * 通过一维数组，构建出树状结构
	 * @param list	
	 * @param map
	 * @param userList  人员列表	
	 * @param jsonArr  传出的人员Json数组
	 * @return
	 */
	public JSONObject getJsonTree(List<Map> list,Map map){
		JSONObject json = new JSONObject();
		String id = map.get("DEPARTMENT_ID").toString();
		String departmentName = map.get("DEPARTMENT_NAME").toString();
		json.put("id", id);
		json.put("text", departmentName);
		json.put("orderId",map.get("ORDER_ID").toString());
		json.put("data", map);
		
		//子节点
		JSONArray arr = new JSONArray();
		List<Map> childrenList = getChildrenList(list,"PID",id);
		if(childrenList.size()>0){
			for(int i=0;i<childrenList.size();i++){
				arr.add(getJsonTree(list,childrenList.get(i)));
			}
			json.put("expanded",true);
			json.put("children",arr);
		}else{
			json.put("leaf",true);
		}
		
		return json;
	}
	
	/**
	 * 从一维数组中获取一个节点下的子节点
	 * @param list
	 * @param parentId
	 * @return
	 */
	public List<Map> getChildrenList(List<Map> list,String key,String value){
		List<Map> childrenList = new ArrayList<Map>();
		for(int i=0;i<list.size();i++){
			Map m = list.get(i);
			if(m.get(key).toString().equals(value)){
				childrenList.add(m);
			}
		}
		
		//将子节点按排序号排列，冒泡排序
		for(int i=0;i<childrenList.size();i++){
			for(int j=i+1;j<childrenList.size();j++){
				int m = Integer.parseInt(childrenList.get(i).get("ORDER_ID").toString());
				int n = Integer.parseInt(childrenList.get(j).get("ORDER_ID").toString());
				if(n<m){
					//交换
					Map swap = childrenList.get(i);
					childrenList.set(i, childrenList.get(j));
					childrenList.set(j, swap);
				}
			}
		}
		
		return childrenList;
	}
	
	public static void main(String[] args) {
		//冒泡排序
		int[] arr= new int[]{2,5,4,3,1};
		//排序前
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[i]){
					//i j元素交换
					int swap = arr[j];
					arr[j] = arr[i];
					arr[i] = swap;
				}
			}
		}
		
		//排序后
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		
		
		//将子节点按排序号排列，冒泡排序
		System.out.println("****************************");
		List<Map> childrenList = new ArrayList<Map>();
		Map map1 = new HashMap();
		map1.put("NAME","b");
		map1.put("ORDER_ID",2);
		childrenList.add(map1);
		Map map2 = new HashMap();
		map2.put("NAME","a");
		map2.put("ORDER_ID",1);
		childrenList.add(map2);
		Map map3 = new HashMap();
		map3.put("NAME","c");
		map3.put("ORDER_ID",3);
		childrenList.add(map3);
		for(int i=0;i<childrenList.size();i++){
			for(int j=i+1;j<childrenList.size();j++){
				int m = Integer.parseInt(childrenList.get(i).get("ORDER_ID").toString());
				int n = Integer.parseInt(childrenList.get(j).get("ORDER_ID").toString());
				if(n<m){
					//交换
					Map swap = childrenList.get(i);
					childrenList.set(i, childrenList.get(j));
					childrenList.set(j, swap);
				}
			}
		}
		//排序后输出
		System.out.println(childrenList.toString());
	}
}
