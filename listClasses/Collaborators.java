package listClasses;

import collabs.AbsCollaboratorClass;

public interface Collaborators {
	public static final String SENIOR = "SENIOR";
	public static final String JUNIOR = "JUNIOR";
	public static final String DIRECTOR = "REALIZADOR";
	public static final String TECHNICIAN = "TECNICO";
	public static final String ACTOR = "ACTOR";
	public static final String VEDETA = "VEDETA";
	public static final String NORMAL = "NORMAL";

	int addCollaborator(String type, int salary, String name, String isAngry);

	AbsCollaboratorClass getCollaborator(String name);

	AbsCollaboratorClass getCollaboratorByIndex(int index);

	void scheduleCollabEvent(String name);

	int collabDislikesSomeone(String hostName, String targetName);

	int collabLikesSomeone(String hostName, String targetName);

}
