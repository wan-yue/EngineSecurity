{
	"en" : "HDLX",
	"cn" : "河段类型",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "HDLX_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "HDLX_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "HDLX_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "HDLX_btnDownload"
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDLX_ID",
		"header" : "河段类型ID"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDLX_TYPE",
		"header" : "河段类型"
	} ]
}