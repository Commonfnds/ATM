package com.coding.java.atm.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.coding.java.atm.currency.Denomination;
import com.coding.java.atm.currency.Note;
import com.coding.java.atm.service.ATMService;

/**
 * Implementation of {@link ATMService}.
 * 
 * @author ChinmayaMishra
 *
 */
public class ATMServiceImpl implements ATMService {

	private Map<Denomination, Integer> notes = new TreeMap<Denomination, Integer>();

	@Override
	public void initializeMachine() {
		Arrays.asList(new Note(Denomination.TEN, 0), new Note(Denomination.TWENTY, 0), new Note(Denomination.ONE, 0),
				new Note(Denomination.FIVE, 0)).stream().forEach(n -> notes.put(n.getDenomination(), n.getQuantity()));
	}

	@Override
	public String displayDenominationBalance() {
		String denominations = notes.entrySet().stream()
				.map(denomination -> denomination.getKey().value() + "s=" + denomination.getValue())
				.collect(Collectors.joining(", "));
		Integer totalSum = notes.entrySet().stream()
				.mapToInt(denomination -> denomination.getKey().value() * denomination.getValue()).sum();
		return String.format("\nBalance: " + denominations + ", Total=" + totalSum);
	}

	@Override
	public String deposit(List<Note> depositedNotes) {
		depositedNotes.stream().forEach(n -> {

			Denomination denomination = n.getDenomination();
			Integer denominationValue = notes.get(denomination);
			int quantity = n.getQuantity();

			if (Objects.nonNull(denominationValue)) {
				notes.put(denomination, denominationValue + quantity);
			} else {
				notes.put(denomination, quantity);
			}
		});

		return displayDenominationBalance();
	}
}
