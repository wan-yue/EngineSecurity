/** 分配用户 */
(function(){

var T_SYS_ROLE_AssignUserForm = {};

T_SYS_ROLE_AssignUserForm.assignUserToStore = new Ext.data.JsonStore({
	url : "common.action?command=T_SYS_USERINFO.getAllUsersByRoleId",
	root:'data',
	fields : [ {
		name : "USER_ID"
	}, {
		name : "USER_NAME"
	} ]
});

T_SYS_ROLE_AssignUserForm.assignUserFromStore = new Ext.data.JsonStore({
	url : "common.action?command=T_SYS_USERINFO.getUserOutOfRoleId",
	root:'data',
	fields : [ {
		name : "USER_ID"
	}, {
		name : "USER_NAME"
	} ]
});

T_SYS_ROLE_AssignUserForm.Btn_save = new Ext.Button({
	text: '保存',
    iconCls:'save',
    handler: function(){
		if (T_SYS_ROLE_AssignUserForm.center.getForm().isValid()) {
			T_SYS_ROLE_AssignUserForm.center.getForm().submit({
				url:'common.action?command=T_SYS_USERROLE.insertByRoleId',
				params:T_SYS_ROLE_AssignUserForm.parent.params,
				waitTitle : '请稍候',
				waitMsg : '正在提交表单数据,请稍候...',
				success : function(form, action) {
					Ext.Msg.show({
						title : '成功提示',
						msg : '数据保存成功！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.INFO
					});
				},
				failure : function(form, action) {
					Ext.Msg.show({
						title : '错误提示',
						msg : '操作失败',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		}
    }
});

T_SYS_ROLE_AssignUserForm.Btn_cancel = new Ext.Button({
	text : '取消',
	iconCls : 'icon-delete',
	handler:function(){
		
	}
});

T_SYS_ROLE_AssignUserForm.center = new Ext.FormPanel({
	title : '分配用户',
	frame : true,
	closable : true,
	bodyStyle : 'padding:10px;',
	items : [ {
		"xtype" : "departmentselection",
		"fieldLabel" : "部门",
		"name" : "ASSIGN_ZZJGDM",
		"closeFn" : function(me){
			T_SYS_ROLE_AssignUserForm.assignUserFromStore.load({
				params : {
					ROLE_ID : T_SYS_ROLE_AssignUserForm.parent.params[T_SYS_ROLE_AssignUserForm.parent.pk],
					ZZJGDM : me.departmentId
				}
			});
			
			return true;
		}
	},{
		"xtype" : "textfield",
		"fieldLabel" : "姓名",
		"name" : "ASSIGN_USERNAME",
		"enableKeyEvents" : true,
		"listeners" : {
			"keyup" : function(txt,e){
				if(e.getKey() != e.SPACE){
					T_SYS_ROLE_AssignUserForm.assignUserFromStore.load({
						params : {
							ROLE_ID : T_SYS_ROLE_AssignUserForm.parent.params[T_SYS_ROLE_AssignUserForm.parent.pk],
							USER_NAME : txt.getValue().replace(/\s+/g,"")
						}
					});
				}
			}
		}
	}, {
		xtype : "itemselector",
		name : "USER_ID",
		hideLabel : true,
		dataFields : [ "USER_ID", "USER_NAME" ],
		msWidth : 250,
		msHeight : 380,
		valueField : "USER_ID",
		displayField : "USER_NAME",
		imagePath : "img/icon/itemselect/",
		fromLegend : "用户列表",
		toLegend : "已分配用户列表",
		fromData : [],
		toData : [],
		fromStore : T_SYS_ROLE_AssignUserForm.assignUserFromStore,
		toStore : T_SYS_ROLE_AssignUserForm.assignUserToStore
	} ],
	buttons : [T_SYS_ROLE_AssignUserForm.Btn_save]
});

return T_SYS_ROLE_AssignUserForm;

})(Ext)