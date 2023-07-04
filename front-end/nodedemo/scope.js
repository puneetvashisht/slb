function print(fn){
    fn();
}

// function foo(){
//     console.log('foo function');
// }

// print(foo)


//anonymous function
print(function(){
    console.log('foo function');
})

// using lamdas
print(() => console.log('foo'))