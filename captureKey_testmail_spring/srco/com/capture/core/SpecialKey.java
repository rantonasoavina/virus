package com.capture.core;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public class SpecialKey implements Comparable<SpecialKey> {
	private final String description;
	private final Integer keyCode;
	private static final SpecialKey[] KEYS = { new SpecialKey(36, "Home"), new SpecialKey(35, "End"),
			new SpecialKey(38, "Up"), new SpecialKey(40, "Down"), new SpecialKey(37, "Left"),
			new SpecialKey(39, "Right"), new SpecialKey(127, "Delete"), new SpecialKey(8, "Backspace"),
			new SpecialKey(33, "Page Up"), new SpecialKey(34, "Page Down"), new SpecialKey(112, "F1"),
			new SpecialKey(113, "F2"), new SpecialKey(114, "F3"), new SpecialKey(115, "F4"), new SpecialKey(116, "F5"),
			new SpecialKey(117, "F6"), new SpecialKey(118, "F7"), new SpecialKey(119, "F8"), new SpecialKey(120, "F9"),
			new SpecialKey(121, "F10"), new SpecialKey(122, "F11"), new SpecialKey(123, "F12") };

	static {
		Arrays.sort(KEYS);
	}

	private SpecialKey(int keyCode, String description) {
		this.keyCode = Integer.valueOf(keyCode);
		this.description = description;
	}

	public int getKeyCode() {
		return this.keyCode.intValue();
	}

	public String getDescription() {
		return this.description;
	}

	public static SpecialKey getKeyByKeyCode(int keyCode) {
		int index = Arrays.binarySearch(KEYS, new SpecialKey(keyCode, null));
		return index >= 0 ? KEYS[index] : null;
	}

	public static SpecialKey getKeyByKeyEvent(KeyEvent evt) {
		return getKeyByKeyCode(evt.getKeyCode());
	}

	public boolean equals(Object o) {
		if (((o instanceof SpecialKey)) && (((SpecialKey) o).keyCode == this.keyCode)) {
			return true;
		}
		return false;
	}

	public int compareTo(SpecialKey sk) {
		return this.keyCode.compareTo(sk.keyCode);
	}

	public int hashCode() {
		return 13 * this.keyCode.intValue();
	}

	public String toString() {
		return this.description;
	}
}
