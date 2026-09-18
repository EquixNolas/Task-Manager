package entities;

public enum Prioridad {
	Baja(1),
	Media(2),
	Alta(3);

	private int valor;
	
	Prioridad(int valor) {
		this.valor = valor;
	}
	
	public int getValor()
	{
		return valor;
	}
}