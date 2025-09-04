package actividad3;

public class Fibonacci {

    // este es la función recursiva para calcular el enesimo numero de fibonacci
    public static int fibonacci(int n) {
        // Caso base: si n es 0 o 1, regresa n
        if (n == 0) return 0;
        if (n == 1) return 1;

        /*este seria el caso recursivo de f(n) donde f (n-1) + f(n-2)
         * 
         */
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // ejemplo
        System.out.println("Fibonacci de " + n + " es: " + fibonacci(n));
    }
}

