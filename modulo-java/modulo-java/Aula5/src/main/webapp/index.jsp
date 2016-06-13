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
    <style>
        #michael{
            height: 200px;
            width: 200px;
            background-image: url('http://rs217.pbsrc.com/albums/cc93/disneyguy100/MOONWALK.gif~c200');
        }
        #michael:hover{
            height: 180px;
            width: 120px;
            background-image: url('https://media.giphy.com/media/TtrcH1Ja351mw/giphy.gif');
        }
    </style>
    <body>
    <marquee><div id="michael"></div></marquee>
    <div class="container">

        <form action="pessoa">
            <div class="form-group">
                <label>Nome</label>
                <input type="text" name="pessoa.nome">
                <label>Idade</label>
                <input type="number" name="pessoa.idade">
                <label>Sexo</label>
                <input type="radio" name="pessoa.sexo" value="MASCULINO"> Masculino
                <input type="radio" name="pessoa.sexo" value="FEMININO"> Feminino
                <input type="radio" name="pessoa.sexo" value="OUTRO"> Outro </input>
                <br>
                <button type="submit" class="btn btn-success">
                    Enviar
                    </submit>
            </div>
        </form>

    </div>
</body>
</html>
