var findJudge = function(n, trust) {
    const vertex = {};
    const count = new Array(n + 1).fill(0);

    for (let i of trust) {
        if (vertex[i[0]] === undefined) {
            vertex[i[0]] = [i[1]];
        } else {
            vertex[i[0]].push(i[1]);
        }
        count[i[1]]++;
    }
    
    for (let i = 1; i <= n; i++) {
        if (vertex[i] === undefined && count[i] === n - 1) return i;
    }
    return -1;
};