{
	"en" : "T_SYS_ROLE",
	"cn" : "角色信息",
	"formColumn" : 1,
	"pageSize" : 20,
	"gridConfig" : {
		'ddGroup' : 'gridDDGroup',
		'enableDragDrop' : true   
	},
	"roleState" : function(val) {
		var red = "#FF6464", yellow = "#FFFF64", gray = "#BFBFBF", blue = "blue", state;
		if (val == '1') {
			state = "<span style='background-color:"
					+ red
					+ ";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"
					+ red + "'>&nbsp;角色锁定</span>";
		} else if (val == '2') {
			state = "<span style='background-color:"
					+ yellow
					+ ";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"
					+ yellow + "'>&nbsp;未分资源</span>";
		} else if (val == '3') {
			state = "<span style='background-color:"
					+ blue
					+ ";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"
					+ blue + "'>&nbsp;正常状态</span>";

		}

		return state;
	},
	"operation" : function(val, last, row) {
		var open = "<span class='open'></span><a  href='javascript:void(0)' onclick='Ext.fcache.obj.openORclose(\""
				+ val + "\",0)'>锁定</a>", 
		close = "<span class='close'></span><a  href='javascript:void(0)' onclick='Ext.fcache.obj.openORclose(\""
				+ val + "\",1)'>解锁</a>";
		if (row.data.BE_USE == 0) {
			return close;
		} else {
			return open;
		}
	},
	"openORclose" : function(val, mark) {
		var me = this;
		Ext.Ajax.request({
			url : 'common.action?command=T_SYS_ROLE.update',
			params : {
				ROLE_ID : val,
				BE_USE : mark
			},
			method : 'post',
			success : function(response, opts) {
				// 刷新父页面
				me.ds.reload();
			},
			failure : function() {
				Ext.Msg.show({
					title : '错误提示',
					msg : '操作失败',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		});
	},
	"assignUserBeforeOp" : function(){
		var me = this;
		var row = me.grid.getSelectionModel().getSelected();
		if(row != null){
			me.params[me.pk] = row.data[me.pk];//获取主键值
			
			me["T_SYS_ROLE_AssignUserForm"].assignUserToStore.load({params:me.params});
			me["T_SYS_ROLE_AssignUserForm"].assignUserFromStore.load({params:me.params});
		}else{
			Ext.Msg.show({
				title : '友情提示',
				msg : '请选择一条记录！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING
			});
			return true;
		}
	},
	"assignResourceBeforeOp" : function(){
		var row = this.grid.getSelectionModel().getSelected();
		if(row != null){
			if(row.data["ROLE_TYPE_ID"] == "82A3722096EB4FC9A8F5B51A48531B26"){
				Ext.Msg.show({
					title : '友情提示',
					msg : '工作流角色，不能分配资源！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return true;
			}
		}else{
			Ext.Msg.show({
				title : '友情提示',
				msg : '请选择一条记录！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING
			});
			return true;
		}
	},
	"assignResourceAfterOp" : function(){
		var me = this;
		var row = me.grid.getSelectionModel().getSelected();
		me.params[me.pk] = row.data[me.pk];//获取主键值
		me["T_SYS_ROLE_AssignResource"].params[me.pk] = row.data[me.pk];
		
		Ext.Ajax.request({
			url : 'common.action?command=T_SYS_RESOURCEROLE.selectByFk',
			params : me.params,
			method : 'post',
			async: false,
			success : function(response, opts) {
				var obj = Ext.util.JSON.decode(response.responseText);
				var res = obj["data"] || [];
				var checkData = [];
				for(var i =0;i<res.length;i++){
					checkData.push(res[i]["RESOURCE_ID"]);
				}
				me["T_SYS_ROLE_AssignResource"].center.checkedRefresh(checkData);
				
				if(me["T_SYS_ROLE_AssignResource"].center.rendered){
					me["T_SYS_ROLE_AssignResource"].center.expandAll();
				}
			},
			failure : function() {
				
				Ext.Msg.show({
					title : '错误提示',
					msg : '操作失败',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		});
	},
	"gridRowClick" : function(grid,index,e){
		Ext.fcache.obj = this;
		this.reset();
	},
	"beforeAddShow" : function(){
		this.params["DEPARTMENT_ID"] = this["DEPARTMENT_ID"];
	},
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "T_SYS_ROLE_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "T_SYS_ROLE_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "T_SYS_ROLE_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "T_SYS_ROLE_btnDownload"
	}, {
		"text" : "分配用户",
		"securityname" : "T_SYS_ROLE_btnAssignUser",
		"linkName" : "T_SYS_ROLE_AssignUserForm",
		"link" : "biz/sys/T_SYS_ROLE_AssignUser.js",
		"type" : "empty",
		"beforeRun" : "assignUserBeforeOp"
	}, {
		"text" : "分配资源",
		"securityname" : "T_SYS_ROLE_btnAssignResource",
		"linkName" : "T_SYS_ROLE_AssignResource",
		"link" : "biz/sys/T_SYS_ROLE_AssignResource.js",
		"type" : "empty",
		"beforeRun" : "assignResourceBeforeOp",
		"afterRun" : "assignResourceAfterOp"
	}, {
		"text" : "复制模板权限",
		"handler" : function(){
			var me = this;
			if(me.grid.getSelectionModel().hasSelection()){
				var thisRows = me.grid.getSelectionModel().getSelections();
				if(thisRows.length == 1){
					var gridTemplate = new GridFace({
						"en" : "T_SYS_ROLE",
						"cn" : "模板角色信息",
						"params" : {
							"filter" : "DEPARTMENT_ID='AEEFA72B530A46A9B2A4D5386B05F1E8'"
						},
						"columns" : [ {
							"isPk" : true,
							"dataIndex" : "ROLE_ID",
							"header" : "角色主键"
						}, {
							"maxLength" : "50",
							"width" : 150,
							"dataIndex" : "ROLE_NAME",
							"header" : "用户姓名"
						}, {
							"autoExpandColumn" : true,
							"xtype" : "textarea",
							"maxLength" : "200",
							"dataIndex" : "ROLE_DESC",
							"header" : "角色描述"
						}]
					});
					
					var gridTemplateWin = Ext.fcache.createWindow({
						title : '从角色模板中选择',
						width : 450,
						height : 300,
						items : gridTemplate.center,
						buttonAlign : 'center',
						buttons : [{
							text : '保存',
							handler : function(){
								if(gridTemplate.grid.getSelectionModel().hasSelection()){
									var rows = gridTemplate.grid.getSelectionModel().getSelections();
									var pkValues = "";
									
									for(var i=0;i<rows.length;i++){
										pkValues += rows[i].data["ROLE_ID"] + ",";
									}
									
									Ext.Ajax.request({
										url : "common.action?command=T_SYS_ROLE.copyResource",
										params : {"ROLE_ID" : thisRows[0].data["ROLE_ID"] ,"PKVALUES" : pkValues},
										success : function(response, opts) {
											
											me.grid.getStore().reload();
											
											gridTemplateWin.close();
											
											Ext.fm.msg("温馨提示","操作成功！");	
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
										title : '友情提示',
										msg : '请选择一条记录进行操作！',
										buttons : Ext.Msg.OK,
										icon : Ext.Msg.WARNING
									});
								}
							}
						},{
							text : '取消',
							handler : function(){
								gridTemplateWin.close();
							}
						}]
					});
					
					gridTemplateWin.show();
				}else{
					Ext.Msg.show({
						title : '友情提示',
						msg : '您选择了多条记录，请只选择一条记录进行操作！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
				}
			}else{
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录进行操作！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
			}
		}
	}],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : "11",
		"xtype" : "numberfield",
		"dataIndex" : "ROLE_ID",
		"header" : "角色ID" 
	}, {
		"maxLength" : "25",
		"isSearch" : true,
		"xtype" : "textfield",
		"dataIndex" : "ROLE_NAME",
		"header" : "角色名称"
	},{
		"isForm" : false,
		"isSearch" : true,
		"hidden" : true,
		"dataIndex" : "ROLE_TYPE_NAME",
		"header" : "角色类型"
	},{
		"isColumn" : false,
		"isForm" : false,
		"maxLength" : "11",
		"xtype" : "numberfield",
		"dataIndex" : "ROLE_TYPE_ID",
		"header" : "角色类型",
		"xtype" : "combo",
		"valueField" : "ROLE_TYPE_ID",
		"displayField" : "ROLE_TYPE_NAME",
		"url" : "common.action?command=T_SYS_ROLETYPE.selectAll"
	}, {
		"xtype" : "textarea",
		"maxLength" : "200",
		"dataIndex" : "ROLE_DESC",
		"header" : "角色描述"
	}, {
		"isColumn" : false,
		"isForm" : false,
		"maxLength" : "11",
		"xtype" : "numberfield",
		"dataIndex" : "BE_USE",
		"header" : "角色锁定"
	}, {
		"isColumn" : false,
		"isForm" : false,
		"maxLength" : "50",
		"dataIndex" : "ROLE_CODE",
		"header" : "角色编码"
	}, {
		"isForm" : false,
		"dataIndex" : "STATE",
		"isDownload" : false,
		"header" : "角色状态",
		"align" : "center",
		"renderer" : "roleState"
	},{
		"isForm" : false,
		"header" : "锁定/解锁 账号",
		"menuDisabled" : false,
		"align" :"center",
		"dataIndex": "ROLE_ID",
		"renderer": "operation"
	} ]
}