//selectors

let prep1 = document.querySelector("#prep1");

//call PreparationController.getDnaSequence()
prep1.addEventListener("click", ()=>{
	
	console.log("prep1"+prep1);

	$.get("/prep1", 
			{ dnaLength: $('#dLength').val()}, 
			// 서버가 필요한 정보를 같이 보냄. 
			function(data, status) { 
				console.log(data);
				console.log(status);
				let seq = data.sequence;
				$("#prep1-result-one").html('3\'-'+seq+'-5\''); 
				
				//get a complementary strand of prep1-result-one
				let complementarySeq = "";
				for(i=0;i<seq.length;i++){
					if(seq.charAt(i) == 'C'){
						complementarySeq += 'G';
					}else if(seq.charAt(i) == 'G'){
						complementarySeq += 'C';
					}else if(seq.charAt(i) == 'A'){
						complementarySeq += 'T';
					}else{
						complementarySeq += 'A';
					};
				}
				$("#prep1-result-another").html('5\'-'+complementarySeq+'-3\''); 
				
				
			} ); 
		});
