package collabs;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class EventClass implements Event {

	CollabListClass collabs;
	LocalDateTime start, end;
	PlaceClass scenario;
	boolean active;

	public EventClass(CollabListClass collabs, LocalDateTime start, LocalDateTime end, PlaceClass scenario) {
		this.collabs = collabs;
		this.start = start;
		this.scenario = scenario;
		this.end = end;
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
		return active;
	}

	@Override
	public LocalDateTime getEnd() {
		return end;
	}

	@Override
	public PlaceClass getPlace() {
		return scenario;
	}

	@Override
	public CollabListClass getCollabs() {
		return collabs;
	}

}
