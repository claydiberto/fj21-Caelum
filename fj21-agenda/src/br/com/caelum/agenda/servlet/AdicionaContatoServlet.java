package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.model.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		// tenta converter a data de nascimento
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);			
		} catch (ParseException e) {
			System.out.println("Erro na conversão da data.");
			return;
		}
		
		Contato contato = new Contato(nome, email, telefone, dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.adicionar(contato);
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet AdicionaContatoServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>O contato " + contato.getNome() + ", foi adicionado com sucesso.</h1>");
        out.println("<h3><a href='/agenda' >Home</a></h3>");
        out.println("</body>");
        out.println("</html>");
		
	}
	
}
