package service;

import java.util.ArrayList;
import java.util.List;

import model.Tasks;

public class TaskService {
	
	private List<Tasks> tasks = new ArrayList<Tasks>();
	private int nextId = 1;
	
	public void addTask(String title) {
		Tasks task = new Tasks(nextId++, title);
		tasks.add(task);
	}
	
	public void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No hay tareas");
			return;
		}
		
		for (Tasks task : tasks) {
			System.out.println(task);
		}
	}
	
	public void completeTask(int id) {
		for (Tasks task : tasks) {
			if (task.getId() == id) {
				task.markAsCompleted();
				return;
			}
		}
		System.out.println("Tarea no encontrada.");
	}
	
	public void deleteTask(int id) {
		for (Tasks task : tasks) {
			if (task.getId() == id) {
				tasks.remove(id);
				return;
			}
		}
		System.out.println("Tarea no encontrada.");
	}
}