package listClasses;

import collabs.AbsCollaboratorClass;
import generics.ArrayClass;

public class CollabListClass implements List {
	public static final String SENIOR = "SENIOR";
	public static final String JUNIOR = "JUNIOR";
	public static final String REALIZADOR = "REALIZADOR";
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
	public AbsCollaboratorClass getCollabByName(String name) {
		// TODO Auto-generated method stub
		return searchByName(name);
	}

	@Override
	public AbsCollaboratorClass getCollabByIndex(int index) {
		// TODO Auto-generated method stub
		return collabs.get(index);
	}

	@Override
	public void addCollaborator(AbsCollaboratorClass newGuy) {
		// TODO Auto-generated method stub
		collabs.insertLast(newGuy);
	}

	private AbsCollaboratorClass searchByName(String name) {
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

}
