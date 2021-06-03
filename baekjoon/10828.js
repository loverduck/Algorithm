class Stack {
    constructor() {
      this.storage = {}
      this.size = 0
    }
    push(element) {
      this.size++ 
      this.storage[this.size] = element 
    }
  
    pop() {
      let removed = this.storage[this.size]
      delete this.storage[this.size]
      this.size--
      return removed
    }
  
    peek() {
      return this.storage[this.size]
    }
}