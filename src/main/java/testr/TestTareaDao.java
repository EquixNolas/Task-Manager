package testr;

import dao.ITareaDao;
import dao.TareaDaoImpl;

public class TestTareaDao {

	private static ITareaDao tdao;
	
	static {
		tdao = new TareaDaoImpl();
	}
	
	public static void main(String[] args) {
		listarTodos();
	}
	
	public static void listarTodos() {
		tdao.findAll().forEach(System.out::println);
	}
}
