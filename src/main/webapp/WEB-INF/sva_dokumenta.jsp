

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pregled dokumenata</title>
        <jsp:include page="include.jsp" />
    </head>

    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
            <h1>Pregled dokumenata</h1> <button class="btn btn-info"
                                                onclick="location.href = '<c:url value="../action/sacuvaj_novi_dokument" >
                                                </c:url>'">Unesi novi dokument</button>  
            <br><br>
            <form name="myform" action="../action/pretraga_dokumenta" method="POST" onsubmit="return validate()"  enctype="multipart/form-data">
                Pretraga po tipu <input name="dokumentName" class="form-control" type="text" style="width: 70%" />
                <input class = "btn btn-primary" type="submit" value="Pretrazi" />
                <input class="btn btn-success" value="Ponisti filter" 
                        onclick="location.href = '<c:url value="../action/ponisti_filter_dokument" >
                           
                        </c:url>'">
            </form>
            <br><br>
            <table class = "table table-striped" border="1" width="600">

                <thead>
                    <tr>
                        <th style="visibility: hidden;">ID</th>
                        <th>Tip dokumenta</th>
                        <th>Datum</th>
                        <th>Napomena</th>
                        <th>Lokacija modela</th>
                        <th>Poslato</th>
                        <th>Akcija</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dokument" items="${listaDokumenata}">
                        <tr>
                            <td style="visibility: hidden;">${dokument.idDokumenta}</td>
                            <td>${dokument.idTipaDokumenta.getNaziv()}</td>
                            <td>${dokument.datum}</td>
                            <td>${dokument.napomena}</td>
                            <td>${dokument.lokacijaModela}</td>
                            <td>${dokument.poslato}</td>
                            <td>
                                <button class="btn btn-info"
                                        onclick="location.href = '<c:url value="../action/izmeni_dokument" >
                                            <c:param name="id" value="${dokument.idDokumenta}"></c:param>
                                        </c:url>'">Izmeni</button>
                                <button class="btn btn-danger"
                                        onclick="location.href = '<c:url value="../action/obrisi_dokument" >
                                            <c:param name="id" value="${dokument.idDokumenta}"></c:param>
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
