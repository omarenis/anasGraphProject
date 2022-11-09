import java.util.*;

/** class Tarjan **/
class Main
{
    public static void main(String[] args)
    {
        List<List<Integer>> graph = CSVReaderTest.read("data.csv");
        Tarjan tarjan = new Tarjan(graph);
        System.out.println("\nSCC : ");
        List<List<Integer>> scComponents = tarjan.getSCComponents(graph);
        System.out.println(scComponents);
    }
}
