import java.util.Scanner;

public class Main {

	private static final String AJUDA = "AJUDA";
	private static final String EXIT = "SAI";
	private static final String REGISTA = "REGISTA";
	private static final String STAFF = "STAFF";

	private static String readCommand(Scanner in, Planner system) {
		String option;
		option = in.next().toUpperCase();
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
		default:
		}
		return option;

	}

	private static void registerWorker(Scanner in, Planner system) {
		String status = "";
		String type = in.next().toUpperCase();
		if (!(type.equals("TECNICO") || type.equals("SENIOR") || type.equals("JUNIOR")))
			status = in.next().toUpperCase();

		in.nextLine();
		int cost = in.nextInt();
		in.nextLine();
		String name = in.next();
		system.addWorker(type, status, cost, name);

	}
//este mete um bocado de nojo mas tentei fazer com enums sem sucesso
	private static void printStaff(Planner system) {
		String status = "normal";
		String type = "";
		for (int i = 0; i < system.getWorkLCounter(); i++) {
			if (system.getWorkerByIndex(i) instanceof Superstar) {
				status = "vedeta";
			} else if (system.getWorkerByIndex(i) instanceof Senior) {
				status = "senior";
			} else if (system.getWorkerByIndex(i) instanceof Junior) {
				status = "junior";
			}
			if (system.getWorkerByIndex(i) instanceof Actor) {
				type = "actor";
			} else if (system.getWorkerByIndex(i) instanceof Producer) {
				type = "produtor";
			} else if (system.getWorkerByIndex(i) instanceof Director) {
				type = "realizador";
			} else {
				type = "tecnico";
			}
			System.out.println(type + " " + status + " " + system.getWorkerByIndex(i).getName() + " "
					+ system.getWorkerByIndex(i).getCost());

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
		Planner system = new Planner();
		String option;
		do {
			option = readCommand(in, system);
		} while (!option.equals(EXIT));
		System.out.println("Ate a proxima");
		System.out.println();
		in.close();

	}

}
