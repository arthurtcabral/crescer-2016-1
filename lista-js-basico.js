function daisyGame(numero){         // Exercício 1
    if(numero % 2 !== 0){
      return 'Love me';
    } else{
      return 'Love me not';
    }
}

function maiorTexto(arrayStrings){             // Exercício 2
var maiorPalavra = " ";
for (var i = 0; i < arrayStrings.length; i++) {
  if(arrayStrings[i].length >= maiorPalavra.length){
    maiorPalavra = arrayStrings[i];
  }
}
return maiorPalavra;
}

function forImprime(arrayStrings){                //Exercício 3
  for (var i = 0; i < arrayStrings.length; i++) {
    console.log('Olá querido instrutor: ' + arrayStrings[i]);
  }
}

function imprime(arrayStrings, fn){               //Exercício 3
  if (typeof fn === 'function') {
  fn(forImprime(arrayStrings));
} else {
  console.log(typeof fn + ' is not a function');
}
}

var somaDiferentona = function(numero1){          //Exercício 4
   return function(numero2){
     return numero1 + numero2;
   }
}

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
}

function queroCafe(mascada, precos){              //Exercício 6
  precos.sort();
  var precosOrdenados = " ";
  for (var i = 0; i < precos.length; i++) {
    if(precos[i] <= mascada){
      precosOrdenados = precosOrdenados + precos[i] + " , "
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
  console.log(gohan);               //A função desconhece a variável gohan, logo aparece undefined
  goku = 'Son Goku';                // goku é renomeado
  var gohan = 'Son ' + gohan;       // gohan recebe 'Son', ficando 'Son undefined'
  return gohan;
}
console.log(revelarSaiyaman());     // printa-se 'Son undefined'
console.log(goku);                  // printa-se o nome renomeado ('Son goku')
