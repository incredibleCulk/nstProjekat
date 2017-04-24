<%-- 
    Document   : sve_aktivnosti_dokumenata
    Created on : Apr 22, 2017, 2:43:24 AM
    Author     : milisava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


    <html>
          <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Pregled aktivnosti dokumenata</title>
        <jsp:include page="include.jsp" />
    </head>
        <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
        <h1>Pregled aktivnosti</h1> 
        <br><br>
        <table class = "table table-striped" border="1" width="600">
            <thead>
                <tr>
                    <th style="visibility: hidden;">Id</th>
                    <th>Proces</th>
                    <th>Naziv</th>
                    <th>Opis</th>
                    <th>Oznaka</th>
                    <th>Akcija</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="aktivnost" items="${listaAktivnosti}">
                    <tr>
                        <td style="visibility: hidden;">${aktivnost.idAktivnosti}</td>
                        <td>${aktivnost.idProcesa.getNaziv()}</td>
                        <td>${aktivnost.naziv}</td>
                        <td>${aktivnost.opis}</td>
                        <td>${aktivnost.oznaka}</td>
                        <td>
                            
                            <button class="btn btn-info"
                                        onclick="location.href = '<c:url value="../action/izmeni_aktivnost" >
                                            <c:param name="id" value="${aktivnost.idAktivnosti}"></c:param>
                                        </c:url>'">Izmeni</button>
                                <button class="btn btn-danger"
                                        onclick="location.href = '<c:url value="../action/obrisi_aktivnost" >
                                            <c:param name="id" value="${aktivnost.idAktivnosti}"></c:param>
                                        </c:url>'">Obriši</button>
                        
                           
                        </td> 
                </c:forEach>
            </tbody>
        </table>
        <br><br>
         
        </div>
    </body>
    </html>

