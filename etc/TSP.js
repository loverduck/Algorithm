function calculateDistance(p1, p2) {
  const yDiffSquared = Math.pow(p2[0] - p1[0], 2);
  const xDiffSquared = Math.pow(p2[1] - p1[1], 2);
  const dist = Math.sqrt(yDiffSquared + xDiffSquared);
  return Math.floor(dist * 100);
}

const TSP = function (places) {
  
  let minDistance = Number.MAX_VALUE;
  const n = places.length;
  const visited = new Array(n).fill(false);

  function findPath(lastPlaceIdx, visited, visitCount, totalDistance) {
    if (visitCount === n) {
      minDistance = Math.min(minDistance, totalDistance);
      return;
    }
    visited.forEach((el, idx) => {
      if (!el) {
        let nextDistance = calculateDistance(places[lastPlaceIdx], places[idx]);
        visited[idx] = true;
        findPath(idx, visited, visitCount + 1, totalDistance + nextDistance);
        visited[idx] = false;
      }
    })
  }

  for (let i = 0; i < n; i++) {
    visited[i] = true;
    findPath(i, visited, 1, 0);
    visited[i] = false;
  }

  return minDistance;
};
  