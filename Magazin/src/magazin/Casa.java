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

import java.util.*;

public class Casa extends Thread {
	private static Vector<Client> clienti;
	private int id;
	
	public Casa(int id){							//constructorul
		this.clienti = new Vector <Client> ();
		this.id = id;
	}
	
	public void run (){
		try{
			while (true){
				sleep(30*Magazin.getDurata());
				stergeClient();
				sleep(20);
			}
		}
		catch (InterruptedException ex){
			System.out.println ("eroare");
		}
	}
	
											//metodele pe clasa "Casa"
	public Vector <Client> getCasa(){
		return this.clienti;
	}
	public int getTimpAstept(){
		int ttimp = 0;
		for(Client c : clienti){
			ttimp = ttimp + c.getDurataServire();
			}
		return ttimp;
	}

	public synchronized void addClient (Client c) throws InterruptedException{
		System.out.println(this.getTimpAstept());
		clienti.add(c);
		
		Interfata.afisareSimulare(id,clienti.size());
		Interfata.addRaport("Am adaugat un client la ora " + Magazin.convertTime(Magazin.getTimp()) + " la casa " + this.id );
		System.out.println("am adaugat");
		notifyAll();
	}
	
	public synchronized void stergeClient () throws InterruptedException{
		while (clienti.size() ==0)
            wait ();
		
		
		Client c = clienti.elementAt(0);
		clienti.removeElementAt(0);
		Interfata.afisareSimulare(id,clienti.size());
		Interfata.addRaport("Un client a fost servit la ora " + Magazin.convertTime(Magazin.getTimp()) + " la casa " + this.id );

		System.out.println("am sters");
		notifyAll();
	}
	
	public synchronized int getLungimeCoada () throws InterruptedException{
		
		notifyAll();
		return this.clienti.size();
	}	
	
	

}



	
