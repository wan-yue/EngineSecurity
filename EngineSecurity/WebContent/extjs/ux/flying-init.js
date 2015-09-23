Ext.apply(Ext, {
	flying : {
		init_dispatch : function(url){
	      	  var params = {};
	      	  var location = url;   
	      	  var index = location.indexOf("?");   
	      	  var queryString = ((index>0)?location.substring(index+1):null);
	      	  if(null!=queryString){
	      		  var parameterArray = queryString.split("&");   
	      		  var length = parameterArray.length;   
	      		  for(var i=0;i<length;i++){
	      			  var parameter = parameterArray[i];   
	      			  index =  parameter.indexOf("=");   
	      			  var key = parameter.substring(0,index);   
	      			  var value = parameter.substring(index+1);   
	      			  params[key] = value;
	      		  }
	      	  }
	      	  
	      	  return params;
	    },
		init : function(){	
			//对请求参数进行编码
		    Ext.Ajax.on('beforerequest',function(conn,opti){
		    	var url = opti.url;
				var params = opti.params;
				
				for ( var name in params) {// 初始化属性
					//含有中文
					if(escape(params[name]).indexOf("%u") > -1){
						params[name] = encodeURI(params[name]);
						params["flexEncode"] = true;
					}
				}
				
				//请求含有中文
				if(escape(url).indexOf("%u") > -1){
					opti.url = encodeURI(url) + "&flexEncode=true";
				}
			});
		    
			Ext.Ajax.on('requestexception',function(conn,response,opti){
				var obj = Ext.util.JSON.decode(response.responseText);
				if(response.status == 403){//自定义相应编码
					//var reg = new RegExp("^[0-9a-zA-Z]+[\.](html|htm)$");
					//if(reg.test(obj.msg)){
						window.location = obj.msg; //如重定向到登陆页面 
					//}
				}
			});
			
			//修原生态的TextArea
			Ext.form.TextArea.prototype.flyingResize = function(){
		    	this.ResizableObj = new Ext.Resizable(this.el, {
				    wrap:true,
				    pinned:false,
				    dynamic: true
				});
		    };
		}
	}	
});

Ext.flying.init();