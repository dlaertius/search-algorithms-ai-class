package problem.travel;

import es.usc.citius.hipster.algorithm.Hipster;
import es.usc.citius.hipster.graph.GraphSearchProblem;
import es.usc.citius.hipster.model.problem.SearchProblem;
import es.usc.citius.hipster.util.examples.RomanianProblem;

public class Viagem {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		SearchProblem problema = GraphSearchProblem.startingFrom(RomanianProblem.City.Arad).in(RomanianProblem.graph()).takeCostsFromEdges().build();
		
		System.out.println("#BUSCA EM PROFUNDIDADE \n");
		System.out.println(Hipster.createDepthFirstSearch(problema).search(RomanianProblem.City.Bucharest));
		System.out.println("\n");
		
		System.out.println("#BUSCA EM LARGURA \n");
		System.out.println(Hipster.createBreadthFirstSearch(problema).search(RomanianProblem.City.Bucharest));
		System.out.println("\n");
		
		System.out.println("#A* \n");
		System.out.println(Hipster.createAStar(problema).search(RomanianProblem.City.Bucharest));
		System.out.println("\n");
		
		System.out.println("#HILL CLIMBING \n");
		System.out.println(Hipster.createHillClimbing(problema, true).search(RomanianProblem.City.Bucharest));
		System.out.println("\n");

	}
}
