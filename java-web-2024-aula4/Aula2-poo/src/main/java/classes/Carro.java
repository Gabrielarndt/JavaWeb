package classes;

public class Carro {
	// atributos da classe armazenam valores
	private int id;
	private String placa;
	private String modelo;

	public Carro(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public Carro(int id, String placa, String modelo) {
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String toString() {
		return "Placa: " + this.placa + " Modelo: " + this.modelo;
	}
}
