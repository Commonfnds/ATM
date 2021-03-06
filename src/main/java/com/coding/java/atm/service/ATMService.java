package com.coding.java.atm.service;

import java.util.List;

import com.coding.java.atm.currency.Note;

/**
 * It allows customers to deposit and withdraw cash in different denominations.
 * 
 * @author ChinmayaMishra
 *
 */
public interface ATMService {

	/**
	 * Initializes ATM machine.
	 *
	 */
	void initializeMachine();

	/**
	 * Displays available denominations and total balance.
	 *
	 */
	String displayDenominationBalance();

	/**
	 * This function allows deposit of different denominations.
	 * 
	 * @param denominations {@link List} of {@link Note}s to be deposited.
	 * 
	 *                      If all the input denomination values are zero, then
	 *                      "Deposit amount cannot be zero" error message will be
	 *                      displayed. If any input values are negative, then
	 *                      "Incorrect deposit amount" error message will be
	 *                      displayed.
	 *
	 */
	String deposit(List<Note> depositedNotes);

	/**
	 * This function allows withdrawing amount with different {@link Denomination}s
	 * from ATM.
	 * 
	 * @param amount to be withdrawn from ATM.
	 * 
	 *               If the input amount is zero, negative, or more than the current
	 *               balance, then "Incorrect or insufficient funds" message will be
	 *               displayed.
	 */
	String withdraw(int withdrawAmount);
}
