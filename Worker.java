
public class Worker implements Worker_Interface {
	
	private String name;
	private int cost;
	private Schedule schedule;
	
	public Worker(String name, int cost) {
		this.name = name;
		this.cost = cost;
	
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	
	@Override
	public int getCost() {
		return cost;
	}
	

	@Override
	public Schedule getSchedule() {
		return schedule;
	}		

}
