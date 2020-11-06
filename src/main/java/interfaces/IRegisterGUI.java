package interfaces;

import java.util.List;

public interface IRegisterGUI extends ISwingGUI {
	public void initialize();
	public List<String> getUsernames();
	public void showAndWait();
}
