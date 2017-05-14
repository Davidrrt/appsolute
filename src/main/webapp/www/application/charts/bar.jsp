
<div class="row ">
    <div class="col-lg-6 col-lg-offset-1" >
        <div class="border-head ">
            <h3><s:text name="bartitre"></s:text></h3>
        </div>
        <div class="custom-bar-chart">
            <ul class="y-axis">
                <li><span>100</span></li>
                <li><span>80</span></li>
                <li><span>60</span></li>
                <li><span>40</span></li>
                <li><span>20</span></li>
                <li><span>0</span></li>
            </ul>
            <c:forEach items="${bar}" var="bar">
                <div class="bar">
                    <div class="bar">
                        <div class="title">${bar.titre}</div>
                        <div class="value tooltips" data-original-title="${bar.data}%" data-toggle="tooltip" data-placement="top" style="background: ${bar.color};">${bar.data}%</div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
