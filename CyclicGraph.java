// check if directed graph contains a cycle


public boolean dfs(Node node,ArrayList<Node> visited,ArrayList<Node> recursiveStack){

        visited.add(node);
  recursiveStack.add(node);
        for(Node eachNode:node.getNeighbors()){
                if(visited.contains(eachNode))
                        return true;
                )
                  if(recursiveStack.contains(eachNode)){
                    return true;
                  }
                return dfs(eachNode,visited);
        }
    recursiveStack.remove(node);
    return false;
}

public boolean isCyclePresent(List<Node> nodes,List<List<Node>> edges){

ArrayList<Node> visited=new ArrayList<>();
  ArrayList<Node> recursiveStack=new ArrayList<>();
boolean isCyclic=false;
buildGraph(nodes,edges);//this adds to  neighbours list for every node with edge to another

for(Node eachNode:nodes){
    if(!visited.contains(eachNode)){
        isCyclic=dfs(eachNode,visited,recursiveStack);
    }
    if(isCyclic==true){
        break;
   }
return isCyclic;
}
