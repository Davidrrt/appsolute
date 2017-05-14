
<style>
    #cercle{
        width: 34px;
        height: 34px;
        border-radius: 20px;
    }
    #cercleL{
        margin-left: -13px;
        margin-top: 2px;
        height: 29px;
        border-radius: 29px;
    }
</style>
<div class="row">
    <div class="col-lg-4 col-lg-offset-1">

        <h4><i class="fa fa-angle-right"></i>Pie</h4>

        <canvas id="pie" height="400" width="500"></canvas>

    </div>
    <div class="col-lg-6">
        <div class="row">
            <br>
            <div class="col-lg-12">
                <div class="col-lg-3" id="cercle" style="background: #ffffff;"><div class="col-lg-1" id="cercleL" style="background: green;"></div></div>
                <div class="col-lg-6"><h4>test (10 %)</h4></div>
            </div>
        </div>
       
    </div>
</div>
 <jsp:include page="../include/footer.jsp"/>
<script type="text/javascript">
    var Script = function () {
        var pieData = [
            {
                value: 10,
                color: "#1abc9c"
            },
            {
                value: 40,
                color: "#16a085"
            },
            {
                value: 40,
                color: "#1abc9c"
            },
            {
                value: 80,
                color: "#27ae60"
            }

        ];
        new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
    }();
</script>