alert("Outro script");
console.log(hello);

function somar(a, b) {
  return a + b;
}
var sub = function(a, b, fn){
  fn(a - b);
}

function subtrair(a, b) {
  return a - b;
}

var funcoes = [somar(1, 1), subtrair];
console.log(funcoes[1](3, 2));

var funcoes2 = [somar(1, 1), sub]; // Usando o segundo valor do array funcoes2, que é sub. function (res) pega o resultado da função interna.
var aux = funcoes2[1](1, 1, function(res){console.log(res)}); // res pega o resultado da função interna.
