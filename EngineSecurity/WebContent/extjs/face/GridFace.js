function GridFace(configs,parent) {
	/** 全局属性区 */
	this.configs = configs || {};// 配置属性
	
	this.parent = parent;//父亲对象
	
	this.cn = '';// 中文

	this.en = '';// 英文
	
	this.author = 'zdf';// 作者

	this.version = '1.0';// 版本
	
	this.params = {};//业务数据
	
	this.pk = '';// 主键名称
	
	this.pageSize = 20;// 分页
	
	this.cmArray = new Array();// 表格列数组
	
	this.modelArray = new Array();// 实体数组
	
	this.pagingBtnArray = new Array();//分页上面加按钮
	
	this.tableAction = ""; // 列表数据请求的url
	
	this.singleSelect =  false;//表格是否能多选
	
	this.storeName = null; //store的名称
	
	this.storeConfig = {}; //store的配置
	
	this.gridName = null; //grid的名称
	
	this.gridConfig = {}; //grid的配置
	
	this.pagingConfig = {}; //分页的配置
	
	this.gridCellClick = function(grid,rowIndex,columnIndex,e) {//初始化表格列单击事件
		if(this.parent){
			Ext.fcache.obj = this.parent;
			if(this.parent["gridCellClick"] != null){
				this.parent["gridCellClick"](grid,rowIndex,columnIndex,e);
			};
		}else{
			Ext.fcache.obj = this;
		}
	};
	
	this.gridRowClick = function() {//初始化表格行单击事件
		if(this.parent){
			Ext.fcache.obj = this.parent;
			if(this.parent["gridRowClick"] != null){
				this.parent["gridRowClick"]();
			};
		}else{
			Ext.fcache.obj = this;
		}
	};
	
	this.gridDbRowClick = function() {//初始化表格双击事件
		if(this.parent){
			Ext.fcache.obj = this.parent;
			if(this.parent["gridDbRowClick"] != null){
				this.parent["gridDbRowClick"]();
			};
		}else{
			Ext.fcache.obj = this;
		}
	};
	
	this.gridRender = function() {//表格渲染事件
		if(this.parent){
			if(this.parent["gridRender"] != null){
				this.parent["gridRender"]();
			};
		}
	};
	
	this.beforeDeleteSave = Ext.emptyFn;//删除保存之前方法 
	
	this.afterDeleteSave = Ext.emptyFn;//删除保存之后方法
	
	/** 初始化操作区 */
	this.Constructor = function() {// 构造方法
		for ( var name in this.configs) {// 初始化属性
			if(!(this.parent != null && typeof this.configs[name] == "function")){
				this[name] = this.configs[name];
			}
		}
		
		if(this.columns){
			if (this.tableAction == "") {// 列表默认值
				this.tableAction = "common.action?command=" + this.en + ".selectAll";
			}
			
			this.cmArray = Ext.futil.handleColumn(this.columns,this);
			
			this.modelArray = Ext.futil.handleModel(this.columns);
			
			this.pagingBtnArray = Ext.futil.handlePagingBtn(this.btns,this);
			
			for(var i = 0;i < this.cmArray.length;i++){
				if(this.cmArray[i]["isPk"]){
					this.pk = this.cmArray[i]["dataIndex"];
					break;
				}
			}
			//根据前台的pageSize进行分页
			if(this.pageSize){
				this.params["start"] = 0;
				this.params["limit"] = this.pageSize;
			}
		}
		//判断是否需要列表分组
		if(Ext.fconfig[this.id] != null && Ext.fconfig[this.id]["gridGroup"] != null){
			this.storeName = Ext.data.GroupingStore;

			var view = new Ext.grid.GroupingView({
	            //forceFit:true,
	            groupTextTpl: '{gvalue}'
	        });
			
			var gridGroup = Ext.fconfig[this.id]["gridGroup"];
			
			for(var name in gridGroup){
				if(name == "view"){
					view = gridGroup[name];
					continue;
				}
				
				this.storeConfig[name] = gridGroup[name];
			}
			
			this.gridConfig["view"] =  view;
			
			
		}
		//设定可伸缩项
		for(var i =0;i<this.cmArray.length;i++){
			if(this.cmArray[i]["autoExpandColumn"] != null && this.cmArray[i]["autoExpandColumn"] == true){
				this.cmArray[i]["id"] = this.cmArray[i]["dataIndex"];
				this.gridConfig["autoExpandColumn"] = this.cmArray[i]["dataIndex"];
				break;
			}
		}
		//设置表格的长度和宽度
		if(this.parent == null){
			if(this.configs["winWidth"] != null){
				this.gridConfig["width"] = this.configs["winWidth"];
			}
			if(this.configs["winHeight"] != null){
				this.gridConfig["height"] = this.configs["winHeight"];
			}
		}
		//修改分页配置
		if(this.pagingBtnArray.length > 0){
			this.pagingConfig["items"] = this.pagingBtnArray;
		}
	};
	
	this.Constructor(); // 执行构造方法，初始化对象
	
	/** grid构建区域 */
	this.Model = Ext.data.Record.create(this.modelArray);// 用户对象

	this.ds = new (this.storeName || Ext.data.Store)(
		Ext.applyIf(this.storeConfig, {// 默认数据源
			autoLoad : true,
			remoteSort : true,
			baseParams:this.params,
			proxy : new Ext.data.HttpProxy({
				url : this.tableAction
			}),
			reader : new Ext.data.JsonReader({
				root : 'data',
				totalProperty : "total"
			}, this.Model)
		})
	);

	this.pagingBar = new Ext.PagingToolbar(
		Ext.applyIf(this.pagingConfig,{// 分页工具栏
			pageSize : this.pageSize,
			store : this.ds,
			displayInfo : false
		})
	);

	this.grid = new (this.gridName || Ext.grid.FlyingGridPanel)(
		Ext.applyIf(this.gridConfig, {// 默认列表属性
			iconCls : 'icon-grid',
			margins : '2 2 2 2',
			loadMask : {
				msg : '数据加载中...'
			},
			cm : this.cmArray,
			ds : this.ds,
			bbar : this.pagingBar,
			sm : new Ext.grid.CheckboxSelectionModel({
				singleSelect : this.singleSelect
			}),
			enableColumnMove : false,
			trackMouseOver : false,
			listeners:{
				scope:this,
				cellclick : this.gridCellClick,
				rowclick:this.gridRowClick,
				rowdblclick:this.gridDbRowClick,
				render : this.gridRender				
			}
		})
	);
	
	/** 容器 */
	this.center = new Ext.Panel({
		layout : 'fit',
		border : false,
		items : [ this.grid ]
	});
}