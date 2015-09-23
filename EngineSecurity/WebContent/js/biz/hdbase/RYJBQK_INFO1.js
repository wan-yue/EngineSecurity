/** 分配用户 */
(function(){

var RYJBQK_INFO1 = {};

RYJBQK_INFO1.Btn_save = new Ext.Button({
	text: '保存',
    iconCls:'save',
    handler: function(){
		if (RYJBQK_INFO1.center.getForm().isValid()) {
			RYJBQK_INFO1.center.getForm().submit({
				url:'common.action?command=RYJBQK.updateInfo1',
				params:RYJBQK_INFO1.parent.params,
				waitTitle : '请稍候',
				waitMsg : '正在提交表单数据,请稍候...',
				success : function(form, action) {
					Ext.fm.msg("人员附加信息1","恭喜，添加成功！");
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
});

RYJBQK_INFO1.center = new Ext.FormPanel({
	title : '人员基本信息1',
	frame : true,
	closable : true,
	bodyStyle : 'padding:10px;',
	items : [ {
		xtype : 'combo',
		fieldLabel : '性别',
		fieldWidth : 50,
		width : 145,
		hiddenName : "XB",
		valueField : 'ID',
		displayField : 'NAME',
		mode : 'remote',
		pageSize : 10,
		store : new Ext.data.Store({
			autoLoad : true,
			url : 'common.action?command=XB.selectAll',
			reader : new Ext.data.JsonReader({
				root : 'data'
			}, [ {
				name : 'ID',
				type : 'int'
			}, {
				name : 'NAME',
				type : 'string'
			} ])
		}),
		selectOnFocus : true,
		triggerAction : 'all',
		loadingText : '加载中...'
	},{
		xtype : 'combo',
		fieldLabel : '民族',
		fieldWidth : 50,
		width : 145,
		hiddenName : "MZ",
		valueField : 'ID',
		displayField : 'NAME',
		mode : 'remote',
		pageSize : 10,
		store : new Ext.data.Store({
			autoLoad : true,
			url : 'common.action?command=MZ.selectAll',
			reader : new Ext.data.JsonReader({
				root : 'data'
			}, [ {
				name : 'ID',
				type : 'int'
			}, {
				name : 'NAME',
				type : 'string'
			} ])
		}),
		selectOnFocus : true,
		triggerAction : 'all',
		loadingText : '加载中...'
	}],
	buttons : [RYJBQK_INFO1.Btn_save]
});

return RYJBQK_INFO1;

})(Ext)