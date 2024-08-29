console.log("Hello Shubham");

//promise

const cart=["shoes","pants","Kurta"];
const promise = createOrder(cart);
console.log(promise);
promise.then(function(orderId) {
  return proceedToPayment(orderId);
}).then(function(paymentId) {
  console.log(paymentId);
}).catch(function(err) {
  console.log(err);
});

//Producer

function createOrder(cart) {
  const pr = new Promise(function(resolve,reject) {
    if(!validateCart(cart)) {
      const err = new Error("Cart is not valid");
      reject(err);
    }
    const orderId="12345";
    if(orderId) {
      resolve(orderId);
    }
  });
  return pr;
}

function proceedToPayment(orderId) {
  const pr = new Promise(function(resolve,reject) {
    if(!validatePayment(orderId)) {
      reject(new Error("Invalid Payment"));
    }
    const paymentId = "abqwer";
    resolve(paymentId);

  });
  return pr;
}
function validateCart(cart) {
  return true;
}
function validatePayment(orderId) {
  return true;
}


const p = new Promise((resolve,reject) => {
  setTimeout(function() {
    resolve("Promise is resolved");
  },10000);
});
console.log(p);
function getData() {
  p.then((res)=>console.log(res));
  console.log("Namaste JS");
}

getData();


// async - await
async function profile() {
  const data = await fetch("https://api.github.com/users/bunny3");
  const jsonData = await data.json();
  console.log(jsonData);
}

profile();