package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.model.Contato;

public class ContatoDao {
	private Connection connection = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	public ContatoDao() {
	}
	
	public void prepararConexao(String sql) {
		try {
			this.connection = new ConnectionFactory().abrirConexao();
			this.stmt = connection.prepareStatement(sql);
			System.out.println("-- Conexão aberta --");
		} catch (SQLException e) {
			throw new DaoException("Erro ao abrir a conexão.", e);
		}
	}
	
	public void adicionar(Contato contato) {
		this.sql = "insert into contatos (nome, email, telefone, dataNascimento) values (?,?,?,?)";
		try {
			prepararConexao(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getTelefone());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
		} catch (Exception e) {
			throw new DaoException("Contato não adicionado", e);
		} finally {
			ConnectionFactory.fecharConexao(connection, stmt);
		}
	}
	
	public List<Contato> listar() {
		this.sql = "select * from contatos";
		try {
			List<Contato> listaDeContatos = new ArrayList<Contato>();
			prepararConexao(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				Contato contato = new Contato(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("email"),
						rs.getString("telefone"),
						dataNascimento);
				listaDeContatos.add(contato);				
			}
			return listaDeContatos;
		} catch (Exception e) {
			throw new DaoException("Erro ao listar todos os contatos.", e);
		} finally {
			ConnectionFactory.fecharConexao(connection, stmt, rs);
		}
	}
	
	
	
}