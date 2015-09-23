{
	"en" : "T_SYS_USERINFO",
	"cn" : "用户信息",
	"userState" : function(val){
		var red = "#FF6464",yellow="#FF7E00",gray="#BFBFBF",blue='blue',state;
		if(val == 1){
			state = "<span style='background-color:"+red+";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"+red+"'>&nbsp;账号关闭</span>";
		}else if(val == 2){
			state = "<span style='background-color:"+yellow+";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"+yellow+"'>&nbsp;未分角色</span>";
		}else if(val == 3){
			state = "<span style='background-color:"+gray+";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"+gray+"'>&nbsp;密码过期</span>";
		}else if(val == 4){
			state = "<span style='background-color:"+blue+";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"+blue+"'>&nbsp;正常状态</span>";
		}
		
		return state;
	},
	"operation" : function(val,last,row){
		return "<span class='csh'></span><a href='javascript:void(0)' onclick='Ext.fcache.obj.csh(\""+val+"\")'>初始化密码</a>";	
	},
	"operation1" : function(val,last,row){
			var open = "<span class='open'></span><a  href='javascript:void(0)' onclick='Ext.fcache.obj.openORclose(\""+val+"\",1)'>开启</a>",
				close = "<span class='close'></span><a  href='javascript:void(0)' onclick='Ext.fcache.obj.openORclose(\""+val+"\",0)'>关闭</a>";
			if(row.data.BE_USE == 1){
				return close;
			}else{
				return open;
			}
	},
	//打开，关闭用户业务
	"openORclose" : function(userId,beUse){
		var me = this;
		Ext.Ajax.request({                        
	        url: 'common.action?command=T_SYS_USERINFO.update',
	        method:'post',
	        params:{"USER_ID":userId,"BE_USE":beUse},
	        success:function(response, opts){
	        	//刷新父页面
				me.ds.load();
	        },
	        failure: function(){
	        	Ext.Msg.show({
					title : '错误提示',
					msg : '操作失败',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
	        }
	    });
	},
	//初始化用户密码业务
	"csh" : function(userId){
		var me = this;
		Ext.Ajax.request({                           
	        url: 'common.action?command=T_SYS_USERINFO.update',
	        method:'post',
	        params:{"USER_ID":userId,"PASSWORD":"123456"},
	        success:function(response, opts){
	        	//刷新父页面
				me.ds.load();
				//Ext.example.msg('提示', '初始化成功！');
	        },
	        failure: function(){
	        	Ext.Msg.show({
					title : '错误提示',
					msg : '初始化失败',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.ERROR
				});
	        }
	    });
	},
	"assignRoleBeforeOp" : function(){
		var me = this;
		var row = me.grid.getSelectionModel().getSelected();
		if(row != null){
			me.params[me.pk] = row.data[me.pk];//获取主键值
			
			me["T_SYS_USERINFO_AssignRoleForm"].assignRoleFromStore.load({params:me.params});
			me["T_SYS_USERINFO_AssignRoleForm"].assignRoleToStore.load({params:me.params});
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
	"gridRowClick" : function(grid,index,e){
		Ext.fcache.obj = this;
		this.assignRoleBeforeOp();
	},
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "modify"
	}, {
		"btype" : "delete"
	},{
		"text" : "分配角色",
		"linkName" : "T_SYS_USERINFO_AssignRoleForm",
		"link" : "biz/sys/T_SYS_USERINFO_AssignRole.js",
		"type" : "empty",
		"beforeRun" : "assignRoleBeforeOp"
	}],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : "11",
		"xtype" : "numberfield",
		"dataIndex" : "USER_ID",
		"header" : "用户ID"
	}, {
		"maxLength" : "50",
		"dataIndex" : "USER_NAME",
		"header" : "用户姓名",
		"order" : 0
	}, {
		"maxLength" : "20",
		"dataIndex" : "LOGIN_NAME",
		"header" : "登陆账号",
		"order" : 1
	}, {
		"maxLength" : "50",
		"sortable" : false,
		"dataIndex" : "PASSWORD",
		"isColumn" : false,
		"header" : "密码",
		"inputType":"password",
		"order" : 2
	}, {
		"maxLength" : "20",
		"xtype" : "datefield",
		"dataIndex" : "EXPIRED",
		"format" : "Y-m-d",
		"header" : "账号有效期",
		"order" : 3
	}, {
		"isColumn" : false,
		"maxLength" : "11",
		"xtype" : "combo",
		"dataIndex" : "BE_USE",
		"header" : "是否使用",
		"displayField" : "name",
		"valueField" : "id",
		"data" : [ [ '已使用',1 ], [ '未使用',0 ] ],
		"value" : 1,
		"order" : 4
	}, {
		"isForm" : false,
		"dataIndex" : "DWMC",
		"header" : "所属部门"
	}, {
		"dataIndex" : "STATE",
		"header" : "用户状态",
		"isForm" : false,
		"align" :'center',
		"renderer" : 'userState'
	}, {
		"isForm" : false,
		"header" : '初始密码区',
		"sortable" : false,
		"align" :'center',
		"dataIndex" : 'USER_ID',
		"renderer" : 'operation'
	},{
		"isForm" : false,
		"header" : '开启/关闭 账号',
		"menuDisabled" : false,
		"align" :'center',
		"dataIndex": 'USER_ID',
		"renderer": 'operation1'
	}]
}