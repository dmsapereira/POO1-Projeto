package collabs;
import generics.Iterator;
import generics.IteratorClass;

public interface List {

	String getName(int index);

	int getSalary(String name);
	
	int getSize();

	AbsCollaboratorClass getCollabByName(String name);

	AbsCollaboratorClass getCollabByIndex(int index);

	void addCollaborator(String type, String status, int cost, String name);

	void updateCollab(String name);
	
	Iterator<AbsCollaboratorClass> getIterator();
	
	int addEnemy(String vedetaName, String targetName);

}
