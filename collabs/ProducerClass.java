package collabs;

public class ProducerClass extends AbsCollaboratorClass {
	private String reputation;

	public ProducerClass(String name, int index, String rep) {
		super(name, index);
		reputation = rep;
	}

	public String getRep() {
		return reputation;
	}
}
