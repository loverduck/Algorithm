var allPathsSourceTarget = function(graph) {
  const lastNode = graph.length - 1;
  paths = [];
    
  const dfs = (start, end, path) => {
        
    for (let i of graph[start]) {
      if (i === end) {
        paths.push([...path, end])
      }
            
      dfs(i, end, [...path, i]);
    }
  }
    
  dfs(0, lastNode, [0]);
  return paths;
};
