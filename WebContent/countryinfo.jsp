<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>USPS ? PostalOne!</TITLE>
<META http-equiv=Content-Type content="text/html; charset=windows-1252">
</HEAD>
<body>
<h1> Country and their Languages </h1>
<s:property value="bestTutorialSite" />

<table border="1px solid black">
	<tr>
		<th>Country Code</th>
		<th>Country Language</th>
		<th>Percentage</th>
	</tr>
	<s:iterator value="lstCountryLanguage">
		<tr>
			<td><s:property value="countryCode"/></td>
			<td><s:property value="language"/></td>
			<td><s:property value="percentage"/></td>
		</tr>
	</s:iterator>
	
</body>
</html>