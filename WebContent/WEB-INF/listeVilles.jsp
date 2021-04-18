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
#next{
		text-align: right;
}

#last{
		text-align: left;
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
		<c:choose>
			<c:when test="${bool}">
				<c:forEach var="i" begin="${taille}" end="${listeVille.size()-1}">
					<tr>
						<td><c:out value=" <a href='infosVille?insee=${listeVille.get(i).getInsee()}'> ${listeVille.get(i).getInsee()}" escapeXml="false" /></td>
				   		<td><c:out value="${listeVille.get(i).getNom()}" /></td>
						<td><c:out value="${listeVille.get(i).getCodePostal()}" /></td>
						<td><c:out value="${listeVille.get(i).getLibelle()}" /></td>
						<td><c:out value="${listeVille.get(i).getLigne()}" /></td>
						<td><c:out value="${listeVille.get(i).getCoord().getLatitude()}, ${listeVille.get(i).getCoord().getLongitude()}" /></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${!bool}">
				<c:forEach var="i" begin="${taille}" end="${taille+49}">
					<tr>
						<td><c:out value=" <a href='infosVille?insee=${listeVille.get(i).getInsee()}'> ${listeVille.get(i).getInsee()}" escapeXml="false" /></td>
						<td><c:out value="${listeVille.get(i).getNom()}" /></td>
						<td><c:out value="${listeVille.get(i).getCodePostal()}" /></td>
						<td><c:out value="${listeVille.get(i).getLibelle()}" /></td>
						<td><c:out value="${listeVille.get(i).getLigne()}" /></td>
						<td><c:out value="${listeVille.get(i).getCoord().getLatitude()}, ${listeVille.get(i).getCoord().getLongitude()}" /></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<c:if test="${nbPage != 1 }">
		<p id="last"><a href="/ESEO_TP_Client/listeVilles?page=${nbPage - 1 }">Page précedente</a></p>
	</c:if>
	<c:if test="${!bool}">
		<p id="next"><a href="/ESEO_TP_Client/listeVilles?page=${nbPage + 1 }">Page suivante</a></p>
	</c:if>
	
</body>
</html>