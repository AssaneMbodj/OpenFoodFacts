<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${produit.nom}</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <header>
        <!-- Même header que index.jsp -->
    </header>

    <div class="product-details">
        <h2>${produit.nom}</h2>
        <img src="${produit.photoUrl}" alt="Photo du produit">
        
        <div class="nutrition-info">
            <h3>Composition nutritionnelle :</h3>
            <p>${produit.compositionNutritionnelle}</p>
        </div>

        <div class="ingredients">
            <h3>Ingrédients :</h3>
            <p>${produit.ingredients}</p>
        </div>
    </div>
</body>
</html>