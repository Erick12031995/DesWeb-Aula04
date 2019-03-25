package service;

import model.Pais;
import dao.PaisDao;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaisService {
	PaisDao dao = new PaisDao();

	public int criar(Pais pais) {
		return dao.criar(pais);
	}

	public void atualizar(Pais pais) {
		dao.atualizar(pais);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Pais carregar(int id) {
		return dao.carregar(id);
	}
	
	public Pais menorArea(){
		return dao.menorArea();
	}
	public Pais maiorPopulacao(){
		return dao.maiorPopulacao();
	}
	public ArrayList<Pais> vetorTresPaises() throws SQLException{
		return dao.vetorTresPaises();
	}
}
