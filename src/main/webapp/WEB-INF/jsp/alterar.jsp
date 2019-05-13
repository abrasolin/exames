 <!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Exclusão de Agendamento de Exame</title>
<style type="text/css">
.button-register {background-color: green;color: white;}
.button-report {background-color: #000000;color: white;margin-left: 30%;}
</style>
	<s:head/>
</head>
<body>
            <div>
            	<h3>Alteração</h3>
                <hr />
            </div>

	<s:form action="alterar.action" method="post">
	
		<input type="hidden"name="id" value='<s:property value="id"/>'>
	    Data do Agendamento: <input type="text"  name="dataExame" value='<s:property value="dataExame"/>'>
        <br>
        Código Cliente: <input type="text"  name="codigoCliente" value='<s:property value="codigoCliente"/>'>
        <br>
        Nome Cliente: <input type="text"  name="nomeCliente" value='<s:property value="nomeCliente"/>'>
        <br>
        Código Exame: <input type="text"  name="codigoExame" value='<s:property value="codigoExame"/>'>
        <br>
        Nome Exame: <input type="text"  name="nomeExame" value='<s:property value="nomeExame"/>'>
		<br>

		<s:submit cssClass="button" value="Alterar" />
	</s:form>

	
</body>
</html>
	