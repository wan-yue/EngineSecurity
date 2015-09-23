{
	"en" : "T_SYS_GROUP",
	"cn" : "私有组管理",
	"afterAddShow" : function(){
		var me = this;
		Ext.fcache.App.desktop.windows["biz/sys/T_SYS_GROUP.js"].on("close",function(){
			console.log(this);
		},me);
	},
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add",
		"securityname" : "T_SYS_GROUP_btnAdd"
	}, {
		"btype" : "modify",
		"securityname" : "T_SYS_GROUP_btnModify"
	}, {
		"btype" : "delete",
		"securityname" : "T_SYS_GROUP_btnDelete"
	}, {
		"btype" : "download",
		"securityname" : "T_SYS_GROUP_btnDownload"
	}, {
		text :'设置组内人员',
		handler:function(){
			var me = this;
			var row = me.grid.getSelectionModel().getSelected();//获取选中列			
			if (row) {
				var selectedUserArr = [];
				//获取选中组内的人员
        	    Ext.Ajax.request({
        	        url : 'common.action?command=T_SYS_GROUP_USER.selectByFk',
        	        method : 'POST',
        	        params : {GROUP_ID:row.data["GROUP_ID"]},
        	        async : false,
        	        success: function(response, opts){
        	                var responseJson = Ext.util.JSON.decode(response.responseText);
        	                me.data = responseJson;
        	                if(responseJson.success){
        	                	for(var i=0;i<responseJson.data.length;i++){
        	                		selectedUserArr.push(responseJson.data[i]["USER_ID"]);
        	                	}
        	                }else{
        	                    Ext.Msg.show({
        	                            title : '异常提示',
        	                            msg : '获取数据出错',
        	                            buttons : Ext.Msg.OK,
        	                            icon : Ext.Msg.ERROR
        	                    });
        	                }
        	        }
        	    });
				var config = {
					dataArr  : selectedUserArr,
					submitUrl:'common.action?command=T_SYS_GROUP_USER.insert&GROUP_ID='+row.data["GROUP_ID"]
				};
				if(me.settingwin==null){
					me.settingwin = new Ext.flying.PersonWindow();
				}
				me.settingwin.show(config);
			}else{
				Ext.Msg.show({
					title : '操作提示',
					msg : '请选择一条记录',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
			}

		}
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "GROUP_ID",
		"header" : "私有组ID"
	}, {
		"maxLength" : 100,
		"xtype" : "textfield",
		"dataIndex" : "GROUP_NAME",
		"header" : "私有组名称"
	}, {
		"maxLength" : 25,
		"xtype" : "textfield",
		"dataIndex" : "PID",
		"header" : "父组"
	}, {
		"maxLength" : "11",
		"xtype" : "combo",
		"dataIndex" : "IS_DEPT",
		"header" : "是否部门共享",
		"displayField" : "name",
		"valueField" : "id",
		"data" : [ [ '是',1 ], [ '否',0 ] ],
		"value" : 0
	}, {
		"xtype" : "combo",
		"dataIndex" : "IS_SHARE",
		"header" : "是否全局共享",
		"displayField" : "name",
		"valueField" : "id",
		"data" : [ [ '是',1 ], [ '否',0 ] ],
		"value" : 0
	}]
}