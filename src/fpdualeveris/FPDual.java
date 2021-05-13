package fpdualeveris;

import java.util.Scanner;

import operators.Pinball;

public class FPDual {
	public static void main(String[] args) {
		operatorsChallenge();		
	}
	
	private static void operatorsChallenge() {
		/*
		 *  Se incializa la clase Pinball con el objeto pb y se le da un pequeño menú al usuario para que pueda introducir su nombre y
		 *  se pueda elegir la dificultad 
		 */
		Pinball pb = new Pinball();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce tu nombre: ");
		String name = sc.nextLine();
		System.out.println("Introduce un numero para seleccionar la dificultad del juego:");
		System.out.println("1 - Fácil");
		System.out.println("2 - Medio");
		System.out.println("3 - Difícil");		
		int difficulty = sc.nextInt();
		pb.launchBall(name, difficulty);
		sc.close();
	}
}
