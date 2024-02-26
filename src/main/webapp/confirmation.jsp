<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation Ajout Employé</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout Employé
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label">Matricule :</label>
                    <input type="text" name="matricule" class="form-control" value="${employe.matricule}" readonly/>
                </div>
                <div class="form-group">
                    <label class="control-label">Nom :</label>
                    <input type="text" name="nom" class="form-control" value="${employe.nom}" readonly/>
                </div>
                <div class="form-group">
                    <label class="control-label">Prenom :</label>
                    <input type="text" name="prenom" class="form-control" value="${employe.prenom}" readonly/>
                </div>
                <div class="form-group">
                    <label class="control-label">Date Embauche :</label>
                    <input type="text" name="dateEmbauche" class="form-control" value="${employe.dateEmbauche}" readonly/>
                </div>
                <div class="form-group">
                    <label class="control-label">Service :</label>
                    <input type="text" name="service" class="form-control" value="${employe.service}"readonly/>
                </div>
                <div class="form-group">
                    <label class="control-label">Fonction :</label>
                    <input type="text" name="fonction" class="form-control" value="${employe.fonction}" readonly/>
                </div>
                <div class="form-group">
                    <label class="control-label">Sexe :</label>
                    <input type="text" name="sexe" class="form-control" value="${employe.sexe}"readonly/>
                </div>
                <div class="form-group">
                    <label class="control-label">Salaire :</label>
                    <input type="text" name="salaire" class="form-control" value="${employe.salaire}" readonly/>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
