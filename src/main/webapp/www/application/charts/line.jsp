

<div class="row">

    <div class="col-lg-6 col-lg-offset-1">
         <h4 style="margin-left: 229px;"><i class="fa fa-angle-right"></i>Line</h4>
        <canvas id="line" height="300" width="700"></canvas>
    </div>
</div>
 <jsp:include page="../include/footer.jsp"/>
<script type="text/javascript">
    var Script = function () {
        var lineChartData = {
            labels: ["janvier", "fevrier", "mars", "avril", "juin", "juillet", "aout", ""],
            datasets: [
                {
                    fillColor: "rgba(255, 255, 255, 0.45)",
                    strokeColor: "#d00e0e",
                    pointColor: "#d00e0e",
                    pointStrokeColor: "#d00e0e",
                    data: [0.1, 0.5, 0.2, 0.9, 1, 0.1, 0.8, 0.6]
                }
            ]

        };
        new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
    }();
</script>