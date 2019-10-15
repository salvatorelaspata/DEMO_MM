package it.cube.demo.sap.mobile.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatiUtente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8807108174059233324L;
	private String user="",nome="",ip="",IDSession="";
	private ArrayList<String> permessi=new ArrayList<String>(0);
	private Map<String, ArrayList<BottoniBean>> menu = new HashMap<String, ArrayList<BottoniBean>>(0);
	private ArrayList<MatchCodeBean> matchCode = new ArrayList<MatchCodeBean>(0);
	 

	
	
	
	public ArrayList<MatchCodeBean> getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(ArrayList<MatchCodeBean> matchCode) {
		this.matchCode = matchCode;
	}

	public Map<String, ArrayList<BottoniBean>> getMenu() {
		return menu;
	}

	public void setMenu(Map<String, ArrayList<BottoniBean>> menu) {
		this.menu = menu;
	}

	public ArrayList<String> getPermessi() {
		return permessi;
	}

	public void setPermessi(ArrayList<String> permessi) {
		this.permessi = permessi;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIDSession() {
		return IDSession;
	}

	public void setIDSession(String iDSession) {
		IDSession = iDSession;
	}
	
}
