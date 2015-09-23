{
	"en" : "T_MILEAGE",
	"cn" : "里程经纬度",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "T_MILEAGE_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "T_MILEAGE_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "T_MILEAGE_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "T_MILEAGE_btnDownload"
	} ],
	"columns" : [ {
		"xtype" : "numberfield",
		"dataIndex" : "FID",
		"header" : null
	}, {
		"maxLength" : 1,
		"xtype" : "numberfield",
		"dataIndex" : "FTYPE",
		"header" : "里程类型(3下游 2 中游 1 上游)",
		"maxValue" : 10
	}, {
		"xtype" : "numberfield",
		"dataIndex" : "FLONGITUDE",
		"header" : "精度"
	}, {
		"xtype" : "numberfield",
		"dataIndex" : "FLATITUDE",
		"header" : "纬度"
	}, {
		"xtype" : "numberfield",
		"dataIndex" : "FMILEAGEV",
		"header" : "里程值"
	}, {
		"maxLength" : 127,
		"xtype" : "textfield",
		"dataIndex" : "FVERSION",
		"header" : null
	} ]
}