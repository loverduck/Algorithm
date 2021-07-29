function solution(people, limit) {
  people.sort((a, b) => a - b);
  let count = 0;
  let start = 0, end = people.length - 1;

  while (start <= end) {
    if (people[start] <= limit - people[end]) {
      start++;
    }
    count++;
    end--;
  }

  return count;
}