package com.mouredev.weeklychallenge2022


import java.util.*

import java.text.Normalizer


/*
 * Reto #12
 * ¿ES UN PALÍNDROMO?
 * Fecha publicación enunciado: 21/03/22
 * Fecha publicación resolución: 28/03/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba un texto y retorne verdadero o falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {

    beOrNotToBePalindromo("Dragon")
    beOrNotToBePalindromo("Ana!")
    beOrNotToBePalindromo("reconocer")
    beOrNotToBePalindromo("Ana lleva al oso la avellana")
    beOrNotToBePalindromo("Ella te dará detalle")
}

fun beOrNotToBePalindromo(word : String) : Boolean{
    // Separate and recompose without spaces or any other thing that isn't a letter and all in lowercase
    val step1 = word.toLowerCase(Locale.ROOT).filter { !it.toString().contains("[ !',.:;?_]".toRegex()) }

    // Replace the special characters á é í ó ú
    var step2 : String = ""
    step1.forEach {
        step2 += when(it){
            'á' -> "a"
            'é' -> "e"
            'í' -> "i"
            'ó' -> "o"
            'ú' -> "u"
            else -> it.toString()
        }
    }

    val beOrNotToBe = step2 == step2.reversed()

    println("The phrase or word: \"$word\" is a palíndromo? [$beOrNotToBe]")
    return beOrNotToBe

    // For the solution given by moure dev
    println(isPalindrome("Ana lleva al oso la avellana."))
    println(isPalindrome("Adivina ya te opina, ya ni miles origina, ya ni cetro me domina, ya ni monarcas, a repaso ni mulato carreta, acaso nicotina, ya ni cita vecino, anima cocina, pedazo gallina, cedazo terso nos retoza de canilla goza, de pánico camina, ónice vaticina, ya ni tocino saca, a terracota luminosa pera, sacra nómina y ánimo de mortecina, ya ni giros elimina, ya ni poeta, ya ni vida"))
    println(isPalindrome("¿Qué os ha parecido el reto?"))
}

// Solution given by moure dev
private fun isPalindrome(text: String): Boolean {

    val normalizedText = Normalizer.normalize(text.toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
        .replace("[^\\p{ASCII}]".toRegex(), "")
        .replace("[^a-z0-9]".toRegex(), "")
        return normalizedText == normalizedText.reversed()
    }

