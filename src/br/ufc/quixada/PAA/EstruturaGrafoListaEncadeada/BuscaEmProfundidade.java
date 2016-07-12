package br.ufc.quixada.PAA.EstruturaGrafoListaEncadeada;

public class BuscaEmProfundidade {		
	public static final byte branco = 0;
	public static byte cinza = 1;
	public static byte preto = 2;
	private int d[];
	private int t[];
	private	int antecessor[];
	private Grafo grafo;
	/*
	public BuscaEmProfundidade(Grafo grafo){
		this.grafo = grafo;
		int n = grafo.numVertices();
		this.d = new int[n];
		this.t = new int [n];
		this.antecessor = new int[n];
	}
	public int visitaDFS(int u, int tempo ,int cor[]){
		cor[u] = cinza;
		this.d[u] = tempo + 1;
		if(!this.grafo.listaAdjVazia(u)){
			Aresta a = this.grafo.primeiroDaListaAdj(u);
			System.out.println("BEP>Aresta = "+ a);
			while(a!= null){
				int v = a.getV2();
				if(v < cor.length && cor[v] == branco){
					this.antecessor[v] = u;
					System.err.println("antecessor de u="+u + "e v="+ v);
					tempo = this.visitaDFS(v, tempo, cor);
				}
				a =this.grafo.proxDaListaAdj(u);
			}
		}
		cor[u] = preto;
		this.t[u] = tempo+1;
		return tempo;
	}
	public void inicializa(){
		int cor[] = new int[this.grafo.numVertices()];
		for(int u = 0; u < grafo.numVertices(); u++){
			cor[u] = branco;
		}
	}
	public void fazBuscaEmVestice(){
		this.inicializa();
		int tempo = 0;
		if(this.grafo.numVertices() > 0){
			int cor[] = new int[this.grafo.numVertices()];
			for(int i = 0; i < grafo.numVertices(); i++){
				cor[i] = branco;
				this.antecessor[i] = -1;
			}
			for(int u = 0; u < grafo.numVertices(); u++){
				if(cor[u] == branco){
					tempo = this.visitaDFS(u, tempo, cor);
				}
			}
		}
	}
	public int getD(int v) {
		return d[v];
	}
	public int getT(int v) {
		return t[v];
	}
	public int getAntecessor(int v) {
		return antecessor[v];
	}
	*/
}
