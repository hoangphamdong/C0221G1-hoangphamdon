function fibonacci(number: number): number {
    if (number < 0) {
        return -1;
    } else if (number == 0 || number == 1) {
        return number;
    } else {
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}

let sum: number = 0;
let fibonacciString="";
for (let i = 0; i < 10; i++) {
    fibonacciString+=fibonacci(i);
    sum+=fibonacci(i);
}
console.log("Đây là dãy 10 số fibonacci: "+fibonacciString);
console.log("Đây là tổng 10 số fibonacci: "+sum);

