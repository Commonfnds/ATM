package com.coding.java.atm.currency;

/**
 * 
 * @author ChinmayaMishra
 *
 */
public enum Denomination {

	TWENTY(new Integer(20)), TEN(new Integer(10)), FIVE(new Integer(5)), ONE(new Integer(1));

	private Integer value;

	Denomination(Integer amount) {
		value = amount;
	}

	public Integer value() {
		return value;
	}

}