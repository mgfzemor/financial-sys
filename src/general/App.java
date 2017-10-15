package general;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import finantials.*;
import ui.MenuOptions;
import ui.MenuOptionsCmd;

public class App {
	private static MenuOptions menuOptions;
	
	public static void main(String args[]) {
		menuOptions = new MenuOptionsCmd();
		menuOptions.show();
	}

}
