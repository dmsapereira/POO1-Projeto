
public class Planner implements WorkerList_Interface {
	
	WorkerList workL = new WorkerList();
	Scenario_List sceneL= new Scenario_List();
	
	public Planner() {

	}
	
	@Override
	public void addWorker(String type,String status, int cost, String name) {
		workL.addWorker(type,status,cost,name); 
	}
	
	@Override
	public int getWorkLCounter() {
		return workL.getWorkLCounter();
	}
	
	@Override
	public Worker getWorkerByIndex(int index) {
		return workL.getWorkerByIndex(index);
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

}
