'use-strict';

var idAux = 0;

$(function () {

    $('#editar').click(function (e) {
        $('#txt').focus();
        idAux = parseInt($(e.target).parent().parent().children().first().text());
    });

    $('#go').click(function (e) {
        registrar({id: parseInt(idAux), nome: $('#txt').val()});
    });

});

function registrar(pessoa) {
    $.ajax({
        url: '/rest/pessoa/save_or_update',
        type: 'POST',
        data: pessoa
    }).done(function () {
        alert('Ação concluída!');
        idAux = 0;
    });
}

function cliqueExcluir(event) {
    var registroASerExcluido = $(event.target).parent().parent().children().first().text();
    $.ajax({
        url: '/rest/pessoa/delete',
        type: 'POST',
        data: {id: registroASerExcluido}
    }).done(function () {
        $(event.target).parents('tr').remove();
    });
}

