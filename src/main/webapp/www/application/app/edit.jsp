
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
                            <div class="white-panel pn" style="margin-bottom: 7px;padding-bottom: 850px;">
                                <div class="panel-heading">
                                    <div class="pull-left"><h5><i class="fa fa-tablet"></i>Modifier l'application</h5></div>
                                    <br>
                                </div>
                                <style>.label{color: black;font-size: 20px;font-weight: 100;}</style>
                                <div class="custom-check goleft mt" style="padding-left: 25px;padding-right: 25px;">

                                    <s:form method="post" action="predit.html">
                                        <s:hidden name="init.id"/>
                                        <s:textfield cssClass="form-control" cssStyle="margin-bottom:10px;"  label="titre" name="init.titreactu"></s:textfield>
                                        <s:textfield cssClass="form-control" cssStyle="margin-bottom:10px;" label="introduction" name="init.introactu"></s:textfield>
                                        <s:textfield cssClass="form-control" cssStyle="margin-bottom:10px;" label="Date" name="init.dateactu"></s:textfield>
                                          <s:hidden name="init.imageactu"/>
                                        <s:textarea cssClass="form-control" cssStyle=" margin: 0px 0px 10px; width: 1159px; height: 524px;" label="Contenu" name="init.contenuactu"></s:textarea>
                                        <s:submit cssClass="btn btn-primary" value="Enregistrer" align="right"></s:submit>
                                    </s:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </section>
        </section>
    </body>
</html>
