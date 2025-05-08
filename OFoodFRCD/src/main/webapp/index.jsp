<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Open Food Fact & Rappel Conso</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <header>
        <div class="logo">
            <h1>Open Food Fact & Rappel Conso</h1>
        </div>
        <nav>
            <a href="recherche-produit">Rechercher un produit</a>
            <a href="rappels-conso">Voir les rappels</a>
        </nav>
    </header>

    <div class="search-container">
        <form action="recherche-produit" method="get">
            <input type="text" name="terme" placeholder="Nom du produit...">
            <button type="submit">Rechercher</button>
        </form>
    </div>
</body>
</html>