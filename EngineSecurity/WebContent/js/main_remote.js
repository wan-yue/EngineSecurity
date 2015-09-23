Ext.BLANK_IMAGE_URL = 'extjs/resources/images/default/s.gif';
Ext.QuickTips.init();//用于Ext的提示
/*
 * 默认首页是一张图片
var start = {
	id : 'start-panel',
	title : '欢迎使用',
	layout : 'fit',
	bodyStyle : 'padding:25px',
	html : '<img src="img/bg.jpg"/>'
};
*/

Ext.onReady(function() {
	setTimeout(function() {
		var num = 0;
		
		Ext.get('loading').remove();
		/*
		 * 默认首页是portal
		 */
		var tools = [{
		    id:'close',
		    handler: function(e, target, panel){
		        panel.ownerCt.remove(panel, true);
		    }
		}];
		var passwordSave = new Ext.Button({
    		text : '提交',
    		iconCls : 'save',
    		handler : function(btn) {
    			if (passwordForm.getForm().isValid()) {
    				passwordForm.getForm().submit({
    					url : "common.action?command=T_SYS_USERINFO.modifyPassword",
    					params : {"USER_ID" : Ext.fcache.session["USER_ID"]},
    					waitTitle : '请稍候',
    					waitMsg : '正在提交表单数据,请稍候...',
    					success : function(form, action) {
    						if(!action.result.success){
    							Ext.Msg.show({
    								title : '异常提示',
    								msg : action.result.msg,
    								buttons : Ext.Msg.OK,
    								icon : Ext.Msg.ERROR
    							});
    							
    							return;
    						};
    						
    						if(action.result.data){
    							passwordWin.hide();
    							Ext.fm.msg("密码修改","恭喜，保存成功！");
							}else{
								Ext.Msg.show({
        							title : '错误提示',
        							msg : '原密码输入错误',
        							buttons : Ext.Msg.OK,
        							icon : Ext.Msg.ERROR
        						});
							}
    					},
    					failure : function(form, action) {
    						Ext.Msg.show({
    							title : '错误提示',
    							msg : '网络或者服务器出现异常，无法连接!',
    							buttons : Ext.Msg.OK,
    							icon : Ext.Msg.ERROR
    						});
    					}
    				})
    			}
    		}
    	});
    	
    	var passwordForm = new Ext.FormPanel({
    		region : 'center',
    		labelAlign : 'right',
    		labelWidth : 70,
    		bodyStyle : 'padding:2px',
    		frame : true,
    		border : false,
    		autoScroll : true,
    		defaultType: 'textfield',
    		defaults : {
    			anchor : '93%'
    		},
    		items : [{
    				 fieldLabel: '原密码',
    	             name: 'OLD_PASSWORD',
    	             inputType : 'password',
    	             allowBlank:false 	    
    			},{
   				 fieldLabel: '新密码',
	             name: 'PASSWORD',
	             inputType : 'password',
	             allowBlank:false 	    
    			},{
				 fieldLabel: '新密码确认',
	             name: 'NEW_PASSWORD',
	             inputType : 'password',
	             allowBlank:false,
	             validator:function(value){
 	         		if(passwordForm.getForm().findField("PASSWORD").getValue() != value){
 	         			return "与新密码不符";
 	         		}else{
 	         			return true;
 	         		}
 	         	}
			}]
    	});
    	
    	var passwordWin = new Ext.Window({
			title : '个人基本信息维护',
			layout : 'border',
			width : 500,
			height : 300,
			frame : true,
			closeAction : 'hide',
			items : passwordForm,
			buttonAlign : 'center',
			buttons : [passwordSave]
		});
    	
		var userinfoObj = Ext.fcache.get("biz/sys/T_SYS_USERINFO.js","common","",true);
		userinfoObj.center.title = null;
		
		var resourceObj = Ext.fcache.get("biz/sys/T_SYS_RESOURCE.js","empty","",true);
		resourceObj.center.title = null;
		var systemMenu = new Ext.flying.Tree({
			border : false,
			rootVisible : false,
			autoScroll : true,
			//params : {"RESOURCE_ID" : '72E79D997AE4441E90D4EB7842AE0F1D'},
			url : 'common.action?command=T_SYS_USERRESOURCE.selectAll',
			baseConfig : {idName : 'RESOURCE_ID',textName:'RESOURCE_NAME',pidName:'PID',sortName:'SORT_NUM',iconName:'ICON'},
			rootNode : {RESOURCE_ID:'72E79D997AE4441E90D4EB7842AE0F1D',RESOURCE_NAME:'根节点'},
			listeners : {
				'click' : function(n) {
					try {
						var sn = this.selModel.selNode || {};
						var data = n.attributes.data;
						if (data["RESOURCE_ADDR"] && data["FACETYPE"] !="subSystem" && data["RESOURCE_ID"] != sn.id) {
							var name = data["RESOURCE_ADDR"];
							var type = data["FACETYPE"] || "empty";
							var cache = data["CACHE"];
							//从缓存中请求
							var page = Ext.fcache.changeUrl(name,type,"",cache);
						}
					} catch (e) {
						console.log(e);
					}
				}
			}
		})
		var vp = new Ext.Viewport({
			layout : 'border',
			defaults : {
				collapsible : true,
				split : true
			},
			items : [{
				xtype : 'toolbar',
				region : 'north',
				height : 50,
				split : false,
				items : [{
					text : '权限管理系统',
					cls : 'logo-center'
				},'->',{
					text : '权限系统',
					tooltip : '打开权限系统菜单',
					iconCls : 'user-kid',
					handler : function(){
						systemMenu.remoteRefresh({"RESOURCE_ID" : 'CD3C4F97320C45AEB11E5AB90FAE68BC'});
						systemMenu.expandAll();
						
					}
				},'-',{ 
					text : '工作流系统',
					tooltip : '打开工作流系统菜单',
					iconCls : 'user-suit',
					handler : function(){
						systemMenu.remoteRefresh({"RESOURCE_ID" : '7FF2AD89BA194EBAA9C5B72D673EC371'});
						systemMenu.expandAll();
					}
				},'-',{
					text : '修改密码',
					tooltip : '修改用户密码',
					iconCls : 'password',
					handler : function(){
						passwordWin.show();
					}
				},'-',{
					text : '退出系统',
					tooltip : '退出系统',
					iconCls : 'logout',
					handler : function(){
						Ext.Ajax.request({                           
				   	        url: 'common.action?command=T_SYS_USERINFO.logout',
				   	        method:'post',
				   	        success:function(response, opts){

				   	        }
				   	    });
					}
				}]
			}, {
				id : 'accordion-panel',
				title : '导航菜单',
				iconCls : 'icon-gray',
				layout : 'border',
				region : 'west',
				margins : '2 0 5 0',
				width : 200,
				collapsible:true,
				maxSize : 250,
				bodyStyle : 'background-color:#DFE8F6',
				defaults : {
					border : false
				},
				items : [{
					region : 'center',
					border : false,
					items : [systemMenu]
				}]
			}, {
				id : 'content-panel',
				region : 'center',
				layout : 'card',
				margins : '2 5 5 0',
				activeItem : 0,
				border : false,
				items:[{
					xtype:'portal',
				    items:[{
				        columnWidth:1,
				        style:'padding:10px 10px 10px 10px',
				        items : [{
				        	 title: userinfoObj.cn,
					         tools: tools,
					         layout : 'fit',
					 		 border : false,
					 		 height : 300,
					 		 items : userinfoObj.center
				        },{
				        	title: '资源管理',
					         tools: tools,
					         layout : 'fit',
					 		 border : false,
					 		 height : 500,
					 		 items : resourceObj.center
				        }]
				    }]
				}]
			}]
		});
	}, 250);
});
