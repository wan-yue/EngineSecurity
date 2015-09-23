{
	"en" : "T_SIGNALSTATION",
	"cn" : "控制信号台",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "T_SIGNALSTATION_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "T_SIGNALSTATION_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "T_SIGNALSTATION_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "T_SIGNALSTATION_btnDownload"
	} ],
	"columns" : [ {
		"xtype" : "numberfield",
		"dataIndex" : "FID",
		"header" : null
	}, {
		"maxLength" : 100,
		"xtype" : "textfield",
		"dataIndex" : "FNAME",
		"header" : "信号台名称"
	}, {
		"maxLength" : 100,
		"xtype" : "textfield",
		"dataIndex" : "FMESSAGETOPIC",
		"header" : "消息主题"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "FCODE",
		"header" : "信号台唯一编码"
	}, {
		"maxLength" : 100,
		"xtype" : "textfield",
		"dataIndex" : "FRIVERNAME",
		"header" : "河段名称"
	}, {
		"xtype" : "numberfield",
		"dataIndex" : "FLON",
		"header" : "经度"
	}, {
		"xtype" : "numberfield",
		"dataIndex" : "FLAT",
		"header" : "纬度"
	}, {
		"maxLength" : 100,
		"xtype" : "textfield",
		"dataIndex" : "FREMARK",
		"header" : "备注"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "DEPARTMENID",
		"header" : "部门编码"
	}, {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "XHTBM",
		"header" : null
	} ]
}