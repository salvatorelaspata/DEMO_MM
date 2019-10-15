package it.cube.demo.sap.mobile.rfc;

import java.util.HashMap;
import java.util.Map;



import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtend;

public class RfcSelectTpMag extends RfcExtend implements ConstantsSap{

	private Map<String, String> tableScelta= new HashMap<String, String>(); 
	public RfcSelectTpMag() throws Exception {
		super("ZWPWM_DESCR_TIPO_MAG");
	}
	
	public void execute(){
		try{
			function.execute(destination);
			JCoTable tb=function.getTableParameterList().getTable("DESCR_TIPO_MAG");
			for(int i = 0;i < tb.getNumRows();i++){
				tb.setRow(i);
				tableScelta.put(tb.getString("LGTYP"),tb.getString("LTYPT"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			disconnectClient();
		}
		
	}

	public Map<String, String> getTableScelta() {
		return tableScelta;
	}

	public void setTableScelta( Map<String, String> tableScelta) {
		this.tableScelta = tableScelta;
	}


}
