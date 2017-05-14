
<jsp:include page="../include/header.jsp"/>
<div class="row">
    <div class="col-md-2">
        <h1 style="float: right;position: absolute;margin-top: 103px;margin-left: 93px;">70%</h1>
        <canvas id="serverstatus01" height="250" width="250"></canvas>
        <h4 style="margin-left: 95px;">Titre</h4>
    </div>
    <div class="col-md-2">
        <h1 style="float: right;position: absolute;margin-top: 103px;margin-left: 93px;">40%</h1>
        <canvas id="serverstatus02" height="250" width="250"></canvas>
        <h4 style="margin-left: 95px;">Titre</h4>
    </div>
</div>
<jsp:include page="../include/footer.jsp"/>
<% String wawa = "var doughnutData = [{value: 70,color: \"#ffd777\" },{value: 30,color: \"#fdfdfd\" }]; var myDoughnut =  new Chart(document.getElementById(\"serverstatus01\").getContext(\"2d\")).Doughnut(doughnutData);";%>
<script>
    <% out.print(wawa); %>
    var doughnutData1 = [
        {
            value: 40,
            color: "#167ac6"
        },
        {
            value: 60,
            color: "#fdfdfd"
        }
    ];
    var myDoughnut2 = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData1);
</script>
