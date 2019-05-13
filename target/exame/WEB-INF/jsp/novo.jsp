 <!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Inclusão de Agendamento de Exame</title>
<style type="text/css">
.button-register {background-color: green;color: white;}
.button-report {background-color: #000000;color: white;margin-left: 30%;}
</style>
	<s:head />
</head>
<body>
	<s:form action="incluir.action" method="post">
	
	
	   <s:date label="Data do Agendamento:" name = "dataExame" format = "dd/MM/yyyy" />
	   
		<s:textfield label="Código do Paciente:" name="codigoCliente" />
		<s:textfield label="Nome do Paciente:" name="nomeCliente" />
		<s:textfield label="Código do Exame:" name="codigoExame" />
		<s:textfield label="Nome do Exame:" name="nomeExame" />
		<s:submit cssClass="button" value="Salvar" />
	</s:form>

	
</body>
</html>
	