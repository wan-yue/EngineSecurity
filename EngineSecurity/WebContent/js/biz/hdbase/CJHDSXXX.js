{
	"en" : "CJHDSXXX",
	"cn" : "长江航道属性信息",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "CJHDSXXX_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "CJHDSXXX_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "CJHDSXXX_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "CJHDSXXX_btnDownload"
	} ],
	"columns" : [ {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDMC",
		"header" : "航道名称"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDGKJS",
		"header" : "航道概况介绍"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "ZZJGDM",
		"header" : "组织机构代码"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "QQD",
		"header" : "起讫点"
	}, {
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "HDLC",
		"header" : "航道里程",
		"maxValue" : 1.0E11
	}, {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDBM",
		"header" : "航道编码"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDDJ",
		"header" : "航道等级"
	} ]
}