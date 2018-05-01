
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import generics.*;

public class EventClass implements Event {

	private Array<AbsCollaboratorClass> collabs;
	private LocalDateTime start;
	int duration;
	private PlaceClass scenario;
	private boolean active, suspendedBySenior;

	public EventClass(Array<AbsCollaboratorClass> collabs, LocalDateTime start, int duration, PlaceClass scenario) {
		this.collabs = collabs;
		this.start = start;
		this.scenario = scenario;
		this.duration = duration;
		this.active = true;
		this.suspendedBySenior = false;

	}

	@Override
	public LocalDateTime getStart() {
		return start;
	}

	@Override
	public void delayEvent(LocalDateTime newDate) {
		this.start = newDate;
	}

	@Override
	public void suspendEvent() {
		this.active = false;
	}

	@Override
	public boolean isOnHold() {
		return !active;
	}

	@Override
	public LocalDateTime getEnd() {
		return start.plusMinutes(duration);
	}

	@Override
	public PlaceClass getPlace() {
		return scenario;
	}

	@Override
	public void activateEvent() {
		this.active = true;

	}

	@Override
	public boolean sameCollab(Event target) {
		Iterator<AbsCollaboratorClass> itera = collabs.iterator();
		while (itera.hasNext()) {
			if (target.collabExistence(itera.next()))
				return true;
		}
		return false;
	}

	@Override
	public boolean collabExistence(AbsCollaboratorClass collab) {
		return (collabs.searchIndexOf(collab) != -1);
	}

	@Override
	public boolean collabExistence(String name) {
		Iterator<AbsCollaboratorClass> itera = collabs.iterator();
		while (itera.hasNext()) {
			if (itera.next().getName().equals(name))
				return true;
		}
		return false;
	}

	@Override
	public boolean checkForSenior() {
		return ((ProducerClass) collabs.get(0)).getRep().equals("SENIOR");
	}

	@Override
	public void suspendSenior() {
		this.suspendedBySenior = true;
	}

	@Override
	public void activateSenior() {
		this.suspendedBySenior = false;
	}

	@Override
	public boolean isSuspendedSenior() {
		return this.suspendedBySenior;
	}

	@Override
	public int getBudget() {
		int budget = this.scenario.getCost();
		Iterator<AbsCollaboratorClass> itera = collabs.iterator();
		while (itera.hasNext()) {
			budget += itera.next().getPay();
		}
		return budget * (int) Math.ceil((float) duration / 60);
	}

	@Override
	public AbsCollaboratorClass getProd() {
		return collabs.get(0);
	}

	@Override
	public AbsCollaboratorClass getDir() {
		return collabs.get(1);
	}

	@Override
	public Array<AbsCollaboratorClass> getCollabs() {
		// TODO Auto-generated method stub
		return collabs;
	}

}
