function solution(files) {
  files.sort((a, b) => {
    let [, head1, number1, tail1] = a.match(/(\D+)(\d+)([\s\S]*)/)
    let [, head2, number2, tail2] = b.match(/(\D+)(\d+)([\s\S]*)/)
    head1 = head1.toLowerCase();
    head2 = head2.toLowerCase();

    if (head1 !== head2) return head1 < head2 ? -1 : 1;
    if (+number1 !== +number2) return +number1 - +number2
    return 0;
  })

  return files;
}