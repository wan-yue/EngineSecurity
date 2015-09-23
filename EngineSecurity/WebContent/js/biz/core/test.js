Ext.onReady(function() {
	Ext.QuickTips.init();
	
	new Ext.Panel({
		title:"新闻",
		renderTo:"testId",					
		width:800,
		height:500,
		layout:"table",
		frame : true,
		border : false,
		layoutConfig:{
			columns:3
		},
		items:[{
				layout : 'form',
				defaults : {
						anchor : '99%'
				},
				items : [{
					 xtype:'textfield',  
	                 fieldLabel:'姓名',  
	                 name:'uname'
				}]
			},
			{
				layout : 'form',
				defaults : {
						anchor : '99%'
				},
				items : [{
					 xtype:'textfield',  
	                 fieldLabel:'姓名',  
	                 name:'uname'
				}]
			},
			{
				colspan:2,
				layout : 'form',
				defaults : {
						anchor : '99%'
				},
				items : [{
					 xtype:'textfield',  
	                 fieldLabel:'姓名',  
	                 name:'uname'
				}]
			},
			{
				rowspan : 3,
				layout : 'form',
				defaults : {
						anchor : '99%'
				},
				items : [{
					 xtype:'textfield',  
	                 fieldLabel:'姓名',  
	                 name:'uname'
				}]
			},
			{
				layout : 'form',
				defaults : {
						anchor : '99%'
				},
				items : [{
					 xtype:'textfield',  
	                 fieldLabel:'姓名',  
	                 name:'uname'
				}]
			},
			{
				layout : 'form',
				defaults : {
						anchor : '99%'
				},
				items : [{
					 xtype:'textfield',  
	                 fieldLabel:'姓名',  
	                 name:'uname'
				}]
			},
			{
				layout : 'form',
				defaults : {
						anchor : '99%'
				},
				items : [{
					 xtype:'textfield',  
	                 fieldLabel:'姓名',  
	                 name:'uname'
				}]
			}
		]
	});
})