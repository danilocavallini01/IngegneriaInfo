import kotlin.jvm.JvmStatic

class CodiceFiscale {
    private val vocali = "AEIOU"
    private val mesiTab = "ABCDEHLMPRST"
    private val woman_const = 40
    private val milano_cod = "F205"
    private val bologna_cod = "A944"

    // zero voglia di mettere tutta la lista comuni
    private val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val dispAlphabet = "BAKPLCQDREVOSFTGUHMINJWZYX"
    private val omocodia = "LMNPQRSTUV"
    fun calcolaCodiceFiscale(nome: String, cognome: String, giorno: Int, mese: Int, anno: Int, sesso: String, comune: String): String {
        val partialResult = (calcolaCognome(cognome) + calcolaNome(nome) + calcolaAnno(anno) + calcolaMese(mese)
                + calcolaGiornoSesso(giorno, sesso) + calcolaComune(comune))
        return partialResult + calcolaCarControllo(partialResult)
    }

    fun verificaCodiceFiscale(cognome: String, nome: String, giorno: Int, mese: Int, anno: Int, comune: String, sesso: String, CF: String): Boolean {
        val CalculatedCF = calcolaCodiceFiscale(cognome, nome, giorno, mese, anno, comune, sesso)
        var charCF = String()
        var charCalculatedCF = String()
        for (i in 0 until CF.length - 1) {
            charCF = CF[i].toString()
            charCalculatedCF = CalculatedCF[i].toString()
            if (charCF != charCalculatedCF) {
                if (charCF != omocodia[Integer.valueOf(charCalculatedCF)].toString()) {
                    return false
                }
            }
        }
        return true
    }

    private fun calcolaComune(comune: String): String {
        val uppedComune = comune.toUpperCase()
        return if (uppedComune == "BOLOGNA") {
            bologna_cod
        } else if (uppedComune == "MILANO") {
            milano_cod
        } else {
            "FRAH"
        }
    }

    private fun calcolaGiornoSesso(giorno: Int, sesso: String): String {
        var result = String()
        result = if (sesso == "M") {
            giorno.toString()
        } else {
            (giorno + woman_const).toString()
        }
        if (result.length == 1) {
            result = "0$result"
        }
        return result
    }

    private fun calcolaMese(mese: Int): String {
        return mesiTab[mese - 1].toString()
    }

    private fun calcolaAnno(anno: Int): String {
        var nascita = (anno % 100).toString()
        if (nascita.length == 1) {
            nascita = "0$nascita"
        }
        return nascita
    }

    private fun calcolaCarControllo(CFincompleto: String): String {
        var result = 0
        var charCF = String()
        var ParsedCF = String()
        for (i in 0 until CFincompleto.length) {
            charCF = CFincompleto[i].toString()
            if (alphabet.contains(charCF)) {
                ParsedCF += charCF
            } else {
                ParsedCF += alphabet[Integer.valueOf(charCF)]
            }
        }
        for (i in 0 until ParsedCF.length) {
            charCF = ParsedCF[i].toString()
            result += if (i % 2 != 0) {
                alphabet.indexOf(charCF)
            } else {
                dispAlphabet.indexOf(charCF)
            }
        }
        return alphabet[result % 26].toString()
    }

    private fun calcolaCognome(cognome: String): String {
        val uppedCognome = cognome.toUpperCase()
        var result = String()
        if (uppedCognome.length < 3) {
            result = uppedCognome
            for (i in uppedCognome.length..2) {
                result += "X"
            }
            return result
        }
        var i = 0
        while (i < uppedCognome.length && result.length < 3) {
            if (isConsonante(uppedCognome[i])) {
                result += uppedCognome[i]
            }
            i++
        }
        if (result.length < 3) {
            var i = 0
            while (i < uppedCognome.length && result.length < 3) {
                if (isVocale(uppedCognome[i])) {
                    result += uppedCognome[i]
                }
                i++
            }
        }
        return result
    }

    private fun calcolaNome(nome: String): String {
        val uppedNome = nome.toUpperCase()
        var result = String()
        if (uppedNome.length < 3) {
            result = uppedNome
            for (i in uppedNome.length..2) {
                result += "X"
            }
            return result
        }
        var i = 0
        while (i < uppedNome.length && result.length < 4) {
            if (isConsonante(uppedNome[i])) {
                result += uppedNome[i]
            }
            i++
        }
        return if (result.length < 4) {
            calcolaCognome(uppedNome)
        } else result
    }

    private fun isVocale(c: Char): Boolean {
        return vocali.contains(c.toString())
    }

    private fun isConsonante(c: Char): Boolean {
        return !isVocale(c)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val CodiceFiscale = CodiceFiscale()
            println(CodiceFiscale.calcolaCodiceFiscale(
                    "Mario", "Rossi", 12, 6, 1976, "M", "Bologna") == "RSSMRA76H12A944I")
            println(CodiceFiscale.calcolaCodiceFiscale(
                    "Mario", "Rossi", 1, 1, 1990, "M", "Milano") == "RSSMRA90A01F205Z")
            println(CodiceFiscale.verificaCodiceFiscale(
                    "Mario", "Rossi", 12, 6, 1976, "M", "Bologna", "RSSMRA76H12A94QF"))
            println(CodiceFiscale.verificaCodiceFiscale(
                    "Mario", "Rossi", 12, 6, 1976, "M", "Bologna", "RSSMRA76H12A9Q4U"))
            println(CodiceFiscale.verificaCodiceFiscale(
                    "Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A01F20RU"))
            println(CodiceFiscale.verificaCodiceFiscale(
                    "Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A01F2L5K"))
            println(CodiceFiscale.verificaCodiceFiscale(
                    "Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A01FN05O"))
            println(CodiceFiscale.verificaCodiceFiscale(
                    "Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90A0MF205R"))
            println(CodiceFiscale.verificaCodiceFiscale(
                    "Mario", "Rossi", 1, 1, 1990, "M", "Milano", "RSSMRA90AL1F205K"))
        }
    }
}