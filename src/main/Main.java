package main;


import java.util.Scanner;

import service.TaskService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskService taskService = new TaskService();
		Scanner input = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n--- TASK MANAGER ---");
			System.out.println("1. Crear Tarea");
			System.out.println("2. Listar Tareas");
			System.out.println("3. Completar Tarea");
			System.out.println("4. Eliminar Tarea");
			System.out.println("5. Salir");
			System.out.println("Opción: ");
			
			int option = input.nextInt();
			input.nextLine();
			
			switch(option) {
			case 1:
				System.out.println("\n--- Crear Tarea ---");
				System.out.println("Titulo: ");
				String title =  input.nextLine();
				taskService.addTask(title);
				System.out.println("Press Enter to Continue");
				input.nextLine();
				break;
			case 2:
				System.out.println("\n--- Lista de Tareas ---");
				taskService.listTasks();
				System.out.println("Press Enter to Continue");
				input.nextLine();
				break;
			case 3:
				System.out.println("\n--- Completar Tarea ---");
				System.out.println("Introduce ID de la tarea:");
				int	completeId = input.nextInt();
				taskService.completeTask(completeId);
				System.out.println("Press Enter to Continue");
				input.nextLine();
				break;
			case 4:
				System.out.println("\n--- Eliminar Tarea ---");
				System.out.println("Introduce ID de la tarea:");
				int	deleteId = input.nextInt();
				taskService.deleteTask(deleteId);
				System.out.println("Press Enter to Continue");
				input.nextLine();
				break;
			case 5:
				System.out.println("Hasta la Próxima...");
				input.close();
				return;
			default:
				System.out.println("Opción no válida.");
				System.out.println("Press Enter to Continue");
				input.nextLine();
			}
		}
	}

}
