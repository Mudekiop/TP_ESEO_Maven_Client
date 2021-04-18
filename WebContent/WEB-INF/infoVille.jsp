<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ville.getNom()}</title>
</head>
<body>
	<h1>Information concernant la commune de ${ville.getNom()}</h1>
	<c:out value="Code insee : ${ville.getInsee()}"/><br/>
	<c:out value="Code postal : ${ville.getCodePostal()}"/><br/>
	<c:out value="Libelle acheminement : ${ville.getLibelle()}"/><br/>
	<c:out value="Ligne : ${ville.getLigne()}"/><br/>
	<c:out value="Coordonnées : ${ville.getCoord().getLatitude()}, ${ville.getCoord().getLongitude()}"/><br/>
</body>
</html>