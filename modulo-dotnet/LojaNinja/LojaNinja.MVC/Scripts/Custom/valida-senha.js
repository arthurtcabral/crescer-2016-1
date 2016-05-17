$(document).ready(function () {

    var regex = /^(?=(?:.*?[A-Z]){1})(?=(?:.*?[0-9]){1})(?=(?:.*?[a-z]){1})*$/;

    $('form').submit(function (e) {
        e.preventDefault();
        if ($('#Senha').val() !== $('#RepetirSenha').val()) {
            alert("Senhas não condizem!");
            return false;

        } else if ($('#Senha').val() < 8) {
            alert("Senha deve ter pelo menos 8 caracteres!");
            return false;

        } else if ($(!regex.exec('#Senha').val())) {
            alert("Mínimo 1 minúsculo, 1 maiúsculo e 1 número!");
            return false;
        } else {
            return true;
        }
    }); 
});