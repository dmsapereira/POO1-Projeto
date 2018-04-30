
import java.time.LocalDateTime;

public interface Event {

	LocalDateTime getStart();

	LocalDateTime getEnd();

	PlaceClass getPlace();

	void delayEvent(LocalDateTime newDate);

	void activateEvent();

	void suspendEvent();

	boolean isOnHold();

	boolean sameCollab(Event target);

	boolean collabExistence(AbsCollaboratorClass collab);

	boolean collabExistence(String name);

	boolean checkForSenior();

	void suspendSenior();

	void activateSenior();

	boolean isSuspendedSenior();

	int getBudget();

	AbsCollaboratorClass getProd();

	AbsCollaboratorClass getDir();

}
