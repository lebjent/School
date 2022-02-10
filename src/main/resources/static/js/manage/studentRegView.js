			$(document).ready(function(){
				//등록 버튼 클릭시
				$("#reg_btn").on("click",function(){
				 
					let studentForm = $("#studentForm");
				 	
					let tel1 = $("#tel1").val();
					let tel2 = $("#tel2").val();
					let tel3 = $("#tel3").val();
					
					//유효성검사 간단히 null값만 실행
				 	
					if($("#studentName").val() == ""){
						alert('학생이름을 입력해주세요.');
						return false;
					}
					
					if($("#studentGrade").val()=="NO"){
				 		alert("학년을 선택해주세요.");
				 		return false;
				 	}
					
				 	if($("#studentClass").val()=="NO"){
				 		alert("반 배정을 선택해주세요.");
				 		return false;
				 	}
				 	
				 		
				 	if(tel1 == "" || tel2 == "" || tel3 == "" ){
				 		alert('전화번호를 입력해주세요.');
				 		return false;
				 	}
				 	
				 	$("#studentPhone").val(tel1+"-"+tel2+"-"+tel3);
				 	
				 	studentForm.submit();
					
				});
				
				//취소 버튼 클릭시 리스트로
				$("#cancel_btn").on("click",function(){
					location.href = "/manage/studentList";
				})
			});