import generics.*;

public interface AngryCollab {
	
	void addEnemy(AbsCollaboratorClass enemy);
	
	void removeEnemy(AbsCollaboratorClass enemy);
	
	boolean isAnEnemy(String name);
	
	Array<AbsCollaboratorClass> getEnemies();
	
}
