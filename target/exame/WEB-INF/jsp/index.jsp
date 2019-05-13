<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Exames</title>
	<style>
	table, td, th {border: 1px solid black;}
	table {border-collapse: collapse;width: 100%;}
	th {height: 30px;}
	.button-update {background-color: #008CBA;color: white;}
	.button-delete {background-color: red;color: white;}
	</style>
	<s:head />
</head>
<body>
	
	<a href="novo.action">
		<button class="button-update">Incluir</button>
	</a>
	
	
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
						<td><s:date name="data" format="dd/MM/yyyy" /></td>
						<td><s:property value="codigoCliente" /> - <s:property value="nomeCliente" /></td>
						<td><s:property value="codigoExame" /> - <s:property value="nomeExame" /></td>
						<td>
							<a href="updatedetails.action?submitType=updatedata&id=<s:property value="id"/>">
								<button class="button-update">Alterar</button>
							</a>
							<a href="deleterecord.action?id=<s:property value="id"/>">
								<button class="button-delete">Excluir</button>
							</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<div style="color: red;">Não foram encontrados agendamentos de exames</div>
		</s:else>
	</div>
	
	
</body>
</html>
	