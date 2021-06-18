function solution(n, edge) {
   // 인접 리스트 생성
  const vertex = {};
      
  for (let i = 1; i <= n; i++) {
    vertex[i] = [];
  }
      
  for (let e of edge) {
    vertex[e[0]].push(e[1]);
    vertex[e[1]].push(e[0]);
  }
          
  return bfs(vertex, 1, n);
}
  
function bfs(vertex, start, n) {
  let level = new Array(n + 1).fill(0); // 노드번호를 인덱스로 갖는 level array 
  let lev = 0 
  let check = {} // 방문 노드 체크
  const queue = [start];
  check[start] = true;
  
  while (queue.length > 0) {
      
    let now = queue.shift();
    lev = level[now] + 1; // 다음 노드로 넘어갈 때 now의 level보다 +1 증가
  
    for (let i = 0; i < vertex[now].length; i++) {
      if (!check[vertex[now][i]]) {
        queue.push(vertex[now][i]);
        check[vertex[now][i]] = true;
        level[vertex[now][i]] = lev; // 노드의 레벨 
      }
    }
  }
    // level의 값 중 가장 큰 값을 가진 요소의 갯수 리턴
  return level.filter((el) => el === Math.max(...level)).length;  
}