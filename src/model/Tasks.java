package model;

import java.util.Objects;

public class Tasks {

	private int id;
	private String title;
	private Boolean completed;
	
	public Tasks(int id, String title) {
		super();
		this.id = id;
		this.title = title;
		this.completed = false;
	}

	public Tasks() {
		super();
	}

	public boolean isCompleted() {
		return completed;
	}
	
	public void markAsCompleted() {
		this.completed = true;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(completed, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tasks))
			return false;
		Tasks other = (Tasks) obj;
		return Objects.equals(completed, other.completed) && id == other.id && Objects.equals(title, other.title);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
}
