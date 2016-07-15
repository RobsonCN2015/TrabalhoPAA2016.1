package br.ufc.quixada.PAA.Comp_Fort_Conectados;

import br.ufc.quixada.PAA.GrafoMatrizAdjacencia.Grafo;

public class Comp_Fort_Conectados {
	private Grafo grafo;
	private static int branco = 0;
	private static int cinza = 1;
	private static int preto = 2;
	private int tempo = 0;
	private int[] cor;
	private int[] descoberta;
	private int[] finalizacao;

	public Comp_Fort_Conectados(Grafo grafo){
		this.grafo = grafo;
		int tamanho = grafo.getM().length;
		this.descoberta = new int[tamanho];
		this.finalizacao = new int[tamanho];
		this.cor = new int[tamanho];

	}
	//inicializa o vetor de cores dos vertices com a cor branca
	//Complecidade O (V)
	private void inicializa(int[][]m){
		for (int u = 1; u < m.length; u++) {
			this.cor[u] = branco;
		}
	}
	// para cada vertice branco visite seus vertices na matriz de adjacencia
	// complexidade O(V + E)
	private void visitaDfs(){
		this.inicializa(this.grafo.getM());
		for (int vertice = 1; vertice < this.grafo.getM().length; vertice++) {
			if (cor[vertice] ==  branco) {
				visitaAdj(vertice);	
			}
		}
		
	}
	// visita os vertices adjacentes ao vertice passado por parêmetro
	private void visitaAdj(int vertice){
		this.cor[vertice] = cinza;
		tempo = tempo + 1;
		this.descoberta[vertice] = tempo;

		for (int i = 1; i < this.grafo.getM().length; i++) {
			if (this.grafo.getM()[vertice][i] == 1) {
				if (this.cor[i] == branco) {
					visitaAdj(i);
				}
			}
		}
		this.cor[vertice] = preto;
	
		this.finalizacao[vertice] = tempo = tempo +1;
		
		int b = 0;
	}
	//visita os adjacentes porém agora sem quardar o tempo de descoberta e o tempo de finalização
	//Complexidade O(V + E)
	private void visitaAdj2(int vertice){
		this.cor[vertice] = cinza;

		for (int i = 1; i < this.grafo.getM().length; i++) {
			if (this.grafo.getM()[vertice][i] == 1) {
				if (this.cor[i] == branco) {
					visitaAdj2(i);
				}
			}
		}
		this.cor[vertice] = preto;
			
	}
	// retorna o vertice com maior tempo de finalizacao
	// Complexidade O(V)
	public int maxTT() {
		int verticeMaior = 0;
		int max = 0;
		for (int i = 1; i < this.finalizacao.length; i++) {
			if (this.finalizacao[i] > max) {
				max = this.finalizacao[i];
				verticeMaior = i;
			}
		}

		return verticeMaior;
	}
	// retorna 0 se existe mais de uma componente fortemente conexa no grafo, retorna 1 caso exista apenas 1.
	
	public int obterCfs(){
		//aplica a busca em profundidade pro Grafo
		this.visitaDfs();
		//cria o grafo transposto 
		int[][] gT = this.grafo.grafoTransposto();
		this.grafo.setM(gT);
		//inicializa a matriz do grafo transposto com cor zero
		this.inicializa(this.grafo.getM());
		//retorna vertice com maior tempo de inicializacao
		int a  = this.maxTT();
		//aplica a busca em profundidade para os vertices adjacentes ao vertice a
		visitaAdj2(a);
		// verifica se algum vertice deixou de ser visitado
		for (int v = 1; v < this.grafo.getM().length; v++) {
			if (cor[v]==branco) {
				return 0;
			}
		}
		// se todos os vertices foram visitados existe apenas 1 CFC no grafo
		return 1;
	}
}
