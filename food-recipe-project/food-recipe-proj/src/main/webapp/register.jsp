<%@ page language="java" contentType="text/html; charset=US-ASCII"  pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - Food Recipe App</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        header {
            background-color: #343a40;
            color: #ffffff;
            padding: 20px;
            text-align: center;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        nav li {
            display: inline;
            margin-right: 20px;
        }

        nav a {
            text-decoration: none;
            color: #ffffff;
            font-weight: bold;
        }

        main {
            padding: 20px;
        }

        form {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #343a40;
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #343a40;
        }

        input, textarea {
            width: 100%;
            padding: 12px;
            margin-bottom: 16px;
            border: 1px solid #ced4da;
            border-radius: 6px;
            box-sizing: border-box;
        }

        button {
            padding: 15px 25px;
            background-color: #343a40;
            color: #ffffff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #495057;
        }

        p {
            text-align: center;
            font-size: 16px;
            color: #495057;
            margin-top: 20px;
        }

        a {
            color: #343a40;
            text-decoration: underline;
        }

        a:hover {
            color: #495057;
        }

        footer {
            background-color: #343a40;
            color: #ffffff;
            padding: 10px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        .social-media a {
            color: #ffffff;
            margin: 0 10px;
            text-decoration: none;
        }

        .social-media a:hover {
            color: #ced4da;
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
            </ul>
        </nav>
    </header>

    <main>
        <form action="register" method="post">
            <h2>Register</h2>
                        <label for="firstName">First Name:</label>
                        <input type="text" id="firstName" name="firstName" required>

                        <label for="lastName">Last Name:</label>
                        <input type="text" id="lastName" name="lastName" required>

                        <label for="emailId">Email:</label>
                        <input type="email" id="emailId" name="emailId" required>

                        <label for="contactNumber">Contact Number:</label>
                        <input type="tel" id="contactNumber" name="contactNumber" required>

                        <label for="alternativeNumber">Alternative Number:</label>
                        <input type="tel" id="alternativeNumber" name="alternativeNumber">

                        <label for="foodType">Food Type:</label>
                        <input type="text" id="foodType" name="foodType" required>

                        <label for="address">Address:</label>
                        <textarea id="address" name="address" rows="4" required></textarea>

                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>

                        <label for="confirmPassword">Confirm Password:</label>
                        <input type="password" id="confirmPassword" name="confirmPassword" required>

                        <div>
                            <button type="submit">Sign Up</button>
                            <button type="button" onclick="location.href='index.jsp'">Cancel</button>
                        </div>
        </form>
        <p>Already have an account? <a href="login.jsp">Sign In</a></p>
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
