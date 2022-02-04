import java.lang.IndexOutOfBoundsException
import kotlin.math.pow

val operatorList = arrayOf("Soma","Multiplicacao","Divisao","Resto","Exponencial","Fatorial")
var a:Float = 0.00F; val b:Float = 0.00F
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
                "5" -> println("Resultado:\n${calculator(a, b, 5, ::power)}")
                "6" -> println("Resutlado:\n${calculator(a, b, 6, ::fact)}")
                else -> println("\nError 1 - Insira um valor valido")
            }
        } catch (e: NumberFormatException) {
            println("\nError 2 - Insira um valor valido")
        }
        println("\nVocê gostaria de utilizar a calculadora novamente? Insira 1 para continuar e qualquer outra coisa para terminar")
        if(readLine() != "1"){
            cont = false
        }
    }
}

fun calculator(n1:Float, n2:Float, operator:Int, operation:(Float, Float)-> Float):Float {
    var tempA = n1; var tempB = n2
    println("\nVocê escolheu a operação: ${operatorList[operator-1]}")
    if(operator == 6) {
        println("Por favor, insira o numero, sem casas decimais, desejado.")
    }else println("Por favor, insira os numeros, com ou sem casas decimais, desejados separados por um espaço. Exemplo:(4 5)")

    try {
        if (operator == 6) {
            tempA = readLine()!!.toInt().toFloat()//toInt e toFloat pra poder pegar o erro de NumberFormatException
        }else{
            val (a,b) = readLine()!!.split(' ').map(String::toFloat)//Pega os numeros, separa pelo uso do .split e transforma de string pra List<Float> pelo uso do .map
            tempA = a
            tempB = b
        }

    } catch (e: NumberFormatException){
        println("\nError 2 - Insira um valor valido")
    } catch (e: IndexOutOfBoundsException){
        println("\nError 3 - Insira um valor valido")
    }
    return operation(tempA,tempB)
}

fun soma(a:Float, b:Float) = a+b
fun multi(a:Float, b:Float) = a*b
fun div(a:Float, b:Float) = a/b
fun rest(a:Float, b:Float) = a%b
fun power(a:Float, b:Float) = a.pow(b)
fun fact(a:Float, b: Float):Float{
    if (a.toInt() <= 1) return 1.0F

    var temp = a.toInt()
    for (i in a.toInt() downTo   2){
        temp *= (i - 1)
    }
    return temp.toFloat()
}

