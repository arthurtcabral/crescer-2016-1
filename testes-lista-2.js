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
