
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Unos nove aktivnosti</title>
        <jsp:include page="include.jsp" />

<script type="text/javascript">

            function validate()
            {
                var naziv = document.myform.naziv.value;
                var oznaka = document.myform.oznaka.value;
                if(oznaka.length<1 || naziv.length<1)
                    {
                        alert("Niste uneli naziv ili oznaku aktivnosti.");
                        return false;
                    }
                
            };

        </script>

    </head>
    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
        <h1>Unos aktivnosti</h1>
        <form name="myform" action="../action/sacuvaj_aktivnost" method="POST" onsubmit="return validate()">
            <table border="0">                
                <tbody>
                   <tr>
                        <td style="visibility: hidden;">
                            <br>
                            Id
                        </td>
                        <td style="visibility: hidden;">
                            <br>
                            <input class="form-control" type="text" name="id" value="${akt.idAktivnosti}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                           Proces
                        </td>
                           <td>
                            <br>
                            <select class="form-control" name="idProcesa">
                                <c:forEach var="proces" items="${listaProcesa}">
                                    
                                    <option value="${proces.idProcesa}" ${proces.idProcesa == akt.idProcesa.idProcesa ? 'selected = "selected"' : ''}>${proces.naziv}</option>
                                </c:forEach>
                            </select> 
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <br>
                            Naziv
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="naziv" value="${akt.naziv}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Opis
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="opis" value="${akt.opis}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Oznaka
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="oznaka" value="${akt.oznaka}" size="80" /></td>
                    </tr>                      
                    <tr>
                        <td colspan="2">
                            <br>
                            <input class = "btn btn-primary" type="submit" value="Sačuvaj aktivnost" />
                        </td>
                    </tr>
                </tbody>
            </table>
        
        </form>
        
        </div>
    </body>
</html>
