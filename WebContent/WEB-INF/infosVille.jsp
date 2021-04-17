<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
<style>
table {
	border-collapse: collapse;
}

td, th {
	border: 2px solid black;
}
body {
	font-family: Helvetica, sans-serif;
	font-size: large;
}
</style>
</head>
<body>

	<h1>Présentation de l'ensemble des villes de France :</h1>
	<table>
		<tr>
			<th>Code insee</th>
			<th>Nom de la commune</th>
			<th>Code postal</th>
			<th>Libelle acheminement</th>
			<th>Ligne 5</th>
			<th>Coordonnees</th>
		</tr>
		<c:forEach var="i" begin="1" end="50">
			<tr>
				<td><c:out value=" <a href='ESEO_TP_Client/infosVille?insee = ${listeVille.get(i).getInsee()}'> ${listeVille.get(i).getInsee()}" escapeXml="false"/></td>
				<td><c:out value="${listeVille.get(i).getNom()}"/></td>
				<td><c:out value="${listeVille.get(i).getCodePostal()}"/></td>
				<td><c:out value="${listeVille.get(i).getLibelle()}"/></td>
				<td><c:out value="${listeVille.get(i).getLigne()}"/></td>
				<td><c:out value="x=${listeVille.get(i).getCoord().getLatitude()}, y=${listeVille.get(i).getCoord().getLongitude()}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>