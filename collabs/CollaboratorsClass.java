package collabs;

import generics.IteratorClass;
import generics.Iterator;
public class CollaboratorsClass implements Collaborators {
	private CollabListClass collabs;

	public CollaboratorsClass() { 
		collabs = new CollabListClass();
	}

	@Override
	public int addCollaborator(String type, int salary, String name, String status) {
		// TODO Auto-generated method stub
		int error = 0;
		if (collabs.searchByName(name)!= null)
			error = 1;
		else if (!(type.equals(JUNIOR) || type.equals(SENIOR) || type.equals(DIRECTOR) || type.equals(TECHNICIAN)
				|| type.equals(ACTOR)))
			error = 2;
		else if ((type.equals(DIRECTOR) || type.equals(ACTOR)) && !(status.equals(VEDETA) || status.equals(NORMAL)))
			error = 3;
		else if (salary < 0)
			error = 4;
		else
			collabs.addCollaborator(type, status, salary, name); 
		return error; 
	}

	@Override
	public AbsCollaboratorClass getCollaborator(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbsCollaboratorClass getCollaboratorByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void scheduleCollabEvent(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public int collabDislikesSomeone(String hostName, String targetName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int collabLikesSomeone(String hostName, String targetName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<AbsCollaboratorClass> getIterator() {
		// TODO Auto-generated method stub
		return collabs.getIterator();
	}

	@Override
	public int addEnemy(String vedetaName, String targetName) {
		// TODO Auto-generated method stub
		return collabs.addEnemy(vedetaName, targetName);
	}

}
