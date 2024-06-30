package com.cibertec.cibertecapp.kotlin

fun main() {
    // 1. Variables
    var miVariable: Int = 10
    val miConstante: Int = 20
    val pi: Double = 3.1416
    val piAlt = 3.1416

    // 2. Tipos de datos
    val myInt: Int = 10
    val myByte: Byte = 127
    val myLong: Long = 1200
    val myDouble: Double = 2.30
    val myFloat: Float = 12.5f
    val myBool: Boolean = true
    val myChar: Char = 'A'
    val myString: String = "C"

    print(myString)
    println(myChar)

    // Arreglos
    val myArray = arrayOf<Int>(20,15,10,20)
    val myArrayMix = arrayOf(1, "C", true)
    val myList = listOf(1,2,3)
    val myArrayList = arrayListOf(1,2)

    // Condicionales
    val aprobareCurso = true
    if (aprobareCurso){
        print("Aprenderé iOS")
    } else {
        print("Me gusta android")
    }

    // For
    val cursos = listOf("Android", "iOS")
    for (curso in cursos){
        print(curso)
    }

    for ((index, value) in cursos.withIndex()) {
        print("$index $value")
    }

    // While -- do While
    var contador = 0
    while (contador < cursos.size) {
        print(cursos[contador])
        contador++
    }

    val maximo = 10
    var contador2 = 0
    do {
        print("Contador es: $contador2")
        contador2++
    } while (contador2 <= maximo)


    // When
    var mes: Int = 1
    when(mes) {
        1 -> "Enero"
        2 -> "Febrero"
        else -> "Verifique datos"
    }

    // Operadores
    print(1+4)
    print(5-4)
    print(5*5)
    print(20/5)
    print(9%4) // modulo

    val persona = Persona("Jose",
        "Li", 20, 45454545)
    persona.showData()

}

// Funciones
fun sumar(a:Int, b:Int): Unit {
    print(a + b)
}

fun sumarReturn(a:Int, b:Int): Int {
    return a + b
}

class Persona(val nombre: String,
    val apellidos: String,
    val edad: Int, val dni: Int) {

    fun showData() {
        print("$nombre $apellidos")
    }
}

class Carro(val anio: Int) {
    var marca: String = ""
    var modelo: String = ""
    var color: String = ""

    constructor(marca: String,
        modelo: String, color: String, anio: Int) : this(anio) {
        this.marca = marca
        this.modelo = modelo
        this.color = color
    }

}



