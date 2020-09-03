function block_ui(){//block ui
	$.blockUI(
	    	{ css:
	    		{
	    	        border: 'none',
		            padding: '15px',
		            backgroundColor: '#000',
		            '-webkit-border-radius': '10px',
		            '-moz-border-radius': '10px',
		            opacity: .5,
		            color: '#fff'
	        	}
	    	}
	);
	setTimeout($.unblockUI, 1000);
}

function mode_change_event(obj,mode){
	if(mode=="read"){
		obj.find(".ed").hide();
		obj.find(".rd").show();
	}else{
		obj.find(".ed").show();
		obj.find(".rd").hide();
	}

}
