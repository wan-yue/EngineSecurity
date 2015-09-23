{
	"en" : "SDXX",
	"cn" : "水道信息",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "SDXX_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "SDXX_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "SDXX_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "SDXX_btnDownload"
	} ],
	"columns" : [  {
		"maxLength" : 50,
		"xtype" : "textfield",
		"dataIndex" : "SDMC",
		"header" : "水道名称",
		"order" : 1
	}, {
		"isColumn" : false,
		"xtype" : "combo",
		"dataIndex" : "HDBM",
		"header" : "所属航道",
		"url" : "common.action?command=CJHDSXXX.selectAll",
		"displayField" : "HDMC",
		"valueField" : "HDBM",
		"order" : 2
	}, {
		"isForm" : false,
		"header" : "所属航道",
		"dataIndex" : "HDMC"
	}, {
		"isColumn" : false,
		"xtype" : "combo",
		"dataIndex" : "HDXZ",
		"header" : "航道性质",
		"url" : "common.action?command=HDXZ.selectAll",
		"displayField" : "MC",
		"valueField" : "BM",
		"order" : 3
	}, {
		"isForm" : false,
		"header" : "航道性质",
		"dataIndex" : "HDXZMC",
	}, {
		"isColumn" : false,
		"xtype" : "combo",
		"dataIndex" : "HDDJ",
		"header" : "航道等级",
		"url" : "common.action?command=HDDJ.selectAll",
		"displayField" : "MC",
		"valueField" : "BM",
		"order" : 4
	}, {
		"isForm" : false,
		"header" : "航道等级",
		"dataIndex" : "HDDJMC"
	}, {
		"maxLength" : 5,
		"xtype" : "numberfield",
		"dataIndex" : "HDSS",
		"header" : "航道水深",
		"maxValue" : 99.99,
		"order" : 5
	}, {
		"maxLength" : 8,
		"xtype" : "numberfield",
		"dataIndex" : "HDKD",
		"header" : "航道宽度",
		"maxValue" : 99999.99,
		"order" : 6
	}, {
		"maxLength" : 6,
		"xtype" : "numberfield",
		"dataIndex" : "HDWQBJ",
		"header" : "航道弯曲半径",
		"maxValue" : 9999.9,
		"order" : 7
	}, {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "SDBH",
		"header" : "水道编号"
	} ]
}