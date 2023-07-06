import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    public static int positiveInteger(Scanner scanner) {
        Boolean invalid = true;
        int input = 0;
        while (invalid) {
            try {
                input = scanner.nextInt();
                if (input < 0)
                    System.out.println("Entrada inválida! Digite um número POSITIVO:");
                else
                    invalid = false;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número INTEIRO:");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static int integerInRange(int min, int max, Scanner scanner) {
        Boolean invalid = true;
        int input = 0;
        while (invalid) {
            try {
                input = scanner.nextInt();
                if (input < min || input > max)
                    System.out.println("Entrada inválida! Digite um número entre " + min + " e " + max + ":");
                else
                    invalid = false;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número INTEIRO:");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static float positiveFloat(Scanner scanner) {
        Boolean invalid = true;
        float input = 0;
        while (invalid) {
            try {
                input = scanner.nextFloat();
                if (input < 0)
                    System.out.println("Entrada inválida! Digite um número POSITIVO:");
                else
                    invalid = false;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número REAL:");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static double positiveDouble(Scanner scanner) {
        Boolean invalid = true;
        double input = 0;
        while (invalid) {
            try {
                input = scanner.nextDouble();
                if (input < 0)
                    System.out.println("Entrada inválida! Digite um número POSITIVO:");
                else
                    invalid = false;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número REAL:");
                scanner.nextLine();
            }
        }
        return input;
    }
}
