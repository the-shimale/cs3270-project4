import java.util.*
import java.io.File
import java.io.InputStream

// global 2D array representing a 9x9 board with all cells initialized to 0
var board=Array(9, {Array(9,{0})})

fun main(args: Array<String>) {
//    val inputStream: InputStream = File("sudoku-test1.txt").inputStream()
//
//    val inputString = inputStream.bufferedReader().use { it.readText() }
//    println(inputString)
//    for(line in inputString) {
//        print(line)
//    }
    loadFromFile()
}

fun loadFromFile() {
    val file = File("sudoku-test1.txt")
    val bufferedReader = file.bufferedReader()
    val text:List<String> = bufferedReader.readLines()
    var i = 0
    var j = 0
    for(line in text){
        for(char in line) {
            if(!char.isWhitespace()) {
                val num = char.toInt()
                print(char)
//                board[i][j] = char.toInt()
//                ++j
            }
        }
        println()
//        j = 0
//        ++i
    }
}