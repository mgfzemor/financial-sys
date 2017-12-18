package general;

import java.util.HashMap;

public class Parameters {

	private HashMap<String,Object> parameters;

	public void setFloat(String name, float value) {
		parameters.put(name, value);
	}

	public float getFloat(String name) {
		return (float)parameters.get(name);
	}

	public void setInt(String name, int value) {
		parameters.put(name, value);
	}

	public int getInt(String name) {
		return (int)parameters.get(name);
	}

	public void setString(String name, String value) {
		parameters.put(name, value);
	}

	public String getString(String name) {
		return (String)parameters.get(name);
	}

}
