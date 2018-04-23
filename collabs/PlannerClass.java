package collabs;

import generics.Iterator;

public class PlannerClass implements Planner {
	public static final String ACTOR = "ACTOR";
	public static final String SENIOR = "SENIOR";
	public static final String JUNIOR = "JUNIOR";
	public static final String TECHNICIAN = "TECNICO";
	public static final String DIRECTOR = "REALIZADOR";
	public static final String NORMAL = "NORMAL";
	public static final String VEDETA = "VEDETA";
	CollabListClass collabs;

	public PlannerClass() {
		collabs = new CollabListClass();
	}

	@Override
	public int addWorker(String type, String status, int cost, String name) {
		// TODO Auto-generated method stub
		int error = 0;
		if (collabs.getCollabByName(name) != null)
			error = 1;
		else if (!(type.equals(SENIOR) || type.equals(JUNIOR) || type.equals(ACTOR) || type.equals(TECHNICIAN)
				|| type.equals(DIRECTOR)))
			error = 2;
		else if ((type.equals(DIRECTOR) || type.equals(ACTOR)) && (!(status.equals(NORMAL) || status.equals(VEDETA))))
			error = 3;
		else if (cost < 0)
			error = 4;
		else
			collabs.addCollaborator(type, status, cost, name);
		return error;
	}

	@Override
	public Iterator<AbsCollaboratorClass> getCollabIterator() {
		// TODO Auto-generated method stub
		return collabs.getIterator();
	}

	@Override
	public int addEnemy(String vedetaName, String targetName) {
		// TODO Auto-generated method stub
		return collabs.addEnemy(vedetaName, targetName);
	}
}
