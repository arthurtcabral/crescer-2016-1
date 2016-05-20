'use strict'

$(function () {
    var porcentagem = Math.floor(Math.random() * 11);
    var $ecletica = $("#ecletica");
    var $formEcletico = $('#form-ecletico');
    $formEcletico.submit(function (e) {
        var $termoPesquisa = $('input[name=pesquisa]').val();
        var douchebag = ($termoPesquisa == 'Justin Bieber' && porcentagem > 2);
        var urlPesquisaPorId = "https://api.spotify.com/v1/search?q=" + $termoPesquisa + "&type=artist";
        $.ajax({ url: urlPesquisaPorId, type: 'GET' })
        .done(function (res) {
            var $ecletica = $('#ecletica');
            var idBusca = null;
            if (douchebag) {
                idBusca = "douchebag";
            } else {
                idBusca = res.artists.items[0].id;
            }
            var urlAlbum = "https://api.spotify.com/v1/artists/" + idBusca + "/albums?limit=50";
            $.ajax({ url: urlAlbum, type: 'GET' })
.done(function (banda) {
    banda.items.forEach(function (album) {
        album.images.forEach(function (imagem) {
            var $img = $('<img>').attr('src', imagem.url);
            if (imagem.height == 300) {
                $ecletica.append(
                $('<li>').append($img)
                );
            }
        });
    });
}).fail(function (a) {
    alert("Caro usuário, devido a um erro 400, não foi possível pesquisar por Justin Bieber");
});
        });
        e.preventDefault();
    });
});