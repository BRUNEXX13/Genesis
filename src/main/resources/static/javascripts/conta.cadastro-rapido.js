$(function() {

	var modal = $('#modalCadastroRapidoConta');
	var botaoSalvar = modal.find('.js-modal-cadastro-conta-salvar-btn');
	var form = modal.find('form');
	form.on('submit', function(event) {event.preventDefault() });
	var url = form.attr('action');
	var inputNumeroAgencia = $("#numeroAgencia");
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-conta');
	
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	
		function onModalShow() {
		inputNumeroAgencia.focus();
		}

		function onModalClose() {
			inputNumeroAgencia.val('');
		}
	
		
		function onBotaoSalvarClick(){
			var numeroAgencia = inputNumeroAgencia.val().trim();
			$.ajax({
				url: url,
				method: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({ 'agencia'  : numeroAgencia}),
				error: onErroSalvandoConta
		});
		
		}
		
		function onErroSalvandoConta(obj){
			var mensagemErro = obj.responseText;
			containerMensagemErro.removeClass('hidden');
			containerMensagemErro.html('<span>' + mensagemErro + '</span>');
			form.find('.form-group').addClass('has-error');
			
		}
		

		function OnContaSalvo(conta){
			var comboConta = $('#conta');
			comboConta.append('<option value=' + conta.codigo + '>' + conta.numero + '</option>');
			comboConta.val(conta.codigo);
			modal.modal('hide');
		}
		
		
		
});