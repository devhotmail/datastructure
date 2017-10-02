package V2.Chap01.Bank.Chap13.bfs;

// bfs.java
// demonstrates breadth-first search
// to run this program: C>java BFSApp
////////////////////////////////////////////////////////////////
class Queue
   {
   private final int SIZE = 10;
   private int[] queArray;
   private int front;
   private int rear;
// -------------------------------------------------------------
   public Queue()            // constructor
      {
      queArray = new int[SIZE];
      for(int i=0;i<queArray.length;i++){
         queArray[i]=-1;
      }
      front = 0;
      rear = -1;
         System.out.println("初始化的queue:");
         showq();
      }
// -------------------------------------------------------------
      public void showq(){
         System.out.print(" Q:[");
       for(int i=0;i<queArray.length;i++){
          if(i==queArray.length-1){
             System.out.println(queArray[i]+"]");}
             else{
          System.out.print(queArray[i]+"  ");}
       }

      }
   public void insert(int j) // put item at rear of queue
      {
      if(rear == SIZE-1)
         rear = -1;
      queArray[++rear] = j;
      }
// -------------------------------------------------------------
   public int remove()       // take item from front of queue
      {
         int j1=front++; //先赋值 后加1 so , j1=0 ,then front =1
         System.out.print("  remove queArray["+j1+"]="+queArray[j1]+" with "+" [f:r-"+front +":"+ +rear+" ]");
      int temp = queArray[j1];
      if(front == SIZE)
         front = 0;
      return temp;
      }
// -------------------------------------------------------------
   public boolean isEmpty()  // true if queue is empty
      {

         System.out.println("   f:r-"+front+":"+rear+"  "+"isEmptyQ?  "+( rear+1==front || (front+SIZE-1==rear) ));
        // System.out.println(" ====>condition is   rear+1==front || (front+SIZE-1==rear) ");
      return ( rear+1==front || (front+SIZE-1==rear) );
      }
// -------------------------------------------------------------
   }  // end class Queue
////////////////////////////////////////////////////////////////
class Vertex
   {
   public char label;        // label (e.g. 'A')
   public boolean wasVisited;
// -------------------------------------------------------------
   public Vertex(char lab)   // constructor
      {
      label = lab;
      wasVisited = false;
      }
// -------------------------------------------------------------
   }  // end class Vertex
////////////////////////////////////////////////////////////////
class Graph
   {
   private final int MAX_VERTS = 5;
   private Vertex vertexList[]; // list of vertices
   private int adjMat[][];      // adjacency matrix
   private int nVerts;          // current number of vertices
   private Queue theQueue;
// ------------------------------------------------------------
   public Graph()               // constructor
      {
         System.out.println("construct Graph() ");
         System.out.println("...adjMat[j][k] = 0;and new Queue ");

      vertexList = new Vertex[MAX_VERTS];
                                          // adjacency matrix
      adjMat = new int[MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      for(int j=0; j<MAX_VERTS; j++)      // set adjacency
         for(int k=0; k<MAX_VERTS; k++)   //    matrix to 0
            adjMat[j][k] = 0;
      theQueue = new Queue();
      }  // end constructor
// -------------------------------------------------------------
   public void addVertex(char lab)
      {

         int tmp1 =nVerts++;
     //    System.out.println("addVertex(char lab)-->vertexList["+tmp1+"] with lab "+lab);
      vertexList[tmp1] = new Vertex(lab);
      }
// -------------------------------------------------------------
   public void addEdge(int start, int end)
      {
      adjMat[start][end] = 1;
      adjMat[end][start] = 1;
     // System.out.println("addEdge--->adjMat["+start+"]["+end+"] =1");
      }
      //------------------
      public void showmatrix() {
         System.out.println("show matrix-------");
         for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
               if (j / 4 == 1) {
                  System.out.println(i+","+j+"-"+adjMat[i][j]+" ");
               } else {
                  System.out.print(i+","+j+"-"+adjMat[i][j]+"  ");
               }

            }
      }
      // -------------------------------------------------------------
   public void displayVertex(int v)
      {
      System.out.print(vertexList[v].label);
      }
// -------------------------------------------------------------
      public static void show(Vertex[] arrVex){
         System.out.print("vertexList status-->");
         for(Vertex v:arrVex){
            if(v!=null)
           System.out.print(v.label +":"+v.wasVisited+"  ");
         }

      }

   public void bfs()                   // breadth-first search
      {
         // begin at vertex 0
         System.out.println("start bfs");
      vertexList[0].wasVisited = true; // mark it
       //  show(vertexList);
      displayVertex(0);

      // display it
         System.out.println("...");
         theQueue.showq();
      theQueue.insert(0);              // insert at tail
         System.out.print("after  theQueue.insert(0)-->"); theQueue.showq();
      int v2;
     //    theQueue.showq();
      while( !theQueue.isEmpty() )     // until queue empty,
         {
         //   theQueue.showq();
         int v1 = theQueue.remove();   // remove vertex at head
            theQueue.showq();
         // until it has no unvisited neighbors
         while( (v2=getAdjUnvisitedVertex(v1)) != -1 )//true: it v1 has neibours vertex
            {                                  // get one,
            vertexList[v2].wasVisited = true;  // mark it
            displayVertex(v2);                 // display it
            theQueue.insert(v2);               // insert it

            }   // end while
         }  // end while(queue not empty)

      // queue is empty, so we're done
      for(int j=0; j<nVerts; j++)             // reset flags
         vertexList[j].wasVisited = false;
      }  // end bfs()
// -------------------------------------------------------------
   // returns an unvisited vertex adj to v
   public int getAdjUnvisitedVertex(int v)
      {
      for(int j=0; j<nVerts; j++)
         if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
            return j;
      return -1;
      }  // end getAdjUnvisitedVertex()
// -------------------------------------------------------------
   }  // end class Graph
////////////////////////////////////////////////////////////////
class BFSApp
   {
   public static void main(String[] args)
      {
      Graph theGraph = new Graph();
      theGraph.addVertex('A');    // 0  (start for bfs)
      theGraph.addVertex('B');    // 1
      theGraph.addVertex('C');    // 2
      theGraph.addVertex('D');    // 3
      theGraph.addVertex('E');    // 4

      theGraph.addEdge(0, 1);     // AB
      theGraph.addEdge(1, 2);     // BC
      theGraph.addEdge(0, 3);     // AD
      theGraph.addEdge(3, 4);     // DE
 theGraph.showmatrix();
      System.out.print("Visits: ");
      theGraph.bfs();             // breadth-first search
      System.out.println();
      }  // end main()
   }  // end class BFSApp
////////////////////////////////////////////////////////////////

