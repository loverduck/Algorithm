const largestRectangularArea = function (histogram) {
    // TODO: 여기에 코드를 작성합니다.
  const createMinTree = (arr, ts, te) => {
    if (ts === te) {
      return { index: ts, value: arr[ts] };
    }
    const mid = parseInt((ts + te) / 2);
    const left = createMinTree(arr, ts, mid);
    const right = createMinTree(arr, mid + 1, te);

    let index = left.value < right.value ? left.index : right.index;
    let value = arr[index];

    return {
      index,
      value,
      left,
      right
    };
  };
  const tree = createMinTree(histogram, 0, histogram.length - 1);

  const findMin = (ts, te, rs, re, tree) => {
    if (rs <= ts && te <= re) {
      return tree.index;
    }

    if (te < rs || re < ts) {
      return rs;
    }

    const mid = parseInt((ts + te) / 2);
    let leftIdx = findMin(ts, mid, rs, re, tree.left) 
    let rightIdx = findMin(mid + 1, te, rs, re, tree.right)
    return histogram[leftIdx] < histogram[rightIdx] ? leftIdx : rightIdx;
  };

  const findArea = (start, end) => {
    if (start > end) return 0;

    let minIdx = findMin(0, histogram.length - 1, start, end, tree);
    let area = histogram[minIdx] * (end - start + 1);
    let leftArea = findArea(start, minIdx - 1);
    let rightArea = findArea(minIdx + 1, end);

    return Math.max(area, leftArea, rightArea);
  }

  return findArea(0, histogram.length - 1, 0, histogram.length - 1, tree);
};