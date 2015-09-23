package com.flying.Interceptor.sys;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import com.flying.Interceptor.AbstractInterceptor;
import com.flying.service.EngineParameter;
/**
 * <B>描述：</B>获取权限拦截类<br/>
 * <B>版本：</B>v2.0<br/>
 * <B>创建时间：</B>2012-10-10<br/>
 * <B>版权：</B>flying团队<br/>
 * 
 * @author zdf
 *
 */
public class PowerInterceptor extends AbstractInterceptor {
	@Override
	public void before(EngineParameter ep) throws Exception{
		HttpSession session = (HttpSession)ep.getParam("session");
		Map userinfo = session.getAttribute("USERINFO") == null?null:(Map)session.getAttribute("USERINFO");
		if(userinfo != null){
			ep.putParam("USER_ID", userinfo.get("USER_ID"));
		}else{
			ep.putParam("USER_ID",0);
		}
	}
	
	@Override
	public void after(EngineParameter ep) throws ParseException{
		//权限集合
    	List<String> menus = new ArrayList();//菜单
    	List<String> buttons = new ArrayList();//按钮
    	List<String> columns = new ArrayList();//列
    	List<String> tabs = new ArrayList();//tab页
    	
    	List<Map> resourceList = ep.getResult("data")==null?null:(List<Map>)ep.getResult("data");
    	if(resourceList != null){
    		for(int i =0;i<resourceList.size();i++){
    			Map resource = resourceList.get(i);
    			String resourceTypeId = resource.get("RESOURCE_TYPE_ID") == null?"":resource.get("RESOURCE_TYPE_ID").toString();
    			if("19AADE52436C4FA99BC3B9897E7B9408".equals(resourceTypeId)){
    				menus.add(resource.get("RESOUCE_ADDR")==null?"":resource.get("RESOUCE_ADDR").toString());
    			}else if("61505B4AD5A443CD8D230F95B21012BB".equals(resourceTypeId)){
    				buttons.add(resource.get("RESOUCE_ADDR")==null?"":resource.get("RESOUCE_ADDR").toString());
    			}else if("AEFA83E468A84650BCDF6A10464FEEA2".equals(resourceTypeId)){
    				columns.add(resource.get("RESOUCE_ADDR")==null?"":resource.get("RESOUCE_ADDR").toString());
    			}else if("8434A75F4FF1426CBA0368AFD05B3CAD".equals(resourceTypeId)){
    				tabs.add(resource.get("RESOUCE_ADDR")==null?"":resource.get("RESOUCE_ADDR").toString());
    			}
    		}
    	}
    	
    	ep.putResult("menus", menus);
    	ep.putResult("buttons", buttons);
    	ep.putResult("columns", columns);
    	ep.putResult("tabs", tabs);
	}
}
