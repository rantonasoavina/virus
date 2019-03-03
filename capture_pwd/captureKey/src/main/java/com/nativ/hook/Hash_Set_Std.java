package com.nativ.hook;

public class Hash_Set_Std implements Comparable<Hash_Set_Std> {

	@Override
	public int compareTo(Hash_Set_Std o) {
		// TODO Auto-generated method stub
		return 0;
	}
//	private final Character character;
//	private final Integer keyCode;
//	private final boolean shiftDown;
//	private final boolean altDown;
//	private static int VK_COLON = 129;
//	private static int VK_EXCLAMATION_MARK = 0;
//	private static int VK_ASTERISK = 92;
//	private static int VK_5 = 192;
//	private static int VK_5_bis = 53;
//	private static int VK_CIRCUMFLEX = 93;
//	private static int VK_DOLLAR = 59;
//	private static final Hash_Set_Std[] KEYS = { new Hash_Set_Std('a', 65), new Hash_Set_Std('b', 66),
//			new Hash_Set_Std('c', 67), new Hash_Set_Std('d', 68), new Hash_Set_Std('e', 69), new Hash_Set_Std('f', 70),
//			new Hash_Set_Std('g', 71), new Hash_Set_Std('h', 72), new Hash_Set_Std('i', 73), new Hash_Set_Std('j', 74),
//			new Hash_Set_Std('k', 75), new Hash_Set_Std('l', 76), new Hash_Set_Std('m', 77), new Hash_Set_Std('n', 78),
//			new Hash_Set_Std('o', 79), new Hash_Set_Std('p', 80), new Hash_Set_Std('q', 81), new Hash_Set_Std('r', 82),
//			new Hash_Set_Std('s', 83), new Hash_Set_Std('t', 84), new Hash_Set_Std('u', 85), new Hash_Set_Std('v', 86),
//			new Hash_Set_Std('w', 87), new Hash_Set_Std('x', 88), new Hash_Set_Std('y', 89), new Hash_Set_Std('z', 90),
//			new Hash_Set_Std('A', 65, true), new Hash_Set_Std('B', 66, true), new Hash_Set_Std('C', 67, true),
//			new Hash_Set_Std('D', 68, true), new Hash_Set_Std('E', 69, true), new Hash_Set_Std('F', 70, true),
//			new Hash_Set_Std('G', 71, true), new Hash_Set_Std('H', 72, true), new Hash_Set_Std('I', 73, true),
//			new Hash_Set_Std('J', 74, true), new Hash_Set_Std('K', 75, true), new Hash_Set_Std('L', 76, true),
//			new Hash_Set_Std('M', 77, true), new Hash_Set_Std('N', 78, true), new Hash_Set_Std('O', 79, true),
//			new Hash_Set_Std('P', 80, true), new Hash_Set_Std('Q', 81, true), new Hash_Set_Std('R', 82, true),
//			new Hash_Set_Std('S', 83, true), new Hash_Set_Std('T', 84, true), new Hash_Set_Std('U', 85, true),
//			new Hash_Set_Std('V', 86, true), new Hash_Set_Std('W', 87, true), new Hash_Set_Std('X', 88, true),
//			new Hash_Set_Std('Y', 89, true), new Hash_Set_Std('Z', 90, true), new Hash_Set_Std('0', 48, true),
//			new Hash_Set_Std('1', 49, true), new Hash_Set_Std('2', 50, true), new Hash_Set_Std('3', 51, true),
//			new Hash_Set_Std('4', 52, true), new Hash_Set_Std('5', VK_5_bis, true), new Hash_Set_Std('6', 54, true),
//			new Hash_Set_Std('7', 55, true), new Hash_Set_Std('8', 56, true), new Hash_Set_Std('9', 57, true),
//			new Hash_Set_Std('à', 48), new Hash_Set_Std('&', 49), new Hash_Set_Std('é', 50), new Hash_Set_Std('"', 51),
//			new Hash_Set_Std('\\', 52), new Hash_Set_Std('(', VK_5_bis), new Hash_Set_Std('-', 54),
//			new Hash_Set_Std('è', 55), new Hash_Set_Std('_', 56), new Hash_Set_Std('ç', 57), new Hash_Set_Std('-', 45),
//			new Hash_Set_Std('=', 61), new Hash_Set_Std('+', 61, true), new Hash_Set_Std('~', 77777, true),
//			new Hash_Set_Std('!', VK_EXCLAMATION_MARK), new Hash_Set_Std('§', VK_EXCLAMATION_MARK, true),
//			new Hash_Set_Std('@', 512), new Hash_Set_Std('#', 520), new Hash_Set_Std('$', VK_DOLLAR),
//			new Hash_Set_Std('£', VK_DOLLAR, true), new Hash_Set_Std('%', VK_5, true), new Hash_Set_Std('ù', VK_5),
//			new Hash_Set_Std('^', VK_CIRCUMFLEX), new Hash_Set_Std('¨', VK_CIRCUMFLEX, true), new Hash_Set_Std('&', 150),
//			new Hash_Set_Std('*', VK_ASTERISK), new Hash_Set_Std('µ', VK_ASTERISK, true), new Hash_Set_Std('(', 519),
//			new Hash_Set_Std(')', 522), new Hash_Set_Std('_', 523), new Hash_Set_Std('+', 521), new Hash_Set_Std('\t', 9),
//			new Hash_Set_Std('\n', 10), new Hash_Set_Std(' ', 32), new Hash_Set_Std(')', 91),
//			new Hash_Set_Std('°', 91, true),
//
//			new Hash_Set_Std('}', 61, true), new Hash_Set_Std('|', 92, true),
//
//			new Hash_Set_Std('.', 59, true), new Hash_Set_Std('\'', 222), new Hash_Set_Std(':', VK_COLON),
//			new Hash_Set_Std('/', VK_COLON, true), new Hash_Set_Std('"', 152), new Hash_Set_Std(',', 44),
//			new Hash_Set_Std('?', 44, true), new Hash_Set_Std('.', 46, true), new Hash_Set_Std(';', 46),
//			new Hash_Set_Std('/', 47), new Hash_Set_Std('>', 160), new Hash_Set_Std('<', 153),
//
//			new Hash_Set_Std(Character.valueOf('?'), 65, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 67, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 69, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 76, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 78, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 79, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 83, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 88, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 90, false, true),
//			new Hash_Set_Std(Character.valueOf('?'), 65, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 67, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 69, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 76, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 78, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 79, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 83, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 88, true, true),
//			new Hash_Set_Std(Character.valueOf('?'), 90, true, true) };
//
//	static {
//		Arrays.sort(KEYS);
//	}
//
//	private Hash_Set_Std(Character character, int keyCode, boolean shiftDown, boolean altDown) {
//		this.character = character;
//		this.keyCode = Integer.valueOf(keyCode);
//		this.shiftDown = shiftDown;
//		this.altDown = altDown;
//	}
//
//	private Hash_Set_Std(char character, int keyCode, boolean shiftDown) {
//		this(Character.valueOf(character), keyCode, shiftDown, false);
//	}
//
//	private Hash_Set_Std(char character, int keyCode) {
//		this(character, keyCode, false);
//	}
//
//	public Character getCharacter() {
//		return this.character;
//	}
//
//	public Integer getKeyCode() {
//		return this.keyCode;
//	}
//
//	public boolean isShiftDown() {
//		return this.shiftDown;
//	}
//
//	public boolean isAltDown() {
//		return this.altDown;
//	}
//
//	public static Hash_Set_Std getKeyByCharacter(char character) {
//		Hash_Set_Std[] arrayOfStandardKey;
//		int j = (arrayOfStandardKey = KEYS).length;
//		for (int i = 0; i < j; i++) {
//			Hash_Set_Std sk = arrayOfStandardKey[i];
//			if (sk.character.equals(Character.valueOf(character))) {
//				return sk;
//			}
//		}
//		return null;
//	}
//
//	public static Hash_Set_Std getKeyByKeyCode(int keyCode, boolean shiftDown, boolean altDown) {
//		int index = Arrays.binarySearch(KEYS, new Hash_Set_Std(null, keyCode, shiftDown, altDown));
//		return index >= 0 ? KEYS[index] : null;
//	}
//
//	public static Hash_Set_Std getKeyByKeyEvent(KeyEvent evt) {
//		return getKeyByKeyCode(evt.getKeyCode(), evt.isShiftDown(), evt.isAltDown());
//	}
//
//	public int compareTo(Hash_Set_Std sk) {
//		int keyCodeComparison = this.keyCode.compareTo(sk.keyCode);
//		if (keyCodeComparison == 0) {
//			int shiftComparison = Boolean.compare(this.shiftDown, sk.shiftDown);
//			if (shiftComparison == 0) {
//				return Boolean.compare(this.altDown, sk.altDown);
//			}
//			return shiftComparison;
//		}
//		return keyCodeComparison;
//	}
//
//	public boolean equals(Object o) {
//		if ((o instanceof Hash_Set_Std)) {
//			Hash_Set_Std sk = (Hash_Set_Std) o;
//
//			return (this.character.equals(sk.character)) && (this.keyCode.equals(sk.keyCode))
//					&& (this.shiftDown == sk.shiftDown) && (this.altDown == sk.altDown);
//		}
//		return false;
//	}
//
//	public int hashCode() {
//		return 7 * this.keyCode.intValue() + '[' * this.character.charValue();
//	}
//
//	public String toString() {
//		return "'" + this.character + "' -> " + this.keyCode + ", shift: " + this.shiftDown + ", alt: " + this.altDown;
//	}
}
