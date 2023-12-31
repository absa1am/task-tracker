
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
                    <c:if test="${sessionScope.containsKey('danger')}">
                        <div class="alert alert-danger" role="alert">
                            <div>${sessionScope.get("danger")}</div>
                        </div>
                        ${sessionScope.remove("danger")}
                    </c:if>

                    <c:if test="${sessionScope.containsKey('success')}">
                        <div class="alert alert-success" role="alert">
                            <div>${sessionScope.get("success")}</div>
                        </div>
                        ${sessionScope.remove("success")}
                    </c:if>
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr>
                                <th class="text-center">ID</th>
                                <th class="text-center">Task</th>
                                <th class="text-center">Status</th>
                                <th class="text-center">Start Date</th>
                                <th class="text-center">End Date</th>
                                <th class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach var="item" items="${tasks}">
                                <tr>
                                    <td class="text-center"><c:out value="${item.getId()}"/></td>
                                    <td class="text-center"><c:out value="${item.getName()}"/></td>
                                    <td class="text-center"><c:out value="${item.getStatus()}"/></td>
                                    <td class="text-center"><c:out value="${item.getStartDate()}"/></td>
                                    <td class="text-center"><c:out value="${item.getEndDate()}"/></td>
                                    <td class="text-center">
                                        <a class="btn btn-outline-secondary" href="edit-todo?id=${item.getId()}"><i class="bi bi-pencil-square"></i></a>
                                        <form action="delete-todo" method="post" class="form-check-inline m-0">
                                            <input type="hidden" name="id" class="form-control" value="${item.getId()}">
                                            <button type="submit" class="btn btn-outline-danger btn"><i class="bi bi-trash-fill"></i></button>
                                        </form>
                                        <a class="btn btn-outline-info" href="view-todo?id=${item.getId()}"><i class="bi bi-eye-fill"></i></a>
                                    </td>
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
