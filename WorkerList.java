
public  class WorkerList implements WorkerList_Interface {

	private static final String ACTOR = "ACTOR";

	private static final String SUPERSTAR ="VEDETA";

	private static final String DIRECTOR ="REALIZADOR";

	private static final String JUNIOR ="JUNIOR";

	private static final String TECHNICIAN ="TECNICO";

	private static final String SENIOR ="SENIOR";

	private static int DEFAULT_SIZE = 50;

	private Worker[] workerList;

	private int counter;

	

	public WorkerList() {
		workerList =  new Worker[DEFAULT_SIZE]; 
		this.counter = 0;
	}

	@Override
 public void addWorker(String type,String status, int cost, String name) {
		switch(type) { 
		case ACTOR: 
			if(status.equals(SUPERSTAR))
				workerList[counter++]=  new SuperStar_Actor(name,cost); 
			else
				workerList[counter++]=  new  Actor(name,cost); 
			break;
		case DIRECTOR:
			if(status.equals(SUPERSTAR))
				workerList[counter++]= new SuperStar_Director(name,cost);
			else
				workerList[counter++]=  new Director(name,cost); 
			break;
		case JUNIOR:
				workerList[counter++]=  new Junior_Producer(name,cost);
			break;
		case SENIOR:
				workerList[counter++]= new Senior_Producer(name,cost);
			break;
		case TECHNICIAN:
				workerList[counter++]=  new Technician(name,cost);
			break;
		default:
		}
		
	} 
 
	@Override
	public int getWorkerIndexByName(String name) {
			int result = -1;
			int i = 0;
			while (i < counter && result == -1) {
				if (workerList[i].getName().equals(name))
					result = i;
				else
					i++;
			}
			return i;
		}
	
	@Override
	public Worker getWorkerByName(String name) {
		Worker result = null;
		int i = 0;
		while (i <counter && result == null) {
			if (workerList[i].getName().equals(name))
				result = workerList[i];
			else
				i++;
		}
		return result;
	}
	
	@Override
	public Worker getWorkerByIndex(int index) {
		return workerList[index];
		
	}
	
	@Override
	public int getWorkLCounter() {
		return counter;
	}

}
