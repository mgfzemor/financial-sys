package general;

public interface TableResource {

	public abstract void loadFromFile(String filePath);
	public abstract void saveToFile(String filePath);

	public abstract void setValue(int i, int j, String value);

	public abstract void setValue(int i, int j, float value);

	public abstract void setValue(int i, int j, int value);

	public abstract String getString(int i, int j);

	public abstract float getFloat(int i, int j);

	public abstract int getInt(int i, int j);

	public abstract int rowCount();
	
	public abstract int columnCount();
}
