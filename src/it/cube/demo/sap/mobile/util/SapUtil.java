package it.cube.demo.sap.mobile.util;

import java.io.File;

import java.io.FileOutputStream;
import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.DestinationDataProvider;




//import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class SapUtil {
	static String DESTINATION_NAME = "proprieta";
	
	
	//-----------------------------INIZIO MIA FUNZIONE-------------------------------------------
	public static JCoDestination connect() throws Exception{
		JCoDestination destination;
		try{
			destination= JCoDestinationManager.getDestination(DESTINATION_NAME);
			if(destination!=null){
				
				if(checkConfig(destination)){
					return destination;
				}else{
					inizialize();
					destination = JCoDestinationManager.getDestination(DESTINATION_NAME);
					return destination;
				}
			}else{
				inizialize();
				destination = JCoDestinationManager.getDestination(DESTINATION_NAME);
			}
		}catch(Exception e){
			inizialize();
			destination = JCoDestinationManager.getDestination(DESTINATION_NAME);
		}
		
	     return destination;
	}	
	//------------------------------FINE MIA FUNZIONE---------------------------------------------
		
		
	public static void inizialize() throws Exception{
		Properties connectProperties = new Properties();
		String sapdestination=null,user=null,passwd=null,ashost=null,sysnr=null;
		ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("it.cube.demo.sap.mobile.properties.proprieta");
//			 ashost="192.168.24.243";
//			 sysnr="00";
////			 server="D40";
//			 user="SIMMET01";
//			 passwd="colle11!";
//			 sapdestination="055";
		 
		 sapdestination=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_CLIENT);
		 user=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_USER);
		 passwd=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_PASSWD);
		 ashost=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_ASHOST);
		 sysnr=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_SYSNR);
//			 
	    connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST,ashost);
	    connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  sysnr);
	    connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, sapdestination);
	    connectProperties.setProperty(DestinationDataProvider.JCO_USER,   user);
	    connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, passwd);  
	    
		createDestinationDataFile(DESTINATION_NAME, connectProperties);

	}
	static void createDestinationDataFile(String destinationName, Properties connectProperties) throws Exception    {
        
		File destCfg = new File(destinationName+".jcoDestination");
        try
        {
            FileOutputStream fos = new FileOutputStream(destCfg, false);
            connectProperties.store(fos, "SapSimmelConnection");
            fos.close();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Unable to create the destination files", e);
        }
    }

	public static boolean checkConfig(JCoDestination destination){
//		boolean same=true;
		String client=null,user=null,ashost=null,sysnr=null;
		String jco_client,jco_user,jco_ashost,jco_sysnr;
		
		ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("it.cube.demo.sap.mobile.properties.proprieta");
		 
		client=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_CLIENT);
		user=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_USER);
		ashost=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_ASHOST);
		sysnr=RESOURCE_BUNDLE.getString(DestinationDataProvider.JCO_SYSNR);
		 
		jco_client=destination.getClient();
		jco_user=destination.getUser();
		jco_ashost=destination.getApplicationServerHost();
		jco_sysnr=destination.getSystemNumber();
		
		return client.equals(jco_client) && user.equals(jco_user) && ashost.equals(jco_ashost) && sysnr.equals(jco_sysnr);

	}
	
	
	public static JCoRepository getRepository(JCoDestination destination) throws JCoException {
//		JCoRepository repository = null;
		JCoRepository repository = destination.getRepository();
		return repository;
	}

//	public static void disconnect(JCO.destination destination) {
//		if (destination != null && destination.isAlive())
//			destination.disconnect();
//	}

	public static JCoFunction createFunction(JCoRepository repository, String name)
        throws Exception
    {
		try{
		JCoFunctionTemplate  ft = repository.getFunctionTemplate(name.toUpperCase());
        if(ft == null)
            return null;
        return ft.getFunction();
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception((new StringBuilder()).append("Problem retrieving JCO.Function object: ").append(e.getMessage()).toString());	
		}
        
    }

	public static void main(String args[]) {
		JCoDestination destination;
		try {
//					 connect(sapdestination, user, passwd, ashost, sysnr)
			destination = connect();
			destination.ping();
			
//			com.sap.mw.jco.JCO.Repository repository = getRepository(destination);
//			com.sap.mw.jco.JCO.Function function = createFunction(repository, "RFC_GET_TABLE_ENTRIES");
//			function.execute(destination);
//			com.sap.mw.jco.JCO.Table codes = function.getTableParameterList().getTable("ENTRIES");
//			for (int i = 0; i < codes.getNumRows(); i++) {
//				codes.setRow(i);
			
			System.out.println("finito");
//			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}

	}

}
