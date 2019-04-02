package kotlinTest

class CollectionExamples {

    fun collections() {

        val readOnly: List<Int> = listOf(1, 2, 3)
        readOnly.size

        val readWrite: MutableList<Int> = mutableListOf(1, 2, 3)
        readWrite.size
        readWrite.add(4)
        readWrite.clear()

    }
}