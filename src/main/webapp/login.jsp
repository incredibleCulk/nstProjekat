

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>[FON] Prijava</title>
        <jsp:include page="WEB-INF/include.jsp" />
    </head>
    <body>

        <div class = "container">
            <h1>Prijavite se na sistem</h1>
            <form action="/action/login" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td><input class = "form-control" type="text" name="korisnickoIme" value="" size="80" placeholder="Korisničko ime"/></td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <input class = "form-control" type="password" name="korisnickaSifra" value="" size="40" placeholder="Korisnička šifra"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                                <input class = "btn btn-primary" type="submit" value="Prijavi se na sistem" />
                            </td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>

            </form>
            <div>
                </body>
                </html>

