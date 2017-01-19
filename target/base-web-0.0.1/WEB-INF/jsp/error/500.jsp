<%@ page language="java" import="org.slf4j.Logger,org.slf4j.LoggerFactory" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Exception ex = (Exception)request.getAttribute("exception");
		final Logger logger = LoggerFactory.getLogger("error");
		logger.error("500系统内部错误!", ex);
		
		out.print("500系统内部错误! exception:"+ex.getMessage());
	%>
</body>
</html>