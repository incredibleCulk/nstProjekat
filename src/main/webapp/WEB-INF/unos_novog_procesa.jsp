
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Unos novog procesa</title>
        <jsp:include page="include.jsp" />
         
 <script type="text/javascript">

            function validate()
            {
                var naziv = document.myform.naziv.value;
                var nivo = document.myform.nivo.value;
                var oznaka = document.myform.oznaka.value;
                if(naziv.length<1 || oznaka.length<1 || nivo.length<1)
                    {
                        alert("Niste uneli naziv, oznaku ili nivo procesa.");
                        return false;
                    }
                
            };

        </script>

    </head>
    <body>
        <%@include file="menu_left.jsp" %>
        <%@include file="user_login.jsp" %>

        <div class="container">
        <h1>Unos procesa</h1>
        <form name="myform" action="../action/sacuvaj_proces" method="POST" onsubmit="return validate()">
            <table border="0">                
                <tbody>
                   <tr>
                        <td style="visibility: hidden;">
                            <br>
                            Id
                        </td>
                        <td style="visibility: hidden;">
                            <br>
                            <input class="form-control" type="text" name="id" value="${proces.idProcesa}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Podsistem
                        </td>
                          <td>
                            <br>
                            <select class="form-control" name="idPodsistema">
                                <c:forEach var="podsistem" items="${listaPodsistema}">
                                    <option value="${podsistem.id}" ${podsistem.id == proces.idPodsistema.id ? 'selected = "selected"' : ''}>${podsistem.naziv}</option>
                                </c:forEach>
                            </select> 
                        </td>
                    </tr>
                    
                     <tr>
                        <td>
                            <br>
                            Nadproces
                        </td>
                         <td>
                            <br>
                            <select class="form-control" name="idNadprocesa">
                              <option value="0"> nista od ponudjenog </option>
                                <c:forEach var="proces" items="${listaProcesa}">
                                    
                                    <option value="${proces.idProcesa}" ${proces.idProcesa == proces.idNadprocesa.idProcesa ? 'selected = "selected"' : ''}>${proces.naziv}</option>
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
                            <input class="form-control" type="text" name="naziv" value="${proces.naziv}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Oznaka
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="oznaka" value="${proces.oznaka}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Opis
                        </td>
                        <td>
                            <br>
                            <input class="form-control" type="text" name="opis" value="${proces.opis}" size="80" /></td>
                    </tr>  
                    <tr>
                        <td>
                            <br>
                            Nivo
                        </td>
                        <td>
                            <br>

                            <select class="form-control" name="nivo" selected="${proces.nivo}">
                                <option value="1">Prvi</option>
                                <option value="2">Drugi</option>
                                <option value="3">Treci</option>
                            </select> 
</td>
                           
                    </tr>    
                   
                    <tr>
                        <td colspan="2">
                            <br>
                            <input class = "btn btn-primary" type="submit" value="Sačuvaj proces" />
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
        </div>
    </body>
</html>
