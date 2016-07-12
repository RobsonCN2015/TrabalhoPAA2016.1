package br.ufc.quixada.PAA.EstruturaGrafoListaEncadeada;

public class Grafo {
	private int numVertices;
	private int[][]m;
	
	public Grafo(){
		
	}
	public void novoGrafo(int numVertices)throws Exception{
		if(numVertices >= 2 && numVertices <= 2000){
			this.numVertices = numVertices;
			this.m = new int[numVertices+1][numVertices+1];
		} else{
			throw new Exception("Numero de Vertices não suportado");
		}
	}
	public int getNumVertices() {
		return numVertices;
	}
	public int[][] getM() {
		return m;
	}
	
	public void setM(int[][]m) {
		this.m = m;
	}
	
	public void insereAresta(int v, int u, int p){
			if(v!= 0 && u!=0){
				if(p == 1 && v <= this.numVertices && u <= this.numVertices){
					this.m [v][u]= p;
				}
				if(p==2 && v <= this.numVertices && u <= this.numVertices){
					this.m[v][u] = p-1;
					this.m[u][v] = p-1;
					
				}
			}
	}
	public int[][] grafoTransposto(){
		int[][] mT = new int[this.m.length][this.m.length];
		
		for(int l = 1; l < this.m.length; l++){
			for(int c = 1; c < this.m.length; c++){
				if(this.m[l][c] == 1 && this.m[c][l] == 0){
					mT[c][l] = 1;
					mT[l][c] = 0;
				}
				if(this.m[l][c] == 1 && this.m[c][l] == 1){
					mT[c][l] = 1;
					mT[l][c] = 1;
				}
			}
			
		}
		return mT;
	}	
	

}
