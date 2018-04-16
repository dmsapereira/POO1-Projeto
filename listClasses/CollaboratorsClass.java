package listClasses;

import collabs.AbsCollaboratorClass;
import collabs.ActorClass;
import collabs.AngryActorClass;
import collabs.AngryDirectorClass;
import collabs.DirectorClass;
import collabs.ProducerClass;
import collabs.TechnicianClass;

public class CollaboratorsClass implements Collaborators {
	private ActorListClass actors;
	private CollabListClass collabs;
	private DirectorListClass directors;
	private ProducerListClass producers;
	private TechnicianListClass technicians;
	private Object DirectorClass;

	public CollaboratorsClass() {
		actors = new ActorListClass();
		collabs = new CollabListClass();
		directors = new DirectorListClass();
		producers = new ProducerListClass();
		technicians = new TechnicianListClass();

	}

	@Override
	public int addCollaborator(String type, int salary, String name, String status) {
		// TODO Auto-generated method stub
		int error = 0;
		if ((name) != null)
			error = 1;
		else if (!(type.equals(JUNIOR) || type.equals(SENIOR) || type.equals(DIRECTOR) || type.equals(TECHNICIAN)
				|| type.equals(ACTOR)))
			error = 2;
		else if ((type.equals(DIRECTOR) || type.equals(ACTOR)) && !(status.equals(VEDETA) || status.equals(NORMAL)))
			error = 3;
		else if (salary < 0)
			error = 4;
		else {
			switch (type) {
			case SENIOR:
			case JUNIOR:
				ProducerClass newProducer = new ProducerClass(name, salary, type);
				producers.addCollaborator(newProducer);
				break;
			case DIRECTOR:
				DirectorClass newDirector;
				if (status.equals(VEDETA)) {
					 newDirector = new AngryDirectorClass(name, salary);
				} else {
					 newDirector = new DirectorClass(name, salary);
				}
				directors.addCollaborator(newDirector);
				break;

			}
		}
	}

	@Override
	public AbsCollaboratorClass getCollaborator(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbsCollaboratorClass getCollaboratorByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void scheduleCollabEvent(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public int collabDislikesSomeone(String hostName, String targetName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int collabLikesSomeone(String hostName, String targetName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
