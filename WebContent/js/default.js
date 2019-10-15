'use strict';

/** Dummy noope function */
function noope() {}

function attachGo(button) {
	var $button = $(button);

	$button.on('click', function () {

		var $hiddenDestinazione = $('#input');
		var $hiddenCodice = $('#codice');
		var $form = $('#menuform');
		var codice = $button.data('codice') || '';
		var target = $button.data('go');

		$hiddenCodice.val(codice);
		$hiddenDestinazione.val(target);
		$form[0].submit();

	});
}

function attachToggle(button) {
	var $button = $(button);

	$button.on('click', function () {
		var $submenu = $button.parent().next('.subMenu');
		$submenu.slideToggle();
	});
}

/**
 * Gestione dei redirect, accetta come input un elemento HTML con gli
 * attributi data-href per indicare l'action da passare tramite il form
 * nascosto ed il data-hidden per definire il campo nascosto del form da
 * popolare. Dopo di che effettua la submit
 */
function goTo() {
	var $this = $(this);
	var _location = $this.data('href');
	var _action = $this.data('hidden');
	$('#' + _action).val(_location);
	document.form.submit();
}

function setEnabled(callback) {
	var $this = $(this);
	var cb = typeof callback === 'function' ? callback : noope;
	var uri = $('#host').val() + '/Ajax';
	var _value = $this.hasClass('active');
	var _row = $this.data('row');
	var payload = 'action=checkOT&row=' + _row + '&value=' + _value;
	$.ajax({
		type: 'POST',
		url: uri,
		async: false,
		dataType: 'text',
		data: payload
	}).done(function(data) {
		console.log('Data', data);
		cb(data);
	}).fail(function(error) {
		console.error('ERRORE', error)
	});
}

/**
 * Controllo dall'evento con un espressione regolare, se non è passata
 * il programma carica di default quella per il controllo numerico.
 * @param  {Event}  	event  		Evento scatenato dall'input
 * @param  {[RegExp]}  	expression  Espressione regolare di controllo
 * @return {Boolean}       			È un numero?
 */
function isNumeric(event, expression) {
	var theEvent = event || window.event;
	var key = theEvent.keyCode || theEvent.which;
	var regex = expression || /^[0-9]+$/;

	key = String.fromCharCode(key);

	if (key.length === 0)
		return

	return regex.test(key);
}

function check(){
	var inputUbicazione = $('.check');

	if (inputUbicazione[0].value != '' && inputUbicazione[1].value != '') 
		return submitHandler();
	
}

function submitHandler(){
    $('.formCheckBatch').append("<input type='hidden' name='checkPartita' value='X' />");
    return true;
}

$(function() {

	/** Memorizzazione degeli elementi del DOM ricorrenti */
	var $window = $(window);
	var $body = $('body');
	var $loader = $('.page-loader');
	var $alert = $('.alert');
	var $goButtons = $body.find('.go');
	var $menuButtons = $body.find('.hasMenu');
	var $header = $body.find('#header');
	var $go = $body.find('.goBack, .goTo');
	var $listGroupItems = $body.find('.list-group-item:not(.noUpdate)');
	var $clearActive = $body.find('.clearActive');
	var $confermaOrdine = $body.find('#confermaOrdine');
	var $dettaglioOrdine = $body.find('#dettaglioOrdine');
	var $numeric = $body.find('.numeric');
	var $modal = $('.modal');
	var $modalWBS = $('#modalWBS');
	if ($modalWBS.length > 0) {
		
		var enabled = $modalWBS.data('enabled');
		if (enabled == true) {
			var wbs = $('#wbs');
			var PS_PSP_PNR = $('#PS_PSP_PNR');
			$modalWBS.find('.setWbs').unbind().bind('click', function () {
				var self = $(this);
				if (wbs){
					wbs.val(self.data('pos'));
				}
				if (PS_PSP_PNR) {
					PS_PSP_PNR.val(self.data('posid'))
					$('button.goTo').attr('data-href', 'check');
					return $('button.goTo').click();					
				}
				$('form').submit();
			});
			
			$modalWBS.modal({backdrop: "static"});
			$modalWBS.show();
		}
	}
	
	var $modalBATCH = $('#modalBATCH');
	if ($modalBATCH.length > 0) {
		
		var enabled = $modalBATCH.data('enabled');
		if (enabled == true) {
			var POSID = $('#POSID');
			var CHARG = $('#CHARG');
			var LICHA = $('#LICHA');
			
			$modalBATCH.find('.setBATCH').unbind().bind('click', function () {
				var self = $(this);
				if (POSID)
					POSID.val(self.data('posid'));
				
				if (CHARG)
					CHARG.val(self.data('charg'));
				
				if (LICHA)
					LICHA.val(self.data('licha'));
				
				$modalBATCH.modal('hide')

				$('button.goTo').attr('data-href', 'check');
				return $('button.goTo').click();					

			});
			
			$modalBATCH.modal({backdrop: "static"});
			$modalBATCH.show();
		}
	}
	
	/** Inizializzazione della variabili globali */
	var _selectedItems = [];

	/** Gestione per la comparsa del loader quando vengono effettuati cambi pagina */
	$window.on('beforeunload', 	function() {
		_selectedItems = [];
	    $loader.removeClass('none');
	});

	if ($header.children().length > 0)
		$body.css('padding-top', '0px').find('footer').addClass('none');


	if ($goButtons.length > 0) {
		for (var i = 0, len = $goButtons.length; i < len; i++)
			attachGo.call(this, $goButtons[i]);
	}

	if ($menuButtons.length > 0) {
		for (var i = 0, len = $menuButtons.length; i < len; i++)
			attachToggle.call(this, $menuButtons[i]);
	}
	
	if ($modal.length > 0) {		
		$modal.on('show.bs.modal', function (event) {
		  var $button = $(event.relatedTarget);
		  var $modal = $(this);
		  var $modalBody = $modal.find('.modal-body');
		  
		  var numero = $button.data('numero');
		  var _numero = $button.data('numero-v');
		  
		  var ubicazione = $button.data('ubicazione');
		  var _ubicazione = $button.data('ubicazione-v');
		  
		  var tipo = $button.data('tipo');
		  var _tipo = $button.data('tipo-v');
		  
		  var pta = $button.data('pta');
		  var _pta = $button.data('pta-v');
		  var qta = $button.data('qta');
		  var _qta = $button.data('qta-v');
		  var idx = $button.data('idx');
		  var _pos = $button.data('pos');
		  
		  $modalBody.find('input.tipo').attr('name', tipo).val(_tipo);
		  
		  $modalBody.find('input.numero').attr('name', numero).val(_numero);
		  
		  $modalBody.find('input.ubicazione').attr('name', ubicazione).val(_ubicazione);
		  
		  $modalBody.find('input.pta').attr('name', pta).val(_pta);
		  $modalBody.find('input.qta').attr('name', qta).val(_qta);
		  
		  $modal.find('.modal-footer .btn-primary').on('click', {pos: _pos, btn: $button}, function (e) {
			  var $this = $(this);
			  var _endpoint = $this.data('endpoint');
			  var $caller = $(e.data.btn);
			  var action = "salvaModifiche281";
			  
			  var payload = {
				  "pos": e.data.pos,
				  "LGPLA": $modalBody.find('input.ubicazione').val(),
				  "LGTYP": $modalBody.find('input.tipo').val(),
				  "LGNUM": $modalBody.find('input.numero').val(),
				  
				  "CHARG": $modalBody.find('input.pta').val(),
				  "BDMNG": $modalBody.find('input.qta').val(),
				  "action": action
			  };
			  
			  $.ajax({
					type: 'POST',
					url: $('#host').val() + '/' +_endpoint,
					data: payload
				}).done(function(data) {
					$this.prev('button').click();
					var $selectedRow = $caller.closest('.list-group-item');
					$selectedRow.find('input[type="checkbox"]').prop('checked', 'checked');
					$selectedRow.find('span.pta').children('span').text($modalBody.find('input.pta').val());
					$selectedRow.find('span.qta').children('span').text($modalBody.find('input.qta').val());
					
					$caller.data('pta-v', $modalBody.find('input.pta').val());
					$caller.data('qta-v', $modalBody.find('input.qta').val());				
					$caller.data('tipo-v', $modalBody.find('input.tipo').val());
					$caller.data('numero-v', $modalBody.find('input.numero').val());
					$caller.data('ubicazione-v', $modalBody.find('input.ubicazione').val());

				}).fail(function(error) {
					console.error('ERRORE[Salvataggio movimentazione]', error);
					alert('Attezione! \nErrore durante l\'aggiornamento. Si prega di riprovare.');
					$this.prev('button').click();
				});
		  });
		  
		}).on('hidden.bs.modal', function (e) {
			var $modal = $(this);
			var $modalBody = $modal.find('.modal-body');
			$modalBody.find('input.pta').removeAttr('name').val('');
			$modalBody.find('input.qta').removeAttr('name').val('');
		});
	}

	/** Gestione di redirect tramite submit del form */
	$go.on('click', function() {
		$('input[type="text"]').each(function() {
		    $( this ).val($(this).val().toUpperCase());
		});
		goTo.call(this);
	});

	/** Gestione della selezione dei record in una lista */
	$listGroupItems.on('click', function() {
		var $this = $(this);
		var idx = $this.data('id');

		$this.toggleClass('active');
		
		if ($this.hasClass('active') && _selectedItems.indexOf(idx) === -1)
			_selectedItems.push(idx);
		else if (!$this.hasClass('active') && _selectedItems.indexOf(idx) !== -1)
			_selectedItems.pop(idx, 1);

		_selectedItems.length === 1 ? $dettaglioOrdine.removeAttr('disabled') : $dettaglioOrdine.attr('disabled', 'disabled');
		setEnabled.call(this);
	});

	/** Gestione del pulsante di reset per le liste */
	$clearActive.on('click', function() {
		var active = $body.find('.active');
		for (var a = 0, len = active.length; a < len; a++)
			$(active[a]).removeClass('active');
		$(this).blur();
	});

	/**
	 * Gestione della conferma sulla ricerca degli ordini di trasferimento
	 * di default vengono confermati tutti quelli presenti in lista dietro 
	 * una confirm per l'utente.
	 * Per entrare nel dettaglio bisogna selezionare SOLO un record.
	 */
	$confermaOrdine.on('click', function() {
		var $this = $(this);
		var _all = $body.find('.list-group-item.active').length <= 0;
		var confirmAll = confirm('Attenzione! \nSi vogliono confermare tutti gli ordini?');

		$('#tutti').val(_all);

		if (_all) {
			if (confirmAll)
				goTo.call(this);
		} else
			goTo.call(this);

		$this.blur();
	});

	/** Gestione dei campi numerici */
	$numeric.on('keypress', function(e) {
		return isNumeric(e);
    });

	/** 
	 * Rimozione del loader dopo un secondo dal caricamento della pagina
	 * per dar tempo agli elementi del DOM gestiti dinamicamente di 
	 * posizionarsi correttamente.
	 */
	window.setTimeout(function () {
		$loader.addClass('none');
	}, 1000);

	/** Rimozione dell'area di notifica */
	/*
	window.setTimeout(function () {
		$alert.addClass('none');
	}, 5000);
	*/
	
	$('#scanner').on('keydown',function(e){
		console.log('e', e);
		console.log('this', this);
	});
	
	$('input.scanSplit').on('keypress', function(e) {
		
		
		if (e.keyCode === 13) {
			
			e.preventDefault();
			e.stopPropagation();
			var $this = $(this);
			//alert($this.val());
			if ($this.hasClass('scanSplit')) {
				
				var _pattern = $this.data('pattern');
				var _next = $this.data('next');
				var _isValid = typeof _pattern !== 'undefined' && typeof _next !== 'undefined' && _pattern !== '' && _next !== '' && _pattern.indexOf('-') !== -1 && _next.indexOf('-') !== -1;
				
				if (_isValid) {
					var pattern = _pattern.split('-');
					var next = _next.split('-');
					var _val = $this.val();
					var p = 0;
					for (var i = 0; i < next.length; i++) {
						var _v = _val.substr(p, pattern[i]);
						p = p + (Number(pattern[i]));
						//console.log(next[i], _v)
						$('input[name="' + next[i] +'"]').focus();
						$('input[name="' + next[i] +'"]').val(_v);
					}
//					$('input[name="' + next[0] +'"]').focus();
//					$this.blur();
					$('.check').change();
				}
				
			}
		}
	});
	
	$('.check').on('change',function(e){
		e.preventDefault();
		e.stopPropagation();
		if(check()){
			$('button.goTo').attr('data-href', 'check');
			return $('button.goTo').click();
		}
	
	});
	
	$('.goToReset').on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();
		$('button.goTo').attr('data-href', 'reset');
		return $('button.goTo').click();
	})
	
	$("#reset").on('click', function(e) {
		e.preventDefault();
		e.stopPropagation();
		var self = this;
		
	$(".cleanOnReset").each(function() {
		    $( this ).val('');
		});
	});

});
