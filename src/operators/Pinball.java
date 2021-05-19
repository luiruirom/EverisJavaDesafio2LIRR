package operators;

public class Pinball {
	private final int BUMPER = 30;
	private final int IN_LANE = 50;
	private final int SPINNER = 100;
	private final int JACKPOT = 500;
	private final int SUPER_JACKPOT = 1000;
	private final int LOW_POINTS = 5;
	private final int MEDIUM_POINTS = 10;
	private final int HIGH_POINTS = 15;
	private final int GAME_OVER = -1;
	private boolean playing = false;
	private int score = 0;
	private int[] possiblePoints = new int[9];

	// Se a�ade una variable bounces para que no haya posibilidad de perder sin conseguir puntos
	int bounces = 0;

	public void launchBall(String playerName, int difficulty) {
		// Se comprueba que en la variable playerName entra un objeto de tipo String
		if (playerName instanceof String) {
			// Se selecciona la dificultad, cuanto m�s bajo el n�mero, m�s f�cil el juego y menos "GAME_OVER" hay

			switch (difficulty) {
			/*
			 * La l�gica del programa en los tres casos es igual: 1. Se rellena el array de posibilidades seg�n la dificultad elegida 2. Se establecen las
			 * variables de juego a su estado inicial: playing true (representa si se est� jugando actualmente) score 0 (representa la puntuaci�n) bounces 0
			 * (representa los rebotes que lleva en la partida) 3. Se llama al m�todo startPlaying(): La pelota se pone en juego y se elige una posici�n
			 * aleatoria del array hasta que la posici�n sea GAME OVER
			 * 
			 * INFO ADICIONAL: Si la pelota cae en GAME OVER en la primera tirada, se le suma un punto de consolaci�n y se sigue jugando. Si se consiguen m�s de
			 * 1000 puntos en un juego, se te felicita
			 */
			case (1):
				possiblePoints[0] = BUMPER;
				possiblePoints[1] = IN_LANE;
				possiblePoints[2] = SPINNER;
				possiblePoints[3] = JACKPOT;
				possiblePoints[4] = SUPER_JACKPOT;
				possiblePoints[5] = LOW_POINTS;
				possiblePoints[6] = MEDIUM_POINTS;
				possiblePoints[7] = HIGH_POINTS;
				possiblePoints[8] = GAME_OVER;
				this.playing = true;
				this.score = 0;
				this.bounces = 0;

				startPlaying(playerName);

				break;

			case (2):
				possiblePoints[0] = BUMPER;
				possiblePoints[1] = IN_LANE;
				possiblePoints[2] = SPINNER;
				possiblePoints[3] = GAME_OVER;
				possiblePoints[4] = SUPER_JACKPOT;
				possiblePoints[5] = LOW_POINTS;
				possiblePoints[6] = MEDIUM_POINTS;
				possiblePoints[7] = HIGH_POINTS;
				possiblePoints[8] = GAME_OVER;
				this.playing = true;
				this.score = 0;
				this.bounces = 0;

				startPlaying(playerName);

				break;

			case (3):
				possiblePoints[0] = BUMPER;
				possiblePoints[1] = IN_LANE;
				possiblePoints[2] = GAME_OVER;
				possiblePoints[3] = JACKPOT;
				possiblePoints[4] = GAME_OVER;
				possiblePoints[5] = LOW_POINTS;
				possiblePoints[6] = GAME_OVER;
				possiblePoints[7] = HIGH_POINTS;
				possiblePoints[8] = GAME_OVER;
				this.playing = true;
				this.score = 0;
				this.bounces = 0;

				startPlaying(playerName);

				break;

			default:
				System.out.println("El n�mero introducido no corresponde a ninguna dificultad.");
				break;
			}
		}
	}

	private void startPlaying(String playerName) {
		// Creamos tres objetos StringBuilder para los mensajes de la aplicaci�n
		StringBuilder strGameOver = new StringBuilder();
		StringBuilder strCurrentPoints = new StringBuilder();
		StringBuilder strLivesLeft = new StringBuilder();
		
		// Se crea un bucle for para representar que hay 3 vidas para jugar
		for (int i = 1; i < 4; i++) {
			// Se obtienen las vidas que quedan aprovechando la variable i del for
			int lives = 3 - i;
			while (playing == true) {
				int nextMove = (int) (Math.random() * 10 - 1);
				// L�gica para cuando acaba la partida, en la que se dan los mensajes al jugador
				if (possiblePoints[nextMove] < 0 && bounces != 0) {
					// Construcci�n del mensaje de puntuaci�n 
					strGameOver.append("La puntuaci�n final de ");
					strGameOver.append(playerName);
					strGameOver.append(" fue: ");
					strGameOver.append(score);
					strGameOver.append(" puntos");
					strGameOver.setLength(0);
					System.out.println(strGameOver);
					// Si se consiguen m�s de 1000 puntos, el programa te felicita 
					String mensajeFinal = (score > 1000) ? "�Enhorabuena! �Has conseguido m�s de 1000 puntos!" : "M�s suerte la pr�xima vez...";
					System.out.println(mensajeFinal);
					System.out.println();
					playing = false;
					// Construcci�n del mensaje de las vidas restantes
					strLivesLeft.append("Te quedan ");
					strLivesLeft.append(lives);
					strLivesLeft.append(" vidas.\n");
					System.out.println(strLivesLeft);
					strLivesLeft.setLength(0);
				} else {
					// Primero se comprueba que la primera vez que la pelota cae, no sea en game over
					if (bounces == 0 && possiblePoints[nextMove] == -1) {
						bounces++;
						this.score += 1;
						System.out.println("La puntuaci�n actual es de 1 punto de consolaci�n.");
						// A partir de aqu� la pelota puede caer en cualquier posici�n del pinball
					} else {
						bounces++;
						this.score += possiblePoints[nextMove];
						strCurrentPoints.append("La puntuacion actual es de: ");
						strCurrentPoints.append(score);
						strCurrentPoints.append(" puntos.");
						System.out.println(strCurrentPoints);
						strCurrentPoints.setLength(0);
					}
				}
			}
			this.playing = true;
		}
	}
}
