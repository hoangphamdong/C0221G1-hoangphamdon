function fibonacci(number) {
    if (number < 0) {
        return -1;
    }
    else if (number == 0 || number == 1) {
        return number;
    }
    else {
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
var sum = 0;
var fibonacciString = "";
for (var i = 0; i < 10; i++) {
    fibonacciString += fibonacci(i);
    sum += fibonacci(i);
}
console.log("Đây là dãy 10 số fibonacci: " + fibonacciString);
console.log("Đây là tổng 10 số fibonacci: " + sum);
