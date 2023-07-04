function outer(){
    console.log('outer fn');
    var x = 34;
    var inner = function(){
        
        console.log('inner fn');
        console.log(x + 2);

    }
    // console.log(x);
    return inner;
}

var result = outer();
result();

result();

// outer()();

// Creation Phase outer [x: undef, inner: undef] inner [x: undef]
// Execution Phase outer [x: 34, inner: fn] inner [x: undef]

// abc();
// function abc(){
//     console.log('abc');
// }

var abc = function(){
    console.log('abc');
}
