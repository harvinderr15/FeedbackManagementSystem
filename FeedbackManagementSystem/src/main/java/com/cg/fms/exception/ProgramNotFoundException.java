package com.cg.fms.exception;

public class ProgramNotFoundException extends Exception {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProgramNotFoundException() {
		super();
	}

	public ProgramNotFoundException(String message, Throwable cause, boolean enableSuppression,
						boolean writableStackTrace) {
					super(message, cause, enableSuppression, writableStackTrace);
				
				}

	public ProgramNotFoundException(String message, Throwable cause) {
					super(message, cause);
					
				}

	public ProgramNotFoundException(String message) {
					super(message);
					
				}

	public ProgramNotFoundException(Throwable cause) {
					super(cause);
					
				}

	}


