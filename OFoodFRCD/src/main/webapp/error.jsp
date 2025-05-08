<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Erreur</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <header>
        <!-- Même header que index.jsp -->
    </header>

    <div class="error-message">
        <h2>Erreur ${statusCode}</h2>
        <p>${errorMessage}</p>
        <a href="index.jsp">Retour à l'accueil</a>
    </div>
</body>
</html>