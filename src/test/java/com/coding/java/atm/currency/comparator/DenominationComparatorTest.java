package com.coding.java.atm.currency.comparator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.coding.java.atm.currency.Denomination;

public class DenominationComparatorTest {

	@Test
	public void testDenominations() {
		DenominationComparator denominationComparator = new DenominationComparator();

		Denomination firstDenomination = Denomination.ONE;
		Denomination secondDenomination = Denomination.ONE;
		assertEquals(denominationComparator.compare(firstDenomination, secondDenomination), 0);

		firstDenomination = Denomination.FIVE;
		secondDenomination = Denomination.ONE;
		assertEquals(denominationComparator.compare(firstDenomination, secondDenomination), -1);

		firstDenomination = Denomination.TEN;
		secondDenomination = Denomination.TWENTY;
		assertEquals(denominationComparator.compare(firstDenomination, secondDenomination), 1);

	}

}
