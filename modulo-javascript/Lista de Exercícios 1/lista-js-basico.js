function daisyGame(numero){         // Exercício 1
    if(numero % 2 !== 0){
      return 'Love me';
    } else{
      return 'Love me not';
    }
}

function maiorTexto(arrayStrings){             // Exercício 2
var maiorPalavra = "";
for (var i = 0; i < arrayStrings.length; i++) {
  if(arrayStrings[i].length > maiorPalavra.length){
    maiorPalavra = arrayStrings[i];
  }
}
return maiorPalavra;
}

function imprime(arrayStrings, fn) {
  arrayStrings.forEach(function(instrutor) { //Para cada instrutor do array
    if (typeof fn === 'function') fn(instrutor);  //Se fn for uma função, ele a usa. O ideal é que a função seja de impressão na tela.
  });
};

var somaDiferentona = function(numero1){          //Exercício 4
   return function(numero2){
     return numero1 + numero2;
   };
};

var fiboSum = function(n){                        //Exercício 5
  var arrayFibo = [n];
  if(n > 0){
  arrayFibo[0] = 1;
  if(n > 1){
  for (var i = 1; i < n; i++) {
    if(i === 1){
        arrayFibo[i] = 1;
    }else{
    arrayFibo[i] = arrayFibo[i-1] + arrayFibo[i-2];
  }
  }
}
var soma = 0;
for (var i = 0; i < arrayFibo.length; i++) {
  soma = soma + arrayFibo[i];
}
console.log(soma);
}else{
  console.log('Digite número maior que 0.');
}
};

function queroCafe(mascada, precos){              //Exercício 6
  precos.sort();
  var precosOrdenados = " ";
  for (var i = 0; i < precos.length; i++) {
    if(precos[i] <= mascada){
      precosOrdenados = precosOrdenados + precos[i] + " , ";
    }
  }
  precosOrdenados = precosOrdenados.substring(0, (precosOrdenados.length - 2));
  return precosOrdenados;
}

function contarPorTipo(obj, tipoObj){               // Exercício 7
    var cont = 0;
    for(var i in obj){
      if(obj[i] === null){
        if(tipoObj === null){
        cont++;
      }
    }else if(obj[i].constructor === tipoObj){
        cont++;
      }
    }
return cont;
}

var gohan = 'gohan', goku = 'Goku';
function revelarSaiyaman() {
  // var gohan;
  console.log(gohan);
  goku = 'Son Goku'; //Como goku não vou redeclarado, foi reescrito.
  var gohan = 'Son ' + gohan;    // o JS puxa todas as declarações de variável para o início, ficando var gohan; Ele puxa apenas a declaração.
  // variavel local gohan vira 'Son + undefined'
  return gohan;
}
console.log(revelarSaiyaman()); // imprime a variavel local gohan
console.log(goku);              // imprime o novo valor da variavel goku
