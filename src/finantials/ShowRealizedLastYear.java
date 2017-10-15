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
		for(Realized realized: project.getRealizedsLastYear()) {
			this.output.println(" ---- MES ----"+realized.getMonth());
			for (Rubric rubric: realized.getAllRubrics()) {
				this.output.println(rubric.toString());
			}
		}
	}
}
