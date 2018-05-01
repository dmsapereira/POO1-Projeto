

import generics.Array;
import generics.ArrayClass;
import generics.Iterator;

public class AngryDirectorClass extends DirectorClass implements AngryCollab {
	ArrayClass<AbsCollaboratorClass> enemies;

	public AngryDirectorClass(String name, int salary) {
		super(name, salary);
		enemies = new ArrayClass<AbsCollaboratorClass>();
	}

	public void addEnemy(AbsCollaboratorClass enemy) {
			enemies.insertLast(enemy); 
	}

	public void removeEnemy(AbsCollaboratorClass enemy) { 
			enemies.remove(enemy);
	}

	public boolean isAnEnemy(String name) {
		Iterator <AbsCollaboratorClass> itera = enemies.iterator();
			while(itera.hasNext()) {
				if(itera.next().getName().equals(name))
					return true;
			}
			return false; 
	}

	@Override
	public Array<AbsCollaboratorClass> getEnemies() {
		return enemies;
	}
	
	
}
