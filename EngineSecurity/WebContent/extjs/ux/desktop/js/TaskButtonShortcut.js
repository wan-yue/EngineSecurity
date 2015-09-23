/*
 * Ext JS Library 2.3.0
 * Copyright(c) 2006-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

/**
 * @class Ext.ux.TaskBar.TaskButtonShortcut
 * @extends Ext.Button
 */
Ext.ux.TaskBar.TaskButtonShortcut = function(shortcutObj, el){
	this.shortcutObj = shortcutObj;
    Ext.ux.TaskBar.TaskButtonShortcut.superclass.constructor.call(this, {
        text: '',
        icon: this.shortcutObj["moduleIcon"],   
        cls: 'buttonShortcuts',
        tooltip : this.shortcutObj["moduleTitle"],
        renderTo: el,
        handler : function(){
			Ext.fcache.App.createWindow(this.shortcutObj);
        },
        template: new Ext.Template(
			'<table border="0" cellpadding="0" cellspacing="0" class="x-btn-wrap"><tbody><tr>',
			'<td class="ux-taskbutton-left"><i>&#160;</i></td><td class="ux-taskbutton-center"><em unselectable="on"><button class="x-btn-text" type="{1}" style="height:28px;">{0}</button></em></td><td class="ux-taskbutton-right"><i>&#160;</i></td>',
			"</tr></tbody></table>")
    });
};

Ext.extend(Ext.ux.TaskBar.TaskButtonShortcut, Ext.Button, {
    onRender : function(){
        Ext.ux.TaskBar.TaskButtonShortcut.superclass.onRender.apply(this, arguments);
        
        this.cmenu = new Ext.menu.Menu({
            items: [{
                text: '打开',
                scope: this,
                handler: function(){
                	Ext.fcache.App.createWindow(this.shortcutObj);
                }
            },{
                text: '删除',
                scope: this,
                handler: function(){
                	var me = this;
                	
                	Ext.Ajax.request({                           
            	        url: 'common.action?command=T_SYS_USERRESOURCE.updateByUserIdResourceId',
            	        method:'post',
            	        params:{"RESOURCE_ID":me.shortcutObj["RESOURCE_ID"],"DESKTOP":0},
            	        success:function(response, opts){
            	        	//刷新父页面
            				var data = {
            						RESOURCE_ID : me.shortcutObj["RESOURCE_ID"],
            						RESOURCE_NAME : me.shortcutObj["moduleTitle"],
            						ICON : me.shortcutObj["moduleIcon"],
            						RESOURCE_ADDR : me.shortcutObj["moduleUrl"],
            						FACETYPE : me.shortcutObj["moduleType"],
            						CACHE : me.shortcutObj["moduleCache"]
            				};
            				
            				
            				Ext.fcache.App.desktop.taskbar.removeTaskButtonShortcut(me);
            				
            	        },
            	        failure: function(){
            	        	Ext.Msg.show({
            					title : '错误提示',
            					msg : '初始化失败',
            					buttons : Ext.Msg.OK,
            					icon : Ext.Msg.ERROR
            				});
            	        }
            	    });
                }
            }]
        });

        this.el.on('contextmenu', function(e){
            e.stopEvent();
            if(!this.cmenu.el){
                this.cmenu.render();
            }
            var xy = e.getXY();
            xy[1] -= this.cmenu.el.getHeight();
            this.cmenu.showAt(xy);
        }, this);
    }
});