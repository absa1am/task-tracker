
<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/23/2023
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <base>
        <title>To Do - Task Tracker</title>

        <!-- styles -->
        <%@include file="layouts/styles.jsp"%>
    </head>
    <body>
        <!-- navigation section -->
        <%@include file="layouts/nav.jsp"%>

        <!-- main section -->
        <div class="container mt-5 mb-5">
            <div class="row">
                <div class="col-lg-4">
                    <h2 class="text-center">New Tasks</h2>
                    <form action="todo" method="post">
                        <div class="mb-3 mt-3">
                            <label for="name">Task</label>
                            <input type="text" id="name" class="form-control" placeholder="Your task" name="name">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="description">To Do</label>
                            <textarea id="description" class="form-control" rows="5" name="description" placeholder="Your task lists"></textarea>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="startDate">Start Date</label>
                            <input type="date" id="startDate" class="form-control" name="startDate">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="endDate">End Date</label>
                            <input type="date" id="endDate" class="form-control" name="endDate">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="taskStatus" class="form-label">Task Status</label>
                            <select class="form-select" id="taskStatus" name="taskStatus">
                                <c:forEach var="item" items="${status}">
                                    <option value="${item.getId()}">${item.getStatus()}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">Create Task</button>
                    </form>
                </div>
                <dib class="col-lg-4">
                    <h2 class="text-center">Status List</h2>
                    <table class="table table-hover table-bordered">
                        <thead>
                            <th class="text-center">ID</th>
                            <th class="text-center">Status</th>
                        </thead>
                        <tbody class="table-group-divider">
                            <c:forEach var="item" items="${status}">
                                <tr>
                                    <td class="text-center"><c:out value="${item.getId()}" /></td>
                                    <td class="text-center"><c:out value="${item.getStatus()}" /></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </dib>
                <div class="col-lg-4">
                    <h2 class="text-center">New Status</h2>
                    <form action="add-status" method="post">
                        <div class="mb-3 mt-3">
                            <label for="status">Status</label>
                            <input type="text" id="status" class="form-control" placeholder="Your status" name="status">
                        </div>
                        <button type="submit" class="btn btn-primary">Create Status</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- footer section -->
        <%@include file="layouts/footer.jsp"%>>

        <!-- scripts -->
        <%@include file="layouts/scripts.jsp"%>
    </body>
</html>
