{"en":"T_SYS_USERRESOURCE","cn":"用户资源表","btns":[{"btype":"refresh"},{"btype":"add"},{"btype":"modify"},{"btype":"delete"},{"btype":"download"}],"columns":[{"isPk":true,"maxLength":11,"xtype":"numberfield","dataIndex":"USER_RESOURCE_ID","header":"用户资源ID"},{"displayField":"USER_ID","xtype":"combo","valueField":"USER_ID","dataIndex":"USER_ID","url":"common.action?command=T_SYS_USERINFO.selectAll","header":"用户ID"},{"displayField":"RESOURCE_ID","xtype":"combo","valueField":"RESOURCE_ID","dataIndex":"RESOURCE_ID","url":"common.action?command=T_SYS_RESOURCE.selectAll","header":"资源ID"},{"maxLength":25,"xtype":"textfield","dataIndex":"FACETYPE","header":"模板类型"},{"displayField":"name","xtype":"combo","data":[["是",1],["否",0]],"valueField":"id","dataIndex":"DESKTOP","header":"是否显示在桌面"},{"maxLength":100,"xtype":"textfield","dataIndex":"ICON","header":"显示图标"},{"maxLength":11,"xtype":"numberfield","dataIndex":"SORT_NUM","header":"排序"}]}