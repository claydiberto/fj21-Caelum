package br.com.caelum.agenda.dao;

public class DaoException extends RuntimeException {

	public DaoException() {
	}
	
	public DaoException(String mensagem) {
		super(mensagem);
	}
	
	public DaoException(Throwable causa) {
		super(causa);
	}
	
	public DaoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
