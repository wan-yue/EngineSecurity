{
	"en" : "RYJBQK",
	"cn" : "人员基本情况",
	"formLabelWidth" : 80,
	"beforeInfo1Fun" : function(){
		var me = this;
		var row = me.grid.getSelectionModel().getSelected();
		if(row != null){
			me.params[me.pk] = row.data[me.pk];
		}else{
			Ext.Msg.show({
				title : '友情提示',
				msg : '请选择一条记录！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING
			});
			return true;
		}
	},
	"afterInfo1Fun" : function(){
		var me = this;

		Ext.Ajax.request({
			url : 'common.action?command=RYJBQK.selectByInfo1',
			params : me.params,
			method : 'post',
			success : function(response, opts) {
				var resultObj = Ext.util.JSON.decode(response.responseText);
				for(var name in resultObj.data){
					if(me["RYJBQK_INFO1"].center.getForm().findField(name)){
						me["RYJBQK_INFO1"].center.getForm().findField(name).setValue(resultObj.data[name]);
					}
				}
			},
			failure : function() {
				Ext.Msg.show({
					title : '错误提示',
					msg : '操作失败',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}
		});
	},
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "RYJBQK_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "RYJBQK_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "RYJBQK_btnDelete"
	},{
		"text" : "附加信息1",
		"linkName" : "RYJBQK_INFO1",
		"link" : "biz/hdbase/RYJBQK_INFO1.js",
		"type" : "empty",
		"beforeRun" : "beforeInfo1Fun",
		"afterRun" : "afterInfo1Fun"
	}, {
		"text" : "附加信息2",
		"linkName" : "RYJBQK_INFO2",
		"link" : "biz/hdbase/RYJBQK_INFO2.js",
		"type" : "empty"
	}, {
		"btype" : "download",
		"securityname" : "RYJBQK_btnDownload"
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "RYBM",
		"header" : "人员编码"
	}, {
		"maxLength" : 18,
		"xtype" : "textfield",
		"dataIndex" : "XM",
		"allowBlank" : false,
		"header" : "姓名"
	}, {
		"isColumn" : false,
		"allowBlank" : false,
		"xtype" : "departmentselection",
		"dataIndex" : "ZZJGDM",
		"header" : "部门名称"
	}, {
		"isForm" : false,
		"dataIndex" : "DWMC",
		"header" : "部门名称"
	}, {
		"maxLength" : 6,
		"xtype" : "textfield",
		"dataIndex" : "ZYM",
		"header" : "曾用名"
	}, {
		"maxLength" : 4,
		"xtype" : "numberfield",
		"dataIndex" : "NL",
		"header" : "年龄",
		"maxValue" : 1000
	}, {
		"xtype" : "datefield",
		"dataIndex" : "CSRQ",
		"header" : "出生日期"
	}, {
		"maxLength" : 9,
		"xtype" : "textfield",
		"dataIndex" : "SFZHM",
		"header" : "身份证号"
	}, {
		"maxLength" : 10,
		"xtype" : "textfield",
		"dataIndex" : "DZXX",
		"header" : "电子信箱"
	}, {
		"maxLength" : 10,
		"xtype" : "textfield",
		"dataIndex" : "YDDH",
		"header" : "移动电话号码"
	} ]
}