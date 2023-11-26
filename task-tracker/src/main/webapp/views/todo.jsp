<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/23/2023
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="col-lg-4 justify-content-center">
                    <h2 class="text-center">New Tasks</h2>
                    <form action="#" method="post">
                        <div class="mb-3 mt-3">
                            <label for="task">Task</label>
                            <input type="text" class="form-control" placeholder="Your task" name="task">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="todo">To Do</label>
                            <textarea class="form-control" rows="5" name="text" placeholder="Your task lists"></textarea>
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="startDate">Start Date</label>
                            <input type="date" class="form-control" name="startDate">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="endDate">End Date</label>
                            <input type="date" class="form-control" name="endDate">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="taskStatus" class="form-label">Task Status</label>
                            <select class="form-select" name="taskStatus">
                                <option value="Pending">Pending</option>
                                <option value="In Progress">Progressing</option>
                                <option value="Completed">Completed</option>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary">Create Task</button>
                    </form>
                </div>
                <dib class="col-lg-4 justify-content-center"></dib>
                <div class="col-lg-4 justify-content-center">
                    <h2 class="text-center">New Status</h2>
                    <form action="#" method="post">
                        <div class="mb-3 mt-3">
                            <label for="task">Status</label>
                            <input type="text" class="form-control" placeholder="Your status" name="status">
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
