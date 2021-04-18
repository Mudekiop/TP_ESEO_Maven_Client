<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ville.getNom()}</title>
<style>
h1{
	text-align: center
}
</style>
</head>
<body>

	<h1>Information concernant la commune de ${ville.getNom()}</h1>
	<c:out value="Code insee : ${ville.getInsee()}" /><br />
	<c:out value="Code postal : ${ville.getCodePostal()}" /><br />
	<c:out value="Libelle acheminement : ${ville.getLibelle()}" /><br />
	<c:out value="Ligne : ${ville.getLigne()}" /><br />
	<c:out value="Coordonnées : ${ville.getCoord().getLatitude()}, ${ville.getCoord().getLongitude()}" /><br />

	<form method="post" action="infosVille?insee=${ville.getInsee()}">
		<div>
			<label for="choix">Champ à modifier :</label>
			<select name="choix" id="choix">
				<option>Code Postal
				<option>Nom
				<option>Libelle acheminement
				<option>Ligne
			</select>
			<label for="chgt">Nouvelle valeur :</label>
			<input type="text" name="chgt" id="chgt" />
		</div>
		<input type="submit" name="send" value="Mettre a jour"/>	
		<input type="submit" name="send" value="Supprimer la ville" />
	</form>

</body>
</html>