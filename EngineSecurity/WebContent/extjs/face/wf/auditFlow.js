Ext.apply(Ext.wfutil,{
	/** 审核流程 */
	auditFlow : function(me) {
		
		if (me.grid.getSelectionModel().hasSelection()) {
			var bussiness_Ids = "";
			var rows = me.grid.getSelectionModel().getSelections();
			var errorItem = new Array();
			var businessArray = new Array();
			
			for ( var i = 0; i < rows.length; i++) {
				businessArray.push(rows[i].data[me.pk]);
				if (rows[i].data["FLOW_STATE"] != 2) {
					errorItem.push(me.grid.getStore().indexOf(rows[i]));
				}
			}
			
			if (errorItem.length) {
				errorItem.sort();//排序
				var itemStr = "";
				for(var m = 0;m < errorItem.length;m++){
					itemStr += errorItem[m] + 1 +",";
				}
				itemStr = itemStr.substring(0, itemStr.length-1);
				
				Ext.Msg.show({
					title : '警告提示',
					msg : '表格中，第 '+ itemStr +' 列业务数据，你无权审核！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return;
			}else{
				var businessIds = "";
				var temp = "";
				for(var m = 0;m < businessArray.length;m++){
					businessIds += "'" + businessArray[m] +"',";
					temp += "'"+businessArray[m] + "',";
				}
				bussiness_Ids = temp.substring(0, temp.length-1);
				businessIds = businessIds.substring(0, businessIds.length-1);
				
				Ext.Ajax.request({
					url : "common.action?command=T_WF_BUSINESS_INSTANCE.selectByBusinessIds",
					params : {
						"BUSINESS_ID" : businessIds
					},
					success : function(response, opts) {
						var businessResultObj = Ext.util.JSON.decode(response.responseText);
						
						
						var selectedItem = new Array();
						for ( var i = 0; i < rows.length; i++) {
							selectedItem.push(me.grid.getStore().indexOf(rows[i]));
						}
						selectedItem.sort();
						
						var stepItem = new Array();
						for(var n = 0;n < businessResultObj["data"].length;n++){
							if(businessResultObj["data"][n]["BUSINESS_ID"] == me.grid.getStore().getAt(selectedItem[0]).data[me.pk]){
								stepItem.push(businessResultObj["data"][n]["STEP_ID"]);
								break;
							}
						}
						
						for(var n = 0;n < businessResultObj["data"].length;n++){
							var stepMark = false;
							
							for(var p = 0;p < stepItem.length;p++){
								if(stepItem[p] == businessResultObj["data"][n]["STEP_ID"]){
									stepMark = true;
									break;
								}
							}
							
							if(!stepMark){
								stepItem.push(businessResultObj["data"][n]["STEP_ID"]);
							}
						}
						
						me.wfObject = {};
						for(var t = 0; t<stepItem.length;t++){
							me.wfObject["titleItem"+t] = new Array();
							me.wfObject["titleStr"+t] = "表格中，第 ";
						}
						
						for ( var i = 0; i < rows.length; i++) {
							for(var n = 0;n < businessResultObj["data"].length;n++){
								for(var m = 0;m < stepItem.length;m++){
									if(rows[i].data[me.pk] == businessResultObj["data"][n]["BUSINESS_ID"] && stepItem[m] == businessResultObj["data"][n]["STEP_ID"]){
										me.wfObject["titleItem"+m].push(me.grid.getStore().indexOf(rows[i])+1);
									}
								}
							}										
						}
						
						me.wfObject["flowFormItem"] =  new Array();
						
						for(var t = 0; t<stepItem.length;t++){
							 var sItems = new Array();
							 me.wfObject["titleItem"+t].sort();
							//标题区
							for(var y = 0; y < me.wfObject["titleItem"+t].length; y++){
								me.wfObject["titleStr"+t] += me.wfObject["titleItem"+t][y] + ",";
								sItems.push({
									"index" : me.wfObject["titleItem"+t][y],
									"bus_id" :  me.grid.getStore().getAt(me.wfObject["titleItem"+t][y]-1).data[me.pk]
								})
							}
							
							me.wfObject["titleStr"+t] = me.wfObject["titleStr"+t].substring(0, me.wfObject["titleStr"+t].length-1) + " 列审批";
							
							//详情区
							var template = new Ext.XTemplate(
									'<tpl for=".">',
									'<span style="width: 16px;height: 16px;vertical-align: middle;display: inline-block"></span>',
									'<a  href="javascript:void(0)" onclick="Ext.wfutil.showFlowStateDetails(\'{bus_id}\')"><span>【第 {index} 列审核详情</span>',
									'<span class="icon-green"></span></a>',
									'<span style="width: 16px;height: 16px;vertical-align: middle;display: inline-block"></span>',
									'<a  href="javascript:void(0)" onclick="Ext.wfutil.showFlow(\'{bus_id}\')"><span>流程图</span>',
									'<span class="icon-orange"></span>】</a>',
									'</tpl>'
							);
							
							//下拉列表区
							me.wfObject["auditCombo"+t]= {
								xtype : 'combo',
								allowBlank : false,
								fieldLabel : "您的选择",
								hiddenName : "ACTION_ID"+"_"+stepItem[t],
								valueField : "ACTION_ID",
								displayField : "ACTION_NAME",
								mode : 'remote',
								pageSize : 10,
								minChars : 1,
								store : new Ext.data.Store({
									url : "common.action?command=T_WF_ACTION.selectAllByStepId",
									baseParams : { "STEP_ID" : stepItem[t]},
									reader : new Ext.data.JsonReader({
										root : 'data',
										totalProperty : "total"
									}, [ {
										name : "ACTION_ID"
									}, {
										name : "ACTION_NAME"
									} ])
								}),
								selectOnFocus : true,
								triggerAction : 'all',
								loadingText : '加载中...',
								listeners : {
									"select" : function(combo,record,i){
										var comboCode = combo.hiddenName.substring(10,combo.hiddenName.length);
										var mark = -1;
										for(var q = 0; q<stepItem.length;q++){
											if(stepItem[q] == comboCode){
												mark = q;
												break;
											}
										}
										
										Ext.Ajax.request({
											url : 'common.action?command=T_WF_OPINION.selectAuditPerson',
											method : 'post',
											params : {
												"ACTION_ID" : record.data["ACTION_ID"]
											},
											success : function(response, opts) {
												var resultObj = Ext.util.JSON.decode(response.responseText);
												
												var auditChecks = new Array();
												
												if(resultObj.data.length == 1){
													var auditObj = {};
													auditObj["boxLabel"] = resultObj.data[0]["USER_NAME"];
													auditObj["name"] = "AUDIT_USER_ID"+"_"+stepItem[mark];
													auditObj["inputValue"] = resultObj.data[0]["USER_ID"];
													auditObj["checked"] = true;
													
													auditChecks.push(auditObj);
												}else{
													for(var i =0;i<resultObj.data.length;i++){
														var auditObj = {};
														auditObj["boxLabel"] = resultObj.data[i]["USER_NAME"];
														auditObj["name"] = "AUDIT_USER_ID"+"_"+stepItem[mark];
														auditObj["inputValue"] = resultObj.data[i]["USER_ID"];
														
														auditChecks.push(auditObj);
													}
												}
												
												me.wfObject["auditPersonPanel"+mark].removeAll();
												
												if(auditChecks.length == 0){
													var str = "";
													if(resultObj.end){
														str = "提交之后，整个流程结束!";
													}else{
														me.wfObject["NoAuditPerson"] = true;
														str = "下一步无审核人员，请联系管理员，分配审核人员!";
													}
													
													me.wfObject["auditPersonArea"+mark] = new Ext.form.Label({
														text : str
													});
													
													me.wfObject["auditPersonPanel"+mark].add(me.wfObject["auditPersonArea"+mark]);
												}else{
													me.wfObject["auditPersonArea"+mark] = new Ext.form.RadioGroup({
														 fieldLabel: '审核人员',
												         items : auditChecks
													});
													
													me.wfObject["auditPersonPanel"+mark].add(me.wfObject["auditPersonArea"+mark]);
												}
												
												me.wfObject["auditPersonPanel"+mark].setVisible(true);
												me.wfObject["auditPersonPanel"+mark].doLayout();
											},
											failure : function() {
												Ext.Msg.show({
													title : '错误提示',
													msg : '初始化失败',
													buttons : Ext.Msg.OK,
													icon : Ext.Msg.ERROR
												});
											}
										});
									}
								}
							};
							
							//选择人员
							me.wfObject["auditPersonArea"+t] = new Ext.form.Label({
								html : "请选择审核人员"
							});

							me.wfObject["auditPersonPanel"+t] = new Ext.Panel({
								layout : 'fit',
								style : 'padding:5px 50px 5px 95px;',
								frame : true
							});
							
							me.wfObject["auditPersonPanel"+t].setVisible(false);
							
							me.wfObject["auditDetailsPanel"+t] = new Ext.Panel({
								layout : 'fit',
								frame : true,
								border : false,
								style : 'padding:5px 50px 5px 25px;',
								html : template.apply(sItems)
							});
							
							me.wfObject["flowFormItem"].push({
								xtype : 'fieldset',
								title : me.wfObject["titleStr"+t],
								collapsible : true,
								autoHeight : true,
								items : [me.wfObject["auditDetailsPanel"+t],me.wfObject["auditCombo"+t],me.wfObject["auditPersonPanel"+t],{
									xtype : 'textarea',
									fieldLabel : '您的意见',
									anchor : '93%',
									allowBlank : false,
									name : 'OPINION_DESC'+'_'+stepItem[t]
								} ]
							});
						}
						
						/** 表单按钮区 */
						me.btsave = new Ext.Button({// 保存按钮
							text : '提交',
							iconCls : 'save',
							handler : function(btn) {
								//如果不存在审核人员，则跳出
								if(me.wfObject["NoAuditPerson"] == true){
									Ext.Msg.show({
										title : '提示',
										msg : "下一步无审核人员，无法提交！请联系管理员，分配审核人员",
										buttons : Ext.Msg.OK,
										icon : Ext.Msg.WARNING
									});
									return;
								}
								
								var opinionIdsAndStepIds = "";
								
								for(var m = 0;m < businessResultObj["data"].length;m++){
									opinionIdsAndStepIds += businessResultObj["data"][m]["OPINION_ID"] +"_"+businessResultObj["data"][m]["STEP_ID"]+",";
								}
								
								opinionIdsAndStepIds = opinionIdsAndStepIds.substring(0, opinionIdsAndStepIds.length-1);
								
								if (me.wfObject["flowFormPanel"].getForm().isValid()) {
									me.wfObject["flowFormPanel"].getForm().submit({
										url : "common.action?command=workflow.auditFlow",
										params : {
											"opinionIdsAndStepIds" : opinionIdsAndStepIds,
											"MSG_ADDR" : me.id || ""
										},
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
											}else{
												me.wfObject["flowStateWin"].close();
												
												 me.grid.getStore().reload();
												 
												 Ext.fm.msg("提示","审核成功！");
											}
										},
										failure : function(form,action) {
											Ext.Msg.show({
												title : '错误提示',
												msg : '网络或者服务器出现异常，无法连接!',
												buttons : Ext.Msg.OK,
												icon : Ext.Msg.ERROR
											});
										}
									});
								}
							}
						});
						
						me.wfObject["flowFormPanel"] = new Ext.FormPanel({// 用户表单
							region : "center",
							labelAlign : 'right',
							labelWidth : 90,
							bodyStyle : 'padding:2px',
							frame : true,
							border : false,
							autoScroll : true,
							defaults : {
								anchor : '93%'
							},
							items : me.wfObject["flowFormItem"],
							buttons : [ me.btsave ]
						});
				
						if (me.wfObject["flowStateWin"]) {
							me.wfObject["flowStateWin"].close();
						}
				
						me.wfObject["flowStateWin"] = new Ext.Window({
							title : '审核流程',
							width : 830,
							height : 450,
							frame : true,
							autoScroll : true,
							maximizable : true,
							closeAction : 'hide',
							items : me.wfObject["flowFormPanel"],
							listeners: {
					        	maximize:function(win){
					        		//关键部分：最大化后需要将窗口重新定位
					        		win.setHeight(win.getInnerHeight());
					        	}
					        }
						});
				
						me.wfObject["flowStateWin"].show();
						
					},
					failure : function() {
						Ext.Msg.show({
							title : '错误提示',
							msg : '操作失败',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.ERROR
						});
					}
				})
			}
		}else{
			Ext.Msg.show({
				title : '友情提示',
				msg : '请选择一条记录！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING
			});
		}	
	}
})
