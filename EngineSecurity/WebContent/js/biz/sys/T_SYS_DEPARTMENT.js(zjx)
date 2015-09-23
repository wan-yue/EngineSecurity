(function(){
	var department = {
		author:'zjx',
		departmentId:null	//选中树节点Id
	};
	//树上工具栏
	department.toolbar = new Ext.Toolbar({// 操作工具栏
		height:25,
        items : [{
					xtype:'button',
					iconCls : 'refresh',
					text : '刷新',
		            handler : function(t,checked){
		            	department.center.tree.root.reload();
		            }
				},'-',{
        			xtype:'button',
        			iconCls : 'user-delete',
        			text : '删除',
	                handler : function(t,checked){
	                	//1 判断是否有子部门，如果有不允许删除
	            		Ext.Ajax.request({
	    					url : "common.action?command=T_SYS_DEPARTMENT.selectByParentId",
	    					params : {PID:department.departmentId},
	    					success : function(response, opts) {	
	    						var responseJson = Ext.util.JSON.decode(response.responseText);
	    						if(responseJson.data.length>0){
	    							Ext.Msg.show({
	    								title : '提示',
	    								msg : "该部门下还包含子部门，不允许删除",
	    								buttons : Ext.Msg.OK,
	    								icon : Ext.Msg.ERROR
	    							});
	    							return;
	    						}else{
	    			            	//2 判断部门下是否有人员userInfo，如果有不允许删除
	    			        		Ext.Ajax.request({
	    								url : "common.action?command=T_SYS_USERINFO.selectByDepartmentId",
	    								params : {DEPARTMENT_ID:department.departmentId},
	    								success : function(response, opts) {	
	    									var responseJson = Ext.util.JSON.decode(response.responseText);
	    									if(responseJson.data.length>0){
	    										Ext.Msg.show({
	    											title : '提示',
	    											msg : "该部门下还包含人员信息，不允许删除",
	    											buttons : Ext.Msg.OK,
	    											icon : Ext.Msg.ERROR
	    										});
	    										return;
	    									}else{
	    						        		//3 提示删除操作
	    						            	Ext.Msg.confirm('部门删除', '你确定删除吗?', function(btn) {
	    											if (btn == 'yes') {
	    							                	Ext.Ajax.request({
	    							                        url : 'common.action?command=T_SYS_DEPARTMENT.delete',
	    							                        method : 'POST',
	    							                        params : {DEPARTMENT_ID:department.departmentId},
	    							                        async : false,
	    							                        success: function(response, opts){
	    							                                var responseJson = Ext.util.JSON.decode(response.responseText);
	    							                                        if(responseJson.success){
	    							                                                //树数据刷新
	    							                                        		department.center.tree.root.reload();
	    							                                        		//跳到addPanel页面,将modifyPanel设为不可用
	    							                                        		department.tabs.setActiveTab(department.addPanel);
	    							                                        		department.modifyPanel.setDisabled(true);
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
	    											}
	    										});
	    									}
	    								},
	    								failure : function(response, opts) {
	    									var obj = Ext.util.JSON.decode(response.responseText);
	    									Ext.Msg.show({
	    										title : '异常提示',
	    										msg : obj.msg,
	    										buttons : Ext.Msg.OK,
	    										icon : Ext.Msg.ERROR
	    									});
	    									return;
	    								}
	    							});
	    						}
	    					},
	    					failure : function(response, opts) {
	    						var obj = Ext.util.JSON.decode(response.responseText);
	    						Ext.Msg.show({
	    							title : '异常提示',
	    							msg : obj.msg,
	    							buttons : Ext.Msg.OK,
	    							icon : Ext.Msg.ERROR
	    						});
	    						return;
	    					}
	    				});
	                	
	                }
    			}]
	});

	//主显示区Form表单
	department.addPanel = new Ext.FormPanel({
		region:'center',
        labelWidth: 75,
        frame:true,
        title: '添加部门',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',
        items: [{
                fieldLabel: '部门名称',
                name: 'DEPARTMENT_NAME',
                allowBlank:false
            },{
            	xtype : 'departmentselection',
                fieldLabel: '所在部门',
                name: 'PID',
                allowBlank:false
            },{
            	xtype:'numberfield',
                fieldLabel: '排序号',
                name: 'ORDER_ID',
                allowBlank:false
            }],
        buttons: [{
            text: '保存',
            handler:function(){
                if (department.addPanel.getForm().isValid()) {
                	department.addPanel.getForm().submit({
                            url:'common.action?command=T_SYS_DEPARTMENT.insert',
                            waitTitle : '请稍候',
                            waitMsg : '正在提交表单数据,请稍候...',
                            params : {},    //参数
                            success : function(form, action) {
                                    //clear data
                            		department.addPanel.getForm().reset();
                            		//刷新树数据
                            		department.center.tree.root.reload();
                            		Ext.fm.msg("组织结构管理","恭喜，添加部门成功！");
                            },
                            failure : function(form, action) {
                                    Ext.Msg.show({
                                            title : '错误提示',
                                            msg : '操作失败',
                                            buttons : Ext.Msg.OK,
                                            icon : Ext.Msg.ERROR
                                    });
                            }
                    });
                }
            }
        }],
        listeners:{
        	"activate" : function(){
        		department.modifyPanel.setDisabled(true);
        	}
        }
    });
	//主显示区修改表单
	department.modifyPanel = new Ext.FormPanel({
		region:'center',
		disabled : true, 
        labelWidth: 75,
        frame:true,
        title: '修改部门',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',
        items: [{
                fieldLabel: '部门名称',
                name: 'DEPARTMENT_NAME',
                allowBlank:false
            },{
            	xtype : 'departmentselection',
                fieldLabel: '所在部门',
                name: 'PID',
                allowBlank:false
            },{
            	xtype:'numberfield',
                fieldLabel: '排序号',
                name: 'ORDER_ID',
                allowBlank:false
            }],
        buttons: [{
            text: '保存',
            handler:function(){
                if (department.modifyPanel.getForm().isValid()) {
                	department.modifyPanel.getForm().submit({
                            url:'common.action?command=T_SYS_DEPARTMENT.update',
                            waitTitle : '请稍候',
                            waitMsg : '正在提交表单数据,请稍候...',
                            params : {DEPARTMENT_ID:department.departmentId},    //参数
                            success : function(form, action) {
                            		//刷新树数据
                            		department.center.tree.root.reload();
                            		Ext.fm.msg("组织结构管理","恭喜，修改部门成功！");
                            },
                            failure : function(form, action) {
                                    Ext.Msg.show({
                                            title : '错误提示',
                                            msg : '操作失败',
                                            buttons : Ext.Msg.OK,
                                            icon : Ext.Msg.ERROR
                                    });
                            }
                    });
                }
            }
        },{
            text: '删除',
            handler:function(){
            	//1 判断是否有子部门，如果有不允许删除
        		Ext.Ajax.request({
					url : "common.action?command=T_SYS_DEPARTMENT.selectByParentId",
					params : {PID:department.departmentId},
					success : function(response, opts) {	
						var responseJson = Ext.util.JSON.decode(response.responseText);
						if(responseJson.data.length>0){
							Ext.Msg.show({
								title : '提示',
								msg : "该部门下还包含子部门，不允许删除",
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
							return;
						}else{
			            	//2 判断部门下是否有人员userInfo，如果有不允许删除
			        		Ext.Ajax.request({
								url : "common.action?command=T_SYS_USERINFO.selectByDepartmentId",
								params : {DEPARTMENT_ID:department.departmentId},
								success : function(response, opts) {	
									var responseJson = Ext.util.JSON.decode(response.responseText);
									if(responseJson.data.length>0){
										Ext.Msg.show({
											title : '提示',
											msg : "该部门下还包含人员信息，不允许删除",
											buttons : Ext.Msg.OK,
											icon : Ext.Msg.ERROR
										});
										return;
									}else{
						        		//3 提示删除操作
						            	Ext.Msg.confirm('部门删除', '你确定删除吗?', function(btn) {
											if (btn == 'yes') {
							                	Ext.Ajax.request({
							                        url : 'common.action?command=T_SYS_DEPARTMENT.delete',
							                        method : 'POST',
							                        params : {DEPARTMENT_ID:department.departmentId},
							                        async : false,
							                        success: function(response, opts){
							                                var responseJson = Ext.util.JSON.decode(response.responseText);
							                                        if(responseJson.success){
							                                                //树数据刷新
							                                        		department.center.tree.root.reload();
							                                        		//跳到addPanel页面,将modifyPanel设为不可用
							                                        		department.tabs.setActiveTab(department.addPanel);
							                                        		department.modifyPanel.setDisabled(true);
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
											}
										});
									}
								},
								failure : function(response, opts) {
									var obj = Ext.util.JSON.decode(response.responseText);
									Ext.Msg.show({
										title : '异常提示',
										msg : obj.msg,
										buttons : Ext.Msg.OK,
										icon : Ext.Msg.ERROR
									});
									return;
								}
							});
						}
					},
					failure : function(response, opts) {
						var obj = Ext.util.JSON.decode(response.responseText);
						Ext.Msg.show({
							title : '异常提示',
							msg : obj.msg,
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
						return;
					}
				});

            }
        }]
    });
	//TabPanel
	department.tabs = new Ext.TabPanel({//tabs
		region:'center',
    	resizeTabs : true,
    	autoDestroy : false,//关闭panel时，不销毁panel
    	activeTab : 0,
    	items:[department.addPanel,department.modifyPanel],
    	listeners:{
    		'remove':function(ct,component) {
    	    	var dom = component.el.dom;
    	    	if(dom.parentNode){
    		    	dom.parentNode.removeChild(dom);//手动删除ext遗留的dom节点   extbug
    	    	}
     		return true; 
    	 }
    	}
    });
	//布局Panel
	department.center = new Ext.flying.TreeLayout({
	    region:'center',
	    layout : 'border',
	    title : "组织机构管理",
	    frame:true,
	    items : [department.tabs],
	    treeClickFn:function(n) {
			var sn = this.selModel.selNode || {};
			if (n.id != sn.id) {
				var pid = n.parentNode.id;
				if(pid!=0){	//非单位根节点
					//激活右侧修改页面，并进行赋值
					department.tabs.setActiveTab(department.modifyPanel);
					department.modifyPanel.setDisabled(false);
					var id = n.id;
					department.departmentId = id;
					var name = n.text;
					var orderId = n.attributes["orderId"];
					department.modifyPanel.getForm().findField('DEPARTMENT_NAME').setValue(name);
					department.modifyPanel.getForm().findField('name_PID').setValue(pid);
					department.modifyPanel.getForm().findField('ORDER_ID').setValue(orderId);
				}
				
			}
		},
		treeUrl : 'common.action?command=T_SYS_DEPARTMENT.selectAllList',
		treebar:department.toolbar
	});
	return department;
})(Ext);