
fun main() {
    val operatorList = arrayOf("Soma","Multiplicacao","Divisao","Resto","Exponencial","Fatorial")
    println("Olá, bem-vindo(a) a Calculadora Kotlin, o que voce gostaria de calcular?")
    println("1- Soma    2- Multiplicação    3- Divisão    4- Resto    5- Exponencial    6- Fatorial")
    println("Por favor, entre com o numero correspondente a opereção desejada.")
    val operator:Int = readLine()!!.toInt() //Pega operação
    println("Você escolheu a operação: ${operatorList[operator-1]}")
    println("Por favor, insira os numeros, com ou sem casas decimais, desejados separados por um espaço. Exemplo:(4 5)")
    val (a,b) = readLine()!!.split(' ').map(String::toFloat)//Pega os numeros, separa pelo uso do .split e transforma de string pra float pelo uso do .map
    //println(calculator(a,b,::soma))
    when(operator){
        1 -> println("Resultado:\n${calculator(a,b,::soma)}")
        2 -> println("Resultado:\n${calculator(a,b,::multi)}")
        3 -> println("Resultado:\n${calculator(a,b,::div)}")
        4 -> println("Resultado:\n${calculator(a,b,::rest)}")
        else -> println("Error")
    }

}

fun calculator(a:Float, b:Float, operation:(Float, Float)-> Float):Float = operation(a,b)
fun soma(a:Float, b:Float) = a+b
fun multi(a:Float, b:Float) = a*b
fun div(a:Float, b:Float) = a/b
fun rest(a:Float, b:Float) = a%b
