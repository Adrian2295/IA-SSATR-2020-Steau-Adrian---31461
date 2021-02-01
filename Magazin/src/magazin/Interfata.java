/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;




public class Interfata extends JFrame {
	
	private static int intmin,intmax,servmin,servmax,nrcase,timp;
	private static Magazin magazin;


	private JLabel labelcasa1;
	private JLabel labelcasa2;
	private JLabel labelcasa3;
	private JLabel labelcasa4;
	private JLabel labelcasa5;
	private JLabel labelcasa6;
	private JLabel labelcasa7;
	private JLabel labelcasa8;
	private JLabel labelcasa9;
	private JLabel labelcasa10;
	private JLabel intervalintrare;
	private JLabel intervalservire;
	private JLabel labelnumarcase;
	private JLabel labeltimp;
	private JLabel labelminus1;
	private JLabel labelminus2;
	private JLabel labelraport;


	private static JTextField textastept;
	private static JTextField textcasa1;
	private static JTextField textcasa2;
	private static JTextField textcasa3;
	private static JTextField textcasa4;
	private static JTextField textcasa5;
	private static JTextField textcasa6;
	private static JTextField textcasa7;
	private static JTextField textcasa8;
	private static JTextField textcasa9;
	private static JTextField textcasa10;
	private JTextField textintmin;
	private JTextField textintmax;
	private JTextField textservmin;
	private JTextField textservmax;
	private JTextField textnumarcase;
	private JTextField texttimp;
	private static JTextArea textraport;
	private JButton buttonstart;
	private JButton buttonstop;
	private JPanel panel = new JPanel();

	
	public Interfata() {
		super();
		
		this.setTitle("Simulare Magazin");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setResizable(false);
		this.setupComp();
		
		
		
		this.setLocation(300,100);
        this.setVisible(true);
        this.setSize(820,570);
        
	}
	private void setupComp(){

		labelraport = new JLabel("Rapoarte:");
		labelminus1 = new JLabel("-");
		labelminus2 = new JLabel("-");
		labelcasa1 = new JLabel("Casa 1");
		labelcasa2 = new JLabel("Casa 2");
		labelcasa3 = new JLabel("Casa 3");
		labelcasa4 = new JLabel("Casa 4");
		labelcasa5 = new JLabel("Casa 5");
		labelcasa6 = new JLabel("Casa 6");
		labelcasa7 = new JLabel("Casa 7");
		labelcasa8 = new JLabel("Casa 8");
		labelcasa9 = new JLabel("Casa 9");
		labelcasa10 = new JLabel("Casa 10");
		intervalintrare = new JLabel("Intervalul dintre \nsosirea clientilor:");
		intervalservire = new JLabel("Intervalul duratei servirii clientilor:");
		labelnumarcase = new JLabel("Numarul de case functionale:");
		labeltimp = new JLabel("Timp de simulare:");	
		textastept = new JTextField();
		textcasa1 = new JTextField();
		textcasa2 = new JTextField();
		textcasa3 = new JTextField();
		textcasa4 = new JTextField();
		textcasa5 = new JTextField();
		textcasa6 = new JTextField();
		textcasa7 = new JTextField();
		textcasa8 = new JTextField();
		textcasa9 = new JTextField();
		textcasa10 = new JTextField();
		textintmin = new JTextField("1");
		textintmax = new JTextField("2");
		textservmin = new JTextField("3");
		textservmax = new JTextField("4");
		textnumarcase = new JTextField("3");
		texttimp = new JTextField("6");
		buttonstart = new JButton("START");
		buttonstop = new JButton("STOP");
		textraport = new JTextArea("");
		textraport.setEditable (false);
		textraport.setLineWrap(true);
		textraport.requestFocus ();
		buttonstart.addActionListener(new StartButtonListener());
		buttonstop.addActionListener(new StopButtonListener());

		labelraport.setBounds(570,50,80,20);
		labelminus1.setBounds(305,350,5,20);
		labelminus2.setBounds(305,380,5,20);
		labelcasa1.setBounds(50,50,100,20);
		labelcasa2.setBounds(50,80,100,20);
		labelcasa3.setBounds(50,110,100,20);
		labelcasa4.setBounds(50,140,100,20);
		labelcasa5.setBounds(50,170,100,20);
		labelcasa6.setBounds(50,200,100,20);
		labelcasa7.setBounds(50,230,100,20);
		labelcasa8.setBounds(50,260,100,20);
		labelcasa9.setBounds(50,290,100,20);
		labelcasa10.setBounds(50,320,100,20);
		intervalintrare.setBounds(50,350,200,20);
		intervalservire.setBounds(50,380,200,20);
		labelnumarcase.setBounds(50,410,200,20);
		labeltimp.setBounds(50,440,130,20);
		textastept.setBounds(250,485,50,20);
		textcasa1.setBounds(100,50,260,20);
		textcasa2.setBounds(100,80,260,20);
		textcasa3.setBounds(100,110,260,20);
		textcasa4.setBounds(100,140,260,20);
		textcasa5.setBounds(100,170,260,20);
		textcasa6.setBounds(100,200,260,20);
		textcasa7.setBounds(100,230,260,20);
		textcasa8.setBounds(100,260,260,20);
		textcasa9.setBounds(100,290,260,20);
		textcasa10.setBounds(100,320,260,20);
		textintmin.setBounds(250,350,50,20);
		textintmax.setBounds(315,350,45,20);
		textservmin.setBounds(250,380,50,20);
		textservmax.setBounds(315,380,45,20);
		textnumarcase.setBounds(250,410,50,20);
		texttimp.setBounds(250,440,50,20);
		//textraport.setBounds(400,80,380,400);
		buttonstart.setBounds(50,480,80,30);
		buttonstop.setBounds(150,480,80,30);
		
		this.add(labelraport);
		this.add(labelminus1);
		this.add(labelminus2);
		this.add(labelcasa1);
		this.add(labelcasa2);
		this.add(labelcasa3);
		this.add(labelcasa4);
		this.add(labelcasa5);
		this.add(labelcasa6);
		this.add(labelcasa7);
		this.add(labelcasa8);
		this.add(labelcasa9);
		this.add(labelcasa10);
		this.add(intervalintrare);
		this.add(intervalservire);
		this.add(labelnumarcase);
		this.add(labeltimp);
		this.add(textastept);
		this.add(textcasa1);
		this.add(textcasa2);
		this.add(textcasa3);
		this.add(textcasa4);
		this.add(textcasa5);
		this.add(textcasa6);
		this.add(textcasa7);
		this.add(textcasa8);
		this.add(textcasa9);
		this.add(textcasa10);
		this.add(textintmin);
		this.add(textintmax);
		this.add(textservmin);
		this.add(textservmax);
		this.add(textnumarcase);
		this.add(texttimp);
		this.add(textraport);
		this.add(buttonstart);
		this.add(buttonstop);
		
		panel.setLayout(new GridLayout(1,1));
		panel.add(textraport);
		JScrollPane jsp = new JScrollPane(panel,ScrollPaneConstants. VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(400,80,380,430);
		this. add(jsp);
	}
	
	public static void addAstept(String S){
		textastept.setText(S);
	}
	public static void addRaport(String S){
		textraport.append(S+ "\n");
	}
	public static void afisareSimulare(int nr,int size){
		String s = "";
		for(int i=0;i<size;i++) s = s + "(CLIENT)  ";
		
		switch(nr){
		case 1:
			textcasa1.setText(s);
			break;
		case 2:
			textcasa2.setText(s);
			break;
		case 3:
			textcasa3.setText(s);
			break;
		case 4:
			textcasa4.setText(s);
			break;
		case 5:
			textcasa5.setText(s);
			break;
		case 6:
			textcasa6.setText(s);
			break;
		case 7:
			textcasa7.setText(s);
			break;
		case 8:
			textcasa8.setText(s);
			break;
		case 9:
			textcasa9.setText(s);
			break;
		case 10:	
			textcasa10.setText(s);
			break;
		default: break;
		}
	}
	
	//citirile datelor de intrare
	static int getIntMin(){
		return intmin;
	}
	
	static int getIntMax(){
		return intmax;
	}
	
	static int getServMin(){
		return servmin;
	}
	
	static int getServMax(){
		return servmax;
	}
	
	static int getNrCase(){
		return nrcase;
	}
	
	static int getTimp(){
		return timp;
	}
	

	class StartButtonListener implements ActionListener{
                @Override
		public void actionPerformed (ActionEvent e){
			
			intmin = Integer.parseInt(textintmin.getText());
			intmax = Integer.parseInt(textintmax.getText());
			servmin = Integer.parseInt(textservmin.getText());
			servmax = Integer.parseInt(textservmax.getText());
			nrcase = Integer.parseInt(textnumarcase.getText());
			timp = Integer.parseInt(texttimp.getText());
			magazin = new  Magazin();
			magazin.start();
			
		}
	}
	class StopButtonListener implements ActionListener{
                @Override
		public void actionPerformed (ActionEvent e){
			magazin.stop();
			magazin.afisFinal();
			Magazin.stopCase();
		}
	}
	public static void main(String args[]){
		Interfata interf = new Interfata();
	}

}
