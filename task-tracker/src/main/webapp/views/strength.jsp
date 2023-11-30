<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/23/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <base>
        <title>Strength - Task Tracker</title>

        <!-- styles -->
        <%@include file="layouts/styles.jsp"%>
    </head>
    <body>
        <!-- navigation section -->
        <%@include file="layouts/nav.jsp"%>

        <!-- main section -->
        <div class="container mt-5 mb-5">
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4 justify-content-center">
                    <h2 class="text-center">My Strength</h2>
                    <canvas id="myChart"></canvas>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>

        <!-- footer section -->
        <%@include file="layouts/footer.jsp"%>

        <!-- scripts -->
        <%@include file="layouts/scripts.jsp"%>

        <script>
            var total = ${strength.get('Total')};
            var pending = ${strength.get('Pending') * 100} / total;
            var processing = ${strength.get('Processing') * 100} / total;
            var completed = ${strength.get('Completed') * 100} / total;
            var backlog = ${strength.get('Backlog') * 100} / total;

            var xValues = ["Pending (%)", "Processing (%)", "Completed (%)", "Backlog (%)"];
            var yValues = [pending, processing, completed, backlog];

            var barColors = [
                "#e8c3b9",
                "#2b5797",
                "#1e7145",
                "#b91d47"
            ];

            new Chart("myChart", {
                type: "doughnut",
                data: {
                    labels: xValues,
                    datasets: [{
                        backgroundColor: barColors,
                        data: yValues
                    }]
                },
                options: {
                    title: {
                        display: true,
                        text: "Strength Report"
                    }
                }
            });
        </script>
    </body>
</html>
