package edu.uark.models.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionTypeClassification {
	NOT_DEFINED(0),
	SALE(1),
	RETURN(2);
		
	public int getValue() {
		return value;
	}

	public static TransactionTypeClassification map(int key) {
		if (valueMap == null) {
			valueMap = new HashMap<Integer, TransactionTypeClassification>();

			for (TransactionTypeClassification status : TransactionTypeClassification.values()) {
				valueMap.put(status.getValue(), status);
			}
		}
		
		return (valueMap.containsKey(key) ? valueMap.get(key) : TransactionTypeClassification.NOT_DEFINED);
	}
	
	private int value;

	private static Map<Integer, TransactionTypeClassification> valueMap = null;

	private TransactionTypeClassification(int value) {
		this.value = value;
	}
}
