

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Meni</title>
        <jsp:include page="include.jsp" />
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="/action/svi_podsistemi">Informacioni sistemi</a></li>
            <li><a href="/action/svi_procesi">Procesi</a></li>
            <li><a href="/action/sve_aktivnosti">Aktivnosti</a></li>
            <li><a href="/action/sva_dokumenta">Dokumenta</a></li>
            <li><a href="/action/svi_tipovi_dokumenata">Tipovi dokumenata</a></li>
            <li><a href="/action/sve_aktivnosti_dokumenta">Aktivnost dokumenta</a></li>
          </ul>
           <ul class="nav navbar-nav navbar-right">
                <li><a href="/action/logout">Izloguj se <span class="sr-only">(current)</span></a></li>
            </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    </body>
</html>
