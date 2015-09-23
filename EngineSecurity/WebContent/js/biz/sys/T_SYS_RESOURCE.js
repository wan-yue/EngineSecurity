(function(){
var T_SYS_RESOURCE = {
		opType:"modify",
		subOpType:"modify",
		pk : "RESOURCE_ID",
		params : {}
};

/** 表单按钮区 */
T_SYS_RESOURCE.btn_save = new Ext.Button({// 保存按钮
	text : '保存',
	iconCls : 'save',
	handler : function(btn) {
		var url = "";
		var p = {};
		if(T_SYS_RESOURCE.opType == 'add'){//如果是添加模式，请求地址
			url = "common.action?command=T_SYS_RESOURCE.insert";
			p["PID"] =  T_SYS_RESOURCE.params["PID"];
		}else if(T_SYS_RESOURCE.opType == 'modify'){//如果是修改模式，请求地址
			url = "common.action?command=T_SYS_RESOURCE.update";
			p["RESOURCE_ID"] = T_SYS_RESOURCE.params[T_SYS_RESOURCE.pk];
		}
		
		if (T_SYS_RESOURCE.form.getForm().isValid()) {
			T_SYS_RESOURCE.form.getForm().submit({
				url : url,
				params : p,
				waitTitle : '请稍候',
				waitMsg : '正在提交表单数据,请稍候...',
				success : function(form, action) {
					Ext.fm.msg("提示","恭喜，操作成功！");
					
					T_SYS_RESOURCE.tree.remoteRefresh();
					
					if(T_SYS_RESOURCE.opType == 'add'){//如果是添加模式，请求地址
						T_SYS_RESOURCE.form.setTitle("修改资源页面");
						T_SYS_RESOURCE.opType = 'modify';
						T_SYS_RESOURCE.params[T_SYS_RESOURCE.pk] = action.result.data;

						var task = new Ext.util.DelayedTask(function(){
							var node = T_SYS_RESOURCE.tree.getNodeById(action.result.data);
							T_SYS_RESOURCE.tree.expandPath(node.getPath());
							node.select();
						});
						
						task.delay(400);
						
					}else if(T_SYS_RESOURCE.opType == 'modify'){//如果是修改模式，请求地址
						var task = new Ext.util.DelayedTask(function(){
							var node = T_SYS_RESOURCE.tree.getNodeById(T_SYS_RESOURCE.params[T_SYS_RESOURCE.pk]);
							T_SYS_RESOURCE.tree.expandPath(node.getPath());
							node.select();
						});
						
						task.delay(400);
						
					}
				},
				failure : function(form, action) {
					Ext.Msg.show({
						title : '错误提示',
						msg : action.result.msg,
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		}
	}
});

T_SYS_RESOURCE.menu1 = new Ext.menu.Menu({
	items:[{
		text:'添加',
		iconCls : 'user-add',
		handler : function(){
			T_SYS_RESOURCE.opType = 'add';
			T_SYS_RESOURCE.form.getForm().reset();
			T_SYS_RESOURCE.form.setTitle("添加资源页面");
			T_SYS_RESOURCE.subResourceStore.removeAll();
		}
	},{
		text:'删除',
		iconCls : 'user-delete',
		handler : function(){
			Ext.Msg.confirm("删除资源", '确定删除?', function(btn) {
				if (btn == 'yes') {
					var p = {};
					p[T_SYS_RESOURCE.pk] = T_SYS_RESOURCE.params["PID"];
					Ext.Ajax.request({
						url : "common.action?command=T_SYS_RESOURCE.delete",
						params : p,
						success : function(response, opts) {	
							Ext.fm.msg("提示","恭喜，操作成功！");
							
							T_SYS_RESOURCE.tree.remoteRefresh();
							
							T_SYS_RESOURCE.tree.expandAll();
							
							T_SYS_RESOURCE.form.getForm().reset();
							
							T_SYS_RESOURCE.subResourceStore.reload();
						},
						failure : function(response, opts) {
							var obj = Ext.util.JSON.decode(response.responseText);
							Ext.Msg.show({
								title : '异常提示',
								msg : obj.msg,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			});
			
		}
	}]
});

T_SYS_RESOURCE.menu2 = new Ext.menu.Menu({
	items : [{
		text:'删除',
		iconCls : 'user-delete',
		handler : function(){
			Ext.Msg.confirm("删除资源", '确定删除?', function(btn) {
				if (btn == 'yes') {
					var p = {};
					p[T_SYS_RESOURCE.pk] = T_SYS_RESOURCE.params["PID"];
					Ext.Ajax.request({
						url : "common.action?command=T_SYS_RESOURCE.delete",
						params : p,
						success : function(response, opts) {	
							Ext.fm.msg("提示","恭喜，操作成功！");
							
							T_SYS_RESOURCE.tree.remoteRefresh();
							
							T_SYS_RESOURCE.tree.expandAll();
							
							T_SYS_RESOURCE.form.getForm().reset();
							
							T_SYS_RESOURCE.subResourceStore.reload();
						},
						failure : function(response, opts) {
							var obj = Ext.util.JSON.decode(response.responseText);
							Ext.Msg.show({
								title : '异常提示',
								msg : obj.msg,
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}
					});
				}
			});			
		}
	}]
});
/** 资源树 */
T_SYS_RESOURCE.tree = new Ext.flying.Tree({
	region : "center",
	border : false,
	rootVisible : false, //是否显示根元素
	autoScroll : true,
	enableDD:true,
	url : 'common.action?command=T_SYS_RESOURCE.selectAllMenu',
	baseConfig : {idName : 'RESOURCE_ID',textName:'RESOURCE_NAME',pidName:'PID'},
	rootNode : {RESOURCE_ID:'0',RESOURCE_NAME:'根节点'},
	listeners : {
		'click' : function(n) {
			T_SYS_RESOURCE.opType = 'modify';

			var data = n.attributes.data;
			if(data["RESOURCE_CODE"] != 0){
				T_SYS_RESOURCE.form.setTitle("修改资源页面");
				
				T_SYS_RESOURCE.params[T_SYS_RESOURCE.pk] = data[T_SYS_RESOURCE.pk];
				for(var name in data){
					if(T_SYS_RESOURCE.form.getForm().findField(name) != null){
						T_SYS_RESOURCE.form.getForm().findField(name).setValue(data[name]);
					}
				}
				
				T_SYS_RESOURCE.subResourceStore.load({params:{"PID":data[T_SYS_RESOURCE.pk],"RESOURCE_TYPE_ID":"8434A75F4FF1426CBA0368AFD05B3CAD"}});
			}
		},
		'contextmenu' : function(n,e){
			e.preventDefault();
			n.select();
			var data = n.attributes.data;
			if(data["RESOURCE_TYPE_ID"] == "61505B4AD5A443CD8D230F95B21012BB" || data["RESOURCE_TYPE_ID"] == "AEFA83E468A84650BCDF6A10464FEEA2"){
				T_SYS_RESOURCE.menu2.showAt(e.getXY());
			}else{
				T_SYS_RESOURCE.menu1.showAt(e.getXY());
			}
			
			T_SYS_RESOURCE.params["PID"] = n.id;
		},
		'beforemovenode' : function(tree,node,oldParent,newParent,i){
			var str = '';
			var mark = true;
			
			if(node.attributes["RESOURCE_TYPE_ID"] == '61505B4AD5A443CD8D230F95B21012BB'){
				str = "按钮类型资源，无需排序！";
				mark = false;
			}
			
			if(mark && node.attributes["RESOURCE_TYPE_ID"] == 'AEFA83E468A84650BCDF6A10464FEEA2'){
				str = "列类型资源，无需排序！";
				mark = false;
			}
			
			if(mark && node.attributes["PID"] == '0' ){
				str = "根节点无法移动！";
				mark = false;
			}
			
			if(mark){
				var beforeNodeId = "";
				var afterNodeId = "";
				for(var m =0;m<newParent.childNodes.length;m++){
					if(newParent.childNodes[m].attributes["RESOURCE_ID"] == node.attributes["RESOURCE_ID"]){
						continue;
					}else{
						if(m < i){
							beforeNodeId += newParent.childNodes[m].attributes["RESOURCE_ID"] + "-";
						}else{
							afterNodeId += newParent.childNodes[m].attributes["RESOURCE_ID"] + "-";
						}
					}
				}
				
				var num = node.attributes["SORT_NUM"];
				if(num == null){
					num = 0;
				}
				
				Ext.Ajax.request({
					url : "common.action?command=T_SYS_RESOURCE.sort",
					params : {'nodeId' : node.attributes["RESOURCE_ID"],'oldNodeId' : oldParent.attributes["RESOURCE_ID"],'newNodeId' : newParent.attributes["RESOURCE_ID"],'beforeNodeId' : beforeNodeId,'afterNodeId' : afterNodeId,'SORT_NUM' : num},
					success : function(response, opts) {	
						Ext.fm.msg("提示","恭喜，资源改变成功！");
					},
					failure : function(response, opts) {
						var obj = Ext.util.JSON.decode(response.responseText);
						Ext.Msg.show({
							title : '异常提示',
							msg : obj.msg,
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
					}
				});
				
			}else{
				Ext.Msg.show({
					title : '友好提醒',
					msg : str,
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return mark;
			}
		}
	}
});

T_SYS_RESOURCE.form = new Ext.FormPanel({// 用户表单
	title:'资源表单维护',
	region : 'center',
	labelAlign : 'right',
	labelWidth : 90,
	bodyStyle : 'padding:2px',
	frame : true,
	border : false,
	autoScroll : true,
	defaultType : 'textfield',
	defaults : {
		anchor : '93%'
	},
	items : [{
		"fieldLabel" : "资源名称",
		"allowBlank" : false,
		"name" : "RESOURCE_NAME"
	},{
		"fieldLabel" : "资源地址",
		"name" : "RESOURCE_ADDR"
	},{
		xtype : 'combo',
		store : new Ext.data.SimpleStore({
			fields : [ "RESOURCE_TYPE_ID","RESOURCE_TYPE_NAME" ],
			data : [["19AADE52436C4FA99BC3B9897E7B9408","菜单"],["61505B4AD5A443CD8D230F95B21012BB","按钮"],["AEFA83E468A84650BCDF6A10464FEEA2","列资源"],["CF6980A123B3439C8112F94C55ABF0AF","GIS图层资源"]]
		}),
		displayField : "RESOURCE_TYPE_NAME",
		valueField : "RESOURCE_TYPE_ID",
		typeAhead : true,
		mode : 'local',
		triggerAction : 'all',
		fieldLabel : "资源类型",
		hiddenName : "RESOURCE_TYPE_ID",
		allowBlank : false,
		maxLength : 50
	},{
		"fieldLabel" : "权限名称",
		"name" : "SECURITY_NAME"
	},{
		xtype : 'combo',
		store : new Ext.data.SimpleStore({
			fields : [ "CACHE","CACHENAME" ],
			data : [["1","是"],["0","否"]]
		}),
		displayField : "CACHENAME",
		valueField : "CACHE",
		typeAhead : true,
		mode : 'local',
		triggerAction : 'all',
		fieldLabel : "是否缓存",
		hiddenName : "CACHE",
		maxLength : 50
	},{
		xtype : 'combo',
		store : new Ext.data.SimpleStore({
			fields : [ "FACETYPENAME","FACETYPE" ],
			data : [[ '上下打开模式','permission' ], [ '弹出打开模式','common' ],['右侧打开模式','email'],["导航打开模式",'subSystem'],["自定义打开模式",'empty']]
		}),
		displayField : "FACETYPENAME",
		valueField : "FACETYPE",
		typeAhead : true,
		mode : 'local',
		triggerAction : 'all',
		fieldLabel : "模板类型",
		hiddenName : "FACETYPE",
		maxLength : 50
	},{
		"fieldLabel" : "显示图片",
		"name" : "ICON"
	},{
		"fieldLabel" : "帮助信息",
		"name" : "RESOURCE_HELPINFO"
	}],
	buttons : [ T_SYS_RESOURCE.btn_save ]
});

T_SYS_RESOURCE.subResource = Ext.data.Record.create([{name : 'RESOURCE_ID'},{name : 'RESOURCE_NAME'},{name : 'RESOURCE_ADDR'}]);

T_SYS_RESOURCE.subResourceDelBtnHandler = function(){
	Ext.Msg.confirm("删除子资源", '确定删除?', function(btn) {
		if (btn == 'yes') {
			var row = T_SYS_RESOURCE.subResourceGrid.getSelectionModel().getSelected();
			var p = {};
			p["RESOURCE_ID"] = row.data["RESOURCE_ID"];
			
			Ext.Ajax.request({
				url : "common.action?command=T_SYS_RESOURCE.delete",
				params : p,
				success : function(response, opts) {	
					Ext.fm.msg("提示","恭喜，操作成功！");
					
					T_SYS_RESOURCE.subResourceStore.reload();
				},
				failure : function(response, opts) {
					var obj = Ext.util.JSON.decode(response.responseText);
					Ext.Msg.show({
						title : '异常提示',
						msg : obj.msg,
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		}
	});
};

T_SYS_RESOURCE.subResourceDelBtn = function(val,last,row){
	return "<span class='csh'></span><a href='javascript:void(0)' onclick='Ext.fcache.obj.subResourceDelBtnHandler()'>删除</a>";
};

T_SYS_RESOURCE.subResourceCm = new Ext.grid.ColumnModel([
	{header:'名称',dataIndex:'RESOURCE_NAME',width:180},
	{header:'命令(sqlid)',dataIndex:'RESOURCE_ADDR',width:180},
	{header:'操作',dataIndex:'RESOURCE_NAME',align : "center",renderer : T_SYS_RESOURCE.subResourceDelBtn}
]);

T_SYS_RESOURCE.subResourceStore = new Ext.data.Store({
	autoload : false,
	proxy : new Ext.data.HttpProxy({
		url : "common.action?command=T_SYS_RESOURCE.selectByPId"
	}),
	reader: new Ext.data.JsonReader({
		root : 'data'
	}, T_SYS_RESOURCE.subResource)
});

T_SYS_RESOURCE.subResourceSave = new Ext.Button({// 保存按钮
	text : '保存',
	iconCls : 'save',
	handler : function(btn) {
		var url = "";
		var p = {"RESOURCE_TYPE_ID" : "8434A75F4FF1426CBA0368AFD05B3CAD"};
		
		if(T_SYS_RESOURCE.subOpType == 'add'){//如果是添加模式，请求地址
			url = "common.action?command=T_SYS_RESOURCE.insert";
			p["PID"] = T_SYS_RESOURCE.params[T_SYS_RESOURCE.pk];
		}else if(T_SYS_RESOURCE.subOpType == 'modify'){//如果是修改模式，请求地址
			url = "common.action?command=T_SYS_RESOURCE.update";
			var row = T_SYS_RESOURCE.subResourceGrid.getSelectionModel().getSelected();
			p["RESOURCE_ID"] = row.data["RESOURCE_ID"];
		}
		
		if (T_SYS_RESOURCE.subResourceForm.getForm().isValid()) {
			T_SYS_RESOURCE.subResourceForm.getForm().submit({
				url : url,
				params : p,
				waitTitle : '请稍候',
				waitMsg : '正在提交表单数据,请稍候...',
				success : function(form, action) {
					Ext.fm.msg("提示","恭喜，操作成功！");
					
					T_SYS_RESOURCE.subResourceStore.reload();
					
					T_SYS_RESOURCE.subResourceWindow.hide();
				},
				failure : function(form, action) {
					Ext.Msg.show({
						title : '错误提示',
						msg : action.result.msg,
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		}
	}
});

T_SYS_RESOURCE.subResourceCancel = new Ext.Button({// 取消按钮
	text : '取消',
	iconCls : 'remove',
	handler : function() {			
		T_SYS_RESOURCE.subResourceWindow.hide();
	}
});

T_SYS_RESOURCE.subResourceForm = new Ext.FormPanel({
	labelAlign : 'right',
	labelWidth : 70,
	bodyStyle : 'padding:2px',
	frame : true,
	border : false,
	autoScroll : true,
	defaultType : 'textfield',
	defaults : {
		anchor : '93%'
	},
	items : [{
		"fieldLabel" : "名称",
		"name" : "RESOURCE_NAME"
	},{
		"fieldLabel" : "命令(sqlid)",
		"name" : "RESOURCE_ADDR"
	}],
	buttons:[T_SYS_RESOURCE.subResourceSave,T_SYS_RESOURCE.subResourceCancel]
});

T_SYS_RESOURCE.subResourceWindow = new Ext.Window({
	title : "子资源操作",
	layout : 'fit',
	width : 300,
	height : 170,
	closeAction : 'hide',
	plain : true,
	items : T_SYS_RESOURCE.subResourceForm
});

T_SYS_RESOURCE.subResourceGrid = new Ext.grid.GridPanel({
	title: '子资源管理页面',
	region: 'south',
    store: T_SYS_RESOURCE.subResourceStore,
    cm: T_SYS_RESOURCE.subResourceCm,
    height : 190,
    frame:true,
    border : false,
    split:true,
    clicksToEdit:1,
    tbar: [{
    	text: '刷新',
    	iconCls : 'refresh',
		handler : function() {
			T_SYS_RESOURCE.subResourceStore.reload();
		}
    },{
        text: '添加',
        iconCls : 'user-add',
        handler : function(){
        	if(T_SYS_RESOURCE.params[T_SYS_RESOURCE.pk] != null){
        		T_SYS_RESOURCE.subOpType = 'add';
        		T_SYS_RESOURCE.subResourceWindow.show();
        		T_SYS_RESOURCE.subResourceForm.getForm().reset();
        	}else{
        		Ext.Msg.show({
					title : '提示',
					msg : '请先选择一条资源！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARM
				});
        	}
        }
    },{
    	text: '修改',
    	iconCls : 'user-edit',
    	handler : function(){
    		if(T_SYS_RESOURCE.params[T_SYS_RESOURCE.pk] != null){
    			var row = T_SYS_RESOURCE.subResourceGrid.getSelectionModel().getSelected();
    			if(row != null){
    				T_SYS_RESOURCE.subOpType = 'modify';
    				T_SYS_RESOURCE.subResourceWindow.show();
    				T_SYS_RESOURCE.subResourceForm.getForm().findField("RESOURCE_NAME").setValue(row.data["RESOURCE_NAME"]);
    				T_SYS_RESOURCE.subResourceForm.getForm().findField("RESOURCE_ADDR").setValue(row.data["RESOURCE_ADDR"]);
    			}else{
    				Ext.Msg.show({
    					title : '友情提示',
    					msg : '请选择一条记录！',
    					buttons : Ext.Msg.OK,
    					icon : Ext.Msg.WARNING
    				});
    			}
        		
        	}else{
        		Ext.Msg.show({
					title : '提示',
					msg : '请先选择一条资源！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARM
				});
        	}
    	}
    }],
    listeners:{
		scope:T_SYS_RESOURCE,
		rowclick:function(){
			var me = this;
			Ext.fcache.obj = me;
		}
	}
});

T_SYS_RESOURCE.center = new Ext.Panel({
    layout : 'border',
    title : "资源管理",
    items : [{
		title : '资源数',
		region : 'west',
		layout : 'border',
		margins : '2 0 5 5',
		width : 275,
		minSize : 200,
		maxSize : 350,
		collapsible : true,	//可以关闭
		split : true,
		items : T_SYS_RESOURCE.tree
	}, {
		region : 'center',
		layout : 'border',
		border : false,
		margins : '2 5 5 0',
		border : false,
		items : [T_SYS_RESOURCE.form,T_SYS_RESOURCE.subResourceGrid]
	}]
});

return T_SYS_RESOURCE;
})(Ext)
