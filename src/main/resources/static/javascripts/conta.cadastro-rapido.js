$(function() {

	var modal = $('#modalCadastroRapidoConta');
	var botaoSalvar = modal.find('.js-modal-cadastro-conta-salvar-btn');
	var form = modal.find('form');
	form.on('submit', function(event) {event.preventDefault() });
	var url = form.attr('action');
	var inputNumeroAgencia = $("#numeroAgencia");
	var inputNumeroConta = $("#numeroConta");
	var inputTipoConta = $("#tipoConta");
	var inputTitularConta = $("#titularConta");
	var inputBancoCodigo = $("#bancoCodigo");
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-conta');
	
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaoSalvar.on('click', onBotaoSalvarClick);
	
	
		function onModalShow() {
		inputTitularConta.focus();
		}

		function onModalClose() {
			inputNumeroAgencia.val('');
			inputTitularConta.val('');
			inputNumeroConta.val('');
			inputTipoConta.val('');
			inputBancoCodigo.val('');
		}
	
		
		function onBotaoSalvarClick(){
			var titularConta  = inputTitularConta.val().trim();
			var numeroAgencia = inputNumeroAgencia.val().trim();
			var numeroConta   = inputNumeroConta.val().trim();
			var tipoConta  	  = inputTipoConta.val().trim();
			var bancoCodigo   = inputBancoCodigo.val();
	
			$.ajax({
				url: url,
				method: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({'agencia'  : numeroAgencia , 'numero' : numeroConta , 'tipoConta' : tipoConta , 'titular' : titularConta , 'banco' : { 'codigo' : bancoCodigo}  }),
				error: onErroSalvandoConta,
				success: OnContaSalvo
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