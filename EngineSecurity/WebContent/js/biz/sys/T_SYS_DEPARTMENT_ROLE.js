(function(){
	var T_SYS_DEPARTMENT_ROLE = {
		author:'zdf',
		DEPARTMENT_ID:null	//选中树节点Id
	};
	
	//主显示区修改表单
	T_SYS_DEPARTMENT_ROLE.rolePanel = Ext.fcache.get("biz/sys/T_SYS_ROLE.js","email",null,true);
	
	T_SYS_DEPARTMENT_ROLE.tab = new Ext.Panel({
		layout : 'fit',
		region : 'center',
		border : false,
		items : T_SYS_DEPARTMENT_ROLE.rolePanel.center
	});
	
	//布局Panel
	T_SYS_DEPARTMENT_ROLE.center = new Ext.flying.TreeLayout({
		title : '组织机构管理',
	    layout : 'border',
	    region : 'center',
	    frame : true,
	    treeUrl : 'common.action?command=T_SYS_DEPARTMENT.selectAllListForRole',
	    items : [T_SYS_DEPARTMENT_ROLE.tab],
	    treeConfig : {
			ddGroup : 'gridDDGroup',
			enableDrop : true,
			listeners : {
				'click' : function(n){
					var sn = this.selModel.selNode || {};
					if (n.id != sn.id) {
						if(n.id !=0 ){	//非单位根节点
							T_SYS_DEPARTMENT_ROLE.rolePanel.reset();
							T_SYS_DEPARTMENT_ROLE.rolePanel["DEPARTMENT_ID"] = n.id;
							//激活右侧修改页面，并进行赋值	
							if( n.id != '39A03AE81AED4CE08D7E4F9F52BF7BF1'){
								T_SYS_DEPARTMENT_ROLE.rolePanel.ds.reload({params:{"filter":"DEPARTMENT_ID='"+n.id+"'"}});
							}else{
								T_SYS_DEPARTMENT_ROLE.rolePanel.ds.reload({params:{"filter":"DEPARTMENT_ID is null"}});
							}
						}
					}
				},
				'beforenodedrop' : function(e){
					 var node = e.target;    // 目标结点  
					 var grid = e.source.grid;      // 拖拽的数据 
					 var row = grid.getSelectionModel().getSelected();
					//获取选中组内的人员
	        	    Ext.Ajax.request({
	        	        url : 'common.action?command=T_SYS_ROLE.update',
	        	        method : 'POST',
	        	        params : {"ROLE_ID":row.data["ROLE_ID"],"DEPARTMENT_ID" : node.id},
	        	        async : false,
	        	        success: function(response, opts){
	        	                var responseJson = Ext.util.JSON.decode(response.responseText);
	        	                if(responseJson.success){
	        	                	Ext.fm.msg("提示","移动成功！");
	        	                	grid.getStore().reload();
	        	                }else{
	        	                    Ext.Msg.show({
	        	                            title : '异常提示',
	        	                            msg : '获取数据出错',
	        	                            buttons : Ext.Msg.OK,
	        	                            icon : Ext.Msg.ERROR
	        	                    });
	        	                }
	        	        },
	        	        fail : function(response, options) {
	        				var obj = Ext.util.JSON.decode(response.responseText);
	        				Ext.Msg.show({
	        					title : '错误提示',
	        					msg : obj.msg,
	        					buttons : Ext.Msg.OK,
	        					icon : Ext.Msg.ERROR
	        				});
	        			}
	        	        
	        	    });
				}
			}
	    }
	});
	
	return T_SYS_DEPARTMENT_ROLE;
})(Ext)