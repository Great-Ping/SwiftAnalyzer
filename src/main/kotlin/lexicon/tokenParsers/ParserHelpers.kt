package lexicon.tokenParsers

import toolkit.enumerators.CharEnumerator
import toolkit.enumerators.moveNext
import java.lang.Character.isWhitespace

//!!!Изменяет состояние enumerator
//Работает на упреждение
//Доверьтесь нам :)
fun skipWhitespaces(
    enumerator: CharEnumerator
) : Unit {
    var state = enumerator.currentIndex
    while (enumerator.moveNext()) {
        if (!isWhitespace(enumerator.current)) {
            break
        }
        state = enumerator.currentIndex;
    }
    enumerator.moveTo(state)

}


//!!!Изменяет состояние enumerator
//Работает на упреждение
fun continuesWith(
    enumerator: CharEnumerator,
    pattern:String
): Boolean {
    val iterator = pattern.iterator()

    while (iterator.hasNext() && enumerator.moveNext()) {
        if (enumerator.current != iterator.next())
            return false
    }

    return !iterator.hasNext()
}


//!!!Изменяет состояние enumerator
//Работает на упреждение
fun continuesWith(
    enumerator: CharEnumerator,
    symbol:Char
): Boolean {
    return enumerator.moveNext()
            && enumerator.current != symbol
}


