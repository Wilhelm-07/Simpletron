

package com.mycompany.simpletron;


        import java.util.Scanner;
public class Simpletron {

    
       


    public static void main(String[] args) {
        int[] memory = new int[100];
        Scanner scanner = new Scanner(System.in);

        // Programa a) - Suma de 10 números positivos
        memory[0] = 1010; // READ
        memory[1] = 2010; // LOAD 10
        memory[2] = 3111; // ADD 11
        memory[3] = 2112; // STORE 12
        memory[4] = 4110; // BRANCH 10
        memory[5] = 4107; // BRANCH 07
        memory[6] = 1110; // WRITE
        memory[7] = 4300; // HALT

        // Programa b) - Promedio de 7 números
        memory[8] = 1011; // READ
        memory[9] = 2109; // STORE 09
        memory[10] = 2012; // LOAD 12
        memory[11] = 3211; // ADD 11
        memory[12] = 2112; // STORE 12
        memory[13] = 4110; // BRANCH 10
        memory[14] = 3312; // DIVIDE 12
        memory[15] = 1111; // WRITE
        memory[16] = 4300; // HALT

        // Programa c) - Encontrar el número más grande
        memory[17] = 1013; // READ
        memory[18] = 2109; // STORE 09
        memory[19] = 4119; // BRANCH 19
        memory[20] = 2019; // LOAD 19
        memory[21] = 2218; // SUBTRACT 18
        memory[22] = 4118; // BRANCH 18
        memory[23] = 1119; // WRITE
        memory[24] = 4300; // HALT

        // Rellenar el resto de la memoria con 0's
        for (int i = 25; i < 100; i++) {
            memory[i] = 0;
        }

        System.out.println("* Ejecución del programa combinado de Simpletron *");

        int accumulator = 0;
        int instructionCounter = 0;
        boolean running = true;

        while (running) {
            int instruction = memory[instructionCounter];
            int operationCode = instruction / 100;
            int operand = instruction % 100;

            switch (operationCode) {
                case 10: // READ
                    System.out.print("Ingrese un número: ");
                    memory[operand] = scanner.nextInt();
                    break;
                case 11: // WRITE
                    System.out.println("Resultado: " + memory[operand]);
                    break;
                case 20: // LOAD
                    accumulator = memory[operand];
                    break;
                case 21: // STORE
                    memory[operand] = accumulator;
                    break;
                case 30: // ADD
                    accumulator += memory[operand];
                    break;
                case 31: // SUBTRACT
                    accumulator -= memory[operand];
                    break;
                case 32: // DIVIDE
                    if (memory[operand] != 0) {
                        accumulator /= memory[operand];
                    } else {
                        System.out.println("* ERROR: División por cero *");
                        running =                     false;
                }
                break;
            case 33: // MULTIPLY
                accumulator *= memory[operand];
                break;
            case 40: // BRANCH
                instructionCounter = operand;
                break;
            case 41: // BRANCHNEG
                if (accumulator < 0) {
                    instructionCounter = operand;
                }
                break;
            case 42: // BRANCHZERO
                if (accumulator == 0) {
                    instructionCounter = operand;
                }
                break;
            case 43: // HALT
                System.out.println("* Ejecución finalizada *");
                running = false;
                break;
            default:
                System.out.println("* ERROR: Código de operación inválido *");
                running = false;
                break;
        }

        instructionCounter++;
    }
}
    }

