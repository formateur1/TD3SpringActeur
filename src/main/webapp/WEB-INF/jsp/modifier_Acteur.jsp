<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<form action="updtActeur" method="POST" modelAttribute="acteur">
  <div class="mb-3">
    <label for="id" class="form-label" hidden="true">Identifiant</label>
    <input type="hidden" class="form-control" id="id" name="id" value="${ acteur.getId() }">
  </div>
  <div class="mb-3">
    <label for="nom" class="form-label">Nom</label>
    <input type="text" class="form-control" id="nom" name="nom" value="${ acteur.getNom() }">
  </div>
    <div class="mb-3">
    <label for="prenom" class="form-label">Prénom</label>
    <input type="text" class="form-control" id="prenom" name="prenom" value="${ acteur.getPrenom() }">
  </div>
    <div class="mb-3">
    <label for="email" class="form-label">Email</label>
    <input type="email" class="form-control" id="email" name="email" value="${ acteur.getEmail() }">
  </div>
    <div class="mb-3">
    <label for="ville" class="form-label">Ville</label>
    <input type="text" class="form-control" id="ville" name="ville" value="${ acteur.getVille() }">
  </div>
  <button type="submit" class="btn btn-primary">Valider</button>
  <button type="reset" class="btn btn-secondary">Annuler</button>
</form>
</body>
</html>