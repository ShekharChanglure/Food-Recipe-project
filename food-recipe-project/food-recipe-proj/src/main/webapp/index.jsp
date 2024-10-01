<%@ page language="java" contentType="text/html; charset=US-ASCII"  pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Food Recipe Application</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: #f5f5f5;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: center;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        nav ul li {
            display: inline;
            margin-right: 20px;
        }

        nav a {
            color: #fff;
            text-decoration: none;
            font-weight: bold;
            font-size: 16px;
        }

        main {
            flex: 1;
            padding: 20px;
        }

        footer {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: center;
        }

        .social-media a {
            color: #fff;
            text-decoration: none;
            margin: 0 15px;
            font-size: 18px;
        }

        h2 {
            color: #333;
        }



        button:hover {
            background-color: #495057;
        }

        p {
            font-size: 16px;
            line-height: 1.5;
            color: #555;
        }
    </style>
</head>
<body>
    <header>
        <h1>Food Recipe App</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="login.jsp">Sign In</a></li>
                <li><a href="register.jsp">Sign Up</a></li>
                <li><a href="getUsers">Users List</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <h2>Welcome to our Food Recipe Application!</h2>
        <p>Explore delicious recipes and start cooking today. Discover a world of flavors and culinary delights.</p>
    </main>

    <footer>
        <div class="social-media">
            <a href="https://facebook.com">Facebook</a>
            <a href="https://twitter.com">Twitter</a>
            <a href="https://instagram.com">Instagram</a>
        </div>
    </footer>
</body>
</html>
