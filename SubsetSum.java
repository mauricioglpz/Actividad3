package actividad3;
public class SubsetSum {

    // función  recursiva para determinar si existe un subconjunto que sume al objetivo
    public static boolean subsetSum(int[] nums, int n, int objetivo) {
        // Caso base: objetivo alcanzado
        if (objetivo == 0) return true;

        // caso base: donde no hay elementos restantes
        if (n == 0) return false;

        // dn caso de que sea el último elemento es mayor que el objetivo, se ignora
        if (nums[n - 1] > objetivo) {
            return subsetSum(nums, n - 1, objetivo);
        }

        /*  opción 1: incluir el elemento
         *  opción 2: excluir el elemento
         */

        return subsetSum(nums, n - 1, objetivo) || subsetSum(nums, n - 1, objetivo - nums[n - 1]);
    }

    public static void main(String[] args) {
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        int objetivo = 9;

        if (subsetSum(conjunto, conjunto.length, objetivo)) {
            System.out.println("existe un subconjunto que suma " + objetivo);
        } else {
            System.out.println("no existe un subconjunto que sume " + objetivo);
        }
    }
}

