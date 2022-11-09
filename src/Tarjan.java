import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tarjan {
    /** number of vertices **/
    private int V;
    /** preorder number counter **/
    private int preCount;
    /** low number of v **/
    private int[] low;
    /** to check if v is visited **/
    private boolean[] visited;
    /** to store given graph **/
    private final List<List<Integer>> graph;
    /** to store all scc **/
    private List<List<Integer>> sccComp;
    private Stack<Integer> stack;

    Tarjan(List<List<Integer>> graph)
    {
        this.V = 0;
        this.graph = graph;
    }
    public List<List<Integer>> getSCComponents(List<List<Integer>> graph)
    {
        V = graph.size();
        low = new int[V];
        visited = new boolean[V];
        stack = new Stack<>();
        sccComp = new ArrayList<>();
        for (int v = 0; v < V; v++)
            if (!visited[v])
                dfs(v);
        return sccComp;
    }
    /** function dfs **/
    public void dfs(int v)
    {
        low[v] = preCount++;
        visited[v] = true;
        stack.push(v);
        int min = low[v];
        for (int w : graph.get(v))
        {
            if (!visited[w])
                dfs(w);
            if (low[w] < min)
                min = low[w];
        }
        if (min < low[v])
        {
            low[v] = min;
            return;
        }
        List<Integer> component = new ArrayList<>();
        int w;
        do
        {
            w = stack.pop();
            component.add(w);
            low[w] = V;
        } while (w != v);
        sccComp.add(component);
    }
}
