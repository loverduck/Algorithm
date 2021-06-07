class Queue {
    constructor() {
      this.storage = [];
      this.length = 0;
    }
    push(element) {
      this.storage[this.length++] = element;
    }
  
    pop() {
      let removed = this.storage[0];
      this.storage = this.storage.slice(1);
      this.length--;
      return removed;
    }
  
    size() {
      return this.length;
    }

    empty() {
      return (this.length ? 0 : 1);
    }

    front() {
      return (this.length ? this.storage[0] : -1);
    }

    back() {
      return (this.length ? this.storage[this.length - 1] : -1);
    }
}

const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

const queue = new Queue()

rl.on('line', function(line) {
  input.push(line);

  rl.close();
}).on("close", function() {
  input = input.slice(1);
  let result = input.forEach((log, line) => {
    let command = line.split(' ');
    if (command[0] === 'push')
      stack.push(command[1]);
    else if (command[0] === 'pop') 
      log += stack.pop() + '\n';
    else if (command[0] === 'size')
      log += stack.size() + '\n';
    else if (command[0] === 'empty')
      log += stack.empty() + '\n';
    else if (command[0] === 'front')
      log += stack.front() + '\n';
    else if (command[0] === 'back')
      log += stack.back() + '\n';
    return log;
  }, '')
  console.log(result);
  
  process.exit();
});