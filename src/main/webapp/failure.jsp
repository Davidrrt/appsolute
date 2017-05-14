
<!DOCTYPE HTML>
<html>
<head>
<title>Poses-404 Website Template | Home :: W3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="www/assets/css/404.css">
</head>
<body>
<div class="wrap">
	<div class="banner">
            <img src="assets/img/tsakisnack_logot.png" alt=""/>
	</div>
	<div class="page">
            <h2>page introuvable!</h2>
            <% if(request.getSession().getAttribute("utilisateur")!=null){%>
            <h2>CAUSE: <% out.print(request.getAttribute("error")); %> </h2>
             <a href="index.html">Accueil</a>
            <%}else{ %>
               <h2>CAUSE: <% out.print(request.getAttribute("error")); %> </h2>
            <a href="index.html">Accueil</a>
           
            <% } %>
	</div>
</div>
</body>
</html>
