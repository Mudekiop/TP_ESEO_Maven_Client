<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
	<p>Hello World !</p></br>
	<c:forEach var="i" begin="1" end="${listeVille.size() - 1}" >
		<c:out value="Code insee : ${listeVille.get(i).getInsee()}"/></br>
		<c:out value="Nom : ${listeVille.get(i).getNom()}"/></br>
		<c:out value="Code postal : ${listeVille.get(i).getCodePostal()}"/></br>
		<c:out value="Libelle : ${listeVille.get(i).getLibelle()}"/></br>
		<c:out value="Ligne : ${listeVille.get(i).getLigne()}"/></br>
		<c:out value="Coordonnees : x=${listeVille.get(i).getCoord().getLatitude()} et y=${listeVille.get(i).getCoord().getLongitude()}"/>
	</c:forEach>
</body>
</html>