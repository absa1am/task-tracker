<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/28/2023
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Edit Task - Task Tracker</title>

        <%@include file="layouts/styles.jsp"%>
    </head>
    <body>
        <!-- navigation section -->
        <%@include file="layouts/nav.jsp"%>

        <!-- main section -->
        <div class="container mt-5 mb-5">
            <div class="row">
                <dib class="col-lg-4"></dib>
                <div class="col-lg-4">
                    <h2 class="text-center">Edit Tasks</h2>
                    <form action="edit-todo?id=${task.getId()}" method="post">
                        <div class="mb-3 mt-3">
                            <label for="name">Task</label>
                            <input type="text" id="name" class="form-control" placeholder="Your task" name="name" value="${task.getName()}" required>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="description">To Do</label>
                            <textarea id="description" class="form-control" rows="5" name="description" placeholder="Your task lists">${task.getDescription()}</textarea>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="startDate">Start Date</label>
                            <input type="date" id="startDate" class="form-control" name="startDate" value="${task.getStartDate()}" required>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="endDate">End Date</label>
                            <input type="date" id="endDate" class="form-control" name="endDate" value="${task.getEndDate()}" required>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="taskStatus" class="form-label">Task Status</label>
                            <select class="form-select" id="taskStatus" name="taskStatus">
                                <c:forEach var="item" items="${status}">
                                    <option value="${item}" <c:if test="${item == task.getStatus()}">selected</c:if> >${item}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" class="btn btn-primary">Edit Task</button>
                    </form>
                </div>
                <div class="col-lg-4"></div>
            </div>
        </div>

        <!-- footer section -->
        <%@include file="layouts/footer.jsp"%>

        <!-- scripts section -->
        <%@include file="layouts/scripts.jsp"%>
    </body>
</html>
