package listClasses;

import collabs.AbsCollaboratorClass;

public interface List {
	String getName(int index);

	int getSalary(String name);

	AbsCollaboratorClass getCollabByName(String name);

	AbsCollaboratorClass getCollabByIndex(int index);

	int addCollaborator(String type, int pay, String name);

	int addCollaborator(String type, int pay, String name, String rep);

}
