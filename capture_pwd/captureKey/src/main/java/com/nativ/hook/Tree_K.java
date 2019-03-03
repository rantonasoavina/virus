package com.nativ.hook;

public class Tree_K  {
//	private final String description;
//	private final Integer keyCode;
//	private static final Tree_K[] KEYS = { new Tree_K(36, "Home"), new Tree_K(35, "End"),
//			new Tree_K(38, "Up"), new Tree_K(40, "Down"), new Tree_K(37, "Left"),
//			new Tree_K(39, "Right"), new Tree_K(127, "Delete"), new Tree_K(8, "Backspace"),
//			new Tree_K(33, "Page Up"), new Tree_K(34, "Page Down"), new Tree_K(112, "F1"),
//			new Tree_K(113, "F2"), new Tree_K(114, "F3"), new Tree_K(115, "F4"), new Tree_K(116, "F5"),
//			new Tree_K(117, "F6"), new Tree_K(118, "F7"), new Tree_K(119, "F8"), new Tree_K(120, "F9"),
//			new Tree_K(121, "F10"), new Tree_K(122, "F11"), new Tree_K(123, "F12") };
//
//	static {
//		Arrays.sort(KEYS);
//	}
//
//	private Tree_K(int keyCode, String description) {
//		this.keyCode = Integer.valueOf(keyCode);
//		this.description = description;
//	}
//
//	public int getKeyCode() {
//		return this.keyCode.intValue();
//	}
//
//	public String getDescription() {
//		return this.description;
//	}
//
//	public static Tree_K getKeyByKeyCode(int keyCode) {
//		int index = Arrays.binarySearch(KEYS, new Tree_K(keyCode, null));
//		return index >= 0 ? KEYS[index] : null;
//	}
//
//	public static Tree_K getKeyByKeyEvent(KeyEvent evt) {
//		return getKeyByKeyCode(evt.getKeyCode());
//	}
//
	public boolean equals(Object o) {
//		if (((o instanceof Tree_K)) && (((Tree_K) o).keyCode == this.keyCode)) {
			return true;
//		}
//		return false;
	}
//
//	public int compareTo(Tree_K sk) {
//		return this.keyCode.compareTo(sk.keyCode);
//	}
//
//	public int hashCode() {
//		return 13 * this.keyCode.intValue();
//	}
//
//	public String toString() {
//		return this.description;
//	}
}
