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
public class RfcExtendT implements ConstantsSap{
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
	public RfcExtendT(String sapFunction) throws Exception{
		try{
		destination = SapUtil.connect();
		}catch(Exception e){
			throw new Exception("Errore durante la connessione al sistema SAP");	
		}
		repository = SapUtil.getRepository(destination);		
		function = SapUtil.createFunction(repository, sapFunction);
		function = repository.getFunctionTemplate(sapFunction).getFunction();

	}
	protected void disconnectClient(){
//		if (client != null && client.isAlive())
//			client.disconnect();
//		
	}
	protected void setEsitoAndMsg(String returnname){
		returnTable = function.getTableParameterList().getTable(returnname);
		if (returnTable != null && returnTable.getNumRows() > 0 ) {
    	   returnTable.setRow(0);
    	   esito=returnTable.getString(SapRfc.Esito);
    	   msg= returnTable.getString(SapRfc.Msg);
		}else{
			esito=SapRfc.Error;
			msg= SapRfc.ConnectionProblem;
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
	
	public JCoDestination getDestination() {
		return destination;
	}
	public void setDestination(JCoDestination destination) {
		this.destination = destination;
	}
	protected JCoTable getReturnTable() {
		return returnTable;
	}
	protected void setReturnTable(JCoTable returnTable) {
		this.returnTable = returnTable;
	}
	protected JCoRepository getRepository() {
		return repository;
	}
	protected void setRepository(JCoRepository repository) {
		this.repository = repository;
	}
	protected JCoFunction getFunction() {
		return function;
	}
	protected void setFunction(JCoFunction function) {
		this.function = function;
	}

}
