function decryptCaesarCipher(str, secret) {
    return str.split('').map((letter) => {
      if (letter === ' ') {
        return ' ';
      }
      let idx = letter.charCodeAt(0) - secret;
      if (idx < 97) {
        idx += 26;
      }
      return String.fromCharCode(idx);
    }).join('');
  }