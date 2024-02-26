<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Éditer Employé</title>
</head>
<body>
    <h1>Éditer Employé</h1>
    <form action="update.do" method="post">
        <input type="hidden" name="id" value="${employe.id}">
        <label>Matricule:</label>
        <input type="text" name="matricule" value="${employe.matricule}" required><br>
        <label>Nom:</label>
        <input type="text" name="nom" value="${employe.nom}" required><br>
        <label>Prénom:</label>
        <input type="text" name="prenom" value="${employe.prenom}" required><br>
        <label>Date d'embauche:</label>
		<input type="date" name="dateEmbauche" value="${employe.dateEmbauche}" required><br>
        <label>Service:</label>
        <input type="text" name="service" value="${employe.service}" required><br>
        <label>Fonction:</label>
        <input type="text" name="fonction" value="${employe.fonction}" required><br>
        <label>Sexe:</label>
        <input type="text" name="sexe" value="${employe.sexe}" required><br>
        <label>Salaire:</label>
        <input type="number" name="salaire" value="${employe.salaire}" required><br>
        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>
