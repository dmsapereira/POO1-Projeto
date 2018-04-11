
public class BlackList implements BlackList_Interface {

	private static final int DEFAULT_SIZE = 50;

	private Worker[] blackList;
	private int counter;

	public BlackList() {
		blackList =  new Worker[DEFAULT_SIZE];
		counter = 0;
	}

	@Override
	public void addToBl() {
	}

	@Override
	public void removeFromBl() {
	}

	@Override
	public int getIndexByName() {
		return 0;
	}

	@Override
	public void addWorker(String type, String status, int cost, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWorkerIndexByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Worker getWorkerByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Worker getWorkerByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWorkLCounter() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
