<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page inexistante</title>
<style type="text/css">
p {
	margin-left: auto;
	margin-right: auto;
	width: 40em
}

body {
	font-family: Helvetica, sans-serif;
	font-size: large;
}

#error {
	color: red;
	font-weight: bold;
	margin-left: auto;
	margin-right: auto;
	width: 38em
}
</style>
</head>
<body>

	<p>La page que vous recherchez n'existe pas !</p>
	<p id="error">Veuillez renseigner un paramètre page valide dans l'url !</p>
	<a href="/ESEO_TP_Client/infosVille?page=1">Retour à la page principale</a>

</body>
</html>