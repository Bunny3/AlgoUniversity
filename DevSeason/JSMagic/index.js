let name = {
  firstname : "Shubham",
  lastname : "Agarwal",
  printFullName: function() {
    console.log(this.firstname + " " + this.lastname);
  }
}

// name.printFullName();

// //pollyfill for bind
// let name2 = {
//   firstname : "Shubham",
//   lastname  : "agarwal"
// }

let printName = function(hometown, state) {
  console.log(this.firstname + " " + this.lastname + " "+ hometown+" "+state);
}

//pollyfill
Function.prototype.mybind = function(...args) {
  //this->printname
  let obj = this;
  params = args.slice(1);
  return function(...args2){
    // obj.call(args[0],params);// Here params is array
    obj.apply(args[0], [...params,...args2]);
  }
};
let printMyName = printName.mybind(name,"LKO");
printMyName("UP");

//Debouncing :
