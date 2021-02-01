/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazin;

/**
 *
 * @author Adrian
 */
//public class Client {
//    
//}
import java.util.*;

public class Client {
	int cID; 	//id client
	int nrCasa; //nr casei unde e asignat
	int durata; //durata servire
        int tsosire; //timpul de intrare
	int tasteptare; //timp asteptare
	
	public Client(int cID, int nrCasa, int tsosire, int tasteptare, int durata){
		this.cID = cID;
		this.nrCasa = nrCasa;
		this.tsosire = tsosire;
		this.tasteptare = tasteptare;
		this.durata = durata;
	}
	
	public int getCID(){
		return this.cID;
	}
	public int getNrCasa(){
		return this.nrCasa;
	}
	public int getTsosire(){
		return this.tsosire;
	}
	int getDurataServire(){
		return this.durata;
	}
	public int getTastept(){
		return this.tasteptare;
	}
}