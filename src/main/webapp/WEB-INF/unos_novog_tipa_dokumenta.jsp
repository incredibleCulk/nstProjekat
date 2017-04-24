
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Unos novog tipa dokumenta</title>
        <jsp:include page="include.jsp" />
        
 <script type="text/javascript">

            function validate()
            {
                var naziv = document.myform.naziv.value;
                if(naziv.length<1)
                    {
                        alert("Niste uneli naziv dokumenta.");
                        return false;
                    }
                
            };

        </script>


    </head>
    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
        <h1>Unos tipa dokumenta</h1>
        <form name="myform" action="../action/sacuvaj_tip_dokumenta" method="POST" onsubmit="return validate()" enctype="multipart/form-data">
            <input class="form-control" type="hidden" name="id" value="${tipDokumenta.id}" size="80" /></td>
            <table border="0">                
                <tbody> 
                     <tr>
                        <td colspan="2">
                            <br>
                            <input class="form-control" type="text" name="naziv" value="${tipDokumenta.naziv}" size="80" placeholder="Naziv"/></td>
                    </tr>  
                    <tr>
                        <td colspan="2">
                            <br>
                            <input class="form-control" type="text" name="opis" value="${tipDokumenta.opis}" size="80" placeholder="Opis"/></td>
                    </tr>  
                    <tr>
                        <td width = "50%">
                            <br>
                            <input class="btn btn-primary" type="file" name="lokacijaModela_file" value="${tipDokumenta.lokacijaModela}" style="width: 97%"/></td>
                        <td width = "50%">
                            <br>
                            <input class="form-control" type="text" name="lokacijaModela_text" value="${tipDokumenta.lokacijaModela}" style="width: 100%" placeholder="Lokacija modela nije uneta."/></td>
                    </tr>               
                    <tr>
                        <td colspan="2">
                            <br>
                            <input class = "btn btn-primary" type="submit" value="Sačuvaj tip dokumenta" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        </div>
    </body>
</html>
