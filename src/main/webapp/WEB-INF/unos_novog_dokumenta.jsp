
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Unos novog dokumenta</title>
        <jsp:include page="include.jsp" />
        

        <script type="text/javascript">

            $(function () {
                $("#datepicker").datepicker();
            });

        </script>
    </head>
    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
            <h1>Unos dokumenta</h1>
            <form name="myform" action="../action/sacuvaj_dokument" method="POST" onsubmit="return validate()"  enctype="multipart/form-data">
                <input class="form-control" type="hidden" name="id" value="${dok.idDokumenta}" size="80" />
                <input class="form-control" type="hidden" name="datum" value="${dok.datum}" size="80" />
                <table border="0" >                
                    <tbody>
                        <tr>
                            <td colspan="2">
                                <select class="form-control" name="idTipadokumenta">
                                    <c:forEach var="tipdokumenta" items="${listaTipova}">
                                        <option value="${tipdokumenta.id}" ${tipdokumenta.id == dok.idTipaDokumenta.id ? 'selected = "selected"' : ''}>${tipdokumenta.naziv}</option>
                                    </c:forEach>
                                </select> 
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <br>
                                <input  name="datum" id="datepicker" />
                            </td>
                        </tr> 
                        <tr>
                            <td colspan="2">
                                <br>
                                <input class="form-control" type="text" name="napomena" value="${dok.napomena}" size="80" placeholder="Napomena"/></td>
                        </tr>  

                        <tr>
                            <td width = "50%">
                                <br>
                                <input class="btn btn-default" type="file" name="lokacijaModela_file" value="${dok.lokacijaModela}" style="width: 97%"/></td>
                            <td width = "50%">
                                <br>
                                <input class="form-control" type="text" name="lokacijaModela_text" value="${dok.lokacijaModela}" style="width: 100%" placeholder="Lokacija originala nije uneta."/></td>

                        </tr>  

                        <tr>
                            <td colspan="2">
                                <br>
                                <select class="form-control" name="poslato" selected="${dok.poslato}">
                                    <option value="1">Da</option>
                                    <option value="0">Ne</option>
                                </select> 
                            </td>
                        </tr>  

                        <tr>
                            <td colspan="3">
                                <br>
                                <input class = "btn btn-success" type="submit" value="Sačuvaj dokument" />
                            </td>
                        </tr>
                    </tbody>
                </table>

            </form>


        </div>

    </body>
</html>
