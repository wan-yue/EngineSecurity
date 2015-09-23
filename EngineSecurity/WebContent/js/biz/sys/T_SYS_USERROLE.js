{
	"en" : "T_SYS_USERROLE",
	"cn" : "用户角色信息",
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
		"dataIndex" : "USER_ROLE_ID",
		"header" : "用户角色ID"
	}, {
		"isForm" : false,
		"dataIndex" : "USER_NAME",
		"header" : "用户"
	}, {
		"isColumn" : false,
		"maxLength" : "11",
		"xtype" : "numberfield",
		"dataIndex" : "USER_ID",
		"header" : "用户ID"
	}, {
		"isForm" : false,
		"dataIndex" : "ROLE_NAME",
		"header" : "角色"
	}, {
		"isColumn" : false,
		"maxLength" : "11",
		"xtype" : "numberfield",
		"dataIndex" : "ROLE_ID",
		"header" : "角色ID"
	} ]
}