
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD</title>
        <meta http-equiv="Content-Type" content="text/html;">    
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-offset-2 col-lg-6">
                    <s:a action="add.html" cssClass="btn btn-default"><i class="fa fa-plus"></i>Ajout</s:a><s:a action="pdf.html" cssClass="btn btn-default"><i class="fa fa-floppy-o"></i>Export pdf</s:a><s:a action="#" cssClass="btn btn-default"><i class="fa fa-table"></i>Export excel</s:a>
                        <br><br>
                        <table class="table table-striped"  cellpadding="2" cellspacing="2">
                            <thead>
                                <tr>          
                                    <th>Nom</th>
                                    <th>login</th>
                                    <th>metier</th>
                                    <th>option</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${table}" var="pr">
                                <tr>
                                    <td>${pr.nomemp}</td>
                                    <td>${pr.login}</td>
                                    <td>${pr.metier}</td>
                                    <td>
                                        <s:url id="action_delete" action="delete">
                                            <s:param name="id">${pr.id}</s:param>
                                        </s:url>
                                        <s:a action="%{action_delete}" cssClass="btn btn-danger" onclick="return confirm('Are you sure ?')"><i class="fa fa-close"></i></s:a>
                                        <s:url id="action_edit" action="edit">
                                            <s:param name="id">${pr.id}</s:param>
                                        </s:url>
                                        <s:a action="%{action_edit}" cssClass="btn btn-primary" ><i class="fa fa-edit"></i></s:a>
                                        </td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <c:forEach items="${pied}" var="p">
                        <ul class="pagination"> 
                            ${p}
                        </ul>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>