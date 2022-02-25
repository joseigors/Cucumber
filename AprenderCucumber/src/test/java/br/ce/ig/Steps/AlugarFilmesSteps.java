package br.ce.ig.Steps;

import br.ce.ig.Entidades.Filme;		
import br.ce.ig.Entidades.NotaAluguel;
import br.ce.ig.Entidades.TipoAluguel;
import br.ce.ig.Serviço.AluguelService;
import br.ce.ig.Utills.DateUtills;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;


public class AlugarFilmesSteps {
	
	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel nota;
	private String erro;
	private TipoAluguel tipoAluguel = TipoAluguel.COMUM;
	
	@Dado("^um filme com estoque de (\\d+) unidades$")
	public void umFilmeComEstoqueDeUnidades(int arg1) throws Throwable {
	   
	   filme = new Filme();
	   filme.setEstoque(arg1);
	}

	@Dado("^que o preço de aluguel seja R\\$ (\\d+)$")
	public void queOPreçoDeAluguelSejaR$(int arg1) {
		filme.setAluguel(arg1);
	   
	}

	@Dado("^um filme$")
	public void umFilme(DataTable table) throws Throwable {
	    Map<String, String> map = table.asMap(String.class, String.class);
	    filme = new Filme();
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setAluguel(Integer.parseInt(map.get("preco")));
	}


	
	@Quando("^alugar$")
	public void alugar() throws Throwable {
		try {
	    nota = aluguel.alugar(filme, tipoAluguel);
		} catch(RuntimeException e) {
			erro = e.getMessage();
		}
	}

	@Entao("^o preço será R\\$ (.*)$")
	public void oPreçoSeráR$(int arg1) throws Throwable {
	   Assert.assertEquals(arg1, nota.getPreco());;
	    
	}

	@Entao("^o estoque será de (\\d+) unidade$")
	public void oEstoqueSeráDeUnidade(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, filme.getEstoque());
	}


	@Entao("^não será possivel por falta de estoque$")
	public void nãoSeráPossivelPorFaltaDeEstoque() throws Throwable {
	    Assert.assertEquals("Filme sem estoqque!!", erro);
	}

	@Dado("^que o tipo de aluguel seja (.*)$")
	public void queOTipoDeAluguelSejaExtendido(String tipo) throws Throwable {
	   tipoAluguel = tipo.equals("semanal")? TipoAluguel.SEMANAL: tipo.equals("extendido")? TipoAluguel.EXTENDIDO: TipoAluguel.COMUM;
	}

	@Entao("^o prazo de entrega será em (\\d+) dias?$")
	public void oPrazoDeEntregaSeráEmDias(int arg1) throws Throwable {
	   Date dataEsperada = DateUtills.obterDataDiferencaDias(arg1);
	   Date dataReal = nota.getDataEntrega();
	   
	   DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	   
	   Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
	}

	@Entao("^a pontuação será de (\\d+) pontos$")
	public void aPontuaçãoSeráDePontos(int arg1) throws Throwable {
	   Assert.assertEquals(arg1, nota.getPontuacao());
	}

	
}
