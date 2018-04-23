package collabs;

import generics.ArrayClass;
import generics.Iterator;
import generics.IteratorClass;

public class CollabListClass implements List {
	public static final String SENIOR = "SENIOR";
	public static final String JUNIOR = "JUNIOR";
	public static final String DIRECTOR = "REALIZADOR";
	public static final String TECHNICIAN = "TECNICO";
	public static final String ACTOR = "ACTOR";
	public static final String VEDETA = "VEDETA";
	public static final String NORMAL = "NORMAL";
	protected ArrayClass<AbsCollaboratorClass> collabs;

	public CollabListClass() {
		collabs = new ArrayClass<AbsCollaboratorClass>();
	}

	public String getName(int index) {
		// TODO Auto-generated method stub
		return collabs.get(index).getName();
	}

	@Override
	public int getSalary(String name) {
		// TODO Auto-generated method stub
		return searchByName(name).getPay();
	}

	@Override
	public int getSize() {
		return collabs.size();
	}

	@Override
	public AbsCollaboratorClass getCollabByName(String name) {
		return searchByName(name);
	}

	@Override
	public AbsCollaboratorClass getCollabByIndex(int index) {
		return collabs.get(index);
	}

	@Override
	public void addCollaborator(String type, String status, int cost, String name) {
		switch (type) {
		case ACTOR:
			if (status.equals(VEDETA)) {
				AngryActorClass actor = new AngryActorClass(name, cost);
				collabs.insertLast(actor);
			} else {
				ActorClass actor = new ActorClass(name, cost);
				collabs.insertLast(actor);
			}
			break;
		case DIRECTOR:
			if (status.equals(VEDETA)) {
				AngryDirectorClass director = new AngryDirectorClass(name, cost);
				collabs.insertLast(director);
			} else {
				DirectorClass director = new DirectorClass(name, cost);
				collabs.insertLast(director);
			}
			break;
		case JUNIOR:
		case SENIOR:
			ProducerClass producer = new ProducerClass(name, cost, type);
			collabs.insertLast(producer);
			break;
		case TECHNICIAN:
			TechnicianClass linus = new TechnicianClass(name, cost);
			collabs.insertLast(linus);
			break;
		default:
		}

	}

	public AbsCollaboratorClass searchByName(String name) {
		for (int i = 0; i < collabs.size(); i++) {
			if (collabs.get(i).getName().equals(name))
				return collabs.get(i);
		}
		return null;
	}

	@Override
	public void updateCollab(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator<AbsCollaboratorClass> getIterator() {
		return collabs.iterator();
	}

	@Override
	public int addEnemy(String vedetaName, String targetName) {
		int error = 0;
		AbsCollaboratorClass current = searchByName(vedetaName);
		if ((current != null) && (!(current instanceof AngryCollab)))
			error = 1;
		else if (searchByName(targetName)==null) 
			error = 2;
		else if (((AngryCollab) current).isAnEnemy(targetName))
			error = 3;
		return error;

	}
}
