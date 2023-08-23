import java.util.Scanner;

public class VentasTotales {
    public static void main(String[] args) {
        int[][] ventas = new int[5][6]; 
        
        
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.printf("Ingrese las ventas del vendedor %d para el producto %d: ", i + 1, j + 1);
                ventas[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println("\nVentas totales por vendedor y por producto:");
        
        
        System.out.print("\t\t");
        for (int i = 0; i < 5; i++) {
            System.out.printf("Vendedor %d\t", i + 1);
        }
        System.out.println("Total");
        
    
        for (int i = 0; i < 5; i++) {
            int totalProducto = 0;
            System.out.printf("Producto %d\t", i + 1);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%d\t\t", ventas[j][i]);
                totalProducto += ventas[j][i];
            }
            System.out.printf("%d\n", totalProducto);
        }
        
      
        System.out.print("Total\t\t");
        for (int i = 0; i < 5; i++) {
            int totalVendedor = 0;
            for (int j = 0; j < 5; j++) {
                totalVendedor += ventas[i][j];
            }
            System.out.printf("%d\t\t", totalVendedor);
        }
        
       
        int totalGeneral = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                totalGeneral += ventas[i][j];
            }
        }
        System.out.printf("%d\n", totalGeneral);
    }
}

