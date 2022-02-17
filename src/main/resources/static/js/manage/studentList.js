			$(document).ready(function(){
				
				//학생등록으로 이동
				$("#studentReg_btn").on("click",function(){
					location.href = '/manage/studentRegView';
				})
				//페이지 이동하기
				let moveForm = $("#moveForm");
				
				$(".page button").on("click",function(){
					
					$("#pageNum").val($(this).val());
					moveForm.attr("action","/manage/studentList");
					moveForm.submit();
					
				})
				
				//검색하기
				$("#search_btn").on("click",function(){
					
					let keyword = $("#realKeyword").val();
					let searchType = $("#realSearchType").val();
					
					$("#keyword").val(keyword);
					$("#searchType").val(searchType);
					moveForm.attr("action","/manage/studentList");
					moveForm.submit();
					
				})
				
			//학년검색
			$("#realGrade").on("change",function(){
				
				let sGrade = $("#realGrade").val();
				$("#sGrade").val(sGrade);
				moveForm.attr("action","/manage/studentList");
				moveForm.submit();
			})
			
			//학년검색
			$("#realClass").on("change",function(){
				
				let sClass = $("#realClass").val();
				$("#sClass").val(sClass);
				
				moveForm.attr("action","/manage/studentList");
				moveForm.submit();
			})
				
		})