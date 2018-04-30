

public abstract class AbsCollaboratorClass implements AbsCollaborator {
	protected String name;
	protected int salary;
	// EventList aqui

	public AbsCollaboratorClass(String name, int salary) {
		this.name = name;
		this.salary = salary; 
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return salary;
	}

	@Override
	public boolean equals(AbsCollaboratorClass target) {
		return (target.getName().equals(this.name));
	}

}
