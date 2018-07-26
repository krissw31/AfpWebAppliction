<%-- 
    Document   : login
    Created on : 26 juil. 2018, 15:09:28
    Author     : kriss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login.jsp</title>
    </head>
    <body>
        <h1>Bienvenue sur la page de login</h1>
        <form action="./logVerif" method="post">
            Name : <input type="text" name="name"/>
            <br />
            <br />
            Mot de passe : <input type="password" name="password"/>
            <br/>
            <br/>
            <input type="submit" value="Connexion"/>
        </form>
        <p></p>
    </body>
</html>
