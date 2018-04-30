import java.time.LocalDateTime;
import generics.*;

public interface EventList {

	void addEvent(Event newEvent);

	void suspendEvent(LocalDateTime start, PlaceClass place);

	void suspendEventSenior(LocalDateTime start, PlaceClass place);

	void delayEvent(LocalDateTime start, PlaceClass place, LocalDateTime newDate);

	void doEvent();

	boolean checkDate(LocalDateTime date);

	Iterator<Event> eventsIterator();

	Iterator<Event> pastEventsIterator();

	Array<Event> getPastEvents();

	Array<Event> getEvents();
}
