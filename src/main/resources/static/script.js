//selectors
let prep1 = document.querySelector("#prep1");
console.log(prep1);
//call PreparationController.getDnaSequence()
prep1.addEventListener("click", ()=>{

	$.get("/prep1/", 
			{ dnaLength: 10 }, 
			// 서버가 필요한 정보를 같이 보냄. 
			function(data, status) { 
				console.log(data);
				console.log(status);
				//$("#text").html(data + "<br>" + status); 
			// 전송받은 데이터와 전송 성공 여부를 보여줌. 
			} ); 
		});
