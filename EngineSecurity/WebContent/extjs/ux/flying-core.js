Ext.apply(Ext, {
	fcache : {
		max : 20,//最大容量
		capacity : 0,//目前的容量
		power : {},//权限
		menu : {},//菜单
		pages : {},//缓存页面js
		obj:{},//当前对象
		session : {},//前端session信息
		tabName:null,//显示的tabName页面
		template:'email',//common email permission empty workflowform
		App:null,
		debug:false,//调试模式，关闭权限验证
		receiveMessage:false, //是否启动接受消息模式
		serverPath : null,
		load:function(){//获取权限信息
			var me = this;
			
			Ext.Ajax.request({
				url : 'common.action?command=T_SYS_RESOURCE.selectSecurityResource',
				method : 'GET',
				success : function(response, opts) {
					var obj= Ext.util.JSON.decode(response.responseText);
					if(obj["buttons"]){
						me.power["buttons"] = obj["buttons"];
					}else{
						me.power["buttons"] = [];
					}
					
					if(obj["columns"]){
						me.power["columns"] = obj["columns"];
					}else{
						me.power["columns"] = [];
					}
				}
			});
			
			Ext.Ajax.request({
				url : 'common.action?command=T_SYS_USERINFO.selectInfo',
				method : 'GET',
				success : function(response, opts) {
					var obj= Ext.util.JSON.decode(response.responseText);
					
					me.session = obj.data;
				}
			});
		},
		init : function(){
			var me = this;
			
			var currentUrl = window.location.href; 

			Ext.fcache.serverPath = currentUrl.replace('desktop.html','');
			
			Ext.fcache.load();//初始化
		},
		pushObj : function(name, page) {
			var me = this;
			if (page) {
				page.visit = 1;
				me.capacity++;
				if (me.capacity > me.max)
					me.pop();
				me.pages[name] = page;
			}
		},
		getByUrl : function(url,face,params) {
			var obj = {};	
			
			var packUrl = "js/"+url;
			
			if(params == null){
				params = {};
			}

			Ext.Ajax.request({
				url : packUrl,
				async : false,
				method : 'GET',
				success : function(response, opts) {
					var responseText = response.responseText;//请求的数据
					var plugin = Ext.util.JSON.decode(responseText);//插件对象
					//添加唯一标示
					plugin["id"] = url;
					//传人参数处理
					for ( var name in params) {// 初始化属性
						plugin[name] = params[name];
						if(typeof params[name] == 'function'){
							delete params[name];
						}
					}
					
					plugin["params"] = params;
					
					//根据配置文件预处理
					if(Ext.fconfig[url] != null){
						if(Ext.fconfig[url]["isFlow"] == true){
							Ext.fconfig.addFlowConfig(plugin);
						}
						if(Ext.fconfig[url]["isHdPlan"] == true){
							Ext.fconfig.addHdPlanConfig(plugin);
						}
					}
					
					//创建对象
					if(face == 'form'){
						obj = new FormFace(plugin);
					}else if(face == 'grid'){
						obj = new GridFace(plugin);
					}else if(face == 'common'){
						obj = new CommonGridFace(plugin);
					}else if(face == "permission"){
						obj = new PermissionGridFace(plugin);
					}else if(face == "email"){
						obj = new EmailGridFace(plugin);
					}else if(face == "workflowform"){
						obj = new FlyingWorkflowJsFormFace(plugin);
					}else if(face == "workflowaudit"){
						obj = new FlyingWorkflowJsAuditFace(plugin);
					}else if(face == "workflowshow"){
						obj = new FlyingWorkflowJsShowFace(plugin);
					}else if(face == "mixface"){
						obj = new MixFaces(plugin);
					}else if(face == "hdworkflowform"){
						obj = new HdWorkflowFormFace(plugin);
					}else if(face == "hdbusinessaudit"){
						obj = new HdBusinessAuditFace(plugin);
					}else if(face == "hdbusinessshow"){
						obj = new HdBusinessShowFace(plugin);
					}else if(face == "hdauditlist"){
						obj = new HdAuditListFace(plugin);
					}else if(face == "empty"){
						obj = eval(responseText);
					}else{
						obj = new FlyingCommonFace(plugin);
					}
				}
			});
			
			obj.face = face;//对象使用的模板
			
			return obj;
		},
		push : function(url,face,params) {
			var me = this;
			
			var packUrl = "js/"+url;
			
			me.obj = me.getByUrl(url,face,params);
			
			me.obj.fileName = packUrl;
			
			me.obj.visit = 1;
			me.capacity++;
			if (me.capacity > me.max){
				me.pop();
			}
			
			return me.obj;
		},
		pop : function() {
			var me = this;
			var miniVisit = 0;
			var num = 1;
			for ( var name in me.pages) {
				if (num == 1) {
					miniVisit = me.pages[name].visit;
				} else {
					if (me.pages[name].visit < miniVisit)
						miniVisit = me.pages[name].visit;
				}
				num++;
			}

			for ( var name in me.pages) {
				if (me.pages[name].visit == miniVisit) {
					delete me.pages[name];
					me.capacity--;
					break;
				}
			}
		},
		/**
		 * name:请求的名字
		 * face:构建页面使用的face，当无此参数时，使用默认template。
		 * tabName:email模式，选择显示tab页。
		 * cache:是否从缓存中获取，true：从缓存中去；false：取新的。
		 * params:初始化传递的参数
		 * */
		get : function(name,face,tabName,cache,params) {
			var me = this;
			
			me.tabName = tabName;//初始化tabName
			
			if(cache == false){
				me.obj = null;
			}else{
				me.obj = me.pages[name];
			}
			
			if (me.obj) {
				me.obj.visit++;
			}else{
				if (name) {
					me.obj = me.push(name,face,params);
					me.pages[name] = me.obj;
				}else{
					me.obj = null;
				}
			}

			me.afterCreate();//创建之后进行处理的动作
			
			return me.obj;
		},
		afterCreate:function(){
			var me = this;
			try{
				if(me.obj != null){
					if(typeof me.obj["refresh"] ){//如果有刷新，则进行刷新操作
						//me.obj.refresh();
					}
				}			
			}catch(e){
				//console.log(e);
			}
		},
		checkSecurity:function(securityName,type){
			var me = this; 
			var check = false;
			var secrityNames = [];
			switch(type){
				case 1:secrityNames = me.power.buttons;break;
				case 2:secrityNames = me.power.columns;break;
				case 3:secrityNames = me.power.tabs;break;
			};
			
			Ext.each(secrityNames,function(name){
	    		if(name == securityName){
	    			check = true;
	    			return false;
	    		}
	    	});
			return check;
		},
		changeUrl:function(url,face,tabName,cache,params){
			var me = this;
			//获取生成对象的模板
			var fa = me.template;
			if(face != undefined){
				fa = face;
			}
			//删除其他的panel
			Ext.getCmp('content-panel').flyingRemoveAll(false);
			//从缓存中请求
			var page = me.get(url,fa,tabName,cache,params);
			//添加缓存中的panel
			Ext.getCmp('content-panel').add(page["center"]);
			//激活panel
			Ext.getCmp('content-panel').layout.setActiveItem(page["center"]);
			//页面刷新
			Ext.getCmp('content-panel').doLayout();
			me.afterShow();//页面显示之后执行
		},
		afterShow:function(){
			var me = this;
			//设置激活的tab页
			try{
				if(me.obj != null && me.tabName != null){
					if(typeof me.obj["activeTab"]){
						me.obj.activeTab(me.tabName);
					}
				}			
			}catch(e){
			}
		},
		createWindow : function(configs){
			//初始化弹出框的大小	
	    	var width = window.screen.availWidth-2*120;
	    	var height = window.screen.availHeight-2*120;
	    	
			var win = new Ext.Window(
	            Ext.applyIf(configs||{}, {
	            	layout : 'fit',
	        		width : width,
	        		height : height,
	        		modal : true,
	        		constrainHeader : true,
	        		maximizable: true,
	        		plain : true
	            })
	        );
			
			return win;
		}
	}
});

Ext.fcache.init();