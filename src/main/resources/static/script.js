


//on clicking, get the position&base
$('#prep1-result-one').click( function () {
  getSelectionPosition (); 
});


function getSelectionPosition () {
  var selection = window.getSelection();
  console.log(selection.focusNode.data[selection.focusOffset]);
  console.log(selection.focusOffset);
}


//selector
let prep1 = document.querySelector("#prep1");

//1.create a sequence of dna. Enter the length of dna you want to get: 		
prep1.addEventListener("click", ()=>{
	
	console.log("prep1"+prep1);
	//call PreparationController.getDnaSequence()
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
		
		 //notice1, prep2-container
		 $('#notice1').show();
		 
		 $('#prep2-subcontainer1').show();
		
		});


	

	 
	/* base.addEventListener("mouseover", (e)=> {
		console.log(e.target);
	} ) */
	
//2.click the starting point of extension on the two complementary strands above. We will find suitable primers.		
//3.now the system brings polymerase enzyme & buffer
prep2.addEventListener("click", ()=>{

	 console.log("prep2 starts");
	 $('#prep2-subcontainer2').show();
	 $('#prep2-subcontainer3').show();
	});	
	

