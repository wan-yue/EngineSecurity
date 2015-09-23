{
	"en" : "T_SYS_REMIND",
	"cn" : "提醒管理",
	"showDetailsRender" : function(val,last,row){
		var title = row.data.SYS_NAME;
		var addr = row.data.LINK_ADDR;
		return "<span class='csh'></span><a href='javascript:void(0)' onclick='Ext.fcache.obj.showDetails(\""+title+"\",\""+addr+"\")'>详情</a>";	
	},
	"showDetails" : function(title,addr){
		var module = {
			"moduleTitle" : title,
			"moduleUrl" : addr
		};
		
		Ext.fcache.App.createWindow(module);
	},
	"btns" : [ {
		"btype" : "refresh"
	}],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "REMIND_ID",
		"header" : "提醒ID"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "SYS_NAME",
		"header" : "系统简称"
	}, {
		"maxLength" : 400,
		"xtype" : "textfield",
		"dataIndex" : "LINK_ADDR",
		"header" : "链接地址",
		"hidden" : true
	}, {
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "USER_ID",
		"header" : "用户ID",
		"hidden" : true
	}, {
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "REMIND_SIZE",
		"header" : "提醒数量"
	}, {
		"isForm" : false,
		"header" : '',
		"sortable" : false,
		"align" :'center',
		"dataIndex" : 'REMIND_ID',
		"renderer" : 'showDetailsRender'
	}]
}