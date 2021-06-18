function connectedVertices(edges) {
  const maxVertex = edges.reduce((acc, e) => Math.max(acc, ...e), 0);

  const adjList = {};
  for (let i = 0; i <= maxVertex; i++) {
    adjList[i] = [];
  }
  
  for (let edge of edges) {
    adjList[edge[0]].push(edge[1]);
    adjList[edge[1]].push(edge[0]);
  }

  const visited = new Array(maxVertex).fill(false);
  let count = 0;

  for (let vertex = 0; vertex <= maxVertex; vertex++) {
    if (!visited[vertex]) {
      bfs(adjList, vertex, visited);
      count++;
    }
  }
  return count;
}

function bfs(adjList, vertex, visited) {
  const queue = [vertex];
  visited[vertex] = true;

  while (queue.length > 0) {
    let now = queue.shift();
    for (let i = 0; i < adjList[now].length; i++) {
      if (!visited[adjList[now][i]]) {
        queue.push(adjList[now][i]);
        visited[adjList[now][i]] = true;
      }
    }
  }
}