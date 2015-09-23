(function(){
var T_SYS_USERINFO_AssignRoleForm = {};

T_SYS_USERINFO_AssignRoleForm.assignRoleToStore = new Ext.data.JsonStore({    
	url:"common.action?command=T_SYS_ROLE.getAllRolesByUserId", 
	root:"data",
	fields:[{name:"ROLE_ID"},{name:"ROLE_NAME"}]    
});

T_SYS_USERINFO_AssignRoleForm.assignRoleFromStore = new Ext.data.JsonStore({      
     url:"common.action?command=T_SYS_ROLE.getRoleOutOfUserId",
     root:"data",
     fields:[{name:"ROLE_ID"},{name:"ROLE_NAME"}]  
});

T_SYS_USERINFO_AssignRoleForm.T_SYS_USERINFO_AssignRoleBtn_save = new Ext.Button({
	text: '保存',
    iconCls:'save',
    handler: function(){
		if (T_SYS_USERINFO_AssignRoleForm.center.getForm().isValid()) {
			T_SYS_USERINFO_AssignRoleForm.center.getForm().submit({
				url:'common.action?command=T_SYS_USERROLE.insertByUserId',
				params:T_SYS_USERINFO_AssignRoleForm.parent.params,
				waitTitle : '请稍候',
				waitMsg : '正在提交表单数据,请稍候...',
				success : function(form, action) {
					T_SYS_USERINFO_AssignRoleForm.parent.ds.load();
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

T_SYS_USERINFO_AssignRoleForm.T_SYS_USERINFO_AssignRoleBtn_cancel = new Ext.Button({
	text : '取消',
	iconCls : 'icon-delete',
	handler:function(){
		
	}
});

T_SYS_USERINFO_AssignRoleForm.center = new Ext.FormPanel({
    title:'角色分配',
    frame: true,
    closable : true,
    bodyStyle: 'padding:10px;',
    items:[{
        xtype:"itemselector",
        name:"ROLE_ID",
        hideLabel:true,
        dataFields:["ROLE_ID", "ROLE_NAME"],    
        msWidth:250,
        msHeight:130,
        valueField:"ROLE_ID",
        displayField:"ROLE_NAME",
        imagePath:"img/icon/itemselect/",
        fromLegend:"角色列表",
        toLegend:"已分配角色列表",
        fromData:[],
        toData:[],
        fromStore:T_SYS_USERINFO_AssignRoleForm.assignRoleFromStore,
        toStore:T_SYS_USERINFO_AssignRoleForm.assignRoleToStore
    }],
    buttons: [T_SYS_USERINFO_AssignRoleForm.T_SYS_USERINFO_AssignRoleBtn_save]
});

	return T_SYS_USERINFO_AssignRoleForm;
})(Ext)