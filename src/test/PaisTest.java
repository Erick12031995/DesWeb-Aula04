package test;

import static org.junit.Assert.assertEquals;
import model.Pais;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.SQLException;
import java.util.ArrayList;

import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais();
		pais.setId(id);
		pais.setNome("Kripton");
		pais.setPopulacao(80000);
		pais.setArea(3000.00);
		copia = new Pais();
		copia.setId(id);
		copia.setNome("Kripton");
		copia.setPopulacao(80000);
		copia.setArea(3000.00);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}

	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		Pais fixture = new Pais();
		fixture.setId(1);
		fixture.setNome("Atlantida");
		fixture.setPopulacao(100000);
		fixture.setArea(5000.00);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setPopulacao(200000);
		copia.setPopulacao(200000);
		paisService.atualizar(pais);
		assertEquals("testa atualizacao", pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(0);
		copia.setArea(0);
		paisService.excluir(id);
		pais=paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}
	
	@Test
	public void test04maiorPopulacao() {
		System.out.println("maiorPopulacao");
		PaisService novoService = new PaisService();
		Pais novo = novoService.maiorPopulacao();
		long maior = novo.getPopulacao();
		 
		assertEquals("testa populacao", 50000, maior);
	}

	@Test
	public void test05menorArea() {
		System.out.println("menorArea");
		PaisService novoService = new PaisService();
		Pais novo = novoService.menorArea();
		double menor = novo.getArea();
		assertEquals( 3,0 , menor);
	}

	@Test
	public void test06ArrayList() throws SQLException {
		ArrayList<String> res = new ArrayList<String>();
		paisService.vetorTresPaises();
		res.add("Atlantida");
		res.add("Wakanda");
		res.add("Themyscira");

		assertArrayEquals(paisService, res);

	}

	private void assertArrayEquals(PaisService paisService2, java.util.ArrayList<String> res) {
		// TODO Auto-generated method stub
	}
}