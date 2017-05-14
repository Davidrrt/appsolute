
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:form method="post" action="pradd.html" enctype="multipart/form-data">
            <s:textfield label="name" name="human.nomemp"></s:textfield>
            <s:textfield label="job" name="human.metier"></s:textfield>
            <s:textfield label="login" name="human.login"></s:textfield>
            <s:textfield label="pass" name="human.pass"></s:textfield>
            <s:textfield label="statut" name="human.statut"></s:textfield>
            <s:file label="image" name="upload"/>
            <s:submit value="Save" align="left"></s:submit>
        </s:form>
    </body>
</html>
