package it.cube.demo.sap.mobile.rfc.login;

import java.util.ArrayList;
import java.util.Set;

import com.sap.conn.jco.JCoTable;

import it.cube.demo.sap.mobile.bean.BottoniBean;
import it.cube.demo.sap.mobile.bean.DatiUtente;
import it.cube.demo.sap.mobile.bean.MatchCodeBean;
import it.cube.demo.sap.mobile.constants.Constants;
import it.cube.demo.sap.mobile.constants.ConstantsSap;
import it.cube.demo.sap.mobile.rfc.extend.RfcExtendT;

public class RfcLogIn extends RfcExtendT implements Constants, ConstantsSap{
	private String user=null,ip=null,password=null,type=null,ret=null;
	private DatiUtente datiutente= new DatiUtente();
	//private ArrayList<String> f_utente =new ArrayList<String>(0); //new boolean[FUNCTION_MENU];
	public RfcLogIn() throws Exception {
		super(ZWP_LOGON.Name);
	}
	
	public void execute(){
		try{
			function.getImportParameterList().setValue(ZWP_LOGON.I_USERID,user);
	        function.getImportParameterList().setValue(ZWP_LOGON.I_PIN,password);
	        function.getImportParameterList().setValue(ZWP_LOGON.I_IP,ip);
	        function.execute(destination);
			setEsitoAndMsg(ZWP_LOGON.RETURN);	
			if(isEsitoOK()){
				JCoTable azioni = function.getTableParameterList().getTable(ZWP_LOGON.TB_AZIONI_USER);
				JCoTable menu = function.getTableParameterList().getTable(ZWP_LOGON.TB_MENU);
				JCoTable matchcode = function.getTableParameterList().getTable(ZWP_LOGON.TB_MATCH_CODE);
    			//Table getsMenu = function.getTableParameterList().getTable("TB_ZWPWM_GEST_MENU");
    			//VIENE SETTATO L'ARRAY CHE CONTIENE I BOOLEAN PER LA VISUALIZZAZIONE DELLE FUNZIONALITA IN MENU
    			//F_"NOMEFUNZIONE" è UN INT CHE VERRA' USATO PER IL CONTROLLO NELLA PAGINA di menu
				azioni.setRow(0);
				datiutente.setNome(azioni.getString("NOMINATIVO"));
				datiutente.setUser(user);

				System.out.println(azioni.getNumColumns()-6);
				for(int j=0;j<azioni.getNumColumns()-6;j++){
					String but=""+(j+1);				
					if(j+1<10)
						but="0"+but;
					System.out.println(("BUT_"+but)+" "+azioni.getString("BUT_"+but));
					datiutente.getPermessi().add(j,azioni.getString("BUT_"+but));
				}
				
				if(menu!=null){
					
					for(int i=0;i<menu.getNumRows();i++){
						menu.setRow(i);
						String me=menu.getString("MENU");
						BottoniBean bb=new BottoniBean();
						bb.setMenu(me);
						bb.setSottomenu(menu.getString("SOTTOMENU"));
						bb.setDescmenu(menu.getString("DESCR_MENU"));
						bb.setDescsottomenu(menu.getString("DESCR_SOTTOMENU"));
						Set<String> sm= datiutente.getMenu().keySet();
						if(sm.contains(me)){						
//							if(datiutente.getMenu().get(me)!=null){
//							}else{			
//							}
							datiutente.getMenu().get(me).add(bb);
						}else{
							ArrayList<BottoniBean> bot= new ArrayList<BottoniBean>();
							bot.add(bb);
							datiutente.getMenu().put(me, bot);
						}
						
					}
				}
				if(matchcode!=null){
					for(int i=0;i<matchcode.getNumRows();i++){
						matchcode.setRow(i);
						MatchCodeBean mcb=new MatchCodeBean();
						mcb.setMenu(matchcode.getString("MENU"));
						mcb.setSottomenu(matchcode.getString("SOTTOMENU"));
						mcb.setCodice(matchcode.getString("COD_MATCHCODE"));
						mcb.setDescrizione(matchcode.getString("DESCR_MATCHCODE"));
					}
				}
//				if(getsMenu!=null){
//					for(int i=0;i<getsMenu.getNumRows();i++){
//						getsMenu.setRow(i);
//					}
//				}
				
				
				
			
         
			}
		}catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			disconnectClient();
		}
	}

	public DatiUtente getDatiutente() {
		return datiutente;
	}

	public void setDatiutente(DatiUtente datiutente) {
		this.datiutente = datiutente;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	
}
