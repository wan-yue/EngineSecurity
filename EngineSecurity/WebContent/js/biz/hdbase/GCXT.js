{
	"en" : "GCXT",
	"cn" : "高程系统",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "GCXT_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "GCXT_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "GCXT_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "GCXT_btnDownload"
	} ],
	"columns" : [  {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "GCBM",
		"header" : "编码"
	}, {
		"maxLength" : 50,
		"xtype" : "textfield",
		"dataIndex" : "GCMC",
		"header" : "名称"
	} ]
}