<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/26/2023
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login - Task Tracker</title>

        <%@ include file="layouts/styles.jsp"%>
    </head>
    <body>
        <%@ include file="layouts/nav.jsp"%>

        <!-- main section -->
        <div class="container mt-5 mb-5">
            <div class="row">
                <dib class="col-lg-4 justify-content-center"></dib>
                <div class="col-lg-4 justify-content-center">
                    <h2 class="text-center">Login</h2>
                    <form action="#" method="post">
                        <div class="mb-3 mt-3">
                            <label for="email">Email</label>
                            <input type="email" id="email" class="form-control" placeholder="Your email" name="email">
                        </div>
                        <div class="mb-3 mt-3">
                            <label for="password">Password</label>
                            <input type="password" id="password" class="form-control" name="password">
                        </div>

                        <div class="mb-3 mt-3">
                            <input type="submit" class="form-control btn btn-primary" value="Login">
                        </div>
                    </form>
                </div>
                <div class="col-lg-4 justify-content-center"></div>
            </div>
        </div>

        <%@ include file="layouts/footer.jsp"%>

        <%@ include file="layouts/scripts.jsp"%>
    </body>
</html>
