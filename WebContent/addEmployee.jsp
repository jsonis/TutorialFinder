<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c" %>
<%@ taglib uri="/WEB-INF/displaytag-12.tld" prefix="display" %>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>USPS ? PostalOne!</TITLE>
<META http-equiv=Content-Type content="text/html; charset=windows-1252">
</HEAD>
<SCRIPT LANGUAGE="JavaScript" SRC="<%= request.getContextPath() %>/scripts/ajaxlib.js"></SCRIPT>
<script language=javascript type='text/javascript'> 
  
  	 function submit_data()
	{
		//var checkboxGroup = document.getElementById('submitCheckedList');
		var checkboxGroup = document.all['submitCheckedList'];
	
		// first check to see if at least one checkbox was selected
		var numCheckboxes = checkboxGroup.length;
		doSubmit = false;
	
	// this will be the case if there's only one row			
	if (numCheckboxes == undefined)
	{
		doSubmit = checkboxGroup.checked;
	} else
	{
		for (i = 0; i < numCheckboxes && !doSubmit; i++)
		{
	      	doSubmit = checkboxGroup[i].checked;
		}
	}
	
	if (doSubmit)
	{
		
	
	  document.forms[0].action="/PrsWeb/evs/webSamplingWorksheet.do?jspAction=Submit";
	  document.forms[0].submit();
	  return true;
			
	}
	else {
	alert('Select a Record to Submit');
	return false;
	}
 }
	function save_data(formValue)
	{
				
	document.forms[0].action="/PrsWeb/evs/webSamplingWorksheet.do?jspAction="+formValue;
	document.forms[0].submit();
					
	}

  function checkAll()
   {
	 var field = document.all['submitCheckedList'];
     for (i = 0; i < field.length; i++){
         field[i].checked = true;
    }
    document.getElementById('submitCheckedList').checked = true;
  }

 
  function refreshSortation(){
  	 mailClass=document.getElementById("displayClass");
   }
</SCRIPT>  


<body>
	<form action="process-Employee.html" method="post">
		<table>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="fname"></td>
			<tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lname"></td>
			<tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age"></td>
			<tr>
			<tr>
				<td>Sexx:</td>
				<td><input type="text" name="sex"></td>
			<tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country"></td>
			<tr>
			<tr>
				<td>Language:</td>
				<td><input type="text" name="language"></td>
			<tr>
			<tr>
				<td><input type="submit" value="add"></td>
			<tr>
		</table>
		</form>	
		<%
			String message =(String) request.getAttribute("message");
			if(!(message == null)){
				out.println(message);
			}else{
				message = "";
				out.println(message);
			}
		%>
	
	
	
<h1> All Employees </h1>
	<display:table name="sessionScope.employee" id="row" style="border: 0; width: 100%;" cellspacing="1" cellpadding="2" export="true" sort="list">
  		<display:column property="id" title="ID" />
  		<display:column property="fname" />
  		<display:column property="lname" />
  		<display:column property="sex" />
  		<display:column property="country" />
  		<display:column property="language" />
  		<display:column property="age" />
	</display:table>
	
</body>
</html>
