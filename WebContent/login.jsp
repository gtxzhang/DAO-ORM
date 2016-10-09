<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
	用户名：<input type="text" name="mid" id="mid"><br>
	密码：<input type="password" name="password" id="password"><br>
	<input type="submit" value="登录">
</form>
<%
	List<String> allErrors = (List<String>) request.getAttribute("err") ;
	Iterator<String> iter = allErrors.iterator() ;
	while (iter.hasNext()) {
%>
		<li><%=iter.next()%></li>
<%
	}
%>
</body>
</html> 