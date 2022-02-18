			$(document).ready(function(){
				
				//페이지 이동하기
				let moveForm = $("#moveForm");
				
				$(".page button").on("click",function(){
					
					$("#pageNum").val($(this).val());
					moveForm.attr("method","GET");
					moveForm.attr("action","/professor/scoreRegView");
					moveForm.submit();
					
				})
				
				//검색하기
				$("#search_btn").on("click",function(){
					
					let searchType = $("#realSearchType").val();
					let keyword = $("#realKeyword").val();
					
					$("#searchType").val(searchType);
					$("#keyword").val(keyword);
					$("#pageNum").val(1);
					moveForm.attr("method","GET");
					moveForm.attr("action","/professor/scoreRegView");
					moveForm.submit();
					
				})
				
			//학년검색
			$("#realGrade").on("change",function(){
				
				let sGrade = $("#realGrade").val();
				$("#sGrade").val(sGrade);
				$("#pageNum").val(1);
				moveForm.attr("action","/professor/scoreRegView");
				moveForm.submit();
			})
			
			//학년검색
			$("#realClass").on("change",function(){
				
				let sClass = $("#realClass").val();
				$("#sClass").val(sClass);
				$("#pageNum").val(1);
				moveForm.attr("method","GET");
				moveForm.attr("action","/professor/scoreRegView");
				moveForm.submit();
			})
			
			//성적등록하기 버튼 클릭시
			$(".scoreReg_btn").on("click",function(){
				
				//클릭한 학생의 인덱스
				let index = $(this).val();

				//클릭한라인의 input정보
				let studentIdx = $("#studentList"+index).val();
				let mJava = $("#mJava"+index).val();
				let mSql = $("#mSql"+index).val();
				let mJavaScript = $("#mJavaScript"+index).val();
				let mSpring = $("#mSpring"+index).val();
				let mCss = $("#mCss"+index).val();
				
				if(mJava==""){
					alert('자바점수를 입력해주세요.');
					return false;
				}
				if(mSql == ""){
					alert('SQL점수를 입력해주세요.');
					return false;
				}
				if(mJavaScript == ""){
					alert('JavaScript 점수를 입력해주세요.');
					return false;
				}
				if(mSpring == ""){
					alert('Spring 점수를 입력해주세요.');
					return false;
				}
				if(mCss == ""){
					alert('CSS 점수를 입력해주세요.');
					return false;
				}
				
				let str = "";
				str +="<input type='hidden' name='studentIdx' value='"+studentIdx+"' >";
				str +="<input type='hidden' name='mJava' value='"+mJava+"'>";
				str +="<input type='hidden' name='mSql' value='"+mSql+"'>";
				str +="<input type='hidden' name='mCss' value='"+mCss+"'>";
				str +="<input type='hidden' name='mJavaScript' value='"+mJavaScript+"'>";
				str +="<input type='hidden' name='mSpring' value='"+mSpring+"'>";
				
				if(confirm("성적을 등록하시겠습니까?\n등록 후에 변경은 불가능 합니다.")){
					
					moveForm.append(str);
					moveForm.attr("method","POST");
					moveForm.attr("action","/professor/scoreReg");
					moveForm.submit();
					
				}else{
					return false;
				}
				
			})
			
			//점수등록시 숫자가 아닌경우
			const checkNum = /[0-9]/;//숫자체크
			
			$(".score input").keyup(function(){
				
				let value = $(this).val();
				
				if(!checkNum.test(value)){
					alert("숫자만 입력해주세요.");
					$(this).val("");
					return false;
				}
				
				if(value > 100 || value<0){
					alert("0점~100점 내외로 점수를 등록해주세요.");
					$(this).val("");
					return false;
				}
				
			})
			
				
		})