{
	"en" : "HDXZ",
	"cn" : "航道性质",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "HDXZ_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "HDXZ_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "HDXZ_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "HDXZ_btnDownload"
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