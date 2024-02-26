<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saisir Employé</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
    <%@include file="header.jsp"%>
    <h1>Saisie Employé</h1>
    <form action="save.do" method="POST">
        Matricule: <input type="text" name="matricule" required><br>
        Nom: <input type="text" name="nom" required><br>
        Prénom: <input type="text" name="prenom" required><br>
        Date d'embauche: <input type="date" name="dateEmbauche" required><br>
        Service: <input type="text" name="service" required><br>
        Fonction: <input type="text" name="fonction" required><br>
        Sexe: 
        <select name="sexe">
            <option value="Homme">Homme</option>
            <option value="Femme">Femme</option>
        </select><br>
        Salaire: <input type="number" name="salaire" required><br>
        <input type="submit" value="Ajouter">
        <input type="reset" value="Effacer">
    </form>
</body>
</html>
