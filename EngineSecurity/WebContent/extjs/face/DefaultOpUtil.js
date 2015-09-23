Ext.apply(Ext, {
	fFaceUtil : {
		kindeditorSync : function(me) {
			for ( var i = 0; i < me.columns.length; i++) {// 遍历
				if (me.columns[i]["isPk"]) {// 对主键进行处理
					continue;
				}
				
				if (me.columns[i]["isForm"] == false) {// 不做为表单项
					continue;
				}
				
				if(me.columns[i]["xtype"] == "kindeditor"){
					me.form.getForm().findField(me.columns[i]["dataIndex"]).editor.sync();
				}
			}
		},
		
		kindeditorInit : function(me){
			for ( var i = 0; i < me.columns.length; i++) {// 遍历
				if (me.columns[i]["isPk"]) {// 对主键进行处理
					continue;
				}
				
				if (me.columns[i]["isForm"] == false) {// 不做为表单项
					continue;
				}
				
				if(me.columns[i]["xtype"] == "kindeditor" && me.form.getForm().findField(me.columns[i]["dataIndex"])){
					me.form.getForm().findField(me.columns[i]["dataIndex"]).flyingInit();
				}
			}
		},
		
		flyingResizeInit : function(me){
			for ( var i = 0; i < me.columns.length; i++) {// 遍历
				if (me.columns[i]["isPk"]) {// 对主键进行处理
					continue;
				}
				
				if (me.columns[i]["isForm"] == false) {// 不做为表单项
					continue;
				}
				
				if(me.columns[i]["xtype"] != "kindeditor" && me.form.getForm().findField(me.columns[i]["dataIndex"]) && me.form.getForm().findField(me.columns[i]["dataIndex"])["flyingResize"] != null){
					me.form.getForm().findField(me.columns[i]["dataIndex"])["flyingResize"]();
				}
			}
		},
		
		imgInit : function(me){
			for(var i=0; i < me.columns.length;i++){
				if(me.columns[i]["xtype"] == "img"){
					var width = 300;
					var height = 200;
					if(me.columns[i]["width"]!=undefined){
						width = me.columns[i]["width"];
					}
					if(me.columns[i]["height"]!=undefined){
						height = me.columns[i]["height"];
					}
					var imgpro = Ext.getCmp('image_'+me.columns[i]["dataIndex"]);
					if(imgpro!=undefined){
						Ext.getCmp('image_'+me.columns[i]["dataIndex"]).body.update('<div align="center"><span ><img style="width:'+width+'px;height:'+height+'px" src="attached/default/nopic.gif" ></span></div>');
					}
				}
			}
		},
		
		clickModifyOrShow : function(me){			
			if(me.grid.getSelectionModel().hasSelection()){
				var rows = me.grid.getSelectionModel().getSelections();
				if(rows.length == 1){
					if(me.opType == "modify"){
						if (me.beforeModifyShow() == false){
							return false;
						}
					}else if(me.opType == "show"){
						if (me.beforeDetailsShow() == false){
							return false;
						}
					}

					if(me.formInit){//表单类初始化
						me.formInit();
					}
					
					var row = rows[0];
				
					me.params[me.pk] = row.data[me.pk];//获取主键值

					Ext.fFaceUtil.assignForm(me,row);
					
					return true;
				}else{
					Ext.Msg.show({
						title : '友情提示',
						msg : '您选择了多条记录，请只选择一条记录进行修改操作！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
					return false;
				}
			}else{
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录进行修改操作！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return false;
			}
		},
		
		clickDelete : function(me){		
			if (me.beforeDeleteSave() == false){//删除保存前操作
				return;
			}

			if(me.grid.getSelectionModel().hasSelection()){
				var rows = me.grid.getSelectionModel().getSelections();
				var pkValues = "";
				
				for(var i=0;i<rows.length;i++){
					pkValues += rows[i].data[me.pk] + ",";
				}
				
				pkValues =  pkValues.substr(0,pkValues.length -1);
				
				Ext.Msg.confirm('删除', '确定删除吗?', function(btn) {
					if (btn == 'yes') {
						Ext.Ajax.request({
							url : me.batchDeleteUrl,
							params : {"PKVALUES" : pkValues},
							success : function(response, opts) {	
								
								Ext.fm.msg(me.cn,"恭喜，删除成功！");
								
								me.grid.getStore().reload();
								
								me.afterDeleteSave();//删除保存后操作
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
				});
			}else{
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
			}
		},
		
		clickDownload : function(me){
			var params = "&FILE_DOWNLOAD_NAME="+me.cn;
			if(me.ds.sortInfo){
				params += "&dir="+me.ds.sortInfo.direction+"&sort="+me.ds.sortInfo.field;
			}
//			if(me.ds.lastOptions && me.ds.lastOptions.params && me.ds.lastOptions.params.searchField ){
//				params += "&searchField="+me.ds.lastOptions.params.searchField+"&searchValue="+me.ds.lastOptions.params.searchValue;
//			}
			
			if(me.ds.lastOptions && me.ds.lastOptions.params){
				for( var name in me.ds.lastOptions.params){
					params += "&" + name + "=" + me.ds.lastOptions.params[name];
				}
			}
				
			var exportForm = new Ext.FormPanel();
			
	    	exportForm.applyToMarkup(Ext.DomHelper.append(Ext.getBody(), {
				tag : "div"
			}, true));
	    	
	    	var cmStr = encodeURIComponent(Ext.util.JSON.encode(me.gridObj.cmArray));  	
	    	Ext.DomHelper.append(exportForm.getForm().getEl(),"<input type=\"hidden\" name=\"FILE_DOWNLOAD_PROPERTY\" value=\""+cmStr+"\"/>");
	    	
	    	exportForm.getForm().getEl().dom.method = "post"; 
	    	exportForm.getForm().getEl().dom.action = me.gridObj.tableAction+params;  
	    	exportForm.getForm().getEl().dom.submit();
		},
		
		clickSave : function(me){			
			var url = "";
			
			if(me.opType == 'add'){//如果是添加模式，请求地址
				if (me.beforeAddSave() == false){
					return;
				}
				
				if(me.opSqlid == null || me.opSqlid == ''){//处理添加请求
					url = "common.action?command="+me.en + ".insert";
				}else{
					url = "common.action?command="+me.opSqlid;
				}
				
			}else if(me.opType == 'modify'){//如果是修改模式，请求地址
				if (me.beforeModifySave() == false){
					return;
				}
				
				if(me.opSqlid == null || me.opSqlid == ''){//处理添加请求
					url = "common.action?command="+me.en + ".update";
				}else{
					url = "common.action?command="+me.opSqlid;
				}
				
				var row = me.grid.getSelectionModel().getSelected();
				if(me.form.getForm().findField(me.pk) != undefined && me.form.getForm().findField(me.pk).getValue() != row.data[me.pk]){
					me.params["MANUAL_CHANGE_PK"] = me.pk;
					me.params["OLD_" + me.pk] =  row.data[me.pk];
					delete me.params[me.pk];
				}
			}else {
				if(me.opSqlid == ''){//处理其他请求
					Ext.Msg.show({
						title : '提示',
						msg : '保存按钮没有配置执行的opSqlid',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
					return false;
				}else{
					url = "common.action?command="+me.opSqlid;
				}
			}
			
			Ext.fFaceUtil.kindeditorSync(me);//对含有kindeditor控件进行处理
			
			if (me.form.getForm().isValid()) {
				me.form.getForm().submit({
					url : url,
					params : me.params,
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
						}
						if (me.opType == 'add') {
		
							Ext.fm.msg(me.cn,"恭喜，添加成功！");							
							
							if(me.ds){
								me.ds.reload();//刷新列表
							}
							
							if(me["reset"] != null){
								me.reset();
							}
							
							if(me.parentWin){
								me.parentWin.close();
							}
							
							me.afterAddSave();//在添加保存之后处理
						}else if(me.opType == 'modify'){
							Ext.fm.msg(me.cn,"恭喜，修改成功！");
							
							if(me.ds){
								me.ds.reload();//刷新列表
							}
							
							if(me.form.getForm().findField(me.pk) != undefined){
								delete me.params["MANUAL_CHANGE_PK"];
								delete me.params["OLD_" + me.pk];
							}
							
							if(me["reset"] != null){
								me.reset();
							}
							
							if(me.parentWin){
								me.parentWin.close();
							}
							
							me.afterModifySave();//在修改保存之后处理
						}else {
							if(me.parentWin){
								me.parentWin.close();
							}
							
							Ext.fm.msg(me.cn,"恭喜，操作成功！");
						}
					},
					failure : function(form, action) {
						Ext.Msg.show({
							title : '错误提示',
							msg : action.result.msg,
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
					}
				});
			}
		},
		toggleForm : function(me,bool){//修改表单状态
			//屏蔽表单项
			/**
			 * 表单项不可编辑
			 * 
			 for(var i =0;i<me.columns.length;i++){//遍历表单赋值
				if (me.columns[i]["isPk"]) {// 对主键进行处理
					continue;
				}
				
				if(me.columns[i]["isForm"] != null && me.columns[i]["isForm"] == false){
					continue;
				}

				var name = me.columns[i].dataIndex;

				if(me.columns[i].xtype == "departmentselection" && me.form.getForm().findField("NAME_"+name) != undefined){
					if(bool){
						me.form.getForm().findField("NAME_"+name).enable();
					}else{
						me.form.getForm().findField("NAME_"+name).disable();
					}
				}else if(me.form.getForm().findField(name) != undefined){
					if(bool){
						me.form.getForm().findField(name).enable();
					}else{
						me.form.getForm().findField(name).disable();
					}
				}
			}
			*/
			//屏蔽按钮		
			if(me.form.buttons[0] != null){
				if(bool){
					me.form.buttons[0].setVisible(true);
				}else{
					me.form.buttons[0].setVisible(false);
				}
			}
		},
		assignForm : function(me,row){
			for(var i =0;i<me.columns.length;i++){//遍历表单赋值
				if (me.columns[i]["isPk"]) {// 对主键进行处理
					if(me.columns[i]["manual"] == null || me.columns[i]["manual"] == false){
						continue;
					}
				}
				
				var name = me.columns[i].dataIndex;
				if(name == undefined){
					continue;
				}else if(me.columns[i].xtype == "departmentselection" && me.form.getForm().findField("NAME_"+name) != undefined){
					me.form.getForm().findField("NAME_"+name).setValue(row.data[name]);
				}else if(me.columns[i].xtype == "combo" && me.form.getForm().findField(name) != undefined && me.form.getForm().findField(name).mode == "remote"){
					var st = me.form.getForm().findField(name).getStore();
					if(me.form.getForm().findField(name)["searchTrigger"] != null && me.form.getForm().findField(name)["searchTrigger"] == true){//初始化模糊匹配，模糊查询不触发
						me.form.getForm().findField(name)["searchTrigger"] = false; 
						
						st.baseParams["searchField"] = "";
						st.baseParams["searchValue"] = "";
					}
					
					var comboValueField = me.columns[i].valueField;
					
					var mark = true;
					st.each(function(record){

						if(record.data[comboValueField] == row.data[name]){
							mark = false;
						}
					});
				
					if(mark){
						var comboValue = me.columns[i]["dataIndex"];
						var comboName = comboValue;
					
						if(comboValue.length > 2 && comboValue.substring(comboValue.length-2,comboValue.length) == "ID"){
							comboName = comboValue.substring(0,comboValue.length-2) + "NAME";
							if(row.data[comboName] == null){
								comboName = me.columns[i]["displayField"];
							}
							
							comboName = comboValue.substring(0,comboValue.length-2) + "MC";
							if(row.data[comboName] == null){
								comboName = me.columns[i]["displayField"];
							}
						}else{
							comboName = comboValue + "MC";
							if(row.data[comboName] == null){
								comboName = me.columns[i]["displayField"];
							}
						}
					
					
						var newRecord = new Ext.data.Record();
						newRecord.data[me.columns[i]["displayField"]] = row.data[comboName];
						newRecord.data[me.columns[i]["valueField"]] = row.data[comboValue];
					
						st.insert(0,newRecord);
					}
				
					me.form.getForm().findField(name).setValue(row.data[name]);
				}else if(me.columns[i].xtype == "img"){
					/**
					 * 当属性xtype为image的时候，进行处理的动作
					 */				
					var width = 300;
					var height = 200;
					if(!(me.columns[i].width==""||me.columns[i].width==undefined)){
						width = me.columns[i].width;
					}
					if(!(me.columns[i].height==""||me.columns[i].height==undefined)){
						height = me.columns[i].height;
					}
					if(!(row.data[me.columns[i].dataIndex] == ""||row.data[me.columns[i].dataIndex] == undefined)){
						Ext.getCmp('image_'+me.columns[i].dataIndex).body.update('<div align="center"><span ><img style="width:'+width+'px;height:'+height+'px" src="attached/'+row.data[me.columns[i].dataIndex]+'" onerror=(this.src=this.src.substr(0,this.src.indexOf("attached"))+"attached/default/nopic.gif");></span></div>');
					}else{
						Ext.getCmp('image_'+me.columns[i].dataIndex).body.update('<div align="center"><span ><img style="width:'+width+'px;height:'+height+'px" src="attached/default/nopic.gif" ></span></div>');
					}
				}else if(me.form.getForm().findField(name) != undefined){
					me.form.getForm().findField(name).setValue(row.data[name]);
				}
			
			}
		},
		afterFormShow : function(me){
			Ext.fFaceUtil.kindeditorInit(me);
			Ext.fFaceUtil.flyingResizeInit(me);
			Ext.fFaceUtil.imgInit(me);
		},
		downfile : function(DATABM){
			var html = "<table border='1' style='text-align:center;border-collapse:collapse;border-spacing:0;'>";
			html = html+"<tr height='25'><td width='40'>序号</td><td width='200'>文件</td><td width='80'>上传时间</td><td width='100'>文件大小</td></tr>";
			Ext.Ajax.request({                           
    			url : 'common.action?command=CHYQ.selectWJByBM',
				params : {DATABM:DATABM},
				async: false,
    	        method:'POST',
    	        success:function(response, opts){	        	
    	        	var responseArray = Ext.util.JSON.decode(response.responseText); 
    	        	for(var i=0;i<responseArray.data.length;i++){
    	        		var str1 = "<a href='"+responseArray.data[i]["PATH"]+"' target='_blank'>"+responseArray.data[i]["NAME"]+"</a>";
    	        		var size = (responseArray.data[i]["WJSIZE"])/1024;
    	        		size = size.toFixed(2);
    	        		var str =  "<tr height='25'><td width='40'>"+i+"</td><td width='200'>"+str1+"</td><td width='80'>"+responseArray.data[i]["COMMITEDATE"]+"</td><td width='100'>"+size+"KB</td></tr>";
    	        		html = html+str;
    	        	}    	        	
    	        }
    	    });
			html = html+"</table>";
			var win = new Ext.Window({
				title : "文件下载列表",
				layout : 'fit',
				autoScroll  : true,
				height : 240,
				width : 420,
				closable : true,
				plain : true,
		        maximizable: true,
		        html : html
		    });
			win.show();
		}
	}	
})