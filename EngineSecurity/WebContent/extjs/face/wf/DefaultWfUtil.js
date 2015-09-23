Ext.apply(Ext,{
	wfutil : {
		/** 获取流程状态 */
		"flowState" : function(row, pk) {
			var red = "#FF6464", yellow = "#FFFF64", gray = "#BFBFBF", blue = "blue", state;
			if (row.data["FLOW_STATE"] == '1') {
				state = "<span style='background-color:"
						+ gray
						+ ";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"
						+ gray
						+ "'>流程完成</span><a  href='javascript:void(0)' onclick='Ext.wfutil.showFlowStateDetails(\""
						+ row.data[pk]
						+ "\")'><span class='icon-green'></span></a>";
			} else if (row.data["FLOW_STATE"] == '2') {
				state = "<span style='background-color:"
						+ red
						+ ";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"
						+ red
						+ "'>流程待审</span><a  href='javascript:void(0)' onclick='Ext.wfutil.showFlowStateDetails(\""
						+ row.data[pk]
						+ "\")'><span class='icon-green'></span></a>";
			} else if (row.data["FLOW_STATE"] == '3') {
				state = "<span style='background-color:"
						+ blue
						+ ";width: 16px;height: 16px;vertical-align: middle;display: inline-block'></span><span  style='color:"
						+ blue
						+ "'>审核中</span><a  href='javascript:void(0)' onclick='Ext.wfutil.showFlowStateDetails(\""
						+ row.data[pk]
						+ "\")'><span class='icon-green'></span></a>";
			}

			return state;
		},
		
		/** 查看流程详情 */
		"showFlowStateDetails" : function(bizId) {
			var me = this;

			Ext.Ajax.request({
				url : 'common.action?command=T_WF_OPINION.selectFlowStateDetails',
				params : {
					BUSINESS_ID : bizId
				},
				method : 'post',
				success : function(response, opts) {
					var resultObj = Ext.util.JSON
							.decode(response.responseText);

					var template = new Ext.XTemplate(
							'<tpl for="data">',
							'<tpl if="this.isStart(STEP_TYPEID)">',
							'<p>',
							'<span class="evidence">申请人：</span>{USER_NAME}<span class="blank"></span>',
							'在 {OPINION_TIME}发起流程 <span class="blank"></span>',
							'</p>',
							'</tpl>',
							'<tpl if="this.isJudge(STEP_TYPEID)">',
							'<p>',
							'<span class="evidence">判断条件：</span>{STEP_NAME}<span class="blank"></span>',
							'<span class="evidence">判断结果：</span>{ACTION_NAME}<span class="blank"></span>',
							'</p>',
							'</tpl>',
							'<tpl if="this.isAudit(STEP_TYPEID)">',
							'<tpl if="this.isState(STATE)">',
							'<p>',
							'<span class="evidence">审批人：</span>{USER_NAME}<span class="blank"></span>',
							'在 {OPINION_TIME}审批 <span class="blank"></span>',
							'<span class="evidence">审批决定：</span>{ACTION_NAME}<span class="blank"></span>',
							'<span class="evidence">审批意见：</span>{OPINION_DESC}',
							'</p>',
							'</tpl>',
							'<tpl if="this.isState(STATE) == false">',
							'<p>',
							'<span class="evidence">流程(待审核)状态：</span>{STEP_NAME}<span class="blank"></span>',
							'<tpl if="this.isNull(USER_NAME) == false">',
							'<span class="evidence">审批人：</span>{USER_NAME}<span class="blank"></span>',
							'</tpl>',
							'</p>',
							'</tpl>',
							'</tpl>',
							'<tpl if="this.isEnd(STEP_TYPEID)">',
							'<p>',
							'<span class="evidence">流程审核结束</span><span class="blank"></span>',
							'</p>',
							'</tpl>',
							'</tpl></p>',
							{
								isStart : function(
										STEP_TYPEID) {
									return STEP_TYPEID == "C36CFF852FBA4F3EB6A061E8063B1C20";
								},
								isAudit : function(
										STEP_TYPEID) {
									return STEP_TYPEID == "92ABBD1AD88A45458670ADCAC8A741A6";
								},
								isJudge : function(
										STEP_TYPEID) {
									return STEP_TYPEID == "3F9BAF91909447E982158445DC13FA94";
								},
								isParallel : function(
										STEP_TYPEID) {
									return STEP_TYPEID == "61C2F6F6EF974E75999E32968FD1CFA9";
								},
								isCombine : function(
										STEP_TYPEID) {
									return STEP_TYPEID == "D01926902F284847BF84BCDA430EC93B";
								},
								isEnd : function(
										STEP_TYPEID) {
									return STEP_TYPEID == "A51E21BF95744487B6AC150CD1B1975D";
								},
								isState : function(
										STATE) {
									return STATE == 0;
								},
								isNull : function(
										value) {
									return value == null;
								}
							});

					var flowStatePanel = new Ext.Panel({
								frame : true,
								style : 'padding:10px 20px 10px 20px;',
								html : template.apply(resultObj)
					});

					if (me.flowStateWin) {
						me.flowStateWin.close();
					}

					me.flowStateWin = new Ext.Window({
						title : '流程详情',
						width : 830,
						height : 450,
						frame : true,
						autoScoll : true,
						closeAction : 'hide',
						items : flowStatePanel
					});

					me.flowStateWin.show();
				},
				failure : function() {
					Ext.Msg.show({
						title : '错误提示',
						msg : '操作失败',
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.ERROR
					});
				}
			});
		},

		/** 工作流中修改或者删除前，做判断 */
		"wfBeforeModifyOrDelete" : function(me) {
			if (me.grid.getSelectionModel().hasSelection()) {
				var rows = me.grid.getSelectionModel().getSelections();
				var mark = true;
				var msg = '';
				var flowState = rows[0].data['FLOW_STATE'];
				if (rows.length > 1) {
					msg = '只能选择一条记录！';
					mark = false;
				}

				if (flowState == 1) {
					msg = '流程已审批结束！';
					mark = false;
				}
				if (flowState == 3) {
					msg = '你不是当前审核人，无权操作数据！';
					mark = false;
				}
				if (!mark) {
					me.reset();
					Ext.Msg.show({
						title : '友情提示',
						msg : msg,
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
					return mark;
				}

			} else {
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return false;
			}
		},
		/** 工作流中修改或者删除前，做判断 */
		"clickShowFlow" : function(me) {
			if (me.grid.getSelectionModel().hasSelection()) {
				var rows = me.grid.getSelectionModel().getSelections();
				var mark = true;
				var msg = '';
				var flowState = rows[0].data['FLOW_STATE'];
				if (rows.length > 1) {
					msg = '只能选择一条记录！';
					mark = false;
				}
				
				if (flowState == 0) {
					msg = '未发起审核流程，看不见流程图！';
					mark = false;
				}
				
				if (!mark) {
					me.reset();
					Ext.Msg.show({
						title : '友情提示',
						msg : msg,
						buttons : Ext.Msg.OK,
						icon : Ext.Msg.WARNING
					});
					return mark;
				}else{
					Ext.wfutil.showFlow(rows[0].data[me.pk]);
				}

			} else {
				Ext.Msg.show({
					title : '友情提示',
					msg : '请选择一条记录！',
					buttons : Ext.Msg.OK,
					icon : Ext.Msg.WARNING
				});
				return false;
			}
		},
		/**  显示流程图 */
		"showFlow" : function(bizId) {		
			Ext.Ajax.request({
				url : 'common.action?command=T_WF_BUSINESS_INSTANCE.selectCurrentByBusinessId',
				method : 'post',
				params : {
					"BUSINESS_ID" : bizId
				},
				success : function(response, opts) {
					var resultObj = Ext.util.JSON.decode(response.responseText);
					var url = "flex/workFlowView.html?INSTANCE_ID="+ resultObj.data["INSTANCE_ID"];

					var showFlowPanel = new Ext.Panel(
							{
								title : '查看流程图',
								frame : true,
								closable : true,
								bodyStyle : 'padding:10px;',
								html : "<iframe id='flowchart' name='flowchart' frameborder='0' width='100%' height='100%' src='"
										+ url
										+ "'></iframe>"
							});
					
					var flowShowWin = new Ext.Window({
						title : '流程详情',
						width : 830,
						height : 450,
						maximizable : true,
						layout : 'fit',
						frame : true,
						autoScoll : true,
						closeAction : 'close',
						items : showFlowPanel
					});

					flowShowWin.show();
					flowShowWin.maximize();

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
			}
	}
})
