<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="newjavascript.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
              integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" 
              crossorigin="anonymous">
    </head>
    <body>
    <marquee><img src="http://rs217.pbsrc.com/albums/cc93/disneyguy100/MOONWALK.gif~c200"></img></marquee>
    <div class="container">

        <form action="pessoa">
            <div class="form-group">
                <label>Nome</label>
                <input type="text" name="pessoa.nome"> 
                </input>
                <submit class="btn btn-success">
                    Enviar
                </submit>
            </div>
        </form>

    </div>
</body>
</html>
