let seq; //3-*****-5
let primerSeq;   
let complementarySeq;   //5-*****-3
let start_t;  //index number

let dlength;
let c_primerSeq;
let start; //index number
$( document ).ready(function() {
//	/$('.pcr-result').show();
	});


//on clicking, get the position & base info
$('#prep1-result-one').click( function () {
	console.log(seq);
  getSelectionPosition_seq(); 
});

//on clicking, get the position & base info
$('#prep1-result-another').click( function () {
	console.log(complementarySeq);
  getSelectionPosition_complementarySeq();
});

function getSelectionPosition_seq() {
  var selection = window.getSelection();
  console.log(selection);
	  console.log(selection.focusNode.data[selection.focusOffset]);
	  console.log(selection.focusOffset);
	 
  let nth = selection.focusOffset - 18;  
      start = nth-3;
      primerSeq = seq.substr(start-1,3);	
      start_t = start-1;
  //get primer sequence
  console.log('primer for Upper Strand: index '+start_t+", "+primerSeq);  //substr(start, length)
  
  $("#base-upperstrand").html(selection.focusNode.data[selection.focusOffset]+'  ( '+start_t+'th base)  '); 
}

function getSelectionPosition_complementarySeq() {
	
  var selection = window.getSelection();
	  console.log(selection.focusNode.data[selection.focusOffset]);
	  console.log(selection.focusOffset);
	 
  let nth = selection.focusOffset - 18;
  
      start = nth-8;
      sub1 = complementarySeq.substr(start-1,1);	
      sub2 = complementarySeq.substr(start-2,1);	
      sub3 = complementarySeq.substr(start-3,1);	
      c_primerSeq = sub1+ sub2+ sub3;
      start_c = start-1;
  
  console.log('primer for Complementary Strand: index '+start_c+", "+c_primerSeq);  //substr(start, length)
  $("#base-lowerstrand").html(selection.focusNode.data[selection.focusOffset]+'  ( '+start_c+'th base)  '); 
}


function conversion(str) {
	  result = "";
	  for (i = 0; i < str.length; i++) {
	    if (str.charAt(i) == "C") {
	      result += "G";
	    } else if (str.charAt(i) == "G") {
	      result += "C";
	    } else if (str.charAt(i) == "A") {
	      result += "T";
	    } else {
	      result += "A";
	    }
	  }
	  return result;
	}


function numOfCopies(nthCycle){
	return Math.pow(2,nthCycle-1);
}

function sleep(milliseconds) {
  const date = Date.now();
  let currentDate = null;
  do {
    currentDate = Date.now();
  } while (currentDate - date < milliseconds);
}

//send pcr experiment result to PcrResultController
function sendPcrResult(result){
	//call PreparationController.primerSearch()
	let param = {
		"seq" : result.seq,
	    "primerSeq" : result.primerSeq,
		"complementarySeq" : result.complementarySeq,
		"start_t" : result.start_t,
		"c_primerSeq" : result.c_primerSeq,	
		"product1_1" : result.product1_1,
		"product1_2" : result.product1_2,
		"product2_1" : result.product2_1,
		"product2_2" : result.product2_2	 
	}
	
	 $.get("/resultStoredToRedis", 
				param, 
				// 서버가 필요한 정보를 같이 보냄. 
				function(data, status) { 
					console.log('ajax request : ResultController.resultStoredToRedis()');
					console.log(data);
					console.log(status);
					console.log(data.result);
				} ); 
	}

//selector
let prep1 = document.querySelector("#prep1");
let yes = document.querySelector("#yes");
let no = document.querySelector("#no");
let pcr = document.querySelector("#pcr");


//1.create a sequence of dna. Enter the length of dna you want to get: 		
prep1.addEventListener("click", ()=>{	
	complementarySeq = "";
	console.log("prep1"+prep1);
	dlength = $('#dLength').val();
	//call PreparationController.getDnaSequence()
	$.get("/prep1", 
			{ dnaLength: dlength}, 
			function(data, status) { 
				console.log(data);
				console.log(status);
				seq = data.sequence;
				
				//$("#prep1-result-one").html('Upper` Strand :  3\'-'+seq[0].fontcolor("red")+'-5\''); 
				$("#prep1-result-one").html('Template Strand :  3\'-'+seq+'-5\''); 
				
				//get a complementary strand of prep1-result-one
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

				$("#prep1-result-another").html('Complementary Strand :  5\'-'+complementarySeq+'-3\''); 		
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
	});	

yes.addEventListener("click", ()=>{
	 console.log("you clicked yes");
	 $('#prep2-subcontainer3-yes').show();
	 $('#prep2-subcontainer3-no').hide();
	 
	 //search the compatible primer from database
	 console.log('primerSeq : '+primerSeq);
	 console.log('c_primerSeq : '+c_primerSeq);

	 console.log('searching primer database starts..');
	 
	 //call PreparationController.primerSearch()
	 $.get("/primerSearch", 
				{ primerSequence : primerSeq , c_primerSequence : c_primerSeq}, 
				// 서버가 필요한 정보를 같이 보냄. 
				function(data, status) { 
					console.log('ajax request : PreparationController.primerSearch()');
					console.log(data);
					console.log(status);
					console.log(data.result);
				    
					
					data.result.forEach(item => {
						console.log(item.name+"  "+item.sequence);
						$("#primer-search-result").html(item.name);
						$("#primer-search-result").html("primer name : "+item.name+", primer sequence :"+item.sequence);
					})
					
					data.result_c.forEach(item => {
						console.log(item.name+"  "+item.sequence);
						$("#primer_c-search-result").html(item.name);
						$("#primer_c-search-result").html("primer name : "+item.name+", primer sequence :"+item.sequence);
					})	
				} ); 
	});
	
no.addEventListener("click", ()=>{
	 console.log("you clicked no");
	 $('#prep2-subcontainer3-no').show();
	 $('#prep2-subcontainer3-yes').hide();
	});		


pcr.addEventListener("click", ()=>{
//$(".pcr").click(function(){
	$("#resultBoard").show();

	console.log("pcr process starts");
	//replicate using primer sequence and dna sequence
	console.log("template strand : 5 -"+seq+"-3");
	console.log("primer for template strand : 5-"+primerSeq+"-3");
	console.log("index of first base of the primer (starting from 5') : "+start_t);
	
	console.log("complementary strand : 5-"+complementarySeq+"-3");
	console.log("primer for complementary strand : 5-"+c_primerSeq+"-3");
	console.log("index of first base of the primer (starting from 5') : "+start_c);

	//show the result, process by process
	console.log("1st cycle");
	
	//product 1-1
	let product1_1=seq;
	console.log(seq);
	
	//for console space
	let emptyspace = "";
	for (i = 0; i < start_t; i++) {
	  emptyspace = emptyspace + "  ";
	}
	//for browser space
	let emptyspace1 = "";
	for (i = 0; i < start_t-2; i++) {
	  emptyspace1 = emptyspace1 + "&nbsp";
	}
	
	//product 1-2 (synthethised from seq) 
	let product1_2 = emptyspace + conversion(seq.substr(start_t, 14));
	console.log(emptyspace + conversion(seq.substr(start_t, 14))); //copy from start to end
    console.log(" ");
    //product 2-2 (synthethised from c-seq) 
    let product2_2 = conversion(complementarySeq.substr(0, start_c + 1));
    
    let emptyspace_behind_product2_2= "";
		for (i = 0; i < start_t; i++) {
		  emptyspace_behind_product2_2 = emptyspace_behind_product2_2 + "&nbsp";
	}
	console.log(conversion(complementarySeq.substr(0, start_c + 1))); // copy from 0 to start
	//product 2-1 
	let product2_1 = complementarySeq;
	console.log(complementarySeq);
	
	
	
	
	console.log(" ");
	console.log("2nd cycle");
	//product 1-1 (synthethised from seq)
	console.log(seq);
	//product 1-2
	console.log(emptyspace + conversion(seq.substr(start_t, 14))); //copy from start to end
    console.log(" ");
     
    //product 2 (final product)
    let product2 = emptyspace + conversion(seq.substr(start_t, start_c-start_t+1));
	console.log(emptyspace + conversion(seq.substr(start_t, start_c-start_t+1))); //copy from start to end
	
    //product 1-2
	console.log(emptyspace + conversion(seq.substr(start_t, 14))); //copy from start to end
    console.log(" ");
     
    //product 2-2 (synthethised from c-seq) 
	console.log(conversion(complementarySeq.substr(0, start_c + 1))); // copy from 0 to start
    //product 2 (final product)
	console.log(emptyspace + conversion(seq.substr(start_t, start_c-start_t+1))); //copy from start to end
	console.log(" ");
	
     
    //product 2-2 (synthethised from c-seq) 
	console.log(conversion(complementarySeq.substr(0, start_c + 1))); // copy from 0 to start
	//product 2-1 (synthethised from c-seq) 
	console.log(complementarySeq);
    $(".pcr-result").empty();
    html = "";
	html += `<div><p>1st cycle</p>`;
	html +=`<p>3'-${product1_1}-5'</p>`;
	html += `<p>3'-${emptyspace1}${product1_2}-5'</p>`;
	html += `<br>`;
	html += `<p>5'-${product2_2}${emptyspace_behind_product2_2}-3'</p>`;
	html += `<p>5'-${product2_1}-3'</p></div>`;

	html += `<div><p>2nd cycle</p>`;
	html +=`<p>3'-${product1_1}-5'</p>`;
	html += `<p>3'-${emptyspace1}${product1_2}-5'</p>`;
	html += `<br>`;
	html += `<p>5'-${emptyspace1}${product2}-3'</p>`;
	html += `<p>5'-${emptyspace1}${product1_2}-3'</p>`;
	html += `<br>`;
	html += `<p>5'-${product2_2}${emptyspace_behind_product2_2}-3'</p>`;
	html += `<p>5'-${emptyspace1}${product2}-3'</p>`;
	html += `<br>`;
	html += `<p>5'-${product2_2}${emptyspace_behind_product2_2}-3'</p>`;
	html += `<p>5'-${product2_1}-3'</p></div>`;

	html += `<div><p>3rd cycle</p>`;
    html +=`<p>3'-${product1_1}-5'</p>`;
	html += `<p>3'-${emptyspace1}${product1_2}-5'</p>`;
	html += `<br>`;
	html += `<p>5'-${emptyspace1}${product2}-3'</p>`;
	html += `<p>5'-${emptyspace1}${product1_2}-3'</p>`;
	html += `<br>`;
	html += `<p style="background-color:lime">5'-${emptyspace1}${product2}-3'</p>`;
	html += `<p style="background-color:lime">5'-${emptyspace1}${product2}-3'</p>`;
	html += `<br>`;	
	html += `<p>5'-${emptyspace1}${product2}-3'</p>`;	
	html += `<p>5'-${emptyspace1}${product1_2}-3'</p>`;
	html += `<br>`;			
	html += `<p>5'-${product2_2}${emptyspace_behind_product2_2}-3'</p>`;
	html += `<p>5'-${emptyspace1}${product2}-3'</p>`;
	html += `<br>`;
	html += `<p style="background-color:lime">5'-${emptyspace1}${product2}-3'</p>`;
	html += `<p style="background-color:lime">5'-${emptyspace1}${product2}-3'</p>`;
	html += `<br>`;	
	html += `<p>5'-${product2_2}${emptyspace_behind_product2_2}-3'</p>`;
	html += `<p>5'-${emptyspace1}${product2}-3'</p>`;
	html += `<p>5'-${product2_2}${emptyspace_behind_product2_2}-3'</p>`;
	html += `<p>5'-${product2_1}-3'</p></div>`;

	html += `<div><p>......</p>`;
	$(".pcr-result").append(html);
   	//$(html).appendTo('.pcr-result');
	$("#NumOfCopies").text(numOfCopies($('#runTimes').val()));
	$("#NumOfCycles").text(	$('#runTimes').val());
	//sleep(3000);
	
	let result = {
		"seq" : seq,
	    "primerSeq" : primerSeq,
		"complementarySeq" : complementarySeq,
		"start_t" : start_t,
		"c_primerSeq" : c_primerSeq,	
		"product1_1" : product1_1,
		"product1_2" : product1_2,
		"product2_1" : product2_1,
		"product2_2" : product2_2		
	}
	   
	sendPcrResult(result);
	
});

