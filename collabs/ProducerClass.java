package collabs;

public class ProducerClass extends AbsCollaboratorClass {
	private boolean reputation;

	public ProducerClass(String name, int index, boolean rep) {
		super(name, index);
		reputation = rep;
	}

	public boolean getRep() {
		return reputation;
	}
}
