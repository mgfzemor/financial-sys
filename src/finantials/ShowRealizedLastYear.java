/**
 * 
 */
package finantials;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author mgfzemor
 */
public class ShowRealizedLastYear extends AbstractProjectCommand {
	
	@Override
	public void execute(Project project){
		Collection<Realized> realizeds =  project.getRealizedsLastYear();
		for(Iterator<Realized> iterator = realizeds.iterator(); iterator.hasNext();) {
			Realized realized = iterator.next();
			this.output.println(" ---- MES ----"+realized.getMonth());
			for (Rubric rubric: realized.getAllRubrics()) {
				this.output.println(rubric.toString());
			}
		}
	}
}
