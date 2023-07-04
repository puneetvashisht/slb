

console.log('starting...');

function sync(){
    // time consuming..
    console.log('sync function invoked...');
    return "success"
}
var result = sync();
console.log(result);

console.log('finishing...');


console.log('starting...');

function async(callback){
    setTimeout(()=> {
        console.log('sync function invoked...');
        callback("success");
    }, 0)
   
}
// var result = async();

async((result)=>{
    console.log(result);
})

// console.log(result);

console.log('finishing...');