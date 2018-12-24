<%@ page contentType="text/html;charset=GB2312"%>
<%@ page isErrorPage="true"%>
<html>
<head>
<title>错误页面</title>
</head>
<body>
	出错了：
	<p>
	错误信息:
	<%=exception.getMessage()%><br> Stack Trace is :
	<pre>
		<font color="red">
			<%
				java.io.CharArrayWriter cw = new java.io.CharArrayWriter();
				java.io.PrintWriter pw = new java.io.PrintWriter(cw, true);
				exception.printStackTrace(pw);
				out.println(cw.toString());
			%>
		</font>
	</pre>
	</p>
</body>
</html>
