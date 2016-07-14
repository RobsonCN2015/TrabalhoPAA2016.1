package br.ufc.quixada.PAA.Main;

import java.util.Scanner;

import br.ufc.quixada.PAA.Comp_Fort_Conectados.Comp_Fort_Conectados;
import br.ufc.quixada.PAA.GrafoMatrizAdjacencia.Grafo;

public class index {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		
		int numVertices = s.nextInt();
		int numAresta = s.nextInt();
		Grafo grafo = new Grafo();
		try {
			grafo.novoGrafo(numVertices);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("0");
			return;
		}
		for(int i=0; i<numAresta; i++){
			int v = s.nextInt();
			int w = s.nextInt();
			int p = s.nextInt();
			grafo.insereAresta(v, w, p);

		}
		/*
		grafo.insereAresta(1, 2, 1);
		grafo.insereAresta(1, 3, 2);
		grafo.insereAresta(2, 4, 1);
		grafo.insereAresta(3, 4, 1);
		grafo.insereAresta(4, 1, 2);*/
		Comp_Fort_Conectados cfc = new Comp_Fort_Conectados(grafo);	
		System.err.println(cfc.obterCfs());
		
	}

}
