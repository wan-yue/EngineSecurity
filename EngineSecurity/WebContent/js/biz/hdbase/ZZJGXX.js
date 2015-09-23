(function(){
	var ZZJGXX = {
		author:'zdf',
		ZZJGDM:null	//选中树节点Id
	};
	
	//树上工具栏
	ZZJGXX.toolbar = new Ext.Toolbar({// 操作工具栏
		height:25,
        items : [{
					xtype:'button',
					iconCls : 'refresh',
					text : '刷新',
		            handler : function(t,checked){
		            	ZZJGXX.center.tree.root.reload();
		            }
				},'-',{
        			xtype:'button',
        			iconCls : 'user-delete',
        			text : '删除',
	                handler : function(t,checked){
			            	Ext.Msg.confirm('部门删除', '你确定删除吗?', function(btn) {
								if (btn == 'yes') {
				                	Ext.Ajax.request({
				                        url : 'common.action?command=ZZJGXX.delete',
				                        method : 'POST',
				                        params : {ZZJGDM:ZZJGXX.ZZJGDM},
				                        async : false,
				                        success: function(response, opts){
				                                var responseJson = Ext.util.JSON.decode(response.responseText);
				                                        if(responseJson.success){
				                                                //树数据刷新
				                                        		ZZJGXX.center.tree.root.reload();
				                                        		//跳到addPanel页面,将modifyPanel设为不可用
				                                        		ZZJGXX.tabs.setActiveTab(ZZJGXX.addPanel);
				                                        		ZZJGXX.modifyPanel.setDisabled(true);
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
    			}]
	});

	//主显示区Form表单
	ZZJGXX.addPanel = new Ext.FormPanel({
		region:'center',
        labelWidth: 75,
        frame:true,
        title: '添加部门',
        bodyStyle:'padding:5px 5px 0',
        width: 350,
        defaults: {width: 230},
        defaultType: 'textfield',
        items: [{
        		"maxLength" : 50,
        		"name" : "DWMC",
        		"fieldLabel" : "单位名称",
        		"allowBlank" : false
        	}, {
        		"maxLength" : 50,
        		"name" : "DWDZ",
        		"fieldLabel" : "单位地址"
        	}, {
        		"maxLength" : 11,
        		"xtype" : "numberfield",
        		"name" : "YZBM",
        		"fieldLabel" : "邮政编码"
        	}, {
        		"maxLength" : 11,
        		"xtype" : "numberfield",
        		"name" : "LXDH",
        		"fieldLabel" : "联系电话"
        	}, {
        		"maxLength" : 11,
        		"xtype" : "numberfield",
        		"name" : "CZHM",
        		"fieldLabel" : "传真号码"
        	}, {
        		"maxLength" : 25,
        		"name" : "DZXX",
        		"fieldLabel" : "电子信箱"
        	}, {
        		"maxLength" : 11,
        		"xtype" : "numberfield",
        		"name" : "DWXZ",
        		"fieldLabel" : "单位性质"
        	}, {
        		"maxLength" : 25,
        		"name" : "HYDM",
        		"fieldLabel" : "行业代码"
        	}, {
        		"xtype" : "departmentselection",
        		"name" : "SJZZJGDM",
        		"allowBlank" : false,
        		"fieldLabel" : "上级机构",
        	}, {
        		"maxLength" : 10,
        		"name" : "FRDB",
        		"fieldLabel" : "法人代表"
        	}],
        buttons: [{
            text: '保存',
            handler:function(){
                if (ZZJGXX.addPanel.getForm().isValid()) {
                	ZZJGXX.addPanel.getForm().submit({
                            url:'common.action?command=ZZJGXX.insert',
                            waitTitle : '请稍候',
                            waitMsg : '正在提交表单数据,请稍候...',
                            params : {},    //参数
                            success : function(form, action) {
                                    //clear data
                            		ZZJGXX.addPanel.getForm().reset();
                            		//刷新树数据
                            		ZZJGXX.center.tree.root.reload();
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
        		ZZJGXX.modifyPanel.setDisabled(true);
        	}
        }
    });
	
	//主显示区修改表单
	ZZJGXX.modifyPanel = new Ext.FormPanel({
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
    		"maxLength" : 50,
    		"name" : "DWMC",
    		"fieldLabel" : "单位名称",
    		"allowBlank" : false
    	}, {
    		"maxLength" : 50,
    		"name" : "DWDZ",
    		"fieldLabel" : "单位地址"
    	}, {
    		"maxLength" : 11,
    		"xtype" : "numberfield",
    		"name" : "YZBM",
    		"fieldLabel" : "邮政编码"
    	}, {
    		"maxLength" : 11,
    		"xtype" : "numberfield",
    		"name" : "LXDH",
    		"fieldLabel" : "联系电话"
    	}, {
    		"maxLength" : 11,
    		"xtype" : "numberfield",
    		"name" : "CZHM",
    		"fieldLabel" : "传真号码"
    	}, {
    		"maxLength" : 25,
    		"name" : "DZXX",
    		"fieldLabel" : "电子信箱"
    	}, {
    		"maxLength" : 11,
    		"xtype" : "numberfield",
    		"name" : "DWXZ",
    		"fieldLabel" : "单位性质"
    	}, {
    		"maxLength" : 25,
    		"name" : "HYDM",
    		"fieldLabel" : "行业代码"
    	}, {
    		"xtype" : "departmentselection",
    		"name" : "SJZZJGDM",
    		"fieldLabel" : "上级机构",
    	}, {
    		"maxLength" : 10,
    		"name" : "FRDB",
    		"fieldLabel" : "法人代表"
    	}, {
    		"maxLength" : 10,
    		"name" : "PXH",
    		"fieldLabel" : "排序号"
    	} ],
        buttons: [{
            text: '保存',
            handler:function(){
                if (ZZJGXX.modifyPanel.getForm().isValid()) {
                	ZZJGXX.modifyPanel.getForm().submit({
                            url:'common.action?command=ZZJGXX.update',
                            waitTitle : '请稍候',
                            waitMsg : '正在提交表单数据,请稍候...',
                            params : {ZZJGDM:ZZJGXX.ZZJGDM},    //参数
                            success : function(form, action) {
                            		//刷新树数据
                            		ZZJGXX.center.tree.root.reload();
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
            	Ext.Msg.confirm('部门删除', '你确定删除吗?', function(btn) {
					if (btn == 'yes') {
	                	Ext.Ajax.request({
	                        url : 'common.action?command=ZZJGXX.delete',
	                        method : 'POST',
	                        params : {ZZJGDM:ZZJGXX.ZZJGDM},
	                        async : false,
	                        success: function(response, opts){
	                                var responseJson = Ext.util.JSON.decode(response.responseText);
	                                        if(responseJson.success){
	                                                //树数据刷新
	                                        		ZZJGXX.center.tree.root.reload();
	                                        		//跳到addPanel页面,将modifyPanel设为不可用
	                                        		ZZJGXX.tabs.setActiveTab(ZZJGXX.addPanel);
	                                        		ZZJGXX.modifyPanel.setDisabled(true);
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
        }]
    });
	
	//TabPanel
	ZZJGXX.tabs = new Ext.TabPanel({//tabs
		region:'center',
    	resizeTabs : true,
    	autoDestroy : false,//关闭panel时，不销毁panel
    	activeTab : 0,
    	items:[ZZJGXX.addPanel,ZZJGXX.modifyPanel],
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
	ZZJGXX.center = new Ext.flying.TreeLayout({
		title : '组织机构管理',
	    layout : 'border',
	    region : 'center',
	    frame : true,
	    enableDD : true,
	    treeUrl : 'common.action?command=ZZJGXX.selectAllList',
		treebar : ZZJGXX.toolbar,
	    items : [ZZJGXX.tabs],
	    treeClickFn:function(n) {
			var sn = this.selModel.selNode || {};
			if (n.id != sn.id) {
				if(n.id !=0 ){	//非单位根节点
					//激活右侧修改页面，并进行赋值
					ZZJGXX.tabs.setActiveTab(ZZJGXX.modifyPanel);
					ZZJGXX.modifyPanel.setDisabled(false);
					ZZJGXX.ZZJGDM = n.id;
					
					var data = n.attributes["data"];
					
					for(var name in data){
						if(ZZJGXX.modifyPanel.getForm().findField(name)){
							if(ZZJGXX.modifyPanel.getForm().findField(name).xtype == "departmentselection"){
								ZZJGXX.modifyPanel.getForm().findField("NAME_"+name).setValue(data[name]);
							}else{
								ZZJGXX.modifyPanel.getForm().findField(name).setValue(data[name]);
							}
						}
					}
					
					ZZJGXX.modifyPanel.getForm().findField("NAME_SJZZJGDM").setValue(data["SJZZJGDM"]);
				}
				
			}
		},
		beforemovenodeFn : function(tree,node,oldParent,newParent,i){
			var str = '';
			var mark = true;
			
			if(mark && node.attributes.data["SJZZJGDM"] == '0' ){
				str = "根节点无法移动！";
				mark = false;
			}
			
			if(mark){
				var beforeNodeId = "";
				var afterNodeId = "";
				for(var m =0;m<newParent.childNodes.length;m++){
					if(newParent.childNodes[m].attributes.data["ZZJGDM"] == node.attributes.data["ZZJGDM"]){
						continue;
					}else{
						if(m < i){
							beforeNodeId += newParent.childNodes[m].attributes.data["ZZJGDM"] + "-";
						}else{
							afterNodeId += newParent.childNodes[m].attributes.data["ZZJGDM"] + "-";
						}
					}
				}
				
				var num = node.attributes.data["PXH"];
				if(num == null){
					num = 0;
				}

				Ext.Ajax.request({
					url : "common.action?command=T_SYS_DEPARTMENT.sort",
					params : {'nodeId' : node.attributes.data["ZZJGDM"],'oldNodeId' : oldParent.attributes.data["ZZJGDM"],'newNodeId' : newParent.attributes.data["ZZJGDM"],'beforeNodeId' : beforeNodeId,'afterNodeId' : afterNodeId,'SORT_NUM' : num},
					success : function(response, opts) {	
						Ext.fm.msg("提示","恭喜，部门改变成功！");
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
				
			}else{
				Ext.Msg.show({
					title : '友好提醒',
					msg : str,
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return mark;
			}
		}
	});
	
	return ZZJGXX;
})(Ext)