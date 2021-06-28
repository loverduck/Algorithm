const powerSet = function (str) {
    let arr = str.split('');
    let strArr = [];
    for (let i of arr) {
      if (!strArr.includes(i)) {
        strArr.push(i);
      }
  
    }
    strArr.sort();
  
    const results = [];
    
    const dfs = (i, subArr) => {
      if (i === strArr.length) {
        results.push(subArr.join(''));
      } else {
        dfs(i + 1, subArr);
        dfs(i + 1, [...subArr, strArr[i]]);
      }
    }
    
    dfs(0, []);
  
    results.sort();
    return results;
  };