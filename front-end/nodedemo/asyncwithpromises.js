



console.log('starting...');

function foo(){
    return new Promise((resolve, reject)=> {
        setTimeout(()=> {
            console.log('async function invoked...');
            reject("failure");
        }, 2000)
    })
}

async function test(){
    //sugar-syntax for promises : using await async
    try{
        var result = await foo();
        console.log(result);
    }
    catch(err){
        console.log('Caught error ', err);
    }
   
}

test();





// foo()
// .then((result) => console.log('in then statement', result))
// .catch((err)=> console.log('Some error happend ', err))

// async((result)=>{
//     console.log(result);
// })

// console.log(result);

console.log('finishing...');