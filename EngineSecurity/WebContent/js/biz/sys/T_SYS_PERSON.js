 {
	"en" : "T_SYS_PERSON",
	"cn" : "人员信息",
	afterModifyShow:function(){
		var me = this;
		var row = me.grid.getSelectionModel().getSelected();
		var departmentValue = 0;
		if(row != null){
		    departmentValue = row.data["DEPARTMENT_ID"];
  		}
		this.form.getForm().findField('name_DEPARTMENT_ID').setValue(departmentValue);
 	},
	"btns" : [ {
		"btype" : "refresh"
	}, {
		"btype" : "add"
	}, {
		"btype" : "modify"
	}, {
		"btype" : "delete"
	}, {
		"btype" : "download"
	} ],
	"columns" : [ {
		"isPk" : true,
		"maxLength" : 11,
		"xtype" : "numberfield",
		"dataIndex" : "PERSON_ID",
		"header" : "人员ID"
	}, {
		"maxLength" : 10,
		"xtype" : "textfield",
		"dataIndex" : "PERSON_NAME",
		"header" : "姓名",
		"allowBlank" : false,
		"order" : 0
	}, {
		"maxLength" : 30,
		"xtype" : "textfield",
		"dataIndex" : "IDCARD",
		"header" : "身份证号",
		"order" : 3
	}, {
		"xtype" : "datefield",
		"dataIndex" : "POST_DATE",
		"header" : "入职时间",
		 "order" : 4
	},{
		"maxLength" : 30,
		"xtype" : "departmentselection",
		"dataIndex" : "DEPARTMENT_ID",
		"header" : "所属部门",
		"isColumn" : false,
		"order" : 5
	},{
		"maxLength" : 11,
		"dataIndex" : "DEPARTMENT_NAME",
		"header" : "所属部门",
		isForm:false,
 		"order" : 5
		
 	}, {
		"maxLength" : "2",
		"displayField" : "sex",
		"xtype" : "combo",
		"data" : [ [ "女", "女" ], [ "男", "男" ] ],
		"valueField" : "id",
		"value" : "男",
		"dataIndex" : "SEX",
		"header" : "性别",
		"order" : 1
 	}, {
		"xtype" : "datefield",
		"dataIndex" : "BIRTHDAY",
		"header" : "出生年月日",
		"order" : 2
	}, {
		"maxLength" : 50,
		"xtype" : "textfield",
		"dataIndex" : "EMAIL",
		"header" : "邮箱",
		"order" : 6
	}, {
		"maxLength" : 20,
		"xtype" : "textfield",
		"dataIndex" : "PHONE",
		"header" : "手机",
		"order" : 7
	}, {
		"maxLength" : 20,
		"xtype" : "textfield",
		"dataIndex" : "QQ",
		"header" : "QQ号",
		"order" : 8
	} ]
}