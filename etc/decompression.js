const decompression = function (image) {

  let m = image.length;
  let result = '';

  const dec = (x, y, len) => {
    let isSame = true;

    if (len === 1) {
      return '' + image[x][y];
    }

    for (let i = 0; i < len; i++) {
    for (let j = 0; j < len; j++) {
      if (image[x][y] !== image[x + i][y + j]) {
        isSame = false;
        break;
      }
    }
      if (!isSame) break;
    }

    if (isSame) return '' + image[x][y];

    len = len / 2;
    let str = 'X';
    str += dec(x, y, len);
    str += dec(x, y + len, len);
    str += dec(x + len, y, len);
    str += dec(x + len, y + len, len);

    return str;
  }

  result = dec(0, 0, m);
  return result;
};
