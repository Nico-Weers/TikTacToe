package utils;

import java.util.Properties;

public abstract class LanguageDictionary {
	private static final String LANGUAGE_DICTIONARY_PATTERN = "(language_Properties_\\w{2}\\.properties)";
	private static final ApplicationPaths DEFAULT_DICTIONARY = ApplicationPaths.LANGUAGE_PROPERTIES_EN;
	private static Properties dictionary;
	private static ApplicationPaths languagePath;

	public static String getEntry(String key) {
		if (LanguageDictionary.dictionary == null) {
			if(languagePath==null) {
				switch (System.getProperty("user.language")) {
					case "de":
						LanguageDictionary.languagePath = ApplicationPaths.LANGUAGE_PROPERTIES_DE;
						break;
					default:
						LanguageDictionary.languagePath = DEFAULT_DICTIONARY;
						break;
				}

			}
			updateDictionary(languagePath);
		}
		return dictionary.getProperty(key);
	}

	public static void updateDictionary(ApplicationPaths applicationPath) {
		if (applicationPath.getPath().matches(LANGUAGE_DICTIONARY_PATTERN))
			LanguageDictionary.dictionary = LoadProperties.loadProperties(applicationPath.getPath());
	}
}
