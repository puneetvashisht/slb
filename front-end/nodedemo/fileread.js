
const fs = require('fs');

//sync version

console.log('starting...')
var content = fs.readFileSync('./hello.js');
// async version
// fs.readFile('./hello.js', function(err, data){
//     console.log('After file is read');
//     console.log('Contents : ' + data)
// })

console.log('Contents : ' + content)
console.log('finishing...')