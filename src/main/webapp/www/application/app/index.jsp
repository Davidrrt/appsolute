
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">    
        <link href="www/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="www/assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="www/assets/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section id="container">
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="billet.html" class="logo">
                    <b>Admin</b></a>
                <!--logo end-->

                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li><a class="logout" href="logout.html">Logout</a></li>
                    </ul>
                </div>
            </header>
            <aside>
                <div id="sidebar" class="nav-collapse " tabindex="5000" style="overflow: hidden; outline: none; margin-left: 0px;">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion" style="display: block;">

                        <p class="centered"><a href="app.html"><img src="www/assets/logo-app.png"  style="width: 210px;"></a></p>


                        <li class="mt">
                            <a class="active"  href="app.html">
                                <i class="fa fa-tablet"></i>
                                <span>Gestion App</span>
                            </a>
                        </li>

                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <section id="main-content">
                <section class="wrapper">
                    <div class="row mt">
                        <div class="col-lg-offset-1 col-lg-10">
                            <div class="white-panel pn" style="margin-bottom: 7px;padding-bottom: 770px;">
                                <div class="panel-heading">
                                    <div class="pull-left"><h5><i class="fa fa-tablet"></i>Gestion Application</h5></div>
                                    <br>
                                </div>
                                <div class="custom-check goleft mt" style="padding-left: 25px;padding-right: 25px;">
                                    <s:a action="add.html" cssClass="btn btn-default"><i class="fa fa-plus"></i>Ajout</s:a>
                                        <br><br>
                                        <table class="table table-striped"  cellpadding="2" cellspacing="2">
                                            <thead>
                                                <tr>          
                                                    <th>Illustration</th>
                                                    <th>titre</th>
                                                    <th>Contenu</th>
                                                    <th>option</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${table}" var="pr">
                                                <tr>
                                                    <td><img src="www/assets/img/${pr.imageactu}" style="border-radius: 28px;width: 113px;height: 113px;"/></td>
                                                    <td>${pr.titreactu}</td>
                                                    <td>${pr.introactu}</td>
                                                    <td>

                                                        <a href="delete.html?id=${pr.id}&img=${pr.imageactu}" class="btn btn-danger" onclick="return confirm('Are you sure ?')"><i class="fa fa-close"></i></a>
                                                        <a href="edit.html?id=${pr.id}" class="btn btn-primary"><i class="fa fa-edit"></i></a>
                                                        <a href="album.html?id=${pr.id}" class="btn btn-default"><i class="fa fa-photo"></i>Album</a>
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
                    </div>
                </section>
            </section>
        </section>
    </body>
</html>