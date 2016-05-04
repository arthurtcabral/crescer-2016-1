'use-strict';

describe('Ex 1. Obter doadores', function() {
  it('Retorno de doadores universais', function() {
    expect(obterDoadores().length).toBe(3);
  });
});

describe('Ex 2. Obter cavaleiro com mais golpes', function() {
  it('O esperado é que o cavaleiro seja o de id 6 ', function() {
    expect(obterCavaleiroComMaisGolpes().id).toEqual(6);
  });
});

describe('Ex 3. Obter mês com mais aniversariantes', function() {
  it('Devem ser 3 mêses ', function() {
    expect(obterMesesComMaisAniversarios().length).toEqual(3);
  });
});

describe('Ex 3. Obter mês com mais aniversariantes', function() {
  it('Deve ser março, maio e novembro ', function() {
    expect(obterMesesComMaisAniversarios()[0]).toEqual('Março');
    expect(obterMesesComMaisAniversarios()[1]).toEqual('Maio');
    expect(obterMesesComMaisAniversarios()[2]).toEqual('Novembro');
  });
});

describe('Ex 4. Obter média das alturas, em metros', function() {
  it('Deve ser 1.86 ', function() {
    expect(obterAlturaMedia()).toEqual(1.86);
  });
});

describe('Ex 5. Obter mediana das alturas, em metros', function() {
  it('Devem ser 1.85 ', function() {
    expect(obterAlturaMediana()).toEqual(1.85);
  });
});

describe('Ex 6a. Obter peso médio, em kilos', function() {
  it('Deve ser 84.27 ', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  });
});

describe('Ex 6b. Obter peso médio dos doadores, em kilos', function() {
  it('Deve ser 80.67 ', function() {
    expect(obterPesoMedioDoadores()).toEqual(80.67);
  });
});

describe('Ex 7. Obter IMC', function() {
  it('Checar tamanho do array, que deve ser = 11 ', function() {
    expect(obterIMC().length).toEqual(11);
  });
});

describe('Ex 7. Obter IMC', function() {
  it('Checar valor por valor', function() {
    expect(obterIMC()[0]).toEqual(22.64);
    expect(obterIMC()[1]).toEqual(29.48);
    expect(obterIMC()[2]).toEqual(24.62);
    expect(obterIMC()[3]).toEqual(24.22);
    expect(obterIMC()[4]).toEqual(24.84);
    expect(obterIMC()[5]).toEqual(20.53);
    expect(obterIMC()[6]).toEqual(24.54);
    expect(obterIMC()[7]).toEqual(24.31);
    expect(obterIMC()[8]).toEqual(23.99);
    expect(obterIMC()[9]).toEqual(22.45);
    expect(obterIMC()[10]).toEqual(21.5);
  });
});

describe('Ex 8. Obter Sobrepeso', function() {
  it('Checar tamanho do array, que deve ser = 1 ', function() {
    expect(obterSobrepeso().length).toEqual(1);
  });
});

describe('Ex 8. Obter Sobrepeso', function() {
  it('Checar quem tem sobrepeso, que deve ser o Aldebaran ', function() {
    expect(obterSobrepeso()[0].nome).toEqual('Aldebaran');
  });
});
