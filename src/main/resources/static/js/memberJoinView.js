	$(document).ready(function(){
		
		$(".joinChoice td").on("click",function(){
			
			//선택한 가입유형
			let value = $(this).attr("data-value");
			
			if(value=="student"){
				location.href = "/studentJoin";
			}else if(value=="professor"){
				location.href="/professorJoin";
			}
			
		})
	})