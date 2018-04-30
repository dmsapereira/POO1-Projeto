
import java.time.LocalDateTime;

import generics.*;

public interface Planner {

	int addWorker(String type, String status, int cost, String name);

	Iterator<AbsCollaboratorClass> getCollabIterator();

	int addEnemy(String vedetaName, String targetName);

	int addPlace(String name, int cost);

	Iterator<PlaceClass> getPlaces();

	int addEvent(String[] collabs, LocalDateTime start, int duration, String scenario);

	int removeEnemy(String vedetaName, String targetName);

	Array<AbsCollaboratorClass> getEnemies(String name);

	Iterator<Event> getPastEventsIte();

	Iterator<Event> getFutureEventsIte();

	boolean doesCollabExist(String name);

	Iterator<Event> getPlaceEvents(String name);

	Iterator<Event> getCollabEvents(String name);

	Event doEvent();

	boolean doesPlaceExist(String name);

}
