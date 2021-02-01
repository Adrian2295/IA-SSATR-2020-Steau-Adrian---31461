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
import java.util.Random;


public class Magazin extends Thread{
	private static Casa[] casele;
	private static int nrCasa; //nr de case DESCHISEEEE
	private static int durata; //timp de servire client

    /**
     *
     * @return
     */
   
	
	private int tastept;
	private int tmaxim;
	private int tvarf;
	private int tsosire;
	private int tmediu;  //de asteptare la o casa
	private static int timp;	//timpul real
	private String hms;    //ora - minut -secunda ptr afisare in format
	private int minIndex;
	private int min;       //nr minim de clienti la case
	private int minClient;  //astea 2 ptr det indicelui casei cu nr min de clienti
	private int[] asteptari;
	private int [] client = new int[10];
	private int [] ora = new int[10];
    private int [] ora1 = new int[10];
    private int [] ora2 = new int[10];
    private int n = 0;
	private static final int maxClientiCasa = 2;
	//constructorul Magazin
	public Magazin(){
		
		casele = new Casa[Interfata.getNrCase()+1];
		asteptari = new int[Interfata.getNrCase()+1];
		
		for(int i=1;i<=Interfata.getNrCase();i++)
			asteptari[i]=0;
		
		nrCasa = 1;
		casele[1] = new Casa(1);
		casele[1].start();
	}
	public static void stopCase(){
		for(int i=1;i<=nrCasa;i++)
			casele[i].stop();
	}
	
	
	
	// functii getter
	public static int getNrCasa(){
		return nrCasa;
	}
	public static int getDurata(){
		return durata;
	}
	public static Casa[] getCasa(){
		return casele;
	}
	public static int getTimp(){
		return timp;
	}
	
	
	// functii
	//converteste timpul t in timp de afisare format hh/mm/ss
	public int generateTime (int n)
	{
		Random generator = new Random();
		int time = generator.nextInt(n*60) + 1;
		return time;
	}
	
	public static String convertTime(int t){
		return (t/3600) + ":" + (t-(t/3600)*3600)/60 + ":" + (t-(t/60)*60);
	}
	
	public int calcMinIndex(){
		int index = 1;
		try{
			int lungime = casele[1].getLungimeCoada();
			for(int i=1;i<=nrCasa;i++)
			{
				lungime = casele[i].getLungimeCoada();
				if(casele[i].getLungimeCoada()<lungime){
					lungime = casele[i].getLungimeCoada();
					index = i;
				}
			}
			min = lungime;
		}
		catch(InterruptedException ex){
			System.out.println(ex.toString());
		}
		return index;
	}
	
	public void run(){
			
		try{
			int i = 1;
			int timpfinal = Interfata.getTimp();
			timp = 0;
			
			while(timp<timpfinal*3600){
				tsosire = generateTime(Interfata.getIntMax()-Interfata.getIntMin()) + Interfata.getIntMin()*60;
				durata = generateTime(Interfata.getServMax()-Interfata.getServMin()) + Interfata.getServMin()*60;
				minIndex = calcMinIndex();
				
				addCasaNoua();
				asteptari[minIndex] = asteptari[minIndex] + durata;
				tmediu = tmediu + durata;
				Client c = new Client (i, minIndex, tsosire, asteptari[minIndex], durata);
				afisTimp();
				timp = timp + tsosire;
				casele[minIndex].addClient(c);
				i++;
				sleep(tsosire*30);
				
				if (ora[minIndex]==0){
                    ora[minIndex]=timp;
                    n++;
                }
				
				client[minIndex]++;
				ora1[minIndex]=ora1[minIndex]+asteptari[minIndex];
                ora2[minIndex]=ora2[minIndex]+tsosire;
			}
			
			
			////////////////generare statistici ale simularii
			tmediu = tmediu / nrCasa; if(tmediu<0) tmediu = -tmediu;
			Interfata.addRaport("===================================\n===================================\nTimpul mediu de asteptare la cate o casa este de: " + tmediu);
			for(int j = 1;j<=n;j++){
				Interfata.addRaport("Casa " + j + " s-a deschis la ora " + convertTime(ora[j]) + ", " + client[j] + " clienti.");
				Interfata.addAstept("Casa " + j + " a servit " + convertTime(ora2[j]) + " si a asteptat " + convertTime(ora1[j]));
			}
			Interfata.addRaport("Ora de varf a fost la ora " + convertTime(tvarf) + "cu timoul total de asteptare de " + convertTime(tmaxim));
			
		}
		catch (InterruptedException ex)
		{
			System.out.println (ex.toString()); //in caz de eroare aceasta se tipareste
		}
	}
	public void afisFinal(){
		tmediu = tmediu / nrCasa; if(tmediu<0) tmediu = -tmediu;
		Interfata.addRaport("===================================\n===================================\nTimpul mediu de asteptare la cate o casa este de: " + tmediu);
		for(int j = 1;j<=n;j++){
			Interfata.addRaport("Casa " + j + " s-a deschis la ora " + convertTime(ora[j]) + ", si a servit " + client[j] + " clienti.");
			Interfata.addRaport("Casa " + j + " a servit " + convertTime(ora2[j]) + " si a asteptat " + convertTime(ora1[j]));	
		}
		Interfata.addRaport("Ora de varf a fost la ora " + convertTime(tvarf) + "cu timoul total de asteptare de " + convertTime(tmaxim));
	}
	public void afisTimp(){
		int timpp = 0;
		for(int j=1;j<=nrCasa;j++){
			timpp = timpp + casele[j].getTimpAstept();
		}
		if(tmaxim<timpp){
			tmaxim = timpp;
			tvarf = timp;
		}
		
		Interfata.addAstept(Magazin.convertTime(timpp));
	}
	
	public void afisRapoarte(){
		
	}
	
	public void addCasaNoua(){
		try{
			if(casele[calcMinIndex()].getLungimeCoada() == maxClientiCasa && nrCasa<Interfata.getNrCase()){
				nrCasa++;
				minIndex = nrCasa;
				Interfata.addRaport("Case pline (>=2 clienti), deschidem casa noua");
				casele[minIndex] = new Casa(minIndex);
				casele[minIndex].start();
			}
		}
		catch (InterruptedException e){
			System.out.println("eroare");
		}
	}	
}