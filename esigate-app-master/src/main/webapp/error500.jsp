<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Timeout example</title>
</head>
<body style="background-color: yellow">
Nothing should appear bellow as the included block does not work at all
<br />
<esi:try>
<esi:attempt><esi:include src="$(PROVIDER{default})error500.jsp" fragment="block1" /></esi:attempt>
<esi:except code="500">500 Internal_Server_Error</esi:except>
</esi:try>
</body>
</html>