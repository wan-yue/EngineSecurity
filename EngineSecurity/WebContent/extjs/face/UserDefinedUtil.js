Ext.apply(Ext, {
	userDefinedUtil : {
		"hbbase" : function(T_BEACON_INFO){
			var rankCondition = T_BEACON_INFO.table.findById('rankCondition').getValue();
			var rankType = T_BEACON_INFO.table.findById('rankType').getValue();
			var CODADN = T_BEACON_INFO.table.findById('CODADN').getValue();
			var NOBJNM = T_BEACON_INFO.table.findById('NOBJNM').getValue();
			var CHU = T_BEACON_INFO.table.findById('CHU').values;
			var SSSD = T_BEACON_INFO.table.findById('SSSD').getValue();
			var ANBIE = T_BEACON_INFO.table.findById('ANBIE').getValue();
			var SSLY = T_BEACON_INFO.table.findById('SSLY').getValue();
			var SZWZ = T_BEACON_INFO.table.findById('SZWZ').getValue();
			var HBZ = T_BEACON_INFO.table.findById('HBZ').getValue();
			var HBL = T_BEACON_INFO.table.findById('HBL').getValue();
			var useStatus = T_BEACON_INFO.table.findById('useStatus').getValue();//使用状态通过发起流程来记录
			if(rankCondition==0){
				rankCondition = 'CODADN';
			}
			if(rankType==0){
				rankType = "ASC";
			}else{
				rankType = "DESC";
			}
			T_BEACON_INFO.gridCenter.grid.getStore().proxy.conn.url = "common.action?command=T_BASE_INFO.selectAll";
			T_BEACON_INFO.gridCenter.grid.getStore().baseParams = {"SSSD":SSSD,"ANBIE":ANBIE,"SSLY":SSLY,"SZWZ":SZWZ,"HBZ":HBZ,"HBL":HBL,"useStatus":useStatus,"CODADN":CODADN,"NOBJNM":NOBJNM,"rankCondition":rankCondition,"rankType":rankType,"CHU":CHU};
			T_BEACON_INFO.gridCenter.grid.getStore().reload();	
		},
		"hbtb" : function(T_BEACON_INFO){
			var rankCondition = T_BEACON_INFO.table.findById('rankCondition4').getValue();
			var rankType = T_BEACON_INFO.table.findById('rankType4').getValue();
			var CODADN = T_BEACON_INFO.table.findById('CODADN4').getValue();
			var NOBJNM = T_BEACON_INFO.table.findById('NOBJNM4').getValue();
			var CHU = T_BEACON_INFO.table.findById('CHU4').values;
			var SSSD = T_BEACON_INFO.table.findById('SSSD4').getValue();
			var ANBIE = T_BEACON_INFO.table.findById('ANBIE4').getValue();
			var SSLY = T_BEACON_INFO.table.findById('SSLY4').getValue();
			var SZWZ = T_BEACON_INFO.table.findById('SZWZ4').getValue();
			var HBZ = T_BEACON_INFO.table.findById('HBZ4').getValue();
			var HBL = T_BEACON_INFO.table.findById('HBL4').getValue();
			if(rankCondition==0){
				rankCondition = 'CODADN';
			}
			if(rankType==0){
				rankType = "ASC";
			}else{
				rankType = "DESC";
			}
			T_BEACON_INFO.gridCenter.grid.getStore().proxy.conn.url = "common.action?command=HBTBJL.selectAll";
			T_BEACON_INFO.gridCenter.grid.getStore().baseParams = {"SSSD":SSSD,"ANBIE":ANBIE,"SSLY":SSLY,"SZWZ":SZWZ,"HBZ":HBZ,"HBL":HBL,"CODADN":CODADN,"NOBJNM":NOBJNM,"rankCondition":rankCondition,"rankType":rankType,"CHU":CHU};
			T_BEACON_INFO.gridCenter.grid.getStore().reload();	
		},
		"tbtz" : function(T_BEACON_INFO){
			var STIME = T_BEACON_INFO.table.findById('STIME').getValue();
			var ETIME = T_BEACON_INFO.table.findById('ETIME').getValue();
			if(STIME!=""){STIME = STIME.format('y-m-d');}
			if(ETIME!=""){ETIME = ETIME.format('y-m-d');}
			var CHU = T_BEACON_INFO.table.findById('TBDW').values;
			T_BEACON_INFO.gridCenter.grid.getStore().proxy.conn.url = "common.action?command=HBTBJL.selectAll";
			T_BEACON_INFO.gridCenter.grid.getStore().baseParams = {"STIME":STIME,"ETIME":ETIME,"CHU":CHU};
			T_BEACON_INFO.gridCenter.grid.getStore().reload();	
		},
		"hbyczd" : function(T_BEACON_INFO){
			var rankCondition = T_BEACON_INFO.table.findById('rankCondition2').getValue();
			var rankType = T_BEACON_INFO.table.findById('rankType2').getValue();
			var CODADN = T_BEACON_INFO.table.findById('CODADN2').getValue();
			var NOBJNM = T_BEACON_INFO.table.findById('NOBJNM2').getValue();
			var ZDGJH = T_BEACON_INFO.table.findById('ZDGJH2').getValue();
			var SIM = T_BEACON_INFO.table.findById('SIM2').getValue();
			var CHU = T_BEACON_INFO.table.findById('CHU2').values;
			var SSSD = T_BEACON_INFO.table.findById('SSSD2').getValue();
			var ANBIE = T_BEACON_INFO.table.findById('ANBIE2').getValue();
			var SSLY = T_BEACON_INFO.table.findById('SSLY2').getValue();
			var SZWZ = T_BEACON_INFO.table.findById('SZWZ2').getValue();
			var HBZ = T_BEACON_INFO.table.findById('HBZ2').getValue();
			var HBL = T_BEACON_INFO.table.findById('HBL2').getValue();
			if(rankCondition==0){
				rankCondition = 'CODADN';
			}
			if(rankType==0){
				rankType = "ASC";
			}else{
				rankType = "DESC";
			}
			T_BEACON_INFO.gridCenter.grid.getStore().proxy.conn.url = "common.action?command=HBJTXX.selectAll";
			T_BEACON_INFO.gridCenter.grid.getStore().baseParams = {"ZDGJH":ZDGJH,"SIM":SIM,"SSSD":SSSD,"ANBIE":ANBIE,"SSLY":SSLY,"SZWZ":SZWZ,"HBZ":HBZ,"HBL":HBL,"CODADN":CODADN,"NOBJNM":NOBJNM,"rankCondition":rankCondition,"rankType":rankType,"CHU":CHU};
			T_BEACON_INFO.gridCenter.grid.getStore().reload();	
		},
		"hbzdkz" : function(T_BEACON_INFO){
			var CODADN = T_BEACON_INFO.table.findById('CODADN3').getValue();
			var NOBJNM = T_BEACON_INFO.table.findById('NOBJNM3').getValue();
			var ZDGJH = T_BEACON_INFO.table.findById('ZDGJH3').getValue();
			var CHU = T_BEACON_INFO.table.findById('CHU3').values;
			T_BEACON_INFO.gridCenter.grid.getStore().proxy.conn.url = "common.action?command=HBDTXX.selectAll";
			T_BEACON_INFO.gridCenter.grid.getStore().baseParams = {"ZDGJH":ZDGJH,"CODADN":CODADN,"NOBJNM":NOBJNM,"CHU":CHU};
			T_BEACON_INFO.gridCenter.grid.getStore().reload();	
		},
		"hbdt" : function(T_BEACON_INFO){
			var rankCondition = T_BEACON_INFO.table.findById('rankCondition1').getValue();
			var rankType = T_BEACON_INFO.table.findById('rankType1').getValue();
			var CODADN = T_BEACON_INFO.table.findById('CODADN1').getValue();
			var NOBJNM = T_BEACON_INFO.table.findById('NOBJNM1').getValue();
			var ZDGJH = T_BEACON_INFO.table.findById('ZDGJH1').getValue();
			var SIM = T_BEACON_INFO.table.findById('SIM').getValue();
			var CHU = T_BEACON_INFO.table.findById('CHU1').values;
			var SSSD = T_BEACON_INFO.table.findById('SSSD1').getValue();
			var ANBIE = T_BEACON_INFO.table.findById('ANBIE1').getValue();
			var SSLY = T_BEACON_INFO.table.findById('SSLY1').getValue();
			var SZWZ = T_BEACON_INFO.table.findById('SZWZ1').getValue();
			var HBZ = T_BEACON_INFO.table.findById('HBZ1').getValue();
			var HBL = T_BEACON_INFO.table.findById('HBL1').getValue();
//			var useStatus = T_BEACON_INFO.table.findById('useStatus1').getValue();//使用状态通过发起流程来记录
			if(rankCondition==0){
				rankCondition = 'CODADN';
			}
			if(rankType==0){
				rankType = "ASC";
			}else{
				rankType = "DESC";
			}
			T_BEACON_INFO.gridCenter.grid.getStore().proxy.conn.url = "common.action?command=HBDTXX.selectAll";
			T_BEACON_INFO.gridCenter.grid.getStore().baseParams = {"ZDGJH":ZDGJH,"SIM":SIM,"SSSD":SSSD,"ANBIE":ANBIE,"SSLY":SSLY,"SZWZ":SZWZ,"HBZ":HBZ,"HBL":HBL,"CODADN":CODADN,"NOBJNM":NOBJNM,"rankCondition":rankCondition,"rankType":rankType,"CHU":CHU};
			T_BEACON_INFO.gridCenter.grid.getStore().reload();	
		},
		"hbyccx" : function(T_BEACON_INFO){
			var rankCondition = T_BEACON_INFO.table.findById('rankCondition5').getValue();
			var rankType = T_BEACON_INFO.table.findById('rankType5').getValue();
			var CODADN = T_BEACON_INFO.table.findById('CODADN5').getValue();
			var NOBJNM = T_BEACON_INFO.table.findById('NOBJNM5').getValue();
			var ZDGJH = T_BEACON_INFO.table.findById('ZDGJH5').getValue();
			var SIM = T_BEACON_INFO.table.findById('SIM5').getValue();
			var CHU = T_BEACON_INFO.table.findById('CHU5').values;
			var SSSD = T_BEACON_INFO.table.findById('SSSD5').getValue();
			var ANBIE = T_BEACON_INFO.table.findById('ANBIE5').getValue();
			var SSLY = T_BEACON_INFO.table.findById('SSLY5').getValue();
			var SZWZ = T_BEACON_INFO.table.findById('SZWZ5').getValue();
			var HBZ = T_BEACON_INFO.table.findById('HBZ5').getValue();
			var HBL = T_BEACON_INFO.table.findById('HBL5').getValue();
//			var useStatus = T_BEACON_INFO.table.findById('useStatus1').getValue();//使用状态通过发起流程来记录
			if(rankCondition==0){
				rankCondition = 'CODADN';
			}
			if(rankType==0){
				rankType = "ASC";
			}else{
				rankType = "DESC";
			}
			T_BEACON_INFO.gridCenter.grid.getStore().proxy.conn.url = "common.action?command=HBDTXX.selectAll";
			T_BEACON_INFO.gridCenter.grid.getStore().baseParams = {"ZDGJH":ZDGJH,"SIM":SIM,"SSSD":SSSD,"ANBIE":ANBIE,"SSLY":SSLY,"SZWZ":SZWZ,"HBZ":HBZ,"HBL":HBL,"CODADN":CODADN,"NOBJNM":NOBJNM,"rankCondition":rankCondition,"rankType":rankType,"CHU":CHU};
			T_BEACON_INFO.gridCenter.grid.getStore().reload();	
		},
		"hdPlanBuler" : function(me){
			if(jdz=me.form.getForm().findField("NYJDLBB_ID").getValue()=="季度"){
			  var lbz=me.form.getForm().findField("LBZ").getValue();
			  var hdmc=me.form.getForm().findField("HD_ID").getValue();
			  var jdz=me.form.getForm().findField("JDZ").getValue();
			  if(lbz==""||hdmc==""){
				  Ext.Msg.show({
			          title : '异常提示',
			          msg : '河段和类别都不可为空！',
			          buttons : Ext.Msg.OK,
			          icon : Ext.Msg.ERROR
		         });	
			  }
			  else{
				  Ext.Ajax.request({
				          url : 'common.action?command=HDYHFYSSJH.selectAllYear',
				          method:'post',
			          params:{"LBZ":lbz,"HD_ID":hdmc},
				          async : false,              
				          success : function(response, opts) {	
				            var resultObj = Ext.util.JSON.decode(response.responseText);
				            var size = resultObj.data.length; 
				            if(size>1||size==0){	
				            	 Ext.Msg.show({
						          title : '异常提示',
						          msg : '有多个相同的年度计划，或者该年度计划不存在！',
						          buttons : Ext.Msg.OK,
						          icon : Ext.Msg.ERROR
					          });
				            }else{
				            	if(jdz=="第一季度"){
				            		me.form.getForm().findField('YYWH').setValue(resultObj.data[0]['YYWH']);
				            		me.form.getForm().findField('EYWH').setValue(resultObj.data[0]['EYWH']);
				            		me.form.getForm().findField('SYWH').setValue(resultObj.data[0]['SYWH']);
				            		me.form.getForm().findField('SYUWH').setValue("");
				            		me.form.getForm().findField('WYWH').setValue("");
				            		me.form.getForm().findField('LYWH').setValue("");
				            		me.form.getForm().findField('QYWH').setValue("");
				            		me.form.getForm().findField('BYWH').setValue("");
				            		me.form.getForm().findField('JYWH').setValue("");
				            		me.form.getForm().findField('SHIYWH').setValue("");
				            		me.form.getForm().findField('SYYWH').setValue("");
				            		me.form.getForm().findField('SEYWH').setValue("");
				            	}else if(jdz=="第二季度"){
				            		me.form.getForm().findField('SYUWH').setValue(resultObj.data[0]['SYUWH']);
				            		me.form.getForm().findField('WYWH').setValue(resultObj.data[0]['WYWH']);
				            		me.form.getForm().findField('LYWH').setValue(resultObj.data[0]['LYWH']);
				            		me.form.getForm().findField('YYWH').setValue("");
				            		me.form.getForm().findField('EYWH').setValue("");
				            		me.form.getForm().findField('SYWH').setValue("");
				            		me.form.getForm().findField('QYWH').setValue("");
				            		me.form.getForm().findField('BYWH').setValue("");
				            		me.form.getForm().findField('JYWH').setValue("");
				            		me.form.getForm().findField('SHIYWH').setValue("");
				            		me.form.getForm().findField('SYYWH').setValue("");
				            		me.form.getForm().findField('SEYWH').setValue("");
				            	}else if(jdz=="第三季度"){
				            		me.form.getForm().findField('QYWH').setValue(resultObj.data[0]['QYWH']);
				            		me.form.getForm().findField('BYWH').setValue(resultObj.data[0]['BYWH']);
				            		me.form.getForm().findField('JYWH').setValue(resultObj.data[0]['JYWH']);
				            		me.form.getForm().findField('YYWH').setValue("");
				            		me.form.getForm().findField('EYWH').setValue("");
				            		me.form.getForm().findField('SYWH').setValue("");
				            		me.form.getForm().findField('SYUWH').setValue("");
				            		me.form.getForm().findField('WYWH').setValue("");
				            		me.form.getForm().findField('LYWH').setValue("");
				            		me.form.getForm().findField('SHIYWH').setValue("");
				            		me.form.getForm().findField('SYYWH').setValue("");
				            		me.form.getForm().findField('SEYWH').setValue("");
				            	}else if(jdz=="第四季度"){
				            		me.form.getForm().findField('SHIYWH').setValue(resultObj.data[0]['SHIYWH']);
				            		me.form.getForm().findField('SYYWH').setValue(resultObj.data[0]['SYYWH']);
				            		me.form.getForm().findField('SEYWH').setValue(resultObj.data[0]['SEYWH']);
				            		me.form.getForm().findField('YYWH').setValue("");
				            		me.form.getForm().findField('EYWH').setValue("");
				            		me.form.getForm().findField('SYWH').setValue("");
				            		me.form.getForm().findField('SYUWH').setValue("");
				            		me.form.getForm().findField('WYWH').setValue("");
				            		me.form.getForm().findField('LYWH').setValue("");
				            		me.form.getForm().findField('QYWH').setValue("");
				            		me.form.getForm().findField('BYWH').setValue("");
				            		me.form.getForm().findField('JYWH').setValue("");
				            	}
				            }
				          },
				          failure : function(response, opts) {
					          var obj = Ext.util.JSON.decode(response.responseText);
					          Ext.Msg.show({
						          title : '异常提示',
						          msg : '提交时存在错误数据！！',
						          buttons : Ext.Msg.OK,
						          icon : Ext.Msg.ERROR
					          });
					        }  		      
					      });
				  	}
			}
		},
		/** 导入生产计划Excel */
		"upLoadFile" : function(me) {
			var template = me.cn;
			var fileForm = new Ext.FormPanel({
				height : 500,
				width : 1000,
				html : "<iframe id='weboffice' name='weboffice' src='js/biz/hdplan/doc.html?template="
						+ template
						+ "' frameborder='0' width='100%' height='100%'></iframe>"
			});
			
			var fileWin = new Ext.Window({
				frame : true,
				height : 550,
				width : 1050,
				items : fileForm
			});
			
			fileWin.show();
		},
		 /*weboffice-excel保修表单录入*/
		upLoadExcel:function(me){
			var template =me.en;
			var cn = me.cn;
			var fileForm = new Ext.FormPanel(
				{
					html:"<iframe id='weboffice' name='weboffice' src='js/biz/hdmapping/excel.html?template="+template+"&cn="+cn+"' frameborder='0' width='100%' height='100%'></iframe>",
					title:'在线填写表单'
				});
			var fileWin = new Ext.Window({
				layout : 'fit',
				frame : true,
				height:550,
				width :1050,
				items : fileForm
				});
			fileWin.show();
			fileWin.maximize();
		},
		/*weboffice-word保修表单录入*/
		upLoadWord:function(me){
			var template =me.en;
			var cn = me.cn;
			var fileForm = new Ext.FormPanel(
				{
					html:"<iframe id='weboffice' name='weboffice' src='js/biz/hdmapping/word.html?template="+template+"&cn="+cn+"' frameborder='0' width='100%' height='100%'></iframe>",
					title:'在线填写表单'
				});
			var fileWin = new Ext.Window({
				layout : 'fit',
				frame : true,
				height:550,
				width :1050,
				items : fileForm
				});
			fileWin.show();
			fileWin.maximize();
		},
		/** 报表导入Execl表格 */
		"bbUpload" : function(me) {
			var fileForm = new Ext.FormPanel({
				frame : true,
				fileUpload : true,
				items : [ {
					fieldLabel : "选择文件",
					xtype : "textfield",
					inputType : "file",
					name : "myfile"
				} ]
			});

			var fileWin = new Ext.Window({
				frame : true,
				items : fileForm,
				buttons : [ {
					"text" : "导入",
					handler : function() {
						if (fileForm.getForm().isValid()) {
							fileForm.getForm().submit({
								url : "common.action?command="
										+ me.en
										+ ".insertExecl",
								waitTitle : '请稍候',
								waitMsg : '正在提交表单数据,请稍候...',
								success : function(form,action) {
									if (!action.result.success) {
										Ext.Msg.show({
													title : '异常提示',
													msg : action.result.msg,
													buttons : Ext.Msg.OK,
													icon : Ext.Msg.ERROR
												});
										return;
									}
									Ext.fm.msg(me.cn,"恭喜，上传成功！");
									me.ds.reload();// 刷新列表
								},
								failure : function(form,action) {
									Ext.Msg.show({
												title : '错误提示',
												msg : action.result.msg,
												buttons : Ext.Msg.OK,
												icon : Ext.Msg.ERROR
											});
								}
							});
						}
					}
				} ]
			});
			
			fileWin.show();
		},
		
		/** 查看生产计划 */
		"hdShow" : function(me) {
			if (me.grid.getSelectionModel().hasSelection()) {
				var rows = me.grid.getSelectionModel().getSelections();
				var type = rows[0].data[me.pk];
				var instanceIds = "";
				var mark = true;

				for ( var i = 0; i < rows.length; i++) {

					instanceIds += rows[i].data[me.pk] + ",";

				}

				instanceIds = instanceIds.substr(0,instanceIds.length - 1);

				if (mark) {
					Ext.Ajax.request({
						url : 'common.action?command=scjh.hdCollectionShow',
						method : 'post',
						params : {
							"instanceIds" : instanceIds,
							"en" : me.en
						},
						success : function(response,
								opts) {
							var resultObj = Ext.util.JSON.decode(response.responseText);

							me.showAuditWin = new Ext.Window(
									{
										title : me.cn,
										layout : 'fit',
										width : 850,
										height : 600,
										plain : true,
										maximizable : true,
										html : resultObj.data
									});

							me.showAuditWin.show();
							me.showAuditWin.maximize();
						},
						failure : function() {
							Ext.Msg.show({
								title : '错误提示',
								msg : '初始化失败',
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.ERROR
							});
						}

					})
				} else {
					Ext.Msg.show({
						title : '友情提示',
						msg : '您选择了不同类型的生产计划，请选择相同类型的生产计划进行查看！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
				}
			} else {
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
			}
		},
		
		/** 导出生产计划 */
		"hdDownload" : function(me) {
			if (me.grid.getSelectionModel().hasSelection()) {
				var rows = me.grid.getSelectionModel()
						.getSelections();
				var type = rows[0].data[me.pk];
				var instanceIds = "";
				var mark = true;

				for ( var i = 0; i < rows.length; i++) {

					instanceIds += rows[i].data[me.pk] + ",";

				}
				instanceIds = instanceIds.substr(0,instanceIds.length - 1);
				if (mark) {
					var exportForm = new Ext.FormPanel();
					exportForm.applyToMarkup(Ext.DomHelper.append(Ext.getBody(), {
								tag : "div"
							}, true));
					exportForm.getForm().getEl().dom.action = "BbDownload?instanceIds="
							+ instanceIds + "&en=" + me.en;
					exportForm.getForm().getEl().dom.submit();
				} else {
					Ext.Msg.show({
						title : '友情提示',
						msg : '您选择了不同类型的生产计划，请选择相同类型的生产计划进行查看！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
				}
			} else {
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
			}
		},
		
		/** 导出word */
		"hdDownloadDoc" : function(me) {
			if (me.grid.getSelectionModel().hasSelection()) {
				var rows = me.grid.getSelectionModel().getSelections();
				var type = rows[0].data[me.pk];
				var instanceIds = "";
				var mark = true;

				for ( var i = 0; i < rows.length; i++) {
					instanceIds += rows[i].data[me.pk] + ",";
				}

				instanceIds = instanceIds.substr(0,instanceIds.length - 1);
				if (mark) {
					var exportForm = new Ext.FormPanel();
					exportForm.applyToMarkup(Ext.DomHelper.append(Ext.getBody(), {
								tag : "div"
							}, true));
					exportForm.getForm().getEl().dom.action = "HdDownloadDoc?instanceIds="
							+ instanceIds + "&en=" + me.en;
					exportForm.getForm().getEl().dom.submit();

				} else {
					Ext.Msg.show({
						title : '友情提示',
						msg : '您选择了不同类型的生产计划，请选择相同类型的生产计划进行查看！',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
				}
			} else {
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
			}

		},
		/**汇总按钮*/
		"hdShowTotal":function(me){
			 var storeHbl = new Ext.data.Store({
		         proxy:new Ext.data.HttpProxy({url : 'common.action?command=ZZJGXX.selectAll'}),
		         reader:new Ext.data.JsonReader({root : 'data',totalProperty : "total",fields : ["ZZJGDM","DWMC"]}),
		         autoLoad : true
		 	});
			 
			var fileForm = new Ext.FormPanel({
		    	labelAlign : 'right',
				labelWidth : 90,
				layout : 'column',
				frame : true,
				border : false,
				defaults : {  bodyStyle : 'padding:30px 0px 0px 10px'},
				items : [ {  
					columnWidth : 1/3,
					layout : 'form',
					defaults : {
						anchor : '99%'
					},
					items : [ {
						xtype:"datepicker",
						fieldLabel : '年度',
						dateConfig:{"dateFmt" : "yyyy"},
						value:'2013',
						id : "CODADN2",
						name : "CODADN2"
					}]	
				},{  
					columnWidth : 1/3,
					layout : 'form',
					defaults : {
						anchor : '99%'
					},
					items : [ {
						xtype : 'combo',
						store: new Ext.data.SimpleStore( { fields: ["name", "id"], data: [[ '年度','年度' ], ['季度','季度']]  }),
						fieldLabel : '(年度/季度)',
						id : "CODADN1",
						name : "CODADN1",
						displayField : 'name',
						valueField : 'id',
						typeAhead : true,
						mode : 'local',
						value : '年度',
						triggerAction : 'all',
						hiddenName : 'rank',
						"listeners" : { 
							"select" : function(combo,record,i){
							  if(combo.getRawValue() == "年度"){
								  fileForm.form.findField("CODADN3").setVisible(false);
							  }else if(combo.getRawValue() == "季度"){
								  fileForm.form.findField("CODADN3").setVisible(true);
							  }
							}
					      }
					} ]	
				},{  
					columnWidth : 1/3,
					layout : 'form',
					defaults : {
						anchor : '99%'
					},
					items : [ {
						xtype : 'combo',
						store: new Ext.data.SimpleStore( { fields: ["name", "id"], data: [[ '第一季度','1' ], ['第二季度','2'],[ '第三季度','3'],[ '第四季度','4' ]]  }),
						fieldLabel : '季度',
						id : "CODADN3",
						name : "CODADN3",
						displayField : 'name',
						valueField : 'name',
						typeAhead : true,
						mode : 'local',
						value : '第一季度',
						triggerAction : 'all',
						hiddenName : 'rank',
						hidden : true,
						hideLabel : true
					}]	
				}]
			});

			var fileWin = new Ext.Window({
				title : "汇总",
				layout : "fit",
				frame : true,
				border : false,
				width : 700,
				height : 180,
				items : fileForm,
				modal : true,
				buttonAlign : "center",
				buttons : [{
					text : "区域局汇总",
					handler : function(){
						var fl=fileForm.form.findField("CODADN1").getValue();
						var lbz=fileForm.form.findField("CODADN2").getValue();
						var jdz=fileForm.form.findField("CODADN3").getValue();
						Ext.Ajax.request({
			   		          url : 'common.action?command='+me.en+'.selectFl',
			   		          method:'post',
					          params:{"NYJDLBB_ID":fl,"LBZ":lbz,"JDZ":jdz},
			   		          async : false,              
			   		          success : function(response, opts) {	
			   		        	  var resultObj = Ext.util.JSON.decode(response.responseText);

					   		         var size = resultObj.data.length;
					   		         if(resultObj.ERROR=="error"){
					   		        	Ext.Msg.show({
					   				          title : '异常提示',
					   				          msg : '用户登录错误！！',
					   				          buttons : Ext.Msg.OK,
					   				          icon : Ext.Msg.ERROR
					   			          });
							          }else{
							        	 var instanceIds = "";
						   		         for ( var i = 0; i < size; i++) {
						   		        	instanceIds +=resultObj.data[i]['INSTANCEIDS'] + ",";
						   		         }
						   		         
									    var exportForm = new Ext.FormPanel();
										exportForm.applyToMarkup(Ext.DomHelper.append(Ext.getBody(), {
											tag : "div"
										}, true));
								        exportForm.getForm().getEl().dom.action = "BbDownload?instanceIds="
										+ instanceIds + "&en=" + me.en;
								        exportForm.getForm().getEl().dom.submit();	
							          }
			   		          	},
			   		          	failure : function(response, opts) {
			   			          var obj = Ext.util.JSON.decode(response.responseText);
			   			          Ext.Msg.show({
			   				          title : '异常提示',
			   				          msg : '提交时存在错误数据！！',
			   				          buttons : Ext.Msg.OK,
			   				          icon : Ext.Msg.ERROR
			   			          });
			   			        }
						 });
					}
				},{
					text : "总局汇总",
					handler : function(){
						var fl=fileForm.form.findField("CODADN1").getValue();
						var lbz=fileForm.form.findField("CODADN2").getValue();
						var jdz=fileForm.form.findField("CODADN3").getValue();	
						
						var exportForm = new Ext.FormPanel();
						exportForm.applyToMarkup(Ext.DomHelper.append(Ext.getBody(), {
							tag : "div"
						}, true));
				        exportForm.getForm().getEl().dom.action = "HzDownload?NYJDLBB_ID="
						+ fl + "&LBZ=" + lbz+"&JDZ="+jdz;
				        exportForm.getForm().getEl().dom.submit();
					}
				}]
			});
			
			fileWin.show();
		},
		/*报表汇总**/
		"hdShowBBTotal":function(me){
			 var storeHbl = new Ext.data.Store({
		         proxy:new Ext.data.HttpProxy({url : 'common.action?command=ZZJGXX.selectAll'}),
		         reader:new Ext.data.JsonReader({root : 'data',totalProperty : "total",fields : ["ZZJGDM","DWMC"]}),
		         autoLoad : true
		 	});
			 
			var fileForm = new Ext.FormPanel({
		    	labelAlign : 'right',
				labelWidth : 90,
				layout : 'column',
				frame : true,
				border : false,
				defaults : {  bodyStyle : 'padding:30px 0px 0px 10px'},
				items : [ {  
					columnWidth : 1/3,
					layout : 'form',
					defaults : {
						anchor : '99%'
					},
					items : [ {
						xtype : 'combo',
						store: new Ext.data.SimpleStore( { fields: ["name", "id"], data: [[ '年份','年份' ], ['月份','月份']]  }),
						fieldLabel : '(年份/月份)',
						id : "CODADN1",
						name : "CODADN1",
						displayField : 'name',
						valueField : 'id',
						typeAhead : true,
						mode : 'local',
						value : '年份',
						triggerAction : 'all',
						hiddenName : 'rank',
						"listeners" : { 
							"select" : function(combo,record,i){
							  if(combo.getRawValue() == "年份"){
								  fileForm.form.findField("CODADN2").format='Y';
							  }else if(combo.getRawValue() == "月份"){
								  fileForm.form.findField("CODADN2").format='Y-m';
							  }
							}
					      }
					} ]		
				},{  
					columnWidth : 1/3,
					layout : 'form',
					defaults : {
						anchor : '99%'
					},
					items : [ {
						xtype:"datefield",
						fieldLabel : '年份',
						format:'Y',
						value:'2013',
						id : "CODADN2",
						name : "CODADN2"
					}]	
				}]
			});

			var fileWin = new Ext.Window({
				title : "汇总",
				layout : "fit",
				frame : true,
				border : false,
				width : 700,
				height : 180,
				items : fileForm,
				modal : true,
				buttonAlign : "center",
				buttons : [{
					text : "航道处汇总",
					handler : function(){
						var fl=fileForm.form.findField("CODADN1").getValue();
						var lbz=fileForm.form.findField("CODADN2").getValue();
						if(fl=="年份"){
							lbz=Ext.util.Format.date(lbz,'Y')
						}
						else if(fl=="月份"){
							lbz=Ext.util.Format.date(lbz,'Y-m')
						}
							Ext.Ajax.request({
			   		          url : 'common.action?command='+me.en+'.selectFl',
			   		          method:'post',
					          params:{"NYJDLBB_ID":fl,"LBZ":lbz},
			   		          async : false,              
			   		          success : function(response, opts) {	
			   		        	  var resultObj = Ext.util.JSON.decode(response.responseText);

					   		         var size = resultObj.data.length;
					   		         if(resultObj.ERROR=="error"){
					   		        	Ext.Msg.show({
					   				          title : '异常提示',
					   				          msg : '用户登录错误！！',
					   				          buttons : Ext.Msg.OK,
					   				          icon : Ext.Msg.ERROR
					   			          });
							          }else{
							        	 var instanceIds = "";
						   		         for ( var i = 0; i < size; i++) {
						   		        	instanceIds +=resultObj.data[i]['INSTANCEIDS'] + ",";
						   		         }
						   		         
									    var exportForm = new Ext.FormPanel();
										exportForm.applyToMarkup(Ext.DomHelper.append(Ext.getBody(), {
											tag : "div"
										}, true));
								        exportForm.getForm().getEl().dom.action = "BbDownload?instanceIds="
										+ instanceIds + "&en=" + me.en;
								        exportForm.getForm().getEl().dom.submit();	
							          }
			   		          	},
			   		          	failure : function(response, opts) {
			   			          var obj = Ext.util.JSON.decode(response.responseText);
			   			          Ext.Msg.show({
			   				          title : '异常提示',
			   				          msg : '提交时存在错误数据！！',
			   				          buttons : Ext.Msg.OK,
			   				          icon : Ext.Msg.ERROR
			   			          });
			   			        }
						 });
					}
				},{
					text : "总局汇总",
					handler : function(){
						var fl=fileForm.form.findField("CODADN1").getValue();
						var lbz=fileForm.form.findField("CODADN2").getValue();
						var jdz=fileForm.form.findField("CODADN3").getValue();	
						
						var exportForm = new Ext.FormPanel();
						exportForm.applyToMarkup(Ext.DomHelper.append(Ext.getBody(), {
							tag : "div"
						}, true));
				        exportForm.getForm().getEl().dom.action = "HzDownload?NYJDLBB_ID="
						+ fl + "&LBZ=" + lbz+"&JDZ="+jdz;
				        exportForm.getForm().getEl().dom.submit();
					}
				}]
			});
			
			fileWin.show();
		},

		"hdPlanChangeJDZ" : function(me,row){
			if(row.data["NYJDLBB_ID"] == "季度"){
				var lbz=row.data["LBZ"];
				var date=lbz.substring(0,4);
				var jdz=lbz.substring(4,lbz.length);
				me.form.getForm().findField("JDZ").setVisible(true);
				me.form.getForm().findField('JDZ').setValue(jdz);
				me.form.getForm().findField('LBZ').setValue(date);
				
			 }else if( row.data["NYJDLBB_ID"] =="年度"){
			    me.form.getForm().findField("JDZ").setVisible(false);
			 }
		},
		"formatTime":function(value,format){
			var date = new Date();
		    date.setYear((value.year) + 1900);
		    date.setMonth(value.month);
		    date.setDate(value.date);
		    date.setHours(value.hours);
		    date.setMinutes(value.minutes);
		    date.setSeconds(value.seconds);
		    return date.format(format);
		}
	}
})