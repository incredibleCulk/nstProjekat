
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Pregled procesa</title>
        <jsp:include page="include.jsp" />
    </head>

    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
            <h1>Pregled procesa</h1>   
            <br><br>
            <table class = "table table-striped" border="1" width="600">
                <thead>
                    <tr>
                        <th style="visibility: hidden;">Id</th>
                        <th>Podsistem</th>
                        <th>Naziv</th>
                        <th>Oznaka</th>
                        <th>Opis</th>
                        <th>Nivo</th>
                        <th>Nadproces</th>
                        <th>Akcija</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="proces" items="${listaProcesa}">
                        <tr>
                            <td style="visibility: hidden;">${proces.idProcesa}</td>
                            <td>${proces.idPodsistema.getNaziv()}</td>
                            <td>${proces.naziv}</td>
                            <td>${proces.oznaka}</td>
                            <td>${proces.opis}</td>
                            <td>${proces.nivo}</td>
                            <td>${proces.idNadprocesa.getNaziv()}</td>
                            <td>

                                <button class="btn btn-info"
                                        onclick="location.href = '<c:url value="../action/izmeni_proces" >
                                            <c:param name="id" value="${proces.idProcesa}"></c:param>
                                        </c:url>'">Izmeni</button>
                                <button class="btn btn-danger"
                                        onclick="location.href = '<c:url value="../action/obrisi_proces" >
                                            <c:param name="id" value="${proces.idProcesa}"></c:param>
                                        </c:url>'">Obriši</button>



                            </td>

                    </c:forEach>
                </tbody>
            </table>  
        </div>

    </body>
</html>
