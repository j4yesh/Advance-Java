package Collections;
import java.util.*;

class Task{
    public int priority;

    Task(int p){
        this.priority=p;
    }
}

public class priorityQueue {
    public void addEdge(List<List<Integer>>nes,int a,int b){
        nes.get(a).add(b);
        nes.get(b).add(a);
    }
    public void bfs(List<List<Integer>>adj,int src,int dst){
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> vis=new HashSet<>();
        q.add(src);
        vis.add(src);
        System.out.println(" BFS: \n");
        while(q.size()>0){
            Integer pick=q.poll();
            System.out.println(pick);
            for(Integer it: adj.get(pick)){
                if(!vis.contains(it)){
                    vis.add(it);
                    q.add(it);
                }
            }
        }
    }
    public static void main(String [] jayesh){
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Task> pq=  new PriorityQueue<>((a,b)->Integer.compare(a.priority,b.priority));
        // PriorityQueue<Task> pq= new PriorityQueue<>(Comparator.comparingInt(ii->ii.priority));
        pq.add(new Task(5));
        pq.add(new Task(6));
        pq.add(new Task(7));
        // System.out.println(pq.poll());
        pq.poll();

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<55;i++){
            List<Integer> temp = new ArrayList<>();
            // for(int j=0;j<55;j++){
            //     temp.add(5);
            // }
            adjList.add(temp);
        }
        //vector<vector<int>>squarelist(55,vector<int>(55,0))
        //vector<pair<int,int>>vecpair
        priorityQueue pq1=new priorityQueue();
        pq1.addEdge(adjList, 0, 1); // Edge from 0 to 1
        pq1.addEdge(adjList, 1, 2); // Edge from 1 to 2
        pq1.addEdge(adjList, 2, 3); // Edge from 2 to 3
        pq1.addEdge(adjList, 3, 0); // Edge from 3 to 0

        // List<List<Integer>> nesliast = new ArrayList<>();

        pq1.bfs(adjList,0,100);

    }

}


//         PriorityQueue <Task> pq=new PriorityQueue<>(Comparator.comparingInt(task -> task.priority));
//         pq.add(new Task(5));
//         pq.add(new Task(6));
//         pq.add(new Task(7));
//         pq.add(new Task(8));
//         System.out.println(pq);
//         pq.poll();
//         System.out.println(pq);
