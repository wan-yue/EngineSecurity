/*
 * Ext JS Library 2.3.0
 * Copyright(c) 2006-2009, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

/**
 * @class Ext.ux.TaskBar
 * @extends Ext.util.Observable
 */
Ext.ux.TaskBar = function(app){
    this.app = app;
    this.init();
}

Ext.extend(Ext.ux.TaskBar, Ext.util.Observable, {
    init : function(){
		this.startMenu = new Ext.ux.StartMenu(Ext.apply({
			iconCls: 'user',
			height: 320,
			shadow: true,
			title: 'Administrator',
			width: 325
		}, this.app.startConfig));

		this.startBtn = new Ext.Button({
            text: '菜单',
            id: 'ux-startbutton',
            iconCls:'start',
            menu: this.startMenu,
            menuAlign: 'bl-tl',
            renderTo: 'ux-taskbar-startMenuBtn',
            clickEvent:'mousedown',
            template: new Ext.Template(
				'<table border="0" cellpadding="0" cellspacing="0" class="x-btn-wrap"><tbody><tr>',
				'<td class="ux-startbutton-left"><i>&#160;</i></td><td class="ux-startbutton-center"><em unselectable="on"><button class="x-btn-text" type="{1}" style="height:30px;">{0}</button></em></td><td class="ux-startbutton-right"><i>&#160;</i></td>',
				"</tr></tbody></table>")
        });
        
        this.startMenuBtn = new Ext.BoxComponent({
			el: 'ux-taskbar-startMenuBtn',
	        id: 'TaskBarStart',
			region:'west'
		});
		
        this.startShortcut = new Ext.ux.TaskButtonsPanel({
			el: 'ux-taskbar-startShortcut',
	        id: 'TaskBarStart1',
			region:'center'
		});
        
        this.startPanel = new Ext.Container({
			el: 'ux-taskbar-start',
	        id: 'TaskBarStart2',
	        border : false,
	        minWidth: 200,
	        layout: 'border',
			region:'west',
			split: true,
			width: 300,
			items :[this.startMenuBtn,this.startShortcut]
		});
        
		this.tbPanel = new Ext.ux.TaskButtonsPanel({
			el: 'ux-taskbuttons-panel',
			id: 'TaskBarButtons',
			region:'center'
		});
		
		this.msgMenu = new Ext.flying.Menu({
			grid : this.creatMsgGrid()
		});
		
		this.msgMenu.on("show",this.msgMenuShow,this);
       	
		this.msgMenu.on("hide",this.msgMenuHide,this);
    	
		this.msgBtn = new Ext.Button({
			id:"ux-msg-panel-btn",
			text:'(0)',
			iconCls : 'message',
			style : 'margin:5px 0px 0px 0px;color:#000;',
            menuAlign: 'br-tr',
            menu: this.msgMenu,
            renderTo: 'ux-msg-panel',
            clickEvent:'mousedown'
        });
		
		this.msgPanel = new Ext.BoxComponent({
			el:"ux-msg-panel",
			minWidth: 75,
			region:'east',
			split: true,
			width: 80
		});
		
        var container = new Ext.ux.TaskBarContainer({
			el: 'ux-taskbar',
			layout: 'border',
			items: [this.startPanel,this.tbPanel,this.msgPanel]
		});
		
		return this;
    },
    
    msgMenuShow : function(){
    	this.msgGrid.grid.getStore().reload();
    	
    	this.app.stopGetMessage();//关闭任务 
    },
    
    msgMenuHide : function(){

    	this.app.startGetMessage();//启动任务 
    },
    
    addTaskButtonShortcut : function(shortcutObj){
		 return this.startShortcut.addButtonShortcut(shortcutObj, 'ux-taskbar-startShortcut');
	},
	
	removeTaskButtonShortcut : function(btn){
		this.startShortcut.removeButton(btn);
	},
	
    addTaskButton : function(win){
		return this.tbPanel.addButton(win, 'ux-taskbuttons-panel');
	},
	
	removeTaskButton : function(btn){
		this.tbPanel.removeButton(btn);
	},
	
	setActiveButton : function(btn){
		this.tbPanel.setActiveButton(btn);
	},
	
	creatMsgGrid : function(){
		this.msgGrid = Ext.fcache.push("biz/sys/T_SYS_MESSAGE.js","grid",{"tableAction" : "common.action?command=T_SYS_MESSAGE.getUserMessage","winWidth":500,"winHeight":500});
		
		return this.msgGrid.grid;
	}
});



/**
 * @class Ext.ux.TaskBarContainer
 * @extends Ext.Container
 */
Ext.ux.TaskBarContainer = Ext.extend(Ext.Container, {
    initComponent : function() {
        Ext.ux.TaskBarContainer.superclass.initComponent.call(this);
        
        this.el = Ext.get(this.el) || Ext.getBody();
        this.el.setHeight = Ext.emptyFn;
        this.el.setWidth = Ext.emptyFn;
        this.el.setSize = Ext.emptyFn;
        this.el.setStyle({
            overflow:'hidden',
            margin:'0',
            border:'0 none'
        });
        this.el.dom.scroll = 'no';
        this.allowDomMove = false;
        this.autoWidth = true;
        this.autoHeight = true;
        Ext.EventManager.onWindowResize(this.fireResize, this);
        this.renderTo = this.el;
    },

    fireResize : function(w, h){
        this.fireEvent('resize', this, w, h, w, h);
    }
});
