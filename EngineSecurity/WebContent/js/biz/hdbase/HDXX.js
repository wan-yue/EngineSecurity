{
	"en" : "HDXX",
	"cn" : "河段信息",
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "HDXX_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "HDXX_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "HDXX_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "HDXX_btnDownload"
	} ],
	"columns" : [{
		"maxLength" : 50,
		"xtype" : "textfield",
		"dataIndex" : "HDMC",
		"header" : "河段名称"
	}, {
		"isForm" : false,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HDLX_TYPE",
		"header" : "河段起点类型"
	}, {
		"isColumn" : false,
		"maxLength" : 25,
		"xtype" : "combo",
		"dataIndex" : "HDQDLX_ID",
		"header" : "河段起点类型",
		"displayField" : "HDLX_TYPE",
		"valueField" : "HDLX_ID",
		"url" : "common.action?command=HDLX.selectAll",
		"order" : 1
	}, {
		"isForm" : false,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "ZDLX",
		"header" : "河段终点类型"
	}, {
		"isColumn" : false,
		"maxLength" : 25,
		"xtype" : "combo",
		"dataIndex" : "HDZDLX_ID",
		"header" : "河段终点类型",
		"displayField" : "HDLX_TYPE",
		"valueField" : "HDLX_ID",
		"url" : "common.action?command=HDLX.selectAll",
		"order" : 2
	},{
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "HD_ID",
		"header" : "河段ID"
	},{
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "HDQDLC",
		"header" : "航道里程起点"
	},{
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "HDZDLC",
		"header" : "航道里程止点"
	}]
}