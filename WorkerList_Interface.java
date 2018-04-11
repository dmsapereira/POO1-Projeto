
public interface WorkerList_Interface {

	void addWorker(String type, String status, int cost, String name);

	int getWorkerIndexByName(String name);
	
	Worker getWorkerByName(String name);
	
	Worker getWorkerByIndex(int index);
	
	int getWorkLCounter();

}
