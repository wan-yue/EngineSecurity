{
	"en" : "HDDJ",
	"cn" : "航道等级",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "HDDJ_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "HDDJ_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "HDDJ_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "HDDJ_btnDownload"
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "BM",
		"header" : "代码"
	}, {
		"maxLength" : 50,
		"xtype" : "textfield",
		"dataIndex" : "MC",
		"header" : "名称"
	} ]
}