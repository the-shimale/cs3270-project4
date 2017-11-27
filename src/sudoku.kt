import java.util.*
import java.io.File
import java.io.InputStream

// global 2D array representing a 9x9 board with all cells initialized to 0
var board=Array(9, {Array(9,{0})})

fun main(args: Array<String>) {
    loadFromFile()
}

// reads file containing sudoku puzzle to solve and stores
// the values into board
fun loadFromFile() {
    val file = File("sudoku-test1.txt")
    val bufferedReader = file.bufferedReader()
    val text:List<String> = bufferedReader.readLines()
    var i = 0
    var j = 0
    for(line in text){
        for(char in line) {
            if(!char.isWhitespace()) {
                board[i][j] = (char - '0')
                ++j
            }
        }
        j = 0
        ++i
    }
}