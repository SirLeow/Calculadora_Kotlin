fun main() {
    println("Olá, bem-vindo(a) a Calculadora Kotlin, o que voce gostaria de calcular?")
    println("1- Soma    2- Multiplicação    3- Divisão    4- Resto    5- Exponencial    6- Fatorial")
    println("Por favor, entre com o numero correspondente a opereção desejada.")
    val operator:Int = readLine()!!.toInt()
    println(operator)
}