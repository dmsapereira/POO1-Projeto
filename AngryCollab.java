import generics.*;

public interface AngryCollab {
	
	boolean addEnemy(AbsCollaboratorClass enemy);
	
	boolean removeEnemy(AbsCollaboratorClass enemy);
	
	boolean isAnEnemy(String name);
	
	Array<AbsCollaboratorClass> getEnemies();
	
}
