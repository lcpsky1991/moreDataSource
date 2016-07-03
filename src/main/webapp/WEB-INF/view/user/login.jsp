<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  	<head>
    	<base href="<%=basePath%>">
    
	    <title>用户登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">    
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
  	</head>
  	<body>
  		<form action="user/login" method="post">
  			<table>
  				<tr>
  					<td>用户类型：</td>
  					<td>
  						<select name="type">
  							<option value="0" selected="selected">前台用户</option>
  							<option value="1">后台用户</option>
  						</select>
  					</td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>用户名：</td>
  					<td><input type="text" name="username" value="" /></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td>密&nbsp;&nbsp;码：</td>
  					<td><input type="password" name="password" value="" /></td>
  					<td></td>
  				</tr>
  				<tr>
  					<td></td>
  					<td><input type="submit" value="登录" /></td>
  					<td></td>
  				</tr>
  			</table>
  		</form>
  	</body>
</html>