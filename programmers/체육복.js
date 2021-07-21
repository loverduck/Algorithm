function solution(n, lost, reserve) {
    // 중복 제거
    lost = lost.filter(el => {
        if (!reserve.includes(el)) return true;
        reserve = reserve.filter(i => i !== el);
    })
    
    for (let r of reserve) {
        if (lost.includes(r - 1)) {
            lost = lost.filter(el => el !== r - 1)
        }
        else if (lost.includes(r + 1)) {
            lost = lost.filter(el => el !== r + 1)
        }
    }
    
    return n - lost.length;
}