<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
	table {border-collapse : collapse; width : 100%}
	th, td {border:solid 1px #000;}
</style>
<title>My Java Environment!!</title>
</head>
<body>
<h3>�ڹ� ȯ�� ����</h3>

<table border = 1 width = "600">
	<tr>
		<th>Ű</th>
		<th>�Ӽ�</th>
	</tr>
<% for(Object k : System.getProperties().keySet()){
	String key = k.toString();
	String value = System.getProperty(key);
%>  <tr>
		<td><%=key%></td>
		<td><%=value%></td>
	</tr>
	<% } %>
	
</table>
</body>
</html>