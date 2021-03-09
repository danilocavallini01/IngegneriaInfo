import java.util.Objects

class Frazione {
    var num: Int
        private set
    var den: Int
        private set

    constructor(num: Int, den: Int) {
        this.num = num
        this.den = den
    }

    constructor(num: Int) {
        this.num = num
        den = 1
    }

    fun minTerm(): Frazione {
        val mcd = mcd(num, den)
        return Frazione(num / mcd, den / mcd)
    }

    private fun mcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (a != b) if (a > b) a -= b else b -= a
        return a
    }

    fun equals(f: Frazione): Boolean {
        return if (this === f) true else f.num * den - num * f.den == 0
    }

    override fun hashCode(): Int {
        return Objects.hash(num, den)
    }

    override fun toString(): String {
        return "$num/$den"
    }
}