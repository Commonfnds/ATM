package com.coding.java.atm.currency;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DenominationTest {

	@Test
	public void testDenominations() {
		assertTrue(Denomination.ONE.value() == 1);
		assertTrue(Denomination.FIVE.value() == 5);
		assertTrue(Denomination.TEN.value() == 10);
		assertTrue(Denomination.TWENTY.value() == 20);
	}
}