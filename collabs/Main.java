package collabs;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import generics.Iterator;

public class Main { 
	
	private static final String FORMAT_DATE = "%d %d %d\n";
	private static final String FORMAT_DATE_TIME = "%d %d %d %d %d\n";
	
	public static final String AJUDA = "AJUDA";
	public static final String EXIT = "SAI";
	public static final String REGISTA = "REGISTA";
	public static final String STAFF = "STAFF";
	public static final String AMUA = "AMUA";
	public static final String RECON = "RECONCILIA";
	public static final String AMUANCOS = "AMUANCOS";
	public static final String MARCA = "MARCA";

	
	public static final String ACTOR = "ACTOR";
	public static final String SENIOR = "SENIOR";
	public static final String JUNIOR = "JUNIOR";
	public static final String TECHNICIAN = "TECNICO";
	public static final String DIRECTOR = "REALIZADOR";
	public static final String NORMAL = "NORMAL";
	public static final String VEDETA = "VEDETA";

	private static String readCommand(Scanner in, PlannerClass system) {
		String option;
		option = in.next().toUpperCase();
		in.nextLine();
		switch (option) {
		case AJUDA:
			printHelp();
			break;
		case REGISTA:
			registerWorker(in, system);
			break;
		case STAFF:
			printStaff(system);
			break;
		case AMUA:
			amua(in, system);
			break; 
		case RECON:
			reconcile(in, system);
			break;
		case AMUANCOS:
			listBl(in, system);
			break;
		case MARCA:
			schedule(in,system);
			break;
		default:

		}
		return option;

	}

	private static void schedule(Scanner in,PlannerClass system) {
		int year,month,day,hr,min,dur;
		CollabListClass aux;
		LocalDateTime dateStart,dateEnd;
		String place = in.nextLine();
		year= in.nextInt();
		month=in.nextInt();
		day = in.nextInt();
		hr = in.nextInt();
		min= in.nextInt();
		dur = in.nextInt();
		in.nextLine();
	    dateStart = LocalDateTime.of(year,month,day,hr,min);
	    dateEnd = dateStart.plusMinutes(dur);
	    aux = new CollabListClass();
	    String producer = in.nextLine();
	    String director = in.nextLine();
	    String technician = in.nextLine();
	    int nCollabs = in.nextInt();
	    in.nextLine();
	    //fazer verificacao ou o crl
	    for(int i = 0; i< nCollabs;i++) {
	    	
	    }
	    
	    
	    
		
		
		
		
	}
	private static void amua(Scanner in, PlannerClass system) {
		String vedeta,target;
		vedeta=in.nextLine();
		target=in.nextLine();
		switch(system.addEnemy(vedeta, target)) {
		case 0:
			System.out.println(vedeta+" colocou "+target+" na sua lista negra, suspendendo 69 gravacoes." );
			break;
		case 1:
			System.out.println(vedeta+" nao e uma vedeta.");
			break;
		case 2:
			System.out.println(target+" nao e um colaborador.");
			break;
		case 3:
			System.out.println("Que falta de paciencia para divas...");
			break;
		}
	}

	private static void listBl(Scanner in, PlannerClass system) {
		String superstar = in.next();
		// for(int i = 0; i<system.getBlCounter(superstar);i++) {
		// System.out.println(system.getWorkerNamebyIndexBl(superstar, i));

	}

	private static void reconcile(Scanner in, PlannerClass system) {
		String superstar = in.next();
		in.nextLine();
		String target = in.next();
		// system.removeFromBl(superstar, target);
	}

	private static void registerWorker(Scanner in, PlannerClass system) {
		String status = "";
		String type = in.next().toUpperCase();
		if (type.equals(ACTOR) || type.equals(DIRECTOR))
			status = in.next().toUpperCase();
		int cost = in.nextInt();
		String name = in.nextLine().trim();
		switch (system.addWorker(type, status, cost, name)) {
		case 0:
			System.out.println("Colaborador registado com sucesso!");
			break;
		case 1:
			System.out.println("Ja existe um colaborador com este nome.");
			break;
		case 2:
			System.out.println("Tipo de colaborador desconhecido.");
			break;
		case 3:
			System.out.println("Notoriedade invalida.");
			break;
		case 4:
			System.out.println("Acha mesmo que este colaborador vai pagar para trabalhar?");
			break;
		default:

		}
		System.out.println();
	}

	private static void printStaff(PlannerClass system) {
		Iterator<AbsCollaboratorClass> itera = system.getCollabIterator();
		while (itera.hasNext()) {
			AbsCollaboratorClass current = itera.next();
			if (current instanceof ActorClass) {
				if (current instanceof AngryCollab)
					System.out.print("actor vedeta ");
				else
					System.out.print("actor normal ");
			} else if (current instanceof DirectorClass) {
				if (current instanceof AngryCollab)
					System.out.print("realizador vedeta ");
				else
					System.out.print("realizador normal ");
			} else if (current instanceof TechnicianClass)
				System.out.print("tecnico ");
			else if (current instanceof ProducerClass) {
				System.out.print("produtor " + ((ProducerClass) current).getRep().toLowerCase() + " ");
			}
			System.out.println(current.getName() + " " + current.getPay());
		}
		System.out.println();
	}

	private static void printHelp() {
		System.out.println("regista - regista um novo colaborador\r\n" + "staff - lista os colaboradores registados\r\n"
				+ "cenario - regista um novo local para gravacoes\r\n"
				+ "cenarios - lista os locais para gravacoes registados\r\n" + "marca - marca uma nova gravacao\r\n"
				+ "amua - vedeta deixa de trabalhar com colaborador\r\n"
				+ "reconcilia - vedeta faz as pazes com colaborador\r\n"
				+ "realizadas - lista as gravacoes realizadas\r\n" + "previstas - lista as gravacoes previstas\r\n"
				+ "local - lista as gravacoes previstas para um local\r\n"
				+ "colaborador - lista as gravacoes previstas para um colaborador\r\n"
				+ "grava - executa a proxima gravacao agendada\r\n"
				+ "amuancos - lista os colaboradores com quem uma vedeta esta amuada\r\n" + "ajuda - Mostra a ajuda\r\n"
				+ "sai - Termina a execucao do programa");

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		PlannerClass system = new PlannerClass();
		String option;
		do {
			option = readCommand(in, system);
		} while (!option.equals(EXIT));
		System.out.println("Ate a proxima");
		System.out.println();
		in.close();

	}

}
