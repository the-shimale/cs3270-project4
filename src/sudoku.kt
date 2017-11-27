import java.io.File
import java.io.InputStream

//int board[9][9];

fun main(args: Array<String>) {
//    val inputStream: InputStream = File("sudoku-test1.txt").inputStream()
//
//    val inputString = inputStream.bufferedReader().use { it.readText() }
//    println(inputString)
    loadFromFile()
}

fun loadFromFile() {
    val file = File("sudoku-test1.txt")
    val bufferedReader = file.bufferedReader()
    val text:List<String> = bufferedReader.readLines()
    for(line in text){
        println(line)
    }
}