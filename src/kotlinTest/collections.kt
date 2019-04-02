package kotlinTest

fun main() {
   /* val list = "ggg qwe asd qwe zxc qwe zcx qwe qwe".split(' ')
    val result = list.groupingBy { it }.eachCount()
    var name: String = ""
    result.forEach { s, i ->
        if (name.isEmpty()) {
            name = s
        }
        if (i > result.getValue(name)) {
            name = s;
        }
    }

    println(name)*/

}

fun calcNullValues(input: Array<Int?>):Array<Int> {

    var nil: Int = 0
    var exist: Int = 0

    for (i in input) {
        if (i == null) nil++
        else exist++
    }

    return arrayOf(nil, exist)
}