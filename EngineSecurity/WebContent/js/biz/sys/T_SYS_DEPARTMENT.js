(function(){
	var T_SYS_DEPARTMENT = {
		author:'zdf',
		DEPARTMENT_ID:null	//选中树节点Id
	};
	//树上工具栏
	T_SYS_DEPARTMENT.toolbar = new Ext.Toolbar({// 操作工具栏
		height:25,
        items : [{
					xtype:'button',
					iconCls : 'refresh',
					text : '刷新',
		            handler : function(t,checked){
		            	T_SYS_DEPARTMENT.center.tree.root.reload();
		            }
				},'-',{
        			xtype:'button',
        			iconCls : 'user-delete',
        			text : '删除',
	                handler : function(t,checked){
			            	Ext.Msg.confirm('部门删除', '你确定删除吗?', function(btn) {
								if (btn == 'yes') {
				                	Ext.Ajax.request({
				                        url : 'common.action?command=T_SYS_DEPARTMENT.delete',
				                        method : 'POST',
				                        params : {DEPARTMENT_ID:T_SYS_DEPARTMENT.DEPARTMENT_ID},
				                        async : false,
				                        success: function(response, opts){
				                                var responseJson = Ext.util.JSON.decode(response.responseText);
				                                        if(responseJson.success){
				                                                //树数据刷新
				                                        		T_SYS_DEPARTMENT.center.tree.root.reload();
				                                        		//跳到addPanel页面,将modifyPanel设为不可用
				                                        		T_SYS_DEPARTMENT.tabs.setActiveTab(T_SYS_DEPARTMENT.addPanel);
				                                        		T_SYS_DEPARTMENT.modifyPanel.setDisabled(true);
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
	T_SYS_DEPARTMENT.addPanel = new Ext.FormPanel({
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
                if (T_SYS_DEPARTMENT.addPanel.getForm().isValid()) {
                	T_SYS_DEPARTMENT.addPanel.getForm().submit({
                            url:'common.action?command=T_SYS_DEPARTMENT.insert',
                            waitTitle : '请稍候',
                            waitMsg : '正在提交表单数据,请稍候...',
                            params : {},    //参数
                            success : function(form, action) {
                                    //clear data
                            		T_SYS_DEPARTMENT.addPanel.getForm().reset();
                            		//刷新树数据
                            		T_SYS_DEPARTMENT.center.tree.root.reload();
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
        		//T_SYS_DEPARTMENT.modifyPanel.setDisabled(true);
        	}
        }
    });
	//主显示区修改表单
	T_SYS_DEPARTMENT.modifyPanel = new Ext.FormPanel({
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
                name: 'PID'
            },{
            	xtype:'numberfield',
                fieldLabel: '排序号',
                name: 'ORDER_ID',
                allowBlank:false
            }],
        buttons: [{
            text: '保存',
            handler:function(){
                if (T_SYS_DEPARTMENT.modifyPanel.getForm().isValid()) {
                	T_SYS_DEPARTMENT.modifyPanel.getForm().submit({
                            url:'common.action?command=T_SYS_DEPARTMENT.update',
                            waitTitle : '请稍候',
                            waitMsg : '正在提交表单数据,请稍候...',
                            params : {DEPARTMENT_ID:T_SYS_DEPARTMENT.DEPARTMENT_ID},    //参数
                            success : function(form, action) {
                            		//刷新树数据
                            		T_SYS_DEPARTMENT.center.tree.root.reload();
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
	                        url : 'common.action?command=T_SYS_DEPARTMENT.delete',
	                        method : 'POST',
	                        params : {DEPARTMENT_ID:T_SYS_DEPARTMENT.DEPARTMENT_ID},
	                        async : false,
	                        success: function(response, opts){
	                                var responseJson = Ext.util.JSON.decode(response.responseText);
	                                        if(responseJson.success){
	                                                //树数据刷新
	                                        		T_SYS_DEPARTMENT.center.tree.root.reload();
	                                        		//跳到addPanel页面,将modifyPanel设为不可用
	                                        		T_SYS_DEPARTMENT.tabs.setActiveTab(T_SYS_DEPARTMENT.addPanel);
	                                        		T_SYS_DEPARTMENT.modifyPanel.setDisabled(true);
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
	T_SYS_DEPARTMENT.tabs = new Ext.TabPanel({//tabs
		region:'center',
    	resizeTabs : true,
    	autoDestroy : false,//关闭panel时，不销毁panel
    	activeTab : 0,
    	items:[T_SYS_DEPARTMENT.addPanel,T_SYS_DEPARTMENT.modifyPanel],
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
	T_SYS_DEPARTMENT.center = new Ext.flying.TreeLayout({
		title : '组织机构管理',
	    layout : 'border',
	    region : 'center',
	    frame : true,
	    enableDD : true,
	    treeUrl : 'common.action?command=T_SYS_DEPARTMENT.selectAllList',
		treebar : T_SYS_DEPARTMENT.toolbar,
	    items : [T_SYS_DEPARTMENT.tabs],
	    treeClickFn:function(n) {
			var sn = this.selModel.selNode || {};
			if (n.id != sn.id) {
				if(n.id !=0 ){	//非单位根节点
					//激活右侧修改页面，并进行赋值
					T_SYS_DEPARTMENT.tabs.setActiveTab(T_SYS_DEPARTMENT.modifyPanel);
					T_SYS_DEPARTMENT.modifyPanel.setDisabled(false);
					T_SYS_DEPARTMENT.DEPARTMENT_ID = n.id;
					
					var data = n.attributes["data"];
					
					for(var name in data){
						if(T_SYS_DEPARTMENT.modifyPanel.getForm().findField(name)){
							if(T_SYS_DEPARTMENT.modifyPanel.getForm().findField(name).xtype == "departmentselection"){
								T_SYS_DEPARTMENT.modifyPanel.getForm().findField("NAME_"+name).setValue(data[name]);
							}else{
								T_SYS_DEPARTMENT.modifyPanel.getForm().findField(name).setValue(data[name]);
							}
						}
					}
					
					T_SYS_DEPARTMENT.modifyPanel.getForm().findField("NAME_PID").setValue(data["PID"]);
				
				}
				
			}
		},
		beforemovenodeFn : function(tree,node,oldParent,newParent,i){
			var str = '';
			var mark = true;
			
			if(mark && node.attributes.data["PID"] == '0' ){
				str = "根节点无法移动！";
				mark = false;
			}
			
			if(mark){
				var beforeNodeId = "";
				var afterNodeId = "";
				for(var m =0;m<newParent.childNodes.length;m++){
					if(newParent.childNodes[m].attributes.data["DEPARTMENT_ID"] == node.attributes.data["DEPARTMENT_ID"]){
						continue;
					}else{
						if(m < i){
							beforeNodeId += newParent.childNodes[m].attributes.data["DEPARTMENT_ID"] + "-";
						}else{
							afterNodeId += newParent.childNodes[m].attributes.data["DEPARTMENT_ID"] + "-";
						}
					}
				}
				
				var num = node.attributes.data["ORDER_ID"];
				if(num == null){
					num = 0;
				}

				Ext.Ajax.request({
					url : "common.action?command=T_SYS_DEPARTMENT.sort",
					params : {'nodeId' : node.attributes.data["DEPARTMENT_ID"],'oldNodeId' : oldParent.attributes.data["DEPARTMENT_ID"],'newNodeId' : newParent.attributes.data["DEPARTMENT_ID"],'beforeNodeId' : beforeNodeId,'afterNodeId' : afterNodeId,'SORT_NUM' : num},
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
	
	return T_SYS_DEPARTMENT;
})(Ext)