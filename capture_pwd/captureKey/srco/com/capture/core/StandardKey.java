package com.capture.core;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public class StandardKey implements Comparable<StandardKey> {
	private final Character character;
	private final Integer keyCode;
	private final boolean shiftDown;
	private final boolean altDown;
	private static int VK_COLON = 129;
	private static int VK_EXCLAMATION_MARK = 0;
	private static int VK_ASTERISK = 92;
	private static int VK_5 = 192;
	private static int VK_5_bis = 53;
	private static int VK_CIRCUMFLEX = 93;
	private static int VK_DOLLAR = 59;
	private static final StandardKey[] KEYS = { new StandardKey('a', 65), new StandardKey('b', 66),
			new StandardKey('c', 67), new StandardKey('d', 68), new StandardKey('e', 69), new StandardKey('f', 70),
			new StandardKey('g', 71), new StandardKey('h', 72), new StandardKey('i', 73), new StandardKey('j', 74),
			new StandardKey('k', 75), new StandardKey('l', 76), new StandardKey('m', 77), new StandardKey('n', 78),
			new StandardKey('o', 79), new StandardKey('p', 80), new StandardKey('q', 81), new StandardKey('r', 82),
			new StandardKey('s', 83), new StandardKey('t', 84), new StandardKey('u', 85), new StandardKey('v', 86),
			new StandardKey('w', 87), new StandardKey('x', 88), new StandardKey('y', 89), new StandardKey('z', 90),
			new StandardKey('A', 65, true), new StandardKey('B', 66, true), new StandardKey('C', 67, true),
			new StandardKey('D', 68, true), new StandardKey('E', 69, true), new StandardKey('F', 70, true),
			new StandardKey('G', 71, true), new StandardKey('H', 72, true), new StandardKey('I', 73, true),
			new StandardKey('J', 74, true), new StandardKey('K', 75, true), new StandardKey('L', 76, true),
			new StandardKey('M', 77, true), new StandardKey('N', 78, true), new StandardKey('O', 79, true),
			new StandardKey('P', 80, true), new StandardKey('Q', 81, true), new StandardKey('R', 82, true),
			new StandardKey('S', 83, true), new StandardKey('T', 84, true), new StandardKey('U', 85, true),
			new StandardKey('V', 86, true), new StandardKey('W', 87, true), new StandardKey('X', 88, true),
			new StandardKey('Y', 89, true), new StandardKey('Z', 90, true), new StandardKey('0', 48, true),
			new StandardKey('1', 49, true), new StandardKey('2', 50, true), new StandardKey('3', 51, true),
			new StandardKey('4', 52, true), new StandardKey('5', VK_5_bis, true), new StandardKey('6', 54, true),
			new StandardKey('7', 55, true), new StandardKey('8', 56, true), new StandardKey('9', 57, true),
			new StandardKey('à', 48), new StandardKey('&', 49), new StandardKey('é', 50), new StandardKey('"', 51),
			new StandardKey('\\', 52), new StandardKey('(', VK_5_bis), new StandardKey('-', 54),
			new StandardKey('è', 55), new StandardKey('_', 56), new StandardKey('ç', 57), new StandardKey('-', 45),
			new StandardKey('=', 61), new StandardKey('+', 61, true), new StandardKey('~', 77777, true),
			new StandardKey('!', VK_EXCLAMATION_MARK), new StandardKey('§', VK_EXCLAMATION_MARK, true),
			new StandardKey('@', 512), new StandardKey('#', 520), new StandardKey('$', VK_DOLLAR),
			new StandardKey('£', VK_DOLLAR, true), new StandardKey('%', VK_5, true), new StandardKey('ù', VK_5),
			new StandardKey('^', VK_CIRCUMFLEX), new StandardKey('¨', VK_CIRCUMFLEX, true), new StandardKey('&', 150),
			new StandardKey('*', VK_ASTERISK), new StandardKey('µ', VK_ASTERISK, true), new StandardKey('(', 519),
			new StandardKey(')', 522), new StandardKey('_', 523), new StandardKey('+', 521), new StandardKey('\t', 9),
			new StandardKey('\n', 10), new StandardKey(' ', 32), new StandardKey(')', 91),
			new StandardKey('°', 91, true),

			new StandardKey('}', 61, true), new StandardKey('|', 92, true),

			new StandardKey('.', 59, true), new StandardKey('\'', 222), new StandardKey(':', VK_COLON),
			new StandardKey('/', VK_COLON, true), new StandardKey('"', 152), new StandardKey(',', 44),
			new StandardKey('?', 44, true), new StandardKey('.', 46, true), new StandardKey(';', 46),
			new StandardKey('/', 47), new StandardKey('>', 160), new StandardKey('<', 153),

			new StandardKey(Character.valueOf('?'), 65, false, true),
			new StandardKey(Character.valueOf('?'), 67, false, true),
			new StandardKey(Character.valueOf('?'), 69, false, true),
			new StandardKey(Character.valueOf('?'), 76, false, true),
			new StandardKey(Character.valueOf('?'), 78, false, true),
			new StandardKey(Character.valueOf('?'), 79, false, true),
			new StandardKey(Character.valueOf('?'), 83, false, true),
			new StandardKey(Character.valueOf('?'), 88, false, true),
			new StandardKey(Character.valueOf('?'), 90, false, true),
			new StandardKey(Character.valueOf('?'), 65, true, true),
			new StandardKey(Character.valueOf('?'), 67, true, true),
			new StandardKey(Character.valueOf('?'), 69, true, true),
			new StandardKey(Character.valueOf('?'), 76, true, true),
			new StandardKey(Character.valueOf('?'), 78, true, true),
			new StandardKey(Character.valueOf('?'), 79, true, true),
			new StandardKey(Character.valueOf('?'), 83, true, true),
			new StandardKey(Character.valueOf('?'), 88, true, true),
			new StandardKey(Character.valueOf('?'), 90, true, true) };

	static {
		Arrays.sort(KEYS);
	}

	private StandardKey(Character character, int keyCode, boolean shiftDown, boolean altDown) {
		this.character = character;
		this.keyCode = Integer.valueOf(keyCode);
		this.shiftDown = shiftDown;
		this.altDown = altDown;
	}

	private StandardKey(char character, int keyCode, boolean shiftDown) {
		this(Character.valueOf(character), keyCode, shiftDown, false);
	}

	private StandardKey(char character, int keyCode) {
		this(character, keyCode, false);
	}

	public Character getCharacter() {
		return this.character;
	}

	public Integer getKeyCode() {
		return this.keyCode;
	}

	public boolean isShiftDown() {
		return this.shiftDown;
	}

	public boolean isAltDown() {
		return this.altDown;
	}

	public static StandardKey getKeyByCharacter(char character) {
		StandardKey[] arrayOfStandardKey;
		int j = (arrayOfStandardKey = KEYS).length;
		for (int i = 0; i < j; i++) {
			StandardKey sk = arrayOfStandardKey[i];
			if (sk.character.equals(Character.valueOf(character))) {
				return sk;
			}
		}
		return null;
	}

	public static StandardKey getKeyByKeyCode(int keyCode, boolean shiftDown, boolean altDown) {
		int index = Arrays.binarySearch(KEYS, new StandardKey(null, keyCode, shiftDown, altDown));
		return index >= 0 ? KEYS[index] : null;
	}

	public static StandardKey getKeyByKeyEvent(KeyEvent evt) {
		return getKeyByKeyCode(evt.getKeyCode(), evt.isShiftDown(), evt.isAltDown());
	}

	public int compareTo(StandardKey sk) {
		int keyCodeComparison = this.keyCode.compareTo(sk.keyCode);
		if (keyCodeComparison == 0) {
			int shiftComparison = Boolean.compare(this.shiftDown, sk.shiftDown);
			if (shiftComparison == 0) {
				return Boolean.compare(this.altDown, sk.altDown);
			}
			return shiftComparison;
		}
		return keyCodeComparison;
	}

	public boolean equals(Object o) {
		if ((o instanceof StandardKey)) {
			StandardKey sk = (StandardKey) o;

			return (this.character.equals(sk.character)) && (this.keyCode.equals(sk.keyCode))
					&& (this.shiftDown == sk.shiftDown) && (this.altDown == sk.altDown);
		}
		return false;
	}

	public int hashCode() {
		return 7 * this.keyCode.intValue() + '[' * this.character.charValue();
	}

	public String toString() {
		return "'" + this.character + "' -> " + this.keyCode + ", shift: " + this.shiftDown + ", alt: " + this.altDown;
	}
}
