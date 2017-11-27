import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("sudoku-test1.txt").inputStream()

    val inputString = inputStream.bufferedReader().use { it.readText() }
    println(inputString)
}