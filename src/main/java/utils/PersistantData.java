package utils;

import java.util.prefs.Preferences;

public abstract class PersistantData {
	private static Preferences prefsRoot = Preferences.userRoot();
	private static Preferences msmxPref = prefsRoot.node("MSMX");

	public static void savePersistant(String key, String value) {
		msmxPref.put(key, value);
	}

	public static String get(String key, String defaultValue) {
		return msmxPref.get(key, defaultValue);
	}

	public static void deleteEntry(String key) {
		msmxPref.remove(key);
	}
}
