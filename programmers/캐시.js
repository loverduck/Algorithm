function solution(cacheSize, cities) {
  let cache = new Array(cacheSize);
  let time = 0;

  if (cacheSize === 0) return cities.length * 5;

  for (let i = 0; i < cities.length; i++) {
    cities[i] = cities[i].toLowerCase();
    if (cache.indexOf(cities[i]) !== -1) {
      cache.splice(cache.indexOf(cities[i]), 1);
      cache = [...cache, cities[i]];
      time++;
    } else {
      cache = [...cache.slice(1), cities[i]]
      time += 5;
    }
  }

  return time;
}