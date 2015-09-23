/**
 * 集成kindeditor
 * @author zdf 2012-10-17
 */
Ext.form.KindEditorPanel = Ext.extend(Ext.form.TextArea, {
		editor : null,
	    onRender : function(ct, position){   
			Ext.form.KindEditorPanel.superclass.onRender.call(this, ct, position);
			var locWidth = "98%";
			var locHeight = "90%";
			
			if(this.width != null){
				locWidth = this.width + "px";
			}
			
			if(this.height != null){
				locHeight = this.height + "px";
			}
			
			this.el.dom.setAttribute("style","width:"+locWidth+";height:"+locHeight+";");

			this.editor = KindEditor.create('textarea[name="'+this.name+'"]',{
				uploadJson : 'KindeditorUpload',
				fileManagerJson : 'KindeditorUploadManager',
				allowFileManager : true
			});
		},
		show: function(){
			Ext.Component.superclass.show.call(this);
		},
		flyingInit : function(){
			if(this.editor){
				this.editor.remove().create();
			}
		},
		getValue : function(){
			var value = "";
			if(this.editor){
				this.editor.sync();
				value = this.editor.html();
			}

			return value;
		},
		setValue : function(v){
			this.editor.html(v);
			this.editor.sync();
		}
});
	
Ext.reg('kindeditor',Ext.form.KindEditorPanel);  