package com.coding.java.atm.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.coding.java.atm.currency.Denomination;
import com.coding.java.atm.currency.Note;
import com.coding.java.atm.service.ATMService;

public class ATMServiceImplTest {
	
	ATMService atmService = new ATMServiceImpl();
	
	@Test
	public void testInitializeMachine() {
		atmService.initializeMachine();
		
		assertEquals("\nBalance: 20s=0, 10s=0, 5s=0, 1s=0, Total=0", atmService.displayDenominationBalance());
	}

	@Test
	public void testDeposit_1() {
		List<Note> depositedNotes = Arrays.asList(new Note(Denomination.TEN, 8), new Note(Denomination.FIVE, 20));
		atmService.deposit(depositedNotes);
		assertEquals("\nBalance: 10s=8, 5s=20, Total=180", atmService.displayDenominationBalance());
	}
	
	@Test
	public void testDeposit_2() {
		List<Note> depositedNotes_1 = Arrays.asList(new Note(Denomination.TEN, 8), new Note(Denomination.FIVE, 20));
		atmService.deposit(depositedNotes_1);
		
		List<Note> depositedNotes_2 = Arrays.asList(new Note(Denomination.TWENTY, 3), new Note(Denomination.FIVE, 18), new Note(Denomination.ONE, 4));
		atmService.deposit(depositedNotes_2);
		assertEquals("\nBalance: 20s=3, 10s=8, 5s=38, 1s=4, Total=334", atmService.displayDenominationBalance());
	}
}