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
