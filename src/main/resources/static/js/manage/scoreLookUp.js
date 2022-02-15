
	$(document).ready(function(){
				//페이지 이동하기
				let moveForm = $("#moveForm");
				
				$(".page button").on("click",function(){
					
					$("#pageNum").val($(this).val());
					moveForm.attr("method","GET");
					moveForm.attr("action","/manage/scoreLookUp");
					moveForm.submit();
					
				})
				
				//검색하기
				$("#search_btn").on("click",function(){
					
					let searchType = $("#realSearchType").val();
					let keyword = $("#realKeyword").val();
					
					$("#searchType").val(searchType);
					$("#keyword").val(keyword);
					moveForm.attr("method","GET");
					moveForm.attr("action","/manage/scoreLookUp");
					moveForm.submit();
					
				})
				
			//학년검색
			$("#realGrade").on("change",function(){
				
				let sGrade = $("#realGrade").val();
				$("#sGrade").val(sGrade);
				moveForm.attr("action","/manage/scoreLookUp");
				moveForm.submit();
			})
			
			//학년검색
			$("#realClass").on("change",function(){
				
				let sClass = $("#realClass").val();
				$("#sClass").val(sClass);
				
				moveForm.attr("method","GET");
				moveForm.attr("action","/manage/scoreLookUp");
				moveForm.submit();
			})
			
		/* 프린트 기능 구현하기*/
		$("#scorePrint").click(function () {
    		window.print();
		});	
})
