package matrici;

import libreriastatica.MatriceLib;

public class Matrix {

    private int col;
    private int row;

    private double[][] matrix;

    public Matrix( double[][] matrix ) {
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = matrix;
    }

    public int getCols() {
        return col;
    }

    public int getRows() {
        return row;
    }

    /** --------------------------
    * FAKE ArrayOutOfBoundException dato che non abbiamo
    * ancora fatto le eccezioni :P
    *
    * @link https://docs.oracle.com/javase/9/docs/api/java/lang/ArrayIndexOutOfBoundsException.html
    *
    */

    private boolean outOfBoundException( int row, int col )
    {
        if(row > this.getRows() || col > this.getCols()) {
            return true;
        }

        return false;
    }

    public double getValue( int row, int col )
    {
        if(this.outOfBoundException( row,col ))
        {
            return Double.NaN;
        }

        return matrix[row][col];
    }

    public double[][] getAllValues() {
        return matrix;
    }

    private void setValue( int row, int col, double value)
    {
        if(this.outOfBoundException( row,col ))
        {
            return;
        }

        this.matrix[row][col] = value;
    }

    public boolean isSquared()
    {
        return row == col;
    }

    public Matrix sum( Matrix matrix )
    {
        if(this.getRows() != matrix.getRows() || this.getCols() != matrix.getCols())
        {
            return null;
        }

        return new Matrix(MatriceLib.sommaMatrici(this.getAllValues(),matrix.getAllValues()));
    }

    public Matrix mul( Matrix matrix )
    {
        if(this.getCols() != matrix.getRows())
        {
            return null;
        }

        return new Matrix(MatriceLib.prodottoMatrici(this.getAllValues(),matrix.getAllValues()));
    }

    public Matrix extractSubMatrix( int startRow, int startCol, int countRow, int countCol )
    {
        if(this.outOfBoundException( startRow+countRow,startCol+countCol))
        {
            return null;
        }

        double [][] matrix = new double[countRow][countCol];

        for(int i = 0; i < countRow; i++)
        {
            for(int j = 0; j < countCol; j++)
            {
                matrix[i][j] = this.getValue(i+startRow,j+startCol);
            }
        }

        return new Matrix(matrix);
    }


    public double det()
    {
        if(!this.isSquared())
        {
            return Double.NaN;
        }

        return this.calcDet();
    }

    // zero voglia di farlo ricorsivo / solo per 3x3 e 2x2

    private double calcDet()
    {
        double result = 0.0d;
        Matrix tmp;

        if(this.getCols() == 2) {
            return this.calcDet2x2();
        }
        if(this.getCols() <= 3) {
            for(int i = 0; i < this.getCols(); i++)
            {
                tmp = this.extractMinor(0,i);
                result += tmp.calcDet2x2();
            }
            return result;

        } else {
            return Double.NaN;
        }

    }

    public double calcDet2x2()
    {
        return this.getValue(0,0) * this.getValue(1,1) - (this.getValue(0,1) * this.getValue(1, 0));
    }


    public Matrix extractMinor(int row, int col)
    {
        if(!this.isSquared())
        {
            return null;
        }

        double[][] minorMatrix = new double[this.getRows()-1][this.getCols()-1];
        int i_2 = 0;
        int j_2 = 0;
        for(int i = 0; i < this.getRows(); i++)
        {
            if(i != row) {

                for(int j = 0; j < this.getCols(); j++)
                {
                    if(j != col) {
                        minorMatrix[i_2][j_2] = this.getValue(i,j);
                        j_2++;
                    }
                }
                j_2 = 0;
                i_2++;
            }

        }

        return new Matrix(minorMatrix);
    }

    @Override
    public String toString() {
        String print =  "";
        for(int i = 0; i < matrix.length; i++)
        {
            for( double cell : matrix[i] )
            {
                print += cell + " | ";
            }

            print += "\n";
        }

        return print;
    }
}
