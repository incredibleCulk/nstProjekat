<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Dobrodošli</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



        <jsp:include page="include.jsp" />


    </head>
    <jsp:useBean id="ulogovan_korisnik" scope="session" class="com.nst.model.User" />
    
    <body>     
        <div class="container">
            <p class="navbar-text"> Trenutno ulogovani korisnik: </p>
            <div class="navbar-text" id="provera">
        <jsp:getProperty name="ulogovan_korisnik" property="ime" /> 
        <jsp:getProperty name="ulogovan_korisnik" property="prezime" />
            </div>
            </div>



        </body>


</html>
