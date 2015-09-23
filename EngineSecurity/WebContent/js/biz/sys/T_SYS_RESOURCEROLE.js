{
	"en" : "T_SYS_RESOURCEROLE",
	"cn" : "资源角色信息",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add"
	}, {
		"btype" : "modify"
	}, {
		"btype" : "delete"
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : "11",
		"xtype" : "numberfield",
		"dataIndex" : "RESOURCE_ROLE_ID",
		"header" : "资源角色ID"
	}, {
		"isForm" : false,
		"dataIndex" : "RESOURCE_NAME",
		"header" : "资源",
	}, {
		"isColumn" : false,
		"maxLength" : "11",
		"xtype" : "combo",
		"dataIndex" : "RESOURCE_ID",
		"header" : "资源",
		"url" : "common.action?command=T_SYS_RESOURCE.selectAll",
		"displayField" : "RESOURCE_NAME",
		"valueField" : "RESOURCE_ID"
		
	}, {
		"isForm" : false,
		"dataIndex" : "ROLE_NAME",
		"header" : "角色",
	}, {
		"isColumn" : false,
		"maxLength" : "11",
		"xtype" : "combo",
		"dataIndex" : "ROLE_ID",
		"header" : "角色",
		"url" : "common.action?command=T_SYS_ROLE.selectAll",
		"displayField" : "ROLE_NAME",
		"valueField" : "ROLE_ID"
	} ]
}