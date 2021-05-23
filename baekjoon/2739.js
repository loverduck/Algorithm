const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.on('line', function(line) {
  let n = Number(line)
  for (let i = 1; i < 10; i++) {
      console.log(n + ' * ' + i + ' = ' + n * i)
  }

  rl.close();
}).on("close", function() {
  process.exit();
});