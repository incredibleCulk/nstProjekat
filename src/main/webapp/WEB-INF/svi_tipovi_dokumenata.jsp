

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Pregled tipova dokumenata</title>
        <jsp:include page="include.jsp" />
    </head>

    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
            <h1>Pregled tipova dokumenata</h1> <button class="btn btn-info"
                                        onclick="location.href = '<c:url value="../action/sacuvaj_novi_tip" >
                                        </c:url>'">Unesi novi tip dokumenta</button>   
            <br><br>
            <form name="myform" action="../action/pretraga_tipova" method="POST" onsubmit="return validate()"  enctype="multipart/form-data">
                Pretraga po nazivu <input name="dokumentName" class="form-control" type="text" style="width: 70%" />
                <input class = "btn btn-primary" type="submit" value="Pretrazi" />
                
                <input class="btn btn-success" value="Ponisti filter" 
                        onclick="location.href = '<c:url value="../action/ponisti_filter_tipa" >
                          
                        </c:url>'">
            </form>
            <br><br>
            <table class = "table table-striped" border="1" width="600">
                <thead>
                    <tr>
                        <th style="visibility: hidden;">Id</th>
                        <th>Naziv</th>
                        <th>Opis</th>
                        <th>Lokacija modela</th>
                        <th>Akcija</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tipDokumenta" items="${listaTipova}">
                        <tr>
                            <td style="visibility: hidden;">${tipDokumenta.id}</td>
                            <td>${tipDokumenta.naziv}</td>
                            <td>${tipDokumenta.opis}</td>
                            <td>${tipDokumenta.lokacijaModela}</td>
                            <td>
                               <button class="btn btn-info"
                                        onclick="location.href = '<c:url value="../action/izmeni_tip" >
                                            <c:param name="id" value="${tipDokumenta.id}"></c:param>
                                        </c:url>'">Izmeni</button>
                                <button class="btn btn-danger"
                                        onclick="location.href = '<c:url value="../action/obrisi_tip" >
                                            <c:param name="id" value="${tipDokumenta.id}"></c:param>
                                        </c:url>'">Obriši</button>

                            </td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br><br>

        </div>
    </body>
</html>
