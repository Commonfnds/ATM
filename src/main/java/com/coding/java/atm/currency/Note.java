package com.coding.java.atm.currency;

/**
 * 
 * @author ChinmayaMishra
 *
 */
public class Note {
	
	private Denomination denomination;
	private int quantity;
	
	public Note() {
	}

	public Note(Denomination type, int quantity) {
		this.denomination = type;
		this.quantity = quantity;
	}

	public Denomination getDenomination() {
		return denomination;
	}

	public void setDenomination(Denomination type) {
		this.denomination = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}