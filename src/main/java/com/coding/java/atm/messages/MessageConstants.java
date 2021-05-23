package com.coding.java.atm.messages;

/**
 * Supported validation messages.
 * 
 * @author ChinmayaMishra
 *
 */
public interface MessageConstants {

	String INCORRENT_DEPOSIT_MSG = "\nIncorrect deposit amount.";
	
	String DEPOSIT_ZERO_MSG = "\nDeposit amount cannot be zero.";
	
	String INSUFFICIENT_FUND_MSG = "\nIncorrect or insufficient funds.";
	
	String NOT_DISPENSABLE_MSG = "\nRequested withdraw amount is not dispensable.";
}