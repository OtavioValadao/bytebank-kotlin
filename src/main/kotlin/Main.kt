class Conta(val titular: String, val numero: Int) {
    var saldo = 0.0
        private set

//    constructor(titular : String, numero : Int){
//        this.titular = titular
//        this.numero = numero
//    }

    fun deposita(valor: Double) { //parametro + Tipo
        // função dentr da classe é um comportamento, métodp
        saldo += valor
    }

    fun sacar(valor: Double) { // this significa que eles está falando daquele saldo
        if (this.saldo >= valor) {// verifica se o valor a sacar não é menor que o saldo
            saldo -= valor
        }
    }

    fun tranferir(valor: Int, destino: Conta): Boolean {
        if (this.saldo >= valor) {// verifica se o valor a sacar não é menor que o saldo
            saldo -= valor
            destino.saldo += valor
            return true
        } else {
            return false
        }
    }

//    fun getSaldo(): Double{ // o get saldo armazena o saldo em um modo de encapsulamento, privando a visibilidade dos usuarios, restrito apenas a cada conta
//        return saldo
//    }
//
//    fun setSaldo(valor : Double) {
//        saldo = valor
//    }

}

fun main() {
    val contaAlex = Conta(titular = "Alex", numero = 1000)
    contaAlex.deposita(valor = 200.0)

    val contaOtavio = Conta(titular = "Otavio", numero = 1001)
    contaOtavio.deposita(valor = 250.5)

    contaAlex.deposita(valor = 50.0)
    println(contaAlex.saldo)

    contaOtavio.sacar(valor = 25.5)
    println(contaOtavio.saldo)

    if (contaAlex.tranferir(valor = 50, contaOtavio)) {
        println(" Transferencia sucedida ")
    } else {
        println(" Falha na transferencia ")
    }
}