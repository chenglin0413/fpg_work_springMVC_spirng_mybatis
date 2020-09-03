	function isNull(str){
        if(str == null || str == undefined || str == "") return true;
    }
	function ist(data_pack){//insert to restdb
    	//console.log("name :"+map["name"]+" tel :"+map["tel"]+" type_index :"+map["type_index"]+"timestamp: "+map["timestamp"]);
    	let data = data_pack;
        if(!isNull(data["data"]["name"])){
        	$.ajax({
    		    type: "POST",
    		    url: "AdrbookServlet/insert",
    		    async: false,
    		    contentType: "application/json", // NOT dataType!
    		    data: JSON.stringify(data),
    		    success: function(response) {
    	            console.log(response);
    		    }
    		});
        }else{
        	alert("姓名欄位不得有空值")
        }

    }
    function qry(data_pack){//query  from restdb
    	let result = '';
    	let data = data_pack;
    	$.ajax({
		    type: "POST",
		    url: "AdrbookServlet/query",
		    async: false,
		    contentType: "application/json", // NOT dataType!
		    data: JSON.stringify(data),
		    success: function(response) {
	            result = JSON.parse(response);//json Str trasfer json Obj
	            console.log("result:"+result);
		    }
		});
        return result;
    }
    function upd(data_pack){//update to restdb
    	let data = data_pack;
		$.ajax({
		    type: "POST",
		    url: "AdrbookServlet/update",
		    async: false,
		    contentType: "application/json", // NOT dataType!
		    data: JSON.stringify(data),
		    success: function(response) {
	            console.log(response);
		    }
		});
    }
    function del(data_pack){//delete to restdb
    	let data = data_pack;
	 	$.ajax({
			    type: "POST",
			    url: "AdrbookServlet/delete",
			    async: false,
			    contentType: "application/json", // NOT dataType!
			    data: JSON.stringify(data),
			    success: function(response) {
		            console.log(response);
			    }
			});
    }

    function data_pack(row_data,crud_sts){
    	let data ='';
    	if(crud_sts=="insert"){
    		data = {action:crud_sts,
        	        data:{name: row_data["name"].trim()
                        ,tel: row_data["tel"]
                        ,notes: row_data["notes"]
                        ,type: row_data["type"]
                        ,type_index: row_data["type_index"]
                        ,gender: row_data["gender"]
                     }
                    };
    	}else if (crud_sts=="getAll"){
    		data = {
        		    action: crud_sts
        		};
    	}else if (crud_sts=="delete"){
    		data = {
   		         action:crud_sts,
    	         data:{xuid:row_data}
                };
    	}else if (crud_sts=="update"){
    		data = {action:crud_sts,
        	        data:{xuid:row_data["_id"]
        	        	,name: row_data["name"]
                        ,tel:  row_data["tel"]
                        ,notes:row_data["notes"]
                        ,type: row_data["type"]
                        ,type_index: row_data["type_index"]
                        ,gender: row_data["gender"]
                     }
               };
    	}
       return data;
    }