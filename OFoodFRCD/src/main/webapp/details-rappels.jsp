<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${rappel.nomProduit}</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <header>
        <!-- Même header que index.jsp -->
    </header>

    <div class="recall-details">
        <h2>${rappel.nomProduit}</h2>
        <p>Date du rappel : ${rappel.dateRappel}</p>
        
        <div class="recall-info">
            <h3>Détails :</h3>
            <p>${rappel.details}</p>
        </div>
    </div>
</body>
</html>