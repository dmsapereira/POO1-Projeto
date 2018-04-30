
import generics.Array;
import generics.ArrayClass;
import generics.Iterator;

public class AngryActorClass extends ActorClass implements AngryCollab {
	ArrayClass<AbsCollaboratorClass> enemies;

	public AngryActorClass(String name, int salary) {
		super(name, salary);
		enemies = new ArrayClass<AbsCollaboratorClass>();
	}

	public boolean addEnemy(AbsCollaboratorClass enemy) {
		if (isAnEnemy(enemy.getName()) == false) {
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
		Iterator<AbsCollaboratorClass> itera = enemies.iterator();
		while (itera.hasNext()) {
			if (itera.next().getName().equals(name))
				return true;
		}
		return false;
	}

	@Override
	public Array<AbsCollaboratorClass> getEnemies() {
		return enemies;
	}

}
