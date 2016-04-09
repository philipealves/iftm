package br.com.adsge.sistemaEcommerceServer.util.exception;

/**
 *
 * @author Philipe Alves de Oliveira e Silva
 * @since 12/03/2016
 *
 */
public class ValidacaoCampoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8238057502907782033L;

	public ValidacaoCampoException() {
	}

	public ValidacaoCampoException(String message) {
		super(message);
	}

	public ValidacaoCampoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidacaoCampoException(Throwable cause) {
		super(cause);
	}

	public ValidacaoCampoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
