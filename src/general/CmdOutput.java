package general;

public class CmdOutput implements Output {
	
	/**
	 * @see general.Output#println(String)
	 */
	
	@Override
	public void println(String out) {
		System.out.println(out);
	}
	
	/**
	 * @see general.Output#print(String)
	 */
	@Override
	public void print(String out) {
		System.out.print(out);		
	}
}
