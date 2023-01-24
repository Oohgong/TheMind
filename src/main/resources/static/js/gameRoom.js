
	let name = "";
	let roomNum = $("#roomNum").val();
	
	document.addEventListener("keypress", function(e){
		if(e.keyCode == 13){
			send();
		}
	});
	
//------------------------------------------
	let ws = new WebSocket ("ws://" +location.host+ "/gameRoom/" +roomNum);
	
	function name(){
		
	}
	
//------------------------------------------
	function wsOpen(){
		
	}

		
	