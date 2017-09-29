import dsa.adt.DirectGraph;
import dsa.adt.Graph;
import dsa.adt.Vertex;

/**
 * Created by lsg on 29/9/2017.
 */
public class TestMain {
	public static void main(String[] args) {
		Graph g1= new DirectGraph();
		Graph g2= new DirectGraph();
		Graph g3= new DirectGraph();
		String A="A";String B="B";String C="C";
		Vertex v1 =new Vertex(g1,A);
		Vertex v2 =new Vertex(g2,B);
		Vertex v3 =new Vertex(g3,C);

		System.out.println("hello");
	}
}
