let seq;
let primerSeq;

//on clicking, get the position&base
$('#prep1-result-one').click( function () {
  getSelectionPosition (); 
});

function getSelectionPosition () {
  var selection = window.getSelection();
  console.log(selection.focusNode.data[selection.focusOffset]);
  console.log(selection.focusOffset);
  
  let nth = selection.focusOffset - 18;
  $("#base-upperstrand").html(selection.focusNode.data[selection.focusOffset]+'  ( '+nth+'th base)  '); 
  
  let start = nth-1;
      primerSeq = seq.substr(start,3);	
  //get primer sequence
  console.log('primer for Upper Strand: index '+start+", "+primerSeq);  //substr(start, length)

}

//selector
let prep1 = document.querySelector("#prep1");
let yes = document.querySelector("#yes");
let no = document.querySelector("#no");

//1.create a sequence of dna. Enter the length of dna you want to get: 		
prep1.addEventListener("click", ()=>{	
	console.log("prep1"+prep1);
	//call PreparationController.getDnaSequence()
	$.get("/prep1", 
			{ dnaLength: $('#dLength').val()}, 
			function(data, status) { 
				console.log(data);
				console.log(status);
				seq = data.sequence;
				
				//$("#prep1-result-one").html('Upper Strand :  3\'-'+seq[0].fontcolor("red")+'-5\''); 
				$("#prep1-result-one").html('Upper Strand :  3\'-'+seq+'-5\''); 
				
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
				$("#prep1-result-another").html('Lower Strand :  5\'-'+complementarySeq+'-3\''); 		
			} ); 
		
		 //notice1, prep2-container
		 $('#notice1').show();	 
		 $('#prep2-subcontainer1').show();	
		});


//2.click the starting point of extension on the two strands above. We will find suitable primers.		
//3.now the system brings polymerase enzyme & buffer
prep2.addEventListener("click", ()=>{
	 console.log("prep2 starts");
	 $('#prep2-subcontainer2').show();
	 getSelectionPosition ();
	});	

yes.addEventListener("click", ()=>{
	 console.log("you clicked yes");
	 $('#prep2-subcontainer3-yes').show();
	 $('#prep2-subcontainer3-no').hide();
	 
	 //search the compatible primer from database
	 console.log('primerSeq : '+primerSeq);
	 console.log('primer database search starts..');
	 
	 //call PreparationController.primerSearch()
	 $.get("/primerSearch", 
				{ primerSequence : primerSeq}, 
				// 서버가 필요한 정보를 같이 보냄. 
				function(data, status) { 
					console.log('ajax request : PreparationController.primerSearch()');
					console.log(data);
					console.log(status);
				
				} ); 
	 
	});
	
no.addEventListener("click", ()=>{
	 console.log("you clicked no");
	 $('#prep2-subcontainer3-no').show();
	 $('#prep2-subcontainer3-yes').hide();
	});		
	
	

