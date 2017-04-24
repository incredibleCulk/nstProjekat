
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="include.jsp" />
        <title> Unos novog podsistema</title>
        

 <script type="text/javascript">

            function validate()
            {
                var naziv = document.myform.naziv.value;
                var opis = document.myform.opis.value;
                var oznaka = document.myform.oznaka.value;
                if(naziv.length<1 || oznaka.length<1)
                    {
                        alert("Niste uneli naziv ili oznaku podsistema.");
                        return false;
                    }
                
            };

        </script>

    </head>
    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>
        <div class="container">
        <h1>Unos podsistema</h1>
        <form name="myform" action="../action/sacuvaj_podsistem" method="POST" onsubmit="return validate()"  >
            <table border="0">                
                <tbody>
                    <tr>
                        <td style="visibility: hidden;">
                            <br>
                            Id
                        </td>
                        <td style="visibility: hidden;">
                            <br>
                            <input class="form-control" type="text" name="id" value="${p.id}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Nadsistem
                        </td>
                        <td>
                            <br>
                            <select class="form-control" name="idNadsistema">
                           <option value="0"> nista od ponudjenog </option>
                                <c:forEach var="podsistem" items="${listaPodsistema}">
                                    
                                    <option value="${podsistem.id}" ${podsistem.id == p.idNadSistema.id ? 'selected = "selected"' : ''}>${podsistem.naziv}</option>
                                </c:forEach>
                            </select> 
                        </td>
                    
                    </tr>
                    <tr>
                        <td>
                            <br>
                            Opis
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="opis" value="${p.opis}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Oznaka 
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="oznaka" value="${p.oznaka}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Naziv
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="naziv" value="${p.naziv}" size="80" /></td>
                    </tr>  
                 
                    <tr>
                        <td colspan="2">
                            <br>
                            <input class = "btn btn-primary" type="submit" value="Sačuvaj podsistem" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        </div>
    </body>
</html>
