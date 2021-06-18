var isSameTree = function(p, q) {
  // p 와 q 모두 빈 노드일 때
  if (p === null && q === null) return true;
  // p와 q 한쪽만 빈 노드일 때
  if (p === null || q === null) return false;
  // p와 q 값 비교    
  if (p.val !== q.val) return false;
  
  // 왼쪽 오른쪽 재귀로 비교
  let isSameLeft = isSameTree(p.left, q.left);
  let isSameRight = isSameTree(p.right, q.right);
      
  return isSameLeft && isSameRight;
  };
  