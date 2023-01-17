<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>방 목록 : The Mind =◕.◕=</title>
</head>
<body>
	<button type="button" class="listDropdown" data-room-num="1" onclick="javascript:open('1');"><span>1</span></button>
	<button type="button" class="listDropdown" data-room-num="2" onclick="javascript:open('2');"><span>2</span></button>
	<button type="button" class="listDropdown" data-room-num="3" onclick="javascript:open('3');"><span>3</span></button>
	
	<script type="text/javascript">
		function open(roomNum){
			location.href="/gameRoom/"+roomNum
		}
	</script>
</body>
</html>