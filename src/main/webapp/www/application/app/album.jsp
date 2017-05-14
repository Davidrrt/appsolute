

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <div class="white-panel pn" style="margin-bottom: 7px;padding-bottom: 1295px;">
                                <div class="panel-heading">
                                    <div class="pull-left"><h5><i class="fa fa-tablet"></i>Illustration</h5></div>
                                    <br>
                                </div>

                                <div class="custom-check goleft mt" style="padding-left: 25px;padding-right: 25px;">
                                    <a href="addal.html?id=<% out.print(request.getParameter("id"));%>" class="btn btn-default"><i class="fa fa-plus"></i>Ajout</a>
                                    <br><br>

                                    <c:forEach items="${album}" var="pr">
                                        <div class="col-lg-4">
                                            <img src="www/assets/img/illustration/${pr.img}" style="margin-top: 17px;height: 432px;"/>
                                            <a href="deleteal.html?id=${pr.id}&img=${pr.img}"  onclick="return confirm('Are you sure ?')"><i class="fa fa-close" style="position: absolute;float: left;margin-top: 11px;margin-left: 7px;font-size: 32px;color: black;"></i></a>
                                        </div>
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