package collabs;

public interface AbsCollaborator {

	String getName();

	int getPay();

	boolean equals(AbsCollaboratorClass target);

	Event getEventByIndex(int index);

}
