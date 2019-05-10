<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Index</title>
	<style>
	table, td, th {border: 1px solid black;}
	table {border-collapse: collapse;width: 60%;}
	th {height: 30px;}
	.button-update {background-color: #008CBA;color: white;}
	.button-delete {background-color: red;color: white;}
	</style>
	<s:head />
</head>
<body>
	<s:form action="helloWorld">
		<s:textfield label="What is your name?" name="name" />
		<s:textfield label="What is the date?" name="dateNow" />
		<s:submit />
	</s:form>
	
	
	<div style="margin-top: 40px;">
		<s:if test="noData==true">
			<table>
				<thead>
					<tr style="background-color: #E0E0E1;">
						<th>Data</th>
						<th>Cliente</th>
						<th>Exame</th>
					</tr>
				</thead>
				<s:iterator value="agendaLista">
					<tr>
						<td><s:property value="data" /></td>
						<td><s:property value="codigoCliente" />-<s:property value="nomeCliente" /></td>
						<td><s:property value="codigoExame" />-<s:property value="nomeExame" /></td>
						<td>
							<a href="updatedetails.action?submitType=updatedata&id=<s:property value="id"/>">
								<button class="button-update">Update</button>
							</a>
							<a href="deleterecord.action?id=<s:property value="id"/>">
								<button class="button-delete">Delete</button>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">No Data Found.</div>
		</s:else>
	</div>
	
	
</body>
</html>
	