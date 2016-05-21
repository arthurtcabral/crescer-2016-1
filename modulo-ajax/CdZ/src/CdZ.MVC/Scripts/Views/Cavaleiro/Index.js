'use strict';

var idAux = 0;

function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .then(
        function onSuccess(res) {
            console.log(res.data);
            var $cavaleiros = $('#cavaleiros');
            res.data.forEach(function (cava) {
                $cavaleiros.append(
                    $('<li>').attr('data-id-cavaleiro', cava.Id).append(cava.Nome)
                .append(
            $('<button>')
                .attr('data-cavaleiro-id', cava.Id)
                .click(excluirCavaleiroNoServidor)
                .text('Excluir')
        ));
                idAux = cava.Id;
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};

setInterval(function () {
    var aux = 0;
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .then(
    function onSuccess(res) {
        var $cavaleiros = $('#cavaleiros');
        res.data.forEach(function (cava) {
            if (cava.Id > idAux) {
                $cavaleiros.append($('<li>').attr('data-id-cavaleiro', cava.Id).append(cava.Nome).append(
            $('<button>')
                .attr('data-cavaleiro-id', cava.Id)
                .click(excluirCavaleiroNoServidor)
                .text('Excluir')
        ));
                idAux = cava.Id;
            }
      });
    }
    );
}, 5000);

function excluirCavaleiroNoServidor() {
    var cavaleiroId = parseInt($(this).attr('data-cavaleiro-id'));
    $.ajax({
        url: '/Cavaleiro/Delete' /*+  $.param({ id: cavaleiroId }),*/,
        type: 'DELETE',
        data: { id: cavaleiroId }
    });
};

carregarDadosNaPagina();

function editarCavaleiroNoServidor() {
    var cavaleiroId = parseInt($(this).attr('data-cavaleiro-id'));

    $.get('/Cavaleiro/GetById', { id: cavaleiroId })
        .done(function (detalhe) {
            // TODO: Implementar atualização a partir de um formulário ou campos na tela, e não hard-coded
            cavaleiroHardCoded = detalhe.data;
            cavaleiroHardCoded.Nome = 'Novo nome após update ' + new Date().getTime();
            cavaleiroHardCoded.AlturaCm = 205;
            cavaleiroHardCoded.Signo = 3;
            cavaleiroHardCoded.TipoSanguineo = 2;
            cavaleiroHardCoded.DataNascimento = new Date(2001, 0, 15);
            cavaleiroHardCoded.Golpes[0].Nome = 'Voadora do Sub-Zero Brasileiro'
            cavaleiroHardCoded.Golpes[1].Nome = 'Cólera dos 42 dragões';
            cavaleiroHardCoded.Golpes[2] = { Nome: 'Novo golpe aterrador' };
            cavaleiroHardCoded.LocalNascimento.Texto = 'Porto Alegre';
            cavaleiroHardCoded.LocalTreinamento.Texto = 'Alvorada';
            cavaleiroHardCoded.Imagens[0].Url = 'https://cloud.githubusercontent.com/assets/526075/15443404/5c97dde6-1ebe-11e6-8ae6-83372051dda7.png';
            cavaleiroHardCoded.Imagens[0].IsThumb = true;
            cavaleiroHardCoded.Imagens[1].Url = 'https://cloud.githubusercontent.com/assets/526075/15443410/6e9ba586-1ebe-11e6-8b90-64aca9e18a32.png';
            cavaleiroHardCoded.Imagens[1].IsThumb = false;

            $.ajax({
                url: '/Cavaleiro/Put',
                type: 'PUT',
                data: cavaleiroHardCoded
            });
        });
};

var $frmNovoCavaleiro = $('#frmNovoCavaleiro');
    $frmNovoCavaleiro.submit(function (e) {
        var cavaleiro = converterFormParaCavaleiro($frmNovoCavaleiro);
        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: cavaleiro.nome,
                AlturaCm: cavaleiro.alturaCm,
                pesoLb: cavaleiro.pesoLb,
                DataNascimento: cavaleiro.dataNascimento,
                Signo: cavaleiro.signo,
                TipoSanguineo: cavaleiro.tipoSanguineo,
                LocalNascimento: {
                    Texto: cavaleiro.localNascimento
                },
                LocalTreinamento: {
                    Texto: cavaleiro.localTreinamento
                },
                Golpes: cavaleiro.golpes,
                Imagens: cavaleiro.imagens
            }
        });
        return e.preventDefault();
    });

function converterFormParaCavaleiro($form) {
    var formData = new FormData($form[0]);
    var data = $('#txtDtNascimento').datepicker('getDate');

    var novasImagens = [];
    $('#novasImagens li').each(function () {
        novasImagens.push({
            url: $(this).find('input[name=urlImagem]').val(),
            isThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('#novosGolpes li').each(function (i) {
        novosGolpes.push($(this).find('input[name=golpe]').val());
    });

    return {
        nome: formData.get('nome'),
        tipoSanguineo: formData.get('tipoSanguineo'),
        imagens: novasImagens,
        dataNascimento: (data || new Date()).toISOString(),
        alturaCm: parseDouble(formData.get('alturaMetros')) * 100,
        pesoLb: parseDouble(formData.get('pesoKg')) * 2.20462262,
        signo: formData.get('signo'),
        localNascimento: formData.get('localNascimento'),
        localTreinamento: formData.get('localTreinamento'),
        golpes: novosGolpes
    };
};

var $novasImagens = $('#novasImagens');

$('#btnAdicionarImg').click(function() {
    var $novoLi = gerarElementoLiComInputs();
    $novasImagens.append($novoLi);
});

$('#btnAdicionarGolpe').click(function() {
    $('#novosGolpes').append(gerarElementoLiComInputTexto());
});

function gerarElementoLiComInputs() {
    var $novoTxt = $('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: bit.ly/shiryu.png');
    var $novoCheckbox =
      $('<label>').append(
        $('<input>')
        .attr('type', 'checkbox')
        .attr('name', 'isThumb')
        .attr('checked', 'checked')
      ).append('É thumbnail?');
    return $('<li>').append($novoTxt).append($novoCheckbox);
};

function gerarElementoLiComInputTexto() {
    var $novoTxt = $('<input>').attr('name', 'golpe').attr('type', 'text').attr('placeholder', 'Ex: Pó de diamante');
    return $('<li>').append($novoTxt);
};

//function registrarEventoDoBotao() {
//    $('#btnCriar').click(function () {

//        $.ajax({
//            url: urlCavaleiroPost,
//            type: 'POST',
//            data: {
//                Nome: 'Xiru ' + new Date().getTime(),
//                AlturaCm: 187,
//                Signo: 7,
//                TipoSanguineo: 1,
//                DataNascimento: new Date(),
//                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
//                LocalNascimento: {
//                    Texto: 'Beijing'
//                },
//                LocalTreinamento: {
//                    Texto: '5 picos de rosan'
//                },
//                Imagens: [{
//                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
//                    IsThumb: true
//                }, {
//                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
//                    IsThumb: false
//                }]
//            }
//        });

//    });
//};
//registrarEventoDoBotao();
