package collabs;

import java.time.LocalDateTime;

public interface Event {

	LocalDateTime getStart();

	LocalDateTime getEnd();
	
	PlaceClass getPlace();
	
	CollabListClass getCollabs();
	
	void delayEvent(LocalDateTime newDate);

	void suspendEvent();
	
	boolean isOnHold();
	
	

}
