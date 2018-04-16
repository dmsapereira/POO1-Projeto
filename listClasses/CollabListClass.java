package listClasses;

import collabs.AbsCollaboratorClass;
import generics.ArrayClass;

public class CollabListClass implements List {
	public static final int DEFAULT_SIZE = 50;
	ArrayClass<AbsCollaboratorClass> collabs;

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
	public int addCollaborator(AbsCollaboratorClass newGuy) {
		// TODO Auto-generated method stub
		if(searchByName(newGuy.getName())==null)
			collabs.insertLast(newGuy);
		else
			return null;
	}

	private AbsCollaboratorClass searchByName(String name) {
		for (int i = 0; i < collabs.size(); i++) {
			if (collabs.get(i).getName().equals(name))
				return collabs.get(i);
		}
		return null;
	}

}
