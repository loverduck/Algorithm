const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', function(line) {
  let year = Number(line)
  if (year % 400 === 0 || (year % 4 === 0 && year % 100 !== 0)) {
    result = 1;
  } else {
    result = 0;
  }
  console.log(result);
  rl.close();
}).on("close", function() {
  process.exit();
});