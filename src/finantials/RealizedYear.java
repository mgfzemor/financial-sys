package finantials;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RealizedYear{

	private Map<Integer, Realized> realizeds;
	
	public RealizedYear() {
		this.realizeds = new HashMap<Integer, Realized>();
	}
	
	public void setRealized(Realized realized) {
		this.realizeds.put(realized.getMonth(),realized);
	}
	
	public Realized getRealized(int month) {
		return this.realizeds.get(month);
	}
	
	public Collection<Realized> getAllRealizeds() {
		return this.realizeds.values();
	}

}
