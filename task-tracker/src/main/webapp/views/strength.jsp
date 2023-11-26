<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/23/2023
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="col-lg-3"></div>
                <div class="col-lg-6 justify-content-center">
                    <h2 class="text-center">My Strength</h2>

                    <canvas id="myChart"></canvas>
                </div>
                <div class="col-lg-3"></div>
            </div>
        </div>

        <!-- footer section -->
        <%@include file="layouts/footer.jsp"%>>

        <!-- scripts -->
        <%@include file="layouts/scripts.jsp"%>
    </body>
</html>
