function improveBook(books, speeds) {
    const result = [];
  
    const days = books.map((el, idx) => {
      let day = parseInt((100 - el) / speeds[idx]);
      return (100 - el) % speeds[idx] ? day + 1 : day;
    });
  
    while (days.length > 0) {
      let idx = days.findIndex((day) => day > days[0]);
      if (idx === -1) {
        result.push(days.length);
        break;
      }
      result.push(idx);
      days.splice(0, idx);
    }
  
    return result; // 배포되는 책 갯수
  }