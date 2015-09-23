Ext.apply(Ext.wfutil,{			
	/** 触发流程 */
	"triggerFlow" : function(me) {
		if (me.grid.getSelectionModel().hasSelection()) {
			var rows = me.grid.getSelectionModel().getSelections();
			var errorItem = new Array();
			
			for ( var i = 0; i < rows.length; i++) {
				if (!(rows[i].data["FLOW_STATE"] == 0 || rows[i].data["FLOW_STATE"] == 1)) {
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
					msg : '表格中，第  '+ itemStr +' 列业务数据已经在审核中，请检查！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return;
			}

			Ext.Ajax.request({
				url : 'common.action?command=T_WF_FLOWFORM.getFlowByBusinessTable',
				method : 'post',
				params : {
					"BUSINESSTABLE" : me.en + '.js'
				},
				success : function(response, opts) {
					var resultObj = Ext.util.JSON
							.decode(response.responseText);
					var flowId = '';
					if (resultObj.data.length == 0) {
						Ext.Msg.show({
							title : '警告提示',
							msg : '业务没有关联的流程！',
							buttons : Ext.Msg.OK,
							icon : Ext.Msg.WARNING
						});
					} else if (resultObj.data.length > 1) {

						var flowChecks = new Array();

						for ( var i = 0; i < resultObj.data.length; i++) {
							var auditObj = {};
							auditObj["boxLabel"] = resultObj.data[i]["FLOW_NAME"];
							auditObj["name"] = "AUDIT_USER_ID";
							auditObj["inputValue"] = resultObj.data[i]["FLOW_ID"];
							auditObj["listeners"] = {
								"scope" : me,
								"check" : function(radio,checked) {
									if (checked) {
										Ext.Msg.confirm('请下一步流程','确定选择'+ radio.boxLabel+ '流程吗?',function(btn) {
											if (btn == 'yes') {
												flowId = radio.inputValue;
												me.checkFlowWin.close();
												Ext.wfutil.getFlowAuditPerson(me,flowId);
											}
										})
									}
								}
							};

							flowChecks.push(auditObj);
						}

						me.checkFlowWin = new Ext.Window(
								{
									title : "选择流程",
									layout : 'fit',
									width : 550,
									height : 200,
									frame : true,
									autoScroll : true,
									items : {
										xytpe : 'panel',
										frame : true,
										items : {
											xtype : 'radiogroup',
											columns : 2,
											style : 'padding:10px 50px 10px 50px;',
											fieldLabel : '流程',
											items : flowChecks
										}
									}
								});
						me.checkFlowWin.show();

					} else {
						flowId = resultObj.data[0]["FLOW_ID"];
						Ext.wfutil.getFlowAuditPerson(me, flowId);
					}

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
		}else{
			Ext.Msg.show({
				title : '友情提示',
				msg : '请选择一条记录！',
				buttons : Ext.Msg.OK,
				icon : Ext.Msg.WARNING
			});
		}
	},
	
	/** 获取流程审核人 */
	"getFlowAuditPerson" : function(me, flowId) {
		Ext.Ajax.request({
					url : "common.action?command=T_WF_OPINION.selectStartStepAuditPerson",
					params : {
						"FLOW_ID" : flowId
					},
					success : function(response, opts) {
						var auditResultObj = Ext.util.JSON.decode(response.responseText);

						if (auditResultObj.data.length == 0) {
							Ext.Msg.show({
								title : '异常提示',
								msg : "下一步无审核人员，请联系管理员，分配审核人员!",
								buttons : Ext.Msg.OK,
								icon : Ext.Msg.WARNING
							});
							return;
						} else if (auditResultObj.data.length == 1) {
							 Ext.wfutil.sendData(me,flowId,auditResultObj.data[0]["USER_ID"]);
						} else if (auditResultObj.data.length > 1) {

							var auditChecks = new Array();

							for ( var i = 0; i < auditResultObj.data.length; i++) {
								var auditObj = {};
								auditObj["boxLabel"] = auditResultObj.data[i]["USER_NAME"];
								auditObj["name"] = "AUDIT_USER_ID";
								auditObj["inputValue"] = auditResultObj.data[i]["USER_ID"];
								auditObj["listeners"] = {
									"scope" : me,
									"check" : function(radio, checked) {
										if (checked) {
											Ext.Msg.confirm('下一步审核人','确定让'+ radio.boxLabel+ '审核吗?',function(btn) {
												if (btn == 'yes') {												
													Ext.wfutil.sendData(me,flowId,radio.inputValue);
												}
											})
										}
									}
								};

								auditChecks.push(auditObj);
							}

							me.auditUserWin = new Ext.Window(
									{
										title : "选择审核人员",
										layout : 'fit',
										width :550,
										height : 200,
										frame : true,
										autoScroll : true,
										items : {
											xytpe : 'panel',
											frame : true,
											autoScroll : true,
											items : {
												xtype : 'radiogroup',
												columns : 3,
												style : 'padding:10px 50px 10px 50px;',
												fieldLabel : '审核人员',
												items : auditChecks
											}
										}
									});

							me.auditUserWin.show();
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
					}
				});
	},
	//发送发起流程数据
	"sendData" : function(me,flowId,auditUserId){
		var businessIds = "";
		var rows = me.grid.getSelectionModel().getSelections();
		for ( var i = 0; i < rows.length; i++) {
			businessIds += rows[i].data[me.pk] + ",";
		}

		businessIds = businessIds.substr(0,businessIds.length - 1);
		
		Ext.Ajax.request({
			url : 'common.action?command=workflow.triggerFlow',
			method : 'post',
			params : {
				"businessIds" : businessIds,
				"businessTable" : me.en,
				"FLOW_ID" : flowId,
				"AUDIT_USER_ID" : auditUserId,
				"MSG_ADDR" : me.id || ""
			},
			success : function(response,opts) {
				if(me.auditUserWin){
					me.auditUserWin.close();
				}
				
				Ext.fm.msg("提示","流程发起成功！");
				me.ds.reload();
			},
			failure : function(response,opts) {
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
})
