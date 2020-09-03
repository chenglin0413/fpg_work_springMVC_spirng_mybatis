	function get_upstair_parent(obj){
    	 return obj.parent().parent();
    }

    function get_outer_html(obj){//取得dom元素
    	return obj.prop("outerHTML");
    }
    function attr_manager(obj,mode){
    	let dict ={};
    	let _id,name,tel,notes,type_obj,type,type_index,gender,timestamp="";
        if(mode==="save"){
            _id = obj.find("#_id > .text").text();
            name = obj.find($("#name > input")).val();//取得name 內的值
            tel = obj.find($("#tel > input")).val();
            notes = obj.find($("#notes > textarea")).val();//取得notes textarea的值
            type_obj = obj.find("#type");//取得type obj
            type =type_obj.find($("select > option:selected")).val();
            type_index = type_obj.find($("select"))[0].selectedIndex;//取得type  option 的索引
            gender = obj.find($("#gender > input:checked")).val();//取得option btn 的值
        }else if(mode==="reload"){
        	console.log("21: "+obj["xuid"]);
            _id = obj["xuid"]; //oracle DB
            name = obj["name"];//取得物件內 name 內的值
            tel = obj["tel"];
            notes = obj["notes"];//取得物件內 notes textarea的值
            type = obj["type"];
            type_index = obj["type_index"];//取得物件內 type  option 的索引
            gender = obj["gender"];//取得物件內 option btn 的值
            timestamp = new Date(obj["timestamp"]).toLocaleString();
        }
        console.log("notict"+name+tel+notes+type_index+_id);
        dict = {"_id":_id,"name":name,"tel":tel,"notes":notes,"type":type,"type_index":type_index.toString(),"gender":gender,"timestamp":timestamp};
        return dict;
    }
    function getID(str){
    	let id = $(str).prop("id");
    	return id;
    }