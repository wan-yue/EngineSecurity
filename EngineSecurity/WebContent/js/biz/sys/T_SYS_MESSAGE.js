{
	"en" : "T_SYS_MESSAGE",
	"cn" : "消息表管理",
	"afterDeleteSave" : function(){
		Ext.fcache.App.checkMessage();
	},
	"gridCellClick" : function(grid,rowIndex,columnIndex,e){
		if(columnIndex==3){
			//改成已读
			var record = grid.getStore().getAt(rowIndex);
            Ext.Ajax.request({
        		url : 'common.action',
        		method : 'GET',
        		params : {'command':'T_SYS_MESSAGE.deleteMessage',"MSG_ID":record.data.MSG_ID},
        		success : function(response, opts) {
        			Ext.fcache.App.checkMessage();
        			
        			grid.getStore().reload();
        		},
				failure : function(response, opts) {
					var obj = Ext.util.JSON.decode(response.responseText);
					Ext.Msg.show({
						title : '异常提示',
						msg : obj.msg,
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
        	});
		}
	},
	"gridDbRowClick" : function(){
		var rows = this.grid.getSelectionModel().getSelections();
		if(rows[0].data.IS_VIEW == 3){
			var module = {};
			module["moduleTitle"] = rows[0].data.MSG_TITLE;
			module["moduleUrl"] = rows[0].data.MSG_ADDR;
			module["moduleParam"] = rows[0].data.MSG_ADDR_PARAM;
			module["moduleType"] = "common";
			module["moduleCache"] = 0;
			
			Ext.fcache.App.msgCreateWindow(module);
		}
	},
	"deleteRender" : function(val,last,row){
		if(row.data.IS_VIEW != 2){
			return String.format("<a href='javascript:void(0)'><span class='remove_norepeat'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></a>",
   				 row.data.MSG_ID);	
		}
    },
	"showTitleRender" : function(val,last,row){
		var title = "";
		if(row.data.IS_VIEW == 3){
			title = String.format("<a href='javascript:void(0)'><span><b>【{1}】{0}</b></span></a>",
					row.data.MSG_TITLE, row.data.SYS_NAME);
		}else{
			title = String.format("<span><b>【{1}】{0}</b></span>",
					row.data.MSG_TITLE, row.data.SYS_NAME);
		}
		
		return String.format(
                '{0}<br/><br/><span style="font-size:12px;margin-left:5px;">发信人：<font color="red">{1}</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：<font color="green">{2}</font></span>',
                title, row.data.MSG_SENDER_NAME,row.data.SEND_DATE);
	},
	"btns" : [ {
		"btype" : "refresh"
	},{
		"onPaging" : true,
		"text" : '查看所有消息',
		"handler" : function(){
			var module = {};
			module["moduleTitle"] = "所有消息提醒";
			module["moduleUrl"] = "biz/sys/T_SYS_MESSAGE.js";
			module["moduleType"] = "common";
			module["moduleCache"] = 0;
			
			Ext.fcache.App.createWindow(module);
		}
	},{
		"onPaging" : true,
		"text" : '删除',
		"iconCls" : 'user-delete',
		"handler" : function(){
			this.batchDeleteUrl = "common.action?command=init.batchDelete&SQLID=T_SYS_MESSAGE.deleteMessage&PK=MSG_ID";
			
			Ext.fFaceUtil.clickDelete(this);
		}
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "MSG_ID",
		"header" : "消息ID"
	}, {
		"autoExpandColumn" : true,
		"dataIndex" : "MSG_TITLE",
		"header" : "提醒",
		"renderer" : "showTitleRender"
	}, {
		"isColumn" : false,
		"xtype" : "textfield",
		"dataIndex" : "MSG_ADDR",
		"header" : "链接地址"
	}, {
		"isColumn" : false,
		"xtype" : "textfield",
		"dataIndex" : "MSG_ADDR_PARAM",
		"header" : "链接地址参数"
	}, {
		"isColumn" : false,
		"xtype" : "numberfield",
		"dataIndex" : "MSG_SENDER_NAME",
		"header" : "发件人"
	}, {
		"isColumn" : false,
		"xtype" : "datefield",
		"dataIndex" : "SEND_DATE",
		"header" : "发送时间"
	}, {
		"isColumn" : false,
		"xtype" : "textfield",
		"dataIndex" : "SYS_NAME",
		"header" : "系统简称"
	}, {
		"isColumn" : false,
		"dataIndex" : "IS_VIEW",
		"header" : "是否查看"
	},{
		"dataIndex" : "MSG_ID",
		"header" : "",
		"width" : 50,
		"align" :'center',
		"renderer" : "deleteRender"
	} ]
}