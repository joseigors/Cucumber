package br.ce.ig.Serviço;

import java.util.Calendar;

import br.ce.ig.Entidades.Filme;
import br.ce.ig.Entidades.NotaAluguel;
import br.ce.ig.Entidades.TipoAluguel;
import br.ce.ig.Utills.DateUtills;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
		if (filme.getEstoque() == 0)
			throw new RuntimeException("Filme sem estoqque!!");

		NotaAluguel nota = new NotaAluguel();
		switch (tipo) {
			case COMUM:
				nota.setPreco(filme.getAluguel() * 1);
				nota.setDataEntrega(DateUtills.obterDataDiferencaDias(1));
				nota.setPontuacao(1);
				break;
			case EXTENDIDO:
				nota.setPreco(filme.getAluguel() * 2);
				nota.setDataEntrega(DateUtills.obterDataDiferencaDias(3));
				nota.setPontuacao(2);
				break;
			case SEMANAL:
				nota.setPreco(filme.getAluguel() * 3);
				nota.setDataEntrega(DateUtills.obterDataDiferencaDias(7));
				nota.setPontuacao(3);
			break;
			
		}

		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	}

}
