package it.cube.demo.sap.mobile.rfc.extend;


import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.util.SapUtil;

/**
 * 
 * @author cube2.
 * Attributi: esito,msg,client,returnTable,repository,function.
 * 
 * Metodi: set,get,disconnectClient,setEsitoAndMsg e isEsitoOK.
 *
 */
public class RfcExtend implements ConstantsSap{
	protected String esito=null;
	protected String msg=null;
	protected JCoDestination destination = null;
	protected JCoTable returnTable = null;
	protected JCoRepository repository=null;
	protected JCoFunction function=null;
	/**
	 * Costruttore che valorizza client,repository e function.
	 * @param sapFunction , nome della funzione sap
	 * @throws Exception
	 */
	public RfcExtend(){};
	public RfcExtend(String sapFunction) throws Exception{
		destination = SapUtil.connect();
		repository = SapUtil.getRepository(destination);		
		function = SapUtil.createFunction(repository, sapFunction);
		
	}
	/**
	 * inizializza la classe rfc
	 * @param sapFunction, il nome della funzione sap da richiamare
	 * @throws Exception
	 */
	public void inizialize(String sapFunction){
		try{
			destination = SapUtil.connect();
			repository = SapUtil.getRepository(destination);		
			function = SapUtil.createFunction(repository, sapFunction);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	protected void disconnectClient(){
//		if (destination != null && destination.isAlive())
//			destination.disconnect();
	}
	protected void setEsitoAndMsg(String returnname){
		try{
			returnTable = function.getExportParameterList().getTable(returnname);
			if (returnTable != null && returnTable.getNumRows() >= 0 ) {
	    	   returnTable.setRow(0);
	    	   esito=returnTable.getString(SapRfc.Esito);
	    	   msg= returnTable.getString(SapRfc.Msg);
			}else{
				esito=SapRfc.Error;
				msg= SapRfc.ConnectionProblem;
			}
		}catch(Exception e){
			e.printStackTrace();
			esito=SapRfc.Error;
			msg=e.getLocalizedMessage();
		}
	}
	
	public boolean isEsitoOK(){
		return SapRfc.Success.equals(esito);
	}
	public String getEsito() {
		return esito;
	}
	public void setEsito(String esito) {
		this.esito = esito;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isEsitoInfo(){
		return esito.equals(SapRfc.Info);
	}
	
	public boolean isEsitoWarning(){
		return esito.equals(SapRfc.Warning);
	}
	
	public JCoDestination getDestination() {
		return destination;
	}
	public void setDestination(JCoDestination destination) {
		this.destination = destination;
	}
	public JCoTable getReturnTable() {
		return returnTable;
	}
	public void setReturnTable(JCoTable returnTable) {
		this.returnTable = returnTable;
	}
	public JCoRepository getRepository() {
		return repository;
	}
	public void setRepository(JCoRepository repository) {
		this.repository = repository;
	}
	public JCoFunction getFunction() {
		return function;
	}
	public void setFunction(JCoFunction function) {
		this.function = function;
	}
	
}
