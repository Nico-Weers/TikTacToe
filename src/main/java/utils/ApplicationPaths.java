package utils;

public enum ApplicationPaths {
	LANGUAGE_PROPERTIES_EN("language_Properties_EN.properties"), LANGUAGE_PROPERTIES_DE("language_Properties_DE.properties");

	private final String path;

	ApplicationPaths(String path) {
		this.path = path;
	}

	public String getPath() {
		return this.path;
	}
}
