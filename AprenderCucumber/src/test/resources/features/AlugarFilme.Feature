# language: pt

Funcionalidade: Alugar filme
	Como usuário
	Eu quero cadastrar alugueis de filmes
	Para controlar preços e datas de entrega

Cenario: Deve alugar um filme com sucesso.
	Dado um filme 
	| estoque | 2 |
	| preco   | 3 |
	Quando alugar 
	Entao o preço será R$ 3
	E o prazo de entrega será em 1 dia
	E o estoque será de 1 unidade
	
Cenario: Não deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar 
	Então não será possivel por falta de estoque
	E o estoque será de 0 unidade
	
	
Esquema do Cenário: Deve dar condições conforme tipo de aluguel
	Dado um filme com estoque de 2 unidades
	E que o preço de aluguel seja R$ <preco>
	E que o tipo de aluguel seja <tipo> 
	Quando alugar
	Então o preço será R$ <valor>
	E o prazo de entrega será em <qtdDia> dias 
	E a pontuação será de <pontuacao> pontos

Exemplos:
	| preco | 		tipo 		| valor | qtdDia | pontuacao |
	|		4		|		extendido | 	8		| 	3		 |		2			 |
	|		4		|		comum			|		4		|		1		 |		1			 |
	|   10  |   extendido |   20  |   3    |    2      |
	| 	5   |   semanal   |   15  |   7    |    3      |
