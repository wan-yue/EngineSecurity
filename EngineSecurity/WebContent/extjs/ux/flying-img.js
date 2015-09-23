Ext.namespace("Ext.flying");

Ext.flying.img = Ext.extend(Ext.Panel,{
	name : null,
	src : "attached/default/nopic.gif",
	width : 300,
	height : 200,
	onRender : function(ct, position) {
		
		Ext.flying.img.superclass.onRender.call(this, ct, position);

		this.imgArea = new Ext.Panel({
			frame : false,
			border : false,
			bodyBorder : false,
			id:'image_' + this.name,
			bodyStyle:'background-color:transparent',
			html:'<div align="center"><img style="width:'+ this.width +'px;height:'+ this.height +'px" src="'+this.src+'" ></div>'
		});
		
		this.add(this.imgArea);
	}
});

Ext.reg('img',Ext.flying.img);