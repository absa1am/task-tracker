
<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/22/2023
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <base>
        <title>Home - Task Tracker</title>

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
                    <h2 class="text-center">My Tasks</h2>
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th scope="col" class="text-center">ID</th>
                                <th scope="col" class="text-center">Task</th>
                                <th scope="col" class="text-center">Status</th>
                                <th scope="col" class="text-center">Start Date</th>
                                <th scope="col" class="text-center">End Date</th>
                                <th scope="col" class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach var="item" items="${tasks}">
                                <tr>
                                    <th class="text-center"><c:out value="${item.getId()}"/></th>
                                    <th class="text-center"><c:out value="${item.getName()}"/></th>
                                    <th class="text-center"><c:out value="${item.getStatusId()}"/></th>
                                    <th class="text-center"><c:out value="${item.getStartDate()}"/></th>
                                    <th class="text-center"><c:out value="${item.getEndDate()}"/></th>
                                    <th class="text-center">Edit | Delete | View</th>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-3"></div>
            </div>
        </div>

        <%@include file="layouts/footer.jsp"%>

        <%@include file="layouts/scripts.jsp"%>
    </body>
</html>
