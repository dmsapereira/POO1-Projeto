package collabs;

import generics.ArrayClass;

public class AngryActorClass extends ActorClass implements AngryCollab {
	ArrayClass<AbsCollaboratorClass> enemies;

	public AngryActorClass(String name, int salary) {
		super(name, salary);
		enemies = new ArrayClass<AbsCollaboratorClass>();
	}

	public boolean addEnemy(AbsCollaboratorClass enemy) {
		if (isAnEnemy(enemy.getName())) {
			enemies.insertLast(enemy);
			return true;
		} else
			return false;
	}

	public boolean removeEnemy(AbsCollaboratorClass enemy) {
		if (isAnEnemy(enemy.getName())) {
			enemies.remove(enemy);
			return true;
		} else
			return false;
	}

	public boolean isAnEnemy(String name) {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getName().equals(name))
				return true;
		}
		return false;
	}
	
	public boolean isAnEnemy(AbsCollaboratorClass enemy) {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).equals(enemy))
				return true;
		}
		return false;
	}

}
