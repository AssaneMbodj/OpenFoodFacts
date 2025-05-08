<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rappels Conso</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <header>
        <!-- Même header que index.jsp -->
    </header>

    <div class="recall-list">
        <c:forEach items="${rappels}" var="rappel">
            <div class="recall-item">
                <a href="details-rappel?id=${rappel.id}">
                    <h3>${rappel.nomProduit}</h3>
                    <p>Date du rappel : ${rappel.dateRappel}</p>
                </a>
            </div>
        </c:forEach>
    </div>
</body>
</html>