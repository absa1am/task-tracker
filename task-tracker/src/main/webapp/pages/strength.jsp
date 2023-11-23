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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="../public/bootstrap-5.3.2-dist/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    </head>
    <body>
        <!-- navigation section -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="/">TASK TRACKER</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                    <ul class="navbar-nav nav-underline">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/">Home</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link text-white" href="/task">My Tasks</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/todo">To Do</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="/strength">Strength</a>
                        </li>
                    </ul>
                </div>
                <div class="nav-item nav-underline justify-content-end">
                    <ul class="navbar-nav nav-underline">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="#">Contact Us</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- main section -->
        <div class="container mt-5 mb-5">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6 justify-content-center">
                    <h2 class="text-center">My Strength</h2>

                </div>
                <div class="col-lg-3"></div>
            </div>
        </div>

        <!-- footer section -->
        <footer class="text-white text-center text-lg-start bg-dark">
            <div class="text-center p-3">
                <p>© 2023 - Dynamic Solution Innovators Ltd.</p>
            </div>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="../public/bootstrap-5.3.2-dist/js/bootstrap.js"></script>
    </body>
</html>
