function FormFace(configs,parent) {
	/** 全局属性区 */
	this.configs = configs || {};// 配置属性
	
	this.parent = parent;//父亲对象
	
	this.url = "";//添加请求url
	
	this.formLayout = "column";
	
	this.formColumn = 2;//表单列数
	
	this.formFileUpload = false;//表单是否含有上传控件
	
	this.formLabelWidth = 80;//表单里面控件前面的标题长度
	
	this.formConfig = {};//表单属性
	
	/** 生命周期中的方法*/
	this.beforeInstance = Ext.emptyFn;//创建页面显示之前方法
	
	this.afterInstance = Ext.emptyFn;//创建页面显示之前方法
	
	this.beforeAddSave = Ext.emptyFn;//添加保存之前方法
	
	this.afterAddSave = Ext.emptyFn;//添加保存之后方法
	
	this.beforeModifySave = Ext.emptyFn;//修改保存之前方法
	
	this.afterModifySave = Ext.emptyFn;//修改保存之后方法
	/** 初始化操作区 */
	this.Constructor = function() {// 构造方法

		for ( var name in this.configs) {// 初始化属性
			if(!(this.parent != null && typeof this.configs[name] == "function")){
				this[name] = this.configs[name];
			}
		}
		
		var fconfig = Ext.fconfig[this.id];//获取当前配置信息
		
		if(this.formLayout == "table"){
			this.formArea = Ext.futil.handlerTableFormArray(this.columns,this.formColumn,fconfig,this);//对列进行一步处理，比如分组
		}else{
			this.formArea = Ext.futil.handlerColumnFormArray(this.columns,this.formColumn,fconfig,this);//对列进行一步处理，比如分组
		}
	};
	
	this.Constructor();
	
	this.clickSave = function(b,e){
		if(this.parent){
			this.parent.clickSave(b,e);
		}else{
			Ext.fFaceUtil.clickSave(this);
		}
	};
	
	this.clickCancel = function(b,e){
		if(this.parent){
			this.parent.clickCancel(b,e);
		}else{
			if(this.parentWin){
				this.parentWin.close();
			}
		}
	};
	
	/** 表单按钮区 */
	this.btn_save = new Ext.Button({// 保存按钮
		text : '保存',
		iconCls : 'save',
		scope:this,
		handler : this.clickSave
	});

	this.btn_cancel = new Ext.Button({// 取消按钮
		text : '取消',
		iconCls : 'remove',
		scope:this,
		handler : this.clickCancel
	});
	
	this.form = new Ext.FormPanel(
		Ext.applyIf(this.formConfig, {// 用户表单
			labelAlign : 'right',
			labelWidth : this.formLabelWidth,
			bodyStyle : 'padding:2px',
			frame : true,
			border : false,
			autoScroll : true,
			fileUpload : this.formFileUpload,
			defaults : {
				anchor : '96%'
			},
			items : this.formArea,
			buttons : [ this.btn_save, this.btn_cancel ]
		})
	);
	
	/** 容器 */
	this.center = new Ext.Panel({
		layout : 'fit',
		border : false,
		items : [ this.form ]
	});
}