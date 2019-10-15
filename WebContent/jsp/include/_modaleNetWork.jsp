<div class="modal fade" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Modifica</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="form-group col-md-12 col-sm-12 col-xs-12">
						<label>Partita</label>
    					<input type="text" class="form-control input-lg pta" placeholder="Partita" value="" required/>
					</div>
					<div class="form-group col-md-12 col-sm-12 col-xs-12">
						<label>Quantit&agrave;</label>
    					<input type="text" class="form-control input-lg qta" placeholder="Quantit&agrave;" value="" required/>
					</div>
					
					<input type="hidden" class="form-control input-lg area" id="area" name="area" value=""/>
					
					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label>Tipo Magazzino</label>
    					<input type="text" class="form-control input-lg tipo" id="tipo" name="tipo" placeholder="Tipo" value="" maxlength="3" required/>
					</div>
					<div class="form-group col-md-6 col-sm-6 col-xs-6">
						<label>N Magazzino</label>
    					<input type="text" class="form-control input-lg numero" id="numero" name="numero" placeholder="Numero" value="" maxlength="3" required/>
					</div>
					<div class="form-group col-md-12 col-sm-12 col-xs-12">
						<label>Ubicazione</label>
    					<input type="text" class="form-control input-lg ubicazione scanSplit" id="ubicazione" name="ubicazione" data-pattern="3-3-3-10" data-next="<%="numero" %>-<%="area" %>-<%="tipo" %>-<%="ubicazione"%>" placeholder="Ubicazione" value="" required/>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-lg btn-outline-secondary btn-block" data-dismiss="modal" >Chiudi</button>
				<button type="button" class="btn btn-lg btn-primary btn-block" data-endpoint="Ajax">Salva</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->