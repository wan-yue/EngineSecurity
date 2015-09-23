{
	"en" : "T_CHANNELINFO",
	"cn" : "水道信息表",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "T_CHANNELINFO_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "T_CHANNELINFO_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "T_CHANNELINFO_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "T_CHANNELINFO_btnDownload"
	} ],
	"columns" : [ {
		"maxLength" : 12,
		"xtype" : "numberfield",
		"dataIndex" : "FID",
		"header" : "编码",
		"maxValue" : 1.0E12
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "FNAME",
		"header" : "河道名称"
	}, {
		"maxLength" : 10,
		"xtype" : "textfield",
		"dataIndex" : "FTYPE",
		"header" : "类型"
	}, {
		"maxLength" : 10,
		"xtype" : "textfield",
		"dataIndex" : "FCODE",
		"header" : "河道编号"
	}, {
		"maxLength" : 50,
		"xtype" : "textfield",
		"dataIndex" : "FSECONDPART",
		"header" : "区域局名称"
	}, {
		"maxLength" : 100,
		"xtype" : "textfield",
		"dataIndex" : "FTHIRDPART",
		"header" : "全能处名称"
	}, {
		"maxLength" : 8,
		"xtype" : "numberfield",
		"dataIndex" : "FDOWNSTART",
		"header" : "下游维护里程起点",
		"maxValue" : 999999.9
	}, {
		"maxLength" : 8,
		"xtype" : "numberfield",
		"dataIndex" : "FDOWNEND",
		"header" : "下游维护里程终点",
		"maxValue" : 999999.9
	}, {
		"maxLength" : 8,
		"xtype" : "numberfield",
		"dataIndex" : "FMIDSTART",
		"header" : "中游维护里程起点",
		"maxValue" : 999999.9
	}, {
		"maxLength" : 8,
		"xtype" : "numberfield",
		"dataIndex" : "FMIDEND",
		"header" : "中游维护里程终点",
		"maxValue" : 999999.9
	}, {
		"maxLength" : 8,
		"xtype" : "numberfield",
		"dataIndex" : "FUPSTART",
		"header" : "上游维护里程起点",
		"maxValue" : 999999.9
	}, {
		"maxLength" : 8,
		"xtype" : "numberfield",
		"dataIndex" : "FUPEND",
		"header" : "上游维护里程终点",
		"maxValue" : 999999.9
	}, {
		"maxLength" : 50,
		"xtype" : "textfield",
		"dataIndex" : "REMARK",
		"header" : null
	}, {
		"maxLength" : 510,
		"xtype" : "textfield",
		"dataIndex" : "RANGE",
		"header" : null
	}, {
		"maxLength" : 1,
		"xtype" : "numberfield",
		"dataIndex" : "FREGION",
		"header" : "1表示上游，2表示中游，3表示下游",
		"maxValue" : 10
	}, {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "SDXXBM",
		"header" : null
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "DEPARTMENID",
		"header" : null
	} ]
}