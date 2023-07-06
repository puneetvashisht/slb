const path = require('path');

module.exports = {
  entry: './tryadd.js',
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js',
  },
};