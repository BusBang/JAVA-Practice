package kh.java.run;

import java.util.Scanner;

import kh.java.client.Client;
import kh.java.server.Server;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print(" > ");
		if(sc.nextInt()==1) {
			new Client().main();
		}else {
			
			new Server().main();
		}
		
	}

}
