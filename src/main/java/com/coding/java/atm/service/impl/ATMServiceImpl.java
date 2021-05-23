package com.coding.java.atm.service.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.coding.java.atm.currency.Denomination;
import com.coding.java.atm.currency.Note;
import com.coding.java.atm.currency.comparator.DenominationComparator;
import com.coding.java.atm.messages.MessageConstants;
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
				new Note(Denomination.FIVE, 0)).stream()
				.forEach(note -> notes.put(note.getDenomination(), note.getQuantity()));
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
		if (depositedNotes.stream().anyMatch(note -> note.getQuantity() < 0)) {
			return MessageConstants.INCORRENT_DEPOSIT_MSG;
		}

		if (depositedNotes.stream().allMatch(note -> note.getQuantity() == 0)) {
			return MessageConstants.DEPOSIT_ZERO_MSG;
		}

		depositedNotes.stream().forEach(note -> {

			Denomination denomination = note.getDenomination();
			Integer denominationValue = notes.get(denomination);
			int quantity = note.getQuantity();

			if (Objects.nonNull(denominationValue)) {
				notes.put(denomination, denominationValue + quantity);
			} else {
				notes.put(denomination, quantity);
			}
		});

		return displayDenominationBalance();
	}

	@Override
	public String withdraw(int withdrawAmount) {
		Integer totalSum = notes.entrySet().stream()
				.mapToInt(denomination -> denomination.getKey().value() * denomination.getValue()).sum();

		if (withdrawAmount <= 0 || withdrawAmount > totalSum) {
			return MessageConstants.INSUFFICIENT_FUND_MSG;
		}

		List<Denomination> sortedDenomination = notes.keySet().stream().sorted(new DenominationComparator())
				.collect(Collectors.toList());
		Map<Denomination, Integer> dispensedDenominations = new LinkedHashMap<>();

		if (canNotesBeDispensed(sortedDenomination, withdrawAmount, dispensedDenominations)) {
			return MessageConstants.NOT_DISPENSABLE_MSG;
		}

		for (Denomination denomination : sortedDenomination) {
			Integer availableDenomination = notes.get(denomination);
			Integer requiredDenomination = withdrawAmount / denomination.value();

			if (availableDenomination < requiredDenomination) {
				requiredDenomination = availableDenomination;
			}

			withdrawAmount -= requiredDenomination * denomination.value();
			notes.put(denomination, notes.get(denomination) - requiredDenomination);
		}

		String dispensedDenominationsText = dispensedDenominations.entrySet().stream()
				.filter(denomination -> denomination.getValue() > 0)
				.map(denomination -> denomination.getKey().value() + "s=" + denomination.getValue())
				.collect(Collectors.joining(", "));

		return "\nDispensed: " + dispensedDenominationsText;
	}

	private boolean canNotesBeDispensed(List<Denomination> sortedDenomination, int withdrawAmount,
			Map<Denomination, Integer> dispensedDenominations) {
		for (Denomination denomination : sortedDenomination) {
			Integer availableDenomination = notes.get(denomination);
			Integer requiredDenomination = withdrawAmount / denomination.value();

			if (availableDenomination < requiredDenomination) {
				requiredDenomination = availableDenomination;
			}

			withdrawAmount -= requiredDenomination * denomination.value();
			dispensedDenominations.put(denomination, requiredDenomination);
		}
		return withdrawAmount > 0;
	}
}
