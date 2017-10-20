package problem.graph;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphBuilder;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.graph.HipsterDirectedGraph;
import es.usc.citius.hipster.graph.HipsterGraph;
import es.usc.citius.hipster.model.problem.SearchProblem;

public class BuscaGrafoGen {

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		
		//Grafo Direcionado
        HipsterDirectedGraph<String,Double> grafoDir = GraphBuilder.<String,Double>create()
                .connect("A").to("B").withEdge(4d)
                .connect("A").to("C").withEdge(2d)
                .connect("B").to("C").withEdge(5d)
                .connect("B").to("D").withEdge(10d)
                .connect("C").to("E").withEdge(3d)
                .connect("D").to("F").withEdge(11d)
                .connect("E").to("D").withEdge(4d)
                .createDirectedGraph();
        
        //Grafo Não-Direcionado
        HipsterGraph<String,Double> grafoNDir = GraphBuilder.<String,Double>create()
                .connect("A").to("B").withEdge(4d)
                .connect("A").to("C").withEdge(2d)
                .connect("B").to("C").withEdge(5d)
                .connect("B").to("D").withEdge(10d)
                .connect("C").to("E").withEdge(3d)
                .connect("D").to("F").withEdge(11d)
                .connect("E").to("D").withEdge(4d)
                .createUndirectedGraph();
        
        SearchProblem problema = GraphSearchProblem.startingFrom("A").in(grafoDir).takeCostsFromEdges().build();
        
        //SearchProblem problema = GraphSearchProblem.startingFrom("A").in(grafoNDir).takeCostsFromEdges().build();
        
		System.out.println("#BUSCA EM PROFUNDIDADE \n");
		System.out.println(Hipster.createDepthFirstSearch(problema).search("L"));
		System.out.println("\n");
		
		System.out.println("#BUSCA EM LARGURA \n");
		System.out.println(Hipster.createBreadthFirstSearch(problema).search("L"));
		System.out.println("\n");
		
		System.out.println("#A* \n");
		System.out.println(Hipster.createAStar(problema).search("L"));
		System.out.println("\n");
		
		System.out.println("#HILL CLIMBING \n");
		System.out.println(Hipster.createHillClimbing(problema, true).search("L"));
		System.out.println("\n");

	}

}
