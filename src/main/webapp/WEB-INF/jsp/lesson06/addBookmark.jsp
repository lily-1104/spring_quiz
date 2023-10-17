<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX로 submit 대신 웹 요청하기</title>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container">
	
		<h2>즐겨찾기 추가하기</h2>
		
		<div class="form-group mt-4">
			<label for="name">제목</label>
			<input type="text" id="title" name="title" class="form-control">
		</div>
		
		<div class="form-group mt-4">
			<label>주소</label>
			<input type="text" id="domain" name="domain" class="form-control">
		</div>
		
		<input type="button" id="addBtn" class="btn btn-success btn-block mt-4" value="추가">		<%-- btn-block : 위의 행이랑 너비 맞춤 --%>
	
	</div>
	
	
	<script>
	
		$(document).ready(function() {
			
			$('#addBtn').on('click', function() {
				
				// validation check
				let title = $("#title").val().trim();
				let domain = $("#domain").val().trim();
				
				console.log(title);
				console.log(domain);
				
				if (!title) {
					alert("제목을 입력하세요");
					return;	
				}
				
				if (domain == "") {
					alert("주소를 입력하세요");
					return;	
				}
				
				
				// http 또는 https 프로토콜까지 모두 입력되었는지 validation 코드를 추가하세요
				if(url.startsWith("http://") == false &&
						url.startsWith("https://") == false) {
					
					alert("주소 형식이 잘못되었습니다");
					return;
				}
				
				
				// AJAX 통신
				$.ajax({
					
					// request  
					type:"post"
					, url:"/lesson06/quiz01/add-bookmark"
					, data:{"title":title, "domain":domain}
					
					// response
					, success:function(data) {	// data: response의 응답값 (JSON String) => Dictionary Object가 됨
						
						// data는 JSON String => Object로 변환된 형태로 사용할 수 있다
						// jquery의 ajax 함수 기능이기 때문에
						
						/* alert(data.code);
						alert(data.result); */
						
						if (data.code == 200) {		// data.code == 200  or  data.result == "success"
							
							location.href = "/lesson06/quiz01/bookmark-list-view";
						}
					}
					, error:function(request, status, error) {
						alert("추가에 실패했습니다. 관리자에게 문의해주세요");
					}
				
				});
				
			});
			
			
			
		});
	
	
	
	
	
	</script>

</body>
</html>