
$(document).ready(function(){
	
	//로그인으로 이동
	$("#login_btn").on("click",function(){
		location.href="/loginPage";
	})
	
	//아이디 중복체크
	$("#userId_btn").on("click",function(){
		
		let userId = $("#userId").val();
		
		if(userId == ""){
			alert('아이디를 입력해주세요.');
			return false;
		}
		
		$.ajax({
			 url:"/idChk",
			type:"post",
			data:{"userId":userId},
		datatype:"json",
		 success:function(data){
			if(data == 0){
				alert("해당아이디는 사용이 가능합니다.");
				$("#userId_btn").val("Y");
			}else if(data == 1){
				alert("해당아이디는 이미 사용하고 있습니다.");
				return false;
			}	
		 }
		})
	})
	
	//학번 중복체크 및 학번으로 가입된 아이디가 있는지 체크
	$("#studentIdx_btn").on("click",function(){
		let studentIdx = $("#studentIdx").val();
		
		if(studentIdx == ""){
			alert("학번을 입력해주세요.");
			return false;
		}
		
		$.ajax({
			 	url:"/studentIdxChk",
				type:"post",
				data:{"studentIdx":studentIdx},
			datatype:"json",
		 	success:function(data){
				if(data == 1){
					alert("등록된 학번이 없습니다.");
					return false;
				}
				if(data == 2){
					alert("학번이 확인 되었습니다.");
					$("#studentIdx_btn").val("Y");
				}
				if(data == 3){
					alert("해당학번으로 이미 등록된 아이디가 존재합니다.");
					return false;
				}
			
		 	}
		})
	})
	
	/*학생 가입페이지에서 회원가입 클릭시*/
	$("#sjoin_btn").on("click",function(){
		
		/*회원가입 폼*/
		let joinForm = $("#joinForm");
		
		/*유효성 체크*/
		let studentIdxChk = $("#studentIdx_btn").val();
		let userIdChk = $("#userId_btn").val();
		let userPw = $("#userPw").val();
		let userPwChk = $("#userPwChk").val();
		
		if(studentIdxChk == "N"){
			alert('학번을 다시한번 확인해주시기 바랍니다.');
			return false;
		}
		if(userIdChk== "N"){
			alert('아이디 중복체크를 확인해주시기 바랍니다.');
			return false;
		}
		
		if(userPw == "" || userPwChk == ""){
			alert("비밀번호를 확인해주세요.");
			return false;
		}
		
		if(userPw != userPwChk){
			alert("입력하신 비밀번호와 비밀번호 확인이 서로다릅니다");
			return false;
		}
		joinForm.submit();
	})
	
	//교수님 임시교번 11111111 1이 8개
	$("#professorId_btn").on("click",function(){
		let studentIdx = $("#studentIdx").val();
		
		if(studentIdx == ""){
			alert("임시교번을 입력해주세요.");
			return false;
		}
		
		if(studentIdx != 11111111){
			alert("임시교번을 학교본부에서 확인해주세요.");
			return false;
		}
		alert("임시교번이 확인되었습니다.");
		$("#professorId_btn").val("Y");
		return true;
		
	})
	
	//교수님 회원가입시
		$("#fjoin_btn").on("click",function(){
		
		/*회원가입 폼*/
		let joinForm = $("#joinForm");
		
		/*유효성 체크*/
		let professorId_btn = $("#professorId_btn").val();
		let userIdChk = $("#userId_btn").val();
		let userPw = $("#userPw").val();
		let userPwChk = $("#userPwChk").val();
		
		if(professorId_btn == "N"){
			alert('교번을 다시한번 확인해주시기 바랍니다.');
			return false;
		}
		if(userIdChk== "N"){
			alert('아이디 중복체크를 확인해주시기 바랍니다.');
			return false;
		}
		
		if(userPw == "" || userPwChk == ""){
			alert("비밀번호를 확인해주세요.");
			return false;
		}
		
		if(userPw != userPwChk){
			alert("입력하신 비밀번호와 비밀번호 확인이 서로다릅니다");
			return false;
		}
		joinForm.submit();
	})	
})