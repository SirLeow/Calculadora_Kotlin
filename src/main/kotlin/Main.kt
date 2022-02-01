val operatorList = arrayOf("Soma","Multiplicacao","Divisao","Resto","Exponencial","Fatorial")
var a:Float = 0.0F; val b:Float = 0.0F
var cont = true
fun main()  {
    while (cont) {
        println("\nOlá, bem-vindo(a) a Calculadora Kotlin, o que voce gostaria de calcular?")
        for (i in operatorList.indices) {
            println("${i + 1}- ${operatorList[i]}")
        }
        println("\nPor favor, entre com o numero correspondente a opereção desejada.")

        try {
            when (readLine()) { //when pra controle de erro
                "1" -> println("Resultado:\n${calculator(a, b, 1, ::soma)}")
                "2" -> println("Resultado:\n${calculator(a, b, 2, ::multi)}")
                "3" -> println("Resultado:\n${calculator(a, b, 3, ::div)}")
                "4" -> println("Resultado:\n${calculator(a, b, 4, ::rest)}")
                else -> println("Error - Insira um valor valido")
            }
        } catch (e: NumberFormatException) {
            println("\nError - Insira um valor valido")
        }
        println("\nVocê gostaria de utilizar a calculadora novamente? Insira 1 para continuar e qualquer outra coisa para terminar")
        if(readLine() != "1"){
            cont = false
            println()
        }
    }
}

fun calculator(a:Float, b:Float, operator:Int, operation:(Float, Float)-> Float):Float {
    println("\nVocê escolheu a operação: ${operatorList[operator-1]}")
    println("Por favor, insira os numeros, com ou sem casas decimais, desejados separados por um espaço. Exemplo:(4 5)")
    return try {
        val (a1,b1) = readLine()!!.split(' ').map(String::toFloat)//Pega os numeros, separa pelo uso do .split e transforma de string pra float pelo uso do .map
        operation(a1,b1)
    } catch (e: NumberFormatException){
        println("\nError - Insira um valor valido")
        operation(a,b)
    }

}
fun soma(a:Float, b:Float) = a+b
fun multi(a:Float, b:Float) = a*b
fun div(a:Float, b:Float) = a/b
fun rest(a:Float, b:Float) = a%b
