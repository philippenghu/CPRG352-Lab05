

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <div>  
                <label>Username:</label>
                <input type="text" name="username" value="${user.username}">
            </div> 

            <div>  
                <label>Password:</label>
                <input type="password" name="password" value="${user.password}">
            </div> 
            <div>   
                <input type="submit" value="Log in"> 
            </div>
                </form>
                <p>${message}</p>
                </body>
                </html>
