

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Pregled informacionih sistema</title>
        <jsp:include page="include.jsp" />
    </head>

    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
            <h1>Pregled informacionih sistema</h1> 
            <br><br>
            <table class = "table table-striped" border="1" width="600">
                <thead>
                    <tr>
                        <th style="visibility: hidden;">Id</th>
                        <th>Nadsistem</th>                    
                        <th>Opis</th>
                        <th>Oznaka</th>
                        <th>Naziv</th>
                        <th>Akcija</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="podsistem" items="${listaPodsistema}">
                        <tr>
                            <td style="visibility: hidden;">${podsistem.id}</td>
                            <td>${podsistem.idNadSistema.getNaziv()}</td>                        
                            <td>${podsistem.opis}</td>
                            <td>${podsistem.oznaka}</td>
                            <td>${podsistem.naziv}</td>
                            <td>
                                <button class="btn btn-info"
                                        onclick="location.href = '<c:url value="../action/izmeni_podsistem" >
                                            <c:param name="id" value="${podsistem.id}"></c:param>
                                        </c:url>'">Izmeni</button>
                                <button class="btn btn-danger"
                                        onclick="location.href = '<c:url value="../action/obrisi_podsistem" >
                                            <c:param name="id" value="${podsistem.id}"></c:param>
                                        </c:url>'">Obriši</button>


                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


        </div>



    </body>
</html>
