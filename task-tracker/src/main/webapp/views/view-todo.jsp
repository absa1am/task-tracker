<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/30/2023
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>View Task - Task Tracker</title>

        <%@include file="layouts/styles.jsp"%>
    </head>
    <body>
        <!-- navigation section -->
        <%@include file="layouts/nav.jsp"%>

        <!-- main section -->
        <div class="container mt-5 mb-5">
            <div class="row">
                <h2 class="text-center">Task Details</h2>
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <b>Task</b>: ${task.getName()}
                        </li>
                        <li class="list-group-item">
                            <b>Status</b>: ${task.getStatus()}
                        </li>
                        <li class="list-group-item">
                            <b>Description</b>: ${task.getDescription()}
                        </li>
                        <li class="list-group-item">
                            <b>Deadline</b>: ${task.getStartDate()} - ${task.getEndDate()}
                        </li>
                    </ul>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>

        <%@include file="layouts/footer.jsp"%>

        <%@include file="layouts/scripts.jsp"%>
    </body>
</html>
