package dao;

import java.util.ArrayList;
import java.util.List;
import entidades.Contato;

public class DaoContato {
	private static List<Contato> contatos = new ArrayList<>();
    
	public static void salvar(Contato ct) {
		contatos.add(ct);
	}
	
	public static List<Contato> consultar() {
		return contatos;
	}
}
