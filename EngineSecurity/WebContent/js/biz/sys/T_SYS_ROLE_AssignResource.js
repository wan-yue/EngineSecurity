/** 分配用户 */
(function(){

var T_SYS_ROLE_AssignResource = {
		params : {},
		checkData : []
};

T_SYS_ROLE_AssignResource.add = new Ext.Button({
	text : '保存',
	iconCls : 'save',
	handler : function(btn){
		var resourceIds = T_SYS_ROLE_AssignResource.center.getCheckedId();
		
		T_SYS_ROLE_AssignResource.params["resourceIds"] = resourceIds;
		
		Ext.Ajax.request({
			url : "common.action?command=T_SYS_RESOURCEROLE.insertByTree",
			params : T_SYS_ROLE_AssignResource.params,
			success : function(response, opts) {	
				Ext.fm.msg("提示","恭喜，操作成功！");
				T_SYS_ROLE_AssignResource.parent.ds.reload();
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

T_SYS_ROLE_AssignResource.center =  new Ext.flying.Tree({
	title : '分配资源',
	frame : true,
	border : false,
	rootVisible : false, //是否显示根元素
	autoScroll : true,
	checked : true,
	checkData : T_SYS_ROLE_AssignResource.checkData,
	url : 'common.action?command=T_SYS_RESOURCE.selectAllMenu',
	baseConfig : {idName : 'RESOURCE_ID',textName:'RESOURCE_NAME',pidName:'PID'},
	rootNode : {RESOURCE_ID:'0',RESOURCE_NAME:'根节点'},
	buttonAlign : 'center',
	buttons:[T_SYS_ROLE_AssignResource.add]
});

return T_SYS_ROLE_AssignResource;

})(Ext)