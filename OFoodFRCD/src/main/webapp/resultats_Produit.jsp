<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultats de recherche</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <header>
        <!-- Même header que index.jsp -->
    </header>

    <div class="product-list">
        <c:forEach items="${produits}" var="produit">
            <div class="product-item">
                <a href="details-produit?id=${produit.id}">
                    <h3>${produit.nom}</h3>
                    <img src="${produit.photoUrl}" alt="Photo du produit">
                </a>
            </div>
        </c:forEach>
    </div>
</body>
</html>