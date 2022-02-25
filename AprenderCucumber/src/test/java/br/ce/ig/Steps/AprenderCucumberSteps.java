package br.ce.ig.Steps;


import java.text.DateFormat;	
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.ce.ig.Converter.DateConverter;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {

	@Dado("^que eu criei o arquivo corretamente$")
	public void queEuCrieiOArquivoCorretamente() throws Throwable {
		System.out.println("Hello!");
	}

	@Quando("^executa-lo$")
	public void executaLo() throws Throwable {

	}

	@Entao("^a especificacao deve finalizar$")
	public void aEspecificacaoDeveFinalizar() throws Throwable {

	}

	private int contador = 0;

	@Dado("^que o valor do contador é (\\d+)$")
	public void que_o_valor_do_contador_é(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void eu_incrementar_em(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void o_valor_do_contador_será(int arg1) throws Throwable {
		System.out.println(arg1);
		System.out.println(contador);
		Assert.assertEquals(arg1, contador);
	}

	Date entrega = new Date();
	
	@Dado("^que a entrega é dia (.*)$")
	public void queAEntregaÉDia(@Transform(DateConverter.class)Date data) throws Throwable {
	   entrega = data;
	   System.out.println(entrega);
	}

	@Quando("^a entrega atrasar em (\\d+) (.+)$")
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(entrega);
	    if (tempo.equals("dias")) {
	    	cal.add(Calendar.DAY_OF_MONTH, arg1);
	    }
	    if (tempo.equals("meses")) {
	    	cal.add(Calendar.MONTH, arg1);
	    }
	    entrega = cal.getTime();
	}

	@Então("^a entrega será efetuada dia (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaDia(String data) throws Throwable {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataformatada = format.format(entrega);
	    Assert.assertEquals(data, dataformatada);
	}

	
	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
	public void queOTicketÉAF(String tipo, String arg1) throws Throwable {
	    
	}

	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void queOValorDaPassagemÉR$(Double numero) throws Throwable {
	   System.out.println(numero);
	}

	@Dado("^que o nome do passageiro é \"(.{20})\"$")
	public void queONomeDoPassageiroÉ(String arg1) throws Throwable {
	 
	}

	@Dado("^que o telefone do passageiro é (\\9d{3})-(\\d{4})$")
	public void queOTelefoneDoPassageiroÉ(String telefone) throws Throwable {
	   
	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	   
	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	    
	}


	
}