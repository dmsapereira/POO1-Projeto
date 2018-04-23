package collabs;
import generics.Iterator;

public interface Planner {

	int addWorker(String type, String status,int cost, String name);
	
	Iterator<AbsCollaboratorClass> getCollabIterator();
	
	int addEnemy(String vedetaName, String targetName);
	
	
	
}
