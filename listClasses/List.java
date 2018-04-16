package listClasses;

import collabs.AbsCollaboratorClass;

public interface List {
	String getName(int index);

	int getSalary(String name);

	AbsCollaboratorClass getCollabByName(String name);

	AbsCollaboratorClass getCollabByIndex(int index);

	void addCollaborator(AbsCollaboratorClass newGuy);

	void updateCollab(String name);

}
