package Servlet;

//RechercheProduitServlet.java
@WebServlet("/recherche-produit")
public class RechercheProduit extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response) {
     String terme = request.getParameter("terme");
     List<Produit> produits = new ProduitDAO().rechercherProduits(terme, 20);
     request.setAttribute("produits", produits);
     request.getRequestDispatcher("resultats-produits.jsp").forward(request, response);
 }
}