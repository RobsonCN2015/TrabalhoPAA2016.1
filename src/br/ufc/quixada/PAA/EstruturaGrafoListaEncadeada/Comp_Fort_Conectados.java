package br.ufc.quixada.PAA.EstruturaGrafoListaEncadeada;

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
	private void inicializa(int[][]m){
		for (int u = 1; u < m.length; u++) {
			this.cor[u] = branco;
		}
	}
	private void visitaDfs(){
		this.inicializa(this.grafo.getM());
		for (int vertice = 1; vertice < this.grafo.getM().length; vertice++) {
			if (cor[vertice] ==  branco) {
				visitaAdj(vertice);	
			}
		}
		
	}
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
	
	public int obterCfs(){
		this.visitaDfs();
		int[][] gT = this.grafo.grafoTransposto();
		this.grafo.setM(gT);
		
		this.inicializa(this.grafo.getM());
		int a  = this.maxTT();
		visitaAdj2(a);
		
		for (int v = 1; v < this.grafo.getM().length; v++) {
			if (cor[v]==branco) {
				return 0;
			}
		}
		return 1;
	}
}
