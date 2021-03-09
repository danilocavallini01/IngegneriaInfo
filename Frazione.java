 import java.util.Objects;

public class Frazione {
    private int num;
    private int den;
    public Frazione(int num, int den) {
        this.num= num;
        this.den= den;
    }

    public Frazione(int num) {
        this.num= num;
        this.den= 1;
    }

    public Frazione sum (Frazione f) {
    	int n = num * f.den + den * f.num;
    	int d = den * f.den;
    	Frazione fSum = new Frazione(n, d);
    	return fSum.minTerm();
    }
    
    public Frazione sumWithMcm (Frazione f) {
    	int n = num * f.den + den * f.num;
    	int d = den * f.den;
    	Frazione fSum = new Frazione(n, d);
    	return fSum.minTerm();
    }
    
    public Frazione sub (Frazione f) {
    	int n,d;
    	n = this.getNum() - f.getNum();
    	d = this.getDen() - f.getDen();
    	Frazione fSub = new Frazione(n , d);
    	return fSub.minTerm();
    }
    
    public Frazione mul (Frazione f) {
    	int n,d;
    	n = this.getNum() * f.getNum();
    	d = this.getDen() * f.getDen();
    	Frazione fMul = new Frazione(n , d);
    	return fMul.minTerm();
    }
    
    public Frazione div (Frazione f) {
    	int n,d;
    	n = this.getNum() * f.getDen();
    	d = this.getDen() * f.getNum();
    	Frazione fDiv = new Frazione(n , d);
    	return fDiv.minTerm();
    }
    
    public Frazione reciprocal() {
    	Frazione f1 = this.minTerm();
    	return new Frazione(f1.getDen(), f1.getNum());
    }
    
    public int compareTo(Frazione f) {
    	if(this.getDouble() > f.getDouble())
    	{
    		return 1;
    	} else if(this.getDouble() > f.getDouble()) {
    		return -1;
    	} else {
    		return 0;
    	}
    }
    
    public double getDouble() {
    	double d = (double)this.getNum() / (double)this.getDen();
    	return d;
    }
    
    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

    public Frazione minTerm() {
        int mcd = mcd(Math.abs(this.getNum()), Math.abs(this.getDen()));
        return new Frazione(this.getNum()/mcd,this.getDen()/mcd);
    }

    private int mcd(int a, int b)
    { while (a != b)
        if (a > b)
            a -= b;
        else
            b -= a;
        return a;
    }

    public boolean equals(Frazione f) {
        if (this == f) return true;
        return (f.getNum() * this.getDen() - this.getNum() * f.getDen()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }
}
