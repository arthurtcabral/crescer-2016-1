'use strict';

$.ajax({ url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET' })
.done(function (res) {
    console.log(res.items);
    var $musicas = $('#musicas');
    res.items.forEach(function (album) {
        album.images.forEach(function (imagem) {
            var $img = $('<img>').attr('src', imagem.url);
            if (imagem.height == 300) {
                $musicas.append(
                $('<li>').append($img)
                );
            }
        });
    });
});