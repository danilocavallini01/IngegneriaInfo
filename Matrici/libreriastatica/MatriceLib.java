package libreriastatica;

public class MatriceLib {

    /**
     * Somma di due matrici
     *
     * @param   matrix1 - prima matrice da sommare
     * @param   matrix2 - seconda matrice da sommare
     * @return  result - somma due matrici
     */

    public static double[][] sommaMatrici(double[][] matrix1, double[][] matrix2)
    {
        double [][] result = new double [matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++)
        {
            for (int j = 0; j < matrix1[0].length; j++)
            {

                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    /**
     * Prodotto di due matrici
     *
     * @param   matrix1 - prima matrice da sommare
     * @param   matrix2 - seconda matrice da sommare
     * @return  result - somma due matrici
     */

    public static double[][] prodottoMatrici(double[][] matrix1, double[][] matrix2)
    {
        double [][] result = new double [matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++)
        {
            for (int j = 0; j < matrix2[0].length; j++)
            {
                result[i][j] = 0;

                for (int notfixed = 0; notfixed < matrix1.length; notfixed++)
                {
                    result[i][j] += matrix1[i][notfixed] * matrix2[notfixed][j];
                }
            }
        }

        return result;
    }

    /**
     * Stampa della matrice
     * @param   matrix - matrice da stampare
     */

    public static void stampaMatrice(double[][] matrix)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for( double cell : matrix[i])
            {
                System.out.print(cell + " | ");
            }

            System.out.println();
        }
    }
}
