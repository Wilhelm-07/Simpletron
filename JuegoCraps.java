import java.util.Random;

public class JuegoCraps {
    public static void main(String[] args) {
        int juegosTotales = 1000000;
        int[] juegosGanados = new int[22];
        int[] juegosPerdidos = new int[22];
        int duracionTotal = 0;
        
        Random random = new Random();
        
        for (int i = 0; i < juegosTotales; i++) {
            int duracionJuego = jugarCraps(random);
            duracionTotal += duracionJuego;
            
            if (duracionJuego <= 20) {
                juegosGanados[duracionJuego]++;
            } else {
                juegosGanados[21]++;
            }
            
            if (duracionJuego == 1) {
                juegosPerdidos[1]++;
            } else if (duracionJuego <= 20) {
                juegosPerdidos[duracionJuego - 1]++;
            } else {
                juegosPerdidos[21]++;
            }
        }
        
        System.out.println("Resultados de los juegos de Craps:");
        System.out.println("----------------------------------");
        
        System.out.println("a) Juegos ganados:");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("En el tiro %d: %d juegos\n", i, juegosGanados[i]);
        }
        System.out.printf("Después del tiro 20: %d juegos\n", juegosGanados[21]);
        
        System.out.println("\nb) Juegos perdidos:");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("En el tiro %d: %d juegos\n", i, juegosPerdidos[i]);
        }
        System.out.printf("Después del tiro 20: %d juegos\n", juegosPerdidos[21]);
        
        double probabilidadesGanar = (double) juegosGanados[21] / juegosTotales;
        System.out.println("\nc) Probabilidades de ganar en Craps:");
        System.out.printf("%.4f\n", probabilidadesGanar);
        
        double duracionPromedio = (double) duracionTotal / juegosTotales;
        System.out.println("\nd) Duración promedio de un juego de Craps:");
        System.out.printf("%.2f\n", duracionPromedio);
        
        System.out.println("\ne) ¿Las probabilidades de ganar mejoran con la duración del juego?");
        System.out.println("No, las probabilidades de ganar en Craps son siempre las mismas, independientemente de la duración del juego.");
    }
    
    public static int jugarCraps(Random random) {
        int sumaDados = lanzarDados(random);
        int resultado = obtenerResultado(sumaDados);
        
        if (resultado == 7 || resultado == 11) {
            return 1; // Juego ganado en el primer tiro
        } else if (resultado == 2 || resultado == 3 || resultado == 12) {
            return 1; // Juego perdido en el primer tiro
        } else {
            int punto = resultado;
            int tirada = 2;
            
            while (true) {
                sumaDados = lanzarDados(random);
                tirada++;
                
                if (sumaDados == punto) {
                    return tirada; // Juego ganado después del primer tiro
                } else if (sumaDados == 7) {
                    return tirada; // Juego perdido después del primer tiro
                }
            }
        }
    }
    
    public static int lanzarDados(Random random) {
        int dado1 = 1 + random.nextInt(6);
        int dado2 = 1 + random.nextInt(6);
        return dado1 + dado2;
    }
    
    public static int obtenerResultado(int sumaDados) {
        return sumaDados;
    }
}
