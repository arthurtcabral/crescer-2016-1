package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pessoa", urlPatterns = ("/pessoa"))
public class PessoaServlet extends HttpServlet {

    List<String> argumentos = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter()) {
            argumentos.add(request.getParameter("pessoa.sexo"));
            argumentos.add(request.getParameter("pessoa.nome"));
            argumentos.add(request.getParameter("pessoa.idade"));
            out.append("<!DOCTYPE html> "
                    + "<html lang=\"pt\">"
                    + "<header>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Tabela Pessoa</title>"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\"\n" +
"              integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" \n" +
"              crossorigin=\"anonymous\">"
                    + "</header>"
                    + "<body>");
            out.append("<div class=\"table-responsive\">");
            out.append("<table class=\"table\">");
            out.append("<thead>");
            out.append("<tr>"
                    + "<th> SEXO </th>"
                    + "<th> NOME </th>"
                    + "<th> IDADE </th>"
                    + "</tr>");
            out.append("</thead>");
            out.append("<tbody>");
            out.append("<tr>");
            for(String argumento : this.argumentos){
                out.append("<td>" + argumento.toUpperCase() + "</td>");
            }
            out.append("</tr>");
            out.append("</tbody>");
            out.append("</table>");
            out.append("</div>");
            out.append("</body>");
            out.append("</html>");
        }
    }

}
