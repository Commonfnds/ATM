package com.coding.java.atm.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.coding.java.atm.currency.Denomination;
import com.coding.java.atm.currency.Note;
import com.coding.java.atm.messages.MessageConstants;
import com.coding.java.atm.service.ATMService;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class ATMServiceImplTest {
	
	private ATMService atmService;
	
	@BeforeEach
	void init() {
		atmService = new ATMServiceImpl();
	}
	
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
	
	@Test
	public void testDeposit_3() {
		List<Note> depositedNotes = Arrays.asList(new Note(Denomination.TEN, 0), new Note(Denomination.FIVE, 0));
		
		assertEquals(MessageConstants.DEPOSIT_ZERO_MSG, atmService.deposit(depositedNotes));
	}
	
	@Test
	public void testDeposit_4() {
		List<Note> depositedNotes = Arrays.asList(new Note(Denomination.TEN, 10), new Note(Denomination.FIVE, -5));
		
		assertEquals(MessageConstants.INCORRENT_DEPOSIT_MSG, atmService.deposit(depositedNotes));
	}
	
	@Test
	public void testWithdraw_1() {
		List<Note> depositedNotes = Arrays.asList(new Note(Denomination.TWENTY, 3), new Note(Denomination.TEN, 8), new Note(Denomination.FIVE, 38), new Note(Denomination.ONE, 4));
		atmService.deposit(depositedNotes);
		assertEquals("\nDispensed: 20s=3, 10s=1, 5s=1", atmService.withdraw(75));
	}
	
	@Test
	public void testWithdraw_2() {
		List<Note> depositedNotes = Arrays.asList(new Note(Denomination.TEN, 7), new Note(Denomination.FIVE, 37), new Note(Denomination.ONE, 4));
		atmService.deposit(depositedNotes);
		assertEquals("\nDispensed: 10s=7, 5s=10, 1s=2", atmService.withdraw(122));
	}
	
	@Test
	public void testWithdraw_3() {
		List<Note> depositedNotes = Arrays.asList(new Note(Denomination.FIVE, 27), new Note(Denomination.ONE, 2));
		atmService.deposit(depositedNotes);
		assertEquals(MessageConstants.NOT_DISPENSABLE_MSG, atmService.withdraw(63));
	}
	
	@Test
	public void testWithdraw_4() {
		assertEquals(MessageConstants.INSUFFICIENT_FUND_MSG, atmService.withdraw(253));
	}
	
	@Test
	public void testWithdraw_5() {
		assertEquals(MessageConstants.INSUFFICIENT_FUND_MSG, atmService.withdraw(0));
	}
	
	@Test
	public void testWithdraw_6() {
		assertEquals(MessageConstants.INSUFFICIENT_FUND_MSG, atmService.withdraw(-25));
	}
}