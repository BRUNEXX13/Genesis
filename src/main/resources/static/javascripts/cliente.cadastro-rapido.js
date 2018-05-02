var Genesis = Genesis || {};

Genesis.ClienteCadastradoRapido = (function() {
	
		function ClienteCadastroRapido(){
			this.modal = $('#modalCadastroRapidoConta');
			this.botaoSalvar = this.modal.find('.js-modal-cadastro-conta-salvar-btn');
			this.form = this.modal.find('form');
			this.url = this.form.attr('action');
			this.inputNumeroAgencia = $("#numeroAgencia");
			this.inputNumeroConta = $("#numeroConta");
			this.inputTipoConta = $("#tipoConta");
			this.inputTitularConta = $("#titularConta");
			this.inputBancoCodigo = $("#bancoCodigo");
			this.containerMensagemErro = $('.js-mensagem-cadastro-rapido-conta');
		}
		
		ClienteCadastroRapido.prototype.iniciar = function() {
			this.form.on('submit', function(event) {event.preventDefault() });
			this.modal.on('shown.bs.modal', onModalShow.bind(this));
			this.modal.on('hide.bs.modal', onModalClose.bind(this));
			this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
			
		}
	
		
		function onModalShow() {
			this.inputTitularConta.focus();
			}

		function onModalClose() {
			this.inputNumeroAgencia.val('');
			this.inputTitularConta.val('');
			this.inputNumeroConta.val('');
			this.inputTipoConta.val('');
			this.inputBancoCodigo.val('');
		}
			

		function onBotaoSalvarClick(){
			var titularConta  = this.inputTitularConta.val().trim();
			var numeroAgencia = this.inputNumeroAgencia.val().trim();
			var numeroConta   = this.inputNumeroConta.val().trim();
			var tipoConta  	  = this.inputTipoConta.val().trim();
			var bancoCodigo   = this.inputBancoCodigo.val();
	
			$.ajax({
				url: this.url,
				method: 'POST',
				contentType: 'application/json',
				data: JSON.stringify({'agencia'  : numeroAgencia , 'numero' : numeroConta , 'tipoConta' : tipoConta , 'titular' : titularConta , 'banco' : { 'codigo' : bancoCodigo}  }),
				error: onErroSalvandoConta.bind(this),
				success: OnContaSalvo.bind(this)
		});
		
		}
		
		function onErroSalvandoConta(obj){
			var mensagemErro = obj.responseText;
			this.containerMensagemErro.removeClass('hidden');
			this.containerMensagemErro.html('<span>' + mensagemErro + '</span>');
			this.form.find('.form-group').addClass('has-error');
			
		}
		
		function OnContaSalvo(conta){
			var comboConta = $('#conta');
			comboConta.append('<option value=' + conta.codigo + '>' + conta.titular + '</option>');
			comboConta.val(conta.codigo);
			this.modal.modal('hide');
		}
		

		return ClienteCadastroRapido;
}());

$(function() {

		var clienteCadastroRapido = new Genesis.ClienteCadastradoRapido();
		clienteCadastroRapido.iniciar();
	
});