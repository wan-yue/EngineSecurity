function CommonGridFace(configs) {
	/** 全局属性区 */
	this.configs = configs || {};// 配置属性

	this.parent = null;//父亲对象
	
	this.gridObj = null;//grid对象
	
	this.formObj = null;//form对象
	
	this.toolbarObj = null;//toolbar对象
	
	this.buttonArray = new Array();// 操作数组
	
	this.params = {};//业务数据
	
	this.pk = '';// 主键名称
	
	this.opSqlid = '';//添加，修改自定义sqlid
	
	this.winWidth = null;//弹出框宽
	
	this.winHeight = null;//弹出框高
	
	this.winModel = true;//弹出模态框
	
	/** 生命周期中的方法*/
	this.beforeInstance = Ext.emptyFn;//创建页面显示之前方法
	
	this.afterInstance = Ext.emptyFn;//创建页面显示之前方法
	
	this.beforeDetailsShow = Ext.emptyFn;//显示详情页面显示之前方法
	
	this.afterDetalsShow = function(){//显示详情显示之后方法
		Ext.fFaceUtil.afterFormShow(this);
	};
	
	this.beforeAddShow = Ext.emptyFn;//添加页面显示之前方法
	
	this.afterAddShow = function(){//添加页面显示之后方法
		Ext.fFaceUtil.afterFormShow(this);
	};
	
	this.beforeAddSave = Ext.emptyFn;//添加保存之前方法
	
	this.afterAddSave = Ext.emptyFn;//添加保存之后方法
	
	this.beforeModifyShow = Ext.emptyFn;//修改页面显示之前方法
	
	this.afterModifyShow = function(){//修改页面显示之后方法
		Ext.fFaceUtil.afterFormShow(this);
	};
	
	this.beforeModifySave = Ext.emptyFn;//修改保存之前方法
	
	this.afterModifySave = Ext.emptyFn;//修改保存之后方法
	
	this.beforeDeleteSave = Ext.emptyFn;//删除保存之前方法 
	
	this.afterDeleteSave = Ext.emptyFn;//删除保存之后方法
	
	this.gridDbRowClick = function() {//初始化表格双击事件
		this.formTitle = "详情—"+this.cn;
		
		this.opType = "show";
		
		if(Ext.fFaceUtil.clickModifyOrShow(this)){			

			Ext.fFaceUtil.toggleForm(this,false);//表单无法保存
			
			this.afterDetailsShow();
		}
	};
	
	/** 初始化操作区 */
	this.Constructor = function() {// 构造方法

		for ( var name in this.configs) {// 初始化属性
			this[name] = this.configs[name];
		}
		this.beforeInstance();//创建实例前执行
		
		//初始化grid
		this.gridObj = new GridFace(this.configs,this);
		this.gridObj.center.region = "center";
		this.grid = this.gridObj.grid;
		this.ds = this.gridObj.ds;
		this.pk = this.gridObj.pk;
		
		//初始化表单
		this.formObj = new FormFace(this.configs,this);
		this.form = this.formObj.form;
		
		//初始化工具栏
		this.toolbarObj = new ToolbarFace(this.configs,this);
		this.toolbarObj.center.region = "north";
		this.toolbar = this.toolbarObj.toolbar;
		
		//初始化弹出框的大小	
    	this.winWidth = this.winWidth || window.screen.availWidth-2*120;
    	this.winHeight = this.winHeight || window.screen.availHeight-2*120;
		
		this.afterInstance();//创建实例后执行
	};
	
	this.Constructor(); // 执行构造方法，初始化对象
	
	this.reset = function(){//初始化方法
		try{
			this.params = {};
			this.formWindow.hide();
		}catch(e){
			
		}
	};
	
	/** 默认动作处理区 */
	this.clickAdd = function(b,e) {//默认添加
		this.opType = "add";
		
		if(b.sqlid){
			this.opSqlid = b.sqlid;
		}
		
		this.params = {};
		this.form.getForm().reset();//表单清空
		
		if (this.beforeAddShow() == false){
			return;
		}
		this.formTitle = "添加—"+this.cn;
		
		Ext.fFaceUtil.toggleForm(this,true);//激活表单
		
		this.formInit();
		
		this.afterAddShow();
	};
	
	this.clickModify = function(b,e) {
		this.formTitle = "修改—"+this.cn;
		
		this.opType = "modify";
		
		if(Ext.fFaceUtil.clickModifyOrShow(this)){			
			if(b.sqlid){
				this.opSqlid = b.sqlid;
			}
			
			Ext.fFaceUtil.toggleForm(this,true);//表单可以保存
			
			this.afterModifyShow();
		}
	};
	
	this.formInit = function(){
		this.formWindow.setTitle(this.formTitle);
		
		this.formWindow.show();//显示修改页面
	};
	
	this.clickDelete = function(b,e){//默认删除
		
		if(this.opType == "modify"){
			this.formWindow.hide();//关闭修改页面
		}
		
		this.batchDeleteUrl = "common.action?command=init.batchDelete";
		
		if(b.sqlid){
			this.batchDeleteUrl += "&SQLID=" + b.sqlid + "&PK=" + this.pk;
		}else{
			this.batchDeleteUrl += "&SQLID=" + this.en + ".delete&PK=" + this.pk;
		}
		
		Ext.fFaceUtil.clickDelete(this);
	};
	
	this.clickCopyAdd = function(b,e) {

		if(this.grid.getSelectionModel().hasSelection()){
			var rows = this.grid.getSelectionModel().getSelections();
			if(rows.length == 1){
				this.opType = "add";
				
				if(b.sqlid){
					this.opSqlid = b.sqlid;
				}
				
				this.params = {};
				this.form.getForm().reset();//表单清空
				
				if (this.beforeAddShow() == false){
					return;
				}
				this.formTitle = "追加—"+this.cn;
				
				Ext.fFaceUtil.toggleForm(this,true);//激活表单
				
				this.formInit();
				
				Ext.fFaceUtil.assignForm(this,rows[0]);//初始化表单数据
				
				this.afterAddShow();
			}else{
				Ext.Msg.show({
					title : '友情提示',
					msg : '您选择了多条记录，请只选择一条记录进行追加操作！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
			}
		}else{
			Ext.Msg.show({
				title : '友情提示',
				msg : '请选择一条记录进行追加操作！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING
			});
		}
	};

	this.clickDownload = function(b,e){//默认删除
		Ext.fFaceUtil.clickDownload(this);
	};
	
	this.refresh = function(b,e){//刷新方法
		this.ds.reload();
		
		this.reset();
	};
	
	this.clickSearch = function(param){//默认搜索
		for ( var name in param) {// 初始化属性
			this.grid.getStore().baseParams[name] = param[name];
		}
		this.grid.getStore().reload();
	};
	
	this.clickShow = function(b,e) {//默认显示片段

		if(typeof b["beforeRun"] == "function"){//方法前拦截
			var beforeResult = b["beforeRun"]();
			
			if(beforeResult){
				return;
			}
		}else if(typeof b["beforeRun"] == "string"){
			var beforeResult = this[b["beforeRun"]]();
			
			if(beforeResult){
				return;
			}
		}
		
		if(this[b["linkName"]] && this[b["linkName"]]["center"])
		{
			var winWidth = b["width"] || this.winWidth;
			var winHeight = b["height"] || this.winHeight;
			
			this[b["linkName"]+"_win"] = new Ext.Window({
	        	minimizable: true,
	            maximizable: true,
	        	width: winWidth,
	            height: winHeight,
	            layout: 'fit',
	            items: this[b["linkName"]]["center"]
			});
		}
		
		this[b["linkName"]+"_win"].show();
		
		if(typeof b["afterRun"] == "function"){//方法前拦截
			b["afterRun"]();
		}else if(typeof b["afterRun"] == "string"){
			this[b["afterRun"]]();
		}
	};
	
	this.clickSave = function(b,e) {//默认保存
		Ext.fFaceUtil.clickSave(this);
	};
	
	this.clickCancel = function(b,e){//默认取消
		this.form.getForm().reset();//表单清空
		
		this.formWindow.hide();
	};
	
	this.formWindow = new Ext.Window({//弹出窗口
		title : this.cn,
		layout : 'fit',
		width : this.winWidth,
		height : this.winHeight,
		modal : this.winModel,
		constrainHeader : true,
		closeAction : 'hide',
		plain : true,
		items : this.form
	});
	
	/** 容器 */
	this.center = new Ext.Panel({
		title : this.cn,
		layout : 'border',
		border : false,
		items : [ this.toolbarObj.center,this.gridObj.center ]
	});
}