package collabs;

public interface AngryCollab {
	
	boolean addEnemy(AbsCollaboratorClass enemy);
	
	boolean removeEnemy(AbsCollaboratorClass enemy);
	
	boolean isAnEnemy(String name);
	
	boolean isAnEnemy(AbsCollaboratorClass enemy);

}
