package collabs;

public class PlaceClass implements Place {
	private String name;
	private int cost;

	public PlaceClass(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

	@Override
	public boolean equals(PlaceClass target) {
		return (this.name.equals(target.getName()));
	}

}
