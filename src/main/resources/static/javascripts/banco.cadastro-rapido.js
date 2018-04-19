$(function() {

	var modal = $('#modalCadastroRapidoBanco');
	var botaoSalvar = modal.find('.js-modal-cadastro-banco-salvar-btn');
	var form = modal.find('form');
	form.on('submit', function(event) {
		event.preventDefault()
	});
	var url = form.attr('action');
	var inputNumeroBanco = $('#numeroBanco');
	var inputNomeBanco = $('#nomeBanco');
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-banco');

	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);

	function onModalShow() {
		inputNumeroBanco.focus();
	}

	function onModalClose() {
		inputNumeroBanco.val('');
		inputNomeBanco.val('');
		containerMensagemErro.addClass('hidden');
		form.find('.form-group').removeClass('has-error');
		
	}

	function onBotaoSalvarClick() {
		var numeroBanco = inputNumeroBanco.val().trim();
		var nomeBanco =   inputNomeBanco.val().trim();
		$.ajax({
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({'numero' : numeroBanco, 'nome': nomeBanco }),
			error: onErroSalvandoBanco,
			success: OnBancoSalvo
		});
	}

	function onErroSalvandoBanco(obj) {
		var mensagemErro = obj.responseText;
		containerMensagemErro.removeClass("hidden");
		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}
	
	function OnBancoSalvo(banco) {
		var comboBanco = $('#banco');
		comboBanco.append('<option value=' + banco.codigo + '>' + banco.nome +'</option>')
		comboBanco.val(banco.codigo);
		modal.modal('hide');
	}

});