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

	// Se añade una variable bounces para que no haya posibilidad de perder sin conseguir puntos
	int bounces = 0;

	public void launchBall(String playerName, int difficulty) {
		// Se comprueba que en la variable playerName entra un objeto de tipo String
		if (playerName instanceof String) {
			// Se selecciona la dificultad, cuanto más bajo el número, más fácil el juego y menos "GAME_OVER" hay
			switch (difficulty) {
			/*
			 * La lógica del programa en los tres casos es igual:
			 * 1. Se rellena el array de posibilidades según la dificultad elegida
			 * 2. Se establecen las variables de juego a su estado inicial: 
			 * 		playing true (representa si se está jugando actualmente)
			 * 		score 0 (representa la puntuación)
			 * 		bounces 0 (representa los rebotes que lleva en la partida)
			 * 3. La pelota se pone en juego y se elige una posición aleatoria del array hasta que la posición sea GAME OVER
			 * 
			 * INFO ADICIONAL:
			 * 	Si la pelota cae en GAME OVER en la primera tirada, se le suma un punto de consolación y se sigue jugando.
			 * 	Si se consiguen más de 1000 puntos en un juego, se te felicita
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

				while (playing == true) {
					int nextMove = (int) (Math.random() * 10 - 1);
					if (possiblePoints[nextMove] < 0 && bounces != 0) {
						System.out.println("GAME OVER - La puntuación final de " + playerName + " fue: " + score + " puntos");
						String mensajeFinal = (score > 1000) ? "¡Enhorabuena! ¡Has conseguido más de 1000 puntos!" : "Más suerte la próxima vez...";
						System.out.println(mensajeFinal);
						playing = false;
					} else {
						if (bounces == 0 && possiblePoints[nextMove] == -1) {
							bounces++;
							this.score += 1;
							System.out.println("La puntuación actual es de 1 punto de consolación.");
						} else {
							bounces++;
							this.score += possiblePoints[nextMove];
							System.out.println("La puntuación actual es de: " + score + " puntos.");
						}
					}
				}
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

				while (playing == true) {
					int nextMove = (int) (Math.random() * 10 - 1);
					if (possiblePoints[nextMove] < 0 && bounces != 0) {
						System.out.println("GAME OVER - La puntuación final de " + playerName + " fue: " + score + " puntos");
						String mensajeFinal = (score > 1000) ? "¡Enhorabuena! ¡Has conseguido más de 1000 puntos!" : "Más suerte la próxima vez...";
						System.out.println(mensajeFinal);
						playing = false;
					} else {
						if (bounces == 0 && possiblePoints[nextMove] == -1) {
							bounces++;
							this.score += 1;
							System.out.println("La puntuación actual es de 1 punto de consolación.");
						} else {
							bounces++;
							this.score += possiblePoints[nextMove];
							System.out.println("La puntuación actual es de: " + score + " puntos.");
						}
					}

				}
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

				while (playing == true) {
					int nextMove = (int) (Math.random() * 10 - 1);
					if (possiblePoints[nextMove] < 0 && bounces != 0) {
						System.out.println("GAME OVER - La puntuación final de " + playerName + " fue: " + score + " puntos");
						String mensajeFinal = (score > 1000) ? "¡Enhorabuena! ¡Has conseguido más de 1000 puntos!" : "Más suerte la próxima vez...";
						System.out.println(mensajeFinal);
						playing = false;
					} else {
						if (bounces == 0 && possiblePoints[nextMove] == -1) {
							bounces++;
							this.score += 1;
							System.out.println("La puntuación actual es de 1 punto de consolación.");
						} else {
							bounces++;
							this.score += possiblePoints[nextMove];
							System.out.println("La puntuación actual es de: " + score + " puntos.");
						}
					}
				}
				break;

			default:
				System.out.println("El número introducido no corresponde a ninguna dificultad.");
				break;
			}
		}
	}
}
