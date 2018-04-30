
import java.time.LocalDateTime;
import generics.*;

public class PlannerClass implements Planner {
	public static final String ACTOR = "ACTOR";
	public static final String SENIOR = "SENIOR";
	public static final String JUNIOR = "JUNIOR";
	public static final String TECHNICIAN = "TECNICO";
	public static final String DIRECTOR = "REALIZADOR";
	public static final String NORMAL = "NORMAL";
	public static final String VEDETA = "VEDETA";
	private CollabListClass collabs;
	private PlaceListClass places;
	private EventListClass events;

	public PlannerClass() {
		collabs = new CollabListClass();
		places = new PlaceListClass();
		events = new EventListClass();
	}

	@Override
	public int addWorker(String type, String status, int cost, String name) {
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
		return collabs.getIterator();
	}

	@Override
	public int addEnemy(String vedetaName, String targetName) {
		Iterator<Event> itera;
		Event aux;
		int error = collabs.addEnemy(vedetaName, targetName);
		int suspendCounter = 0;
		if (error == 0) {
			itera = events.eventsIterator();
			while (itera.hasNext()) {
				aux = itera.next();
				if (aux.collabExistence(vedetaName) && aux.collabExistence(targetName) && aux.isOnHold() == false
						&& aux.isSuspendedSenior() == false) {
					aux.suspendEvent();
					suspendCounter++;
				}
			}
			return suspendCounter;
		}
		return error;
	}

	@Override
	public int addPlace(String name, int cost) {
		int error = 0;
		if (places.alreadyExists(name))
			error = 1;
		else if (cost < 0)
			error = 2;
		else
			places.addPlace(name, cost);
		return error;
	}

	@Override
	public Iterator<PlaceClass> getPlaces() {
		return places.getPlaces();
	}

	@Override
	public int addEvent(String[] collabs, LocalDateTime start, int duration, String scenario) {
		int error = 0;
		Event current = new EventClass(convertCollabs(collabs), start, duration, places.getPlace(scenario));
		if (places.alreadyExists(scenario) == false)
			error = 1;
		else if (events.checkDate(start))
			error = 2;
		else if (places.getPlace(scenario).getCost() <= 0)
			error = 3;
		else if (this.collabs.getCollabByName(collabs[0]) == null
				|| !(this.collabs.getCollabByName(collabs[0]) instanceof ProducerClass))
			error = 4;
		else if (this.collabs.getCollabByName(collabs[1]) == null
				|| !(this.collabs.getCollabByName(collabs[1]) instanceof DirectorClass))
			error = 5;
		else if (this.collabs.getCollabByName(collabs[2]) == null
				|| !(this.collabs.getCollabByName(collabs[2]) instanceof TechnicianClass))
			error = 6;
		else if (!checkCollabs(collabs))
			error = 7;
		else if (checkEnemies(collabs)) {
			events.suspendEvent(start, places.getPlace(scenario));
			error = 8;
		} else if (!(this.checkEventAvailability(current)))
			error = 9;
		/*
		 * else if (current.checkForSenior()) { Event aux = conflictSolver(current); if
		 * (aux != null) aux.delayEvent(current.getEnd()); error = 10;
		 */
		else
			events.addEvent(current);
		return error;

	}

	private boolean checkCollabs(String[] collabs) {
		for (int i = 3; i < collabs.length - 3; i++) {
			if (this.collabs.getCollabByName(collabs[i]) == null)
				return false;
		}
		return true;
	}

	private boolean checkEnemies(String[] collabs) {
		AbsCollaboratorClass current;
		for (int i = 0; i < collabs.length; i++) {
			current = this.collabs.getCollabByName(collabs[i]);
			for (int j = i; j < collabs.length; j++) {
				if (current instanceof AngryCollab)
					if (((AngryCollab) current).isAnEnemy(collabs[j]))
						return true;
			}
		}
		return false;
	}

	private Array<AbsCollaboratorClass> convertCollabs(String[] collabs) {
		Array<AbsCollaboratorClass> aux = new ArrayClass<AbsCollaboratorClass>();
		for (int i = 0; i < collabs.length; i++) {
			aux.insertLast(this.collabs.getCollabByName(collabs[i]));
		}
		return aux;
	}

	private boolean checkEventAvailability(Event current) {
		Event aux;
		Iterator<Event> itera = events.eventsIterator();
		while (itera.hasNext()) {
			aux = itera.next();
			if (aux.getPlace().equals(current.getPlace())) {
				if (aux.getEnd().isAfter(current.getStart())) {
					if (current.checkForSenior() && !(aux.checkForSenior()))
						return true;
					else
						return false;
				}
			} else if (aux.getEnd().isAfter(current.getStart())) {
				if (current.sameCollab(aux))
					return false;
			}
		}
		return true;
	}

	private Event conflictSolver(Event current) {
		Event aux;
		Iterator<Event> itera = events.eventsIterator();
		while (itera.hasNext()) {
			aux = itera.next();
			if (aux.getPlace().equals(current.getPlace())) {
				if (aux.getEnd().isBefore(current.getStart()))
					if (current.checkForSenior() && !(aux.checkForSenior())) {
						return aux;

					}

			}
		}
		return null;
	}

	@Override
	public int removeEnemy(String vedetaName, String targetName) {
		Iterator<Event> itera;
		Event aux;
		int error = collabs.removeEnemy(vedetaName, targetName);
		int savedCounter = 0;
		if (error == 0) {
			itera = events.eventsIterator();
			while (itera.hasNext()) {
				aux = itera.next();
				if (aux.collabExistence(vedetaName) && aux.collabExistence(targetName)
						&&aux.isOnHold()) {
					//VERIFICAR OS ENEMIES DE TODOS OS DO EVENTO
					aux.activateEvent();
					savedCounter++;
				}
			}
			return savedCounter;
		}
		return error;
	}

	@Override
	public Array<AbsCollaboratorClass> getEnemies(String name) {
		return collabs.getEnemies(name);
	}

	@Override
	public Iterator<Event> getPastEventsIte() {
		Event aux;
		Array<Event> origin = events.getPastEvents();
		for (int i = 0; i < origin.size(); i++) {
			for (int j = i + 1; j < origin.size() - 1; j++) {
				if (origin.get(i).getStart().isAfter(origin.get(j).getStart())) {
					aux = origin.get(j);
					origin.removeAt(j);
					origin.insertAt(origin.get(i), j);
					origin.removeAt(i);
					origin.insertAt(aux, i);
				}
			}
		}
		return origin.iterator();
	}

	@Override
	public Iterator<Event> getFutureEventsIte() {
		Event aux;
		Array<Event> origin = events.getEvents();
		for (int i = 0; i < origin.size(); i++) {
			for (int j = i + 1; j < origin.size() - 1; j++) {
				if (origin.get(i).getStart().isAfter(origin.get(j).getStart())) {
					aux = origin.get(j);
					origin.removeAt(j);
					origin.insertAt(origin.get(i), j);
					origin.removeAt(i);
					origin.insertAt(aux, i);
				}
			}
		}
		return origin.iterator();
	}

	@Override
	public boolean doesCollabExist(String name) {
		// TODO Auto-generated method stub
		return collabs.getCollabByName(name) != null;
	}

	@Override
	public Iterator<Event> getPlaceEvents(String name) {
		Event aux;
		Array<Event> origin = new ArrayClass<Event>();
		Iterator<Event> itera = events.getEvents().iterator();
		while (itera.hasNext()) {
			aux = itera.next();
			if (aux.getPlace().equals(places.getPlace(name)))
				origin.insertLast(aux);
		}
		for (int i = 0; i < origin.size(); i++) {
			for (int j = i + 1; j < origin.size() - 1; j++) {
				if (origin.get(i).getStart().isAfter(origin.get(j).getStart())) {
					aux = origin.get(j);
					origin.removeAt(j);
					origin.insertAt(origin.get(i), j);
					origin.removeAt(i);
					origin.insertAt(aux, i);
				}
			}
		}
		return origin.iterator();
	}

	@Override
	public Iterator<Event> getCollabEvents(String name) {
		// TODO Auto-generated method stub
		Event aux;
		Array<Event> origin = new ArrayClass<Event>();
		Iterator<Event> itera = events.getEvents().iterator();
		while (itera.hasNext()) {
			aux = itera.next();
			if (aux.collabExistence(name))
				origin.insertLast(aux);
		}
		for (int i = 0; i < origin.size(); i++) {
			for (int j = i + 1; j < origin.size() - 1; j++) {
				if (origin.get(i).getStart().isAfter(origin.get(j).getStart())) {
					aux = origin.get(j);
					origin.removeAt(j);
					origin.insertAt(origin.get(i), j);
					origin.removeAt(i);
					origin.insertAt(aux, i);
				}
			}
		}
		return origin.iterator();
	}

	@Override
	public Event doEvent() {
		// TODO Auto-generated method stub
		if (events.getEvents().size() == 0)
			return null;
		else {
			events.doEvent();
			return events.getPastEvents().get(events.getPastEvents().size() - 1);
		}
	}

	@Override
	public boolean doesPlaceExist(String name) {
		// TODO Auto-generated method stub
		return places.alreadyExists(name);
	}
}
