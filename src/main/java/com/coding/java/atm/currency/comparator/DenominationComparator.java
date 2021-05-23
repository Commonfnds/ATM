package com.coding.java.atm.currency.comparator;

import java.util.Comparator;

import com.coding.java.atm.currency.Denomination;

/**
 * 
 * @author ChinmayaMishra
 *
 */
public class DenominationComparator implements Comparator<Denomination> {

	@Override
	public int compare(Denomination firstDenomination, Denomination secondDenomination) {
		int firstValue = firstDenomination.value().intValue();
		int secondValue = secondDenomination.value().intValue();
		
		if (firstValue == secondValue)
			return 0;
		else if (firstValue > secondValue)
			return -1;
		else
			return 1;
	}

}