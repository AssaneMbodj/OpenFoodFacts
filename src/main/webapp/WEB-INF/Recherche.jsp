<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recherche de produits</title>

</head>
<body>
    <div class="container mt-4">
        <form action="Recherche" method="post" class="mb-5">
            <div class="row g-3">
                <div class="col-md-3">
                    <select name="typeRecherche" class="form-select">
                        <option value="nom">Nom</option>
                        <option value="ingredient">Ingrédient</option>
                        <option value="code">Code-barres</option>
                    </select>
                </div>
                <div class="col-md-6">
                    <input type="text" 
                           name="terme" 
                           class="form-control" 
                           placeholder="Entrez votre recherche...">
                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-success w-100">🔍 Rechercher</button>
                </div>
            </div>
        </form>

        <c:if test="${not empty resultats}">
            <h3 class="mb-4">${resultats.size()} résultats trouvés</h3>
            <div class="row row-cols-1 row-cols-md-3 g-4">
                <c:forEach items="${resultats}" var="produit">
                    <div class="col">
                        <div class="card h-100">
                            <img src="${produit.urlPhoto}" class="card-img-top" alt="Photo produit">
                            <div class="card-body">
                                <h5 class="card-title">${produit.nom}</h5>
                                <p class="text-muted">${produit.codeBarres}</p>
                                <a href="ProduitController?codeBarres=${produit.codeBarres}" 
                                   class="btn btn-outline-primary">Voir détails</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>

        <c:if test="${not empty message}">
            <div class="alert alert-warning mt-4">${message}</div>
        </c:if>
    </div>
</body>
</html>