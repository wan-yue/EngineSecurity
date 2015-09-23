{
	"en" : "HDFL",
	"cn" : "航道分类",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "HDFL_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "HDFL_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "HDFL_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "HDFL_btnDownload"
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDFLBM",
		"header" : "航道分类编号"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDFLMC",
		"header" : "航道分类名称"
	} ]
}