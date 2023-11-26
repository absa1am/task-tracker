<%--
  Created by IntelliJ IDEA.
  User: DSi
  Date: 11/22/2023
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <th scope="col" class="text-center">#</th>
                                <th scope="col" class="text-center">Task</th>
                                <th scope="col" class="text-center">Status</th>
                                <th scope="col" class="text-center">Action</th>
                            </tr>
                        </thead>
                        <tbody class="table-group-divider">
                            <tr>
                                <th scope="row" class="text-center">1</th>
                                <td class="text-center">Mark</td>
                                <td class="text-center">Otto</td>
                                <td class="text-center">View | Edit | Delete |</td>
                            </tr>
                            <tr>
                                <th scope="row" class="text-center">2</th>
                                <td class="text-center">Mark</td>
                                <td class="text-center">Otto</td>
                                <td class="text-center">View | Edit | Delete |</td>
                            </tr>
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
