// CS 3270 Vanderbilt University
// Name: Able Shi and Austin Wilms
// VUnetID: shiza and wilmsad
// Email: zaixing.a.shi@vanderbilt.edu and austin.d.wilms@vanderbilt.edu
// Honor Statement: We have neither given nor received unauthorized help on this assignment
// Description: Kotlin implementation of Sudoku class

import java.util.*
import java.io.File
import java.io.InputStream

// global constant representing board size
val BOARD_SIZE = 9

// global 2D array representing a 9x9 board with all cells initialized to 0
var board=Array(BOARD_SIZE, {Array(BOARD_SIZE,{0})})

// class to represent the coordinates of a point or cell on the sudoku board
// initialize row and col to 0 by default
class Point {
    var row: Int = 0
    var col: Int = 0
}

fun main(args: Array<String>) {
    loadFromFile()
    print()
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

// Prints the current puzzle contents to the screen in a nicely formatted manner.
fun print() {
    for (row in 0 until 9) {
        for (col in 0 until 9) {
            if (col == 2 || col == 5)
                print("${board[row][col]} | ")
            else
                print("${board[row][col]} ")
        }
        if (row == 2 || row == 5) {
            println()
            print("------+-------+------")
            println()
        }
        else
            println()
    }
}

// The entry point for your solver.
// Returns true if a solution was found, otherwise returns false.
fun solve(): Boolean {
    // find an empty cell
    val start = Point()
    val cell = findEmpty(start)
    if(cell.row == BOARD_SIZE && cell.col == BOARD_SIZE) {
        return true
    } else {
        var num = 1
        while(num <= BOARD_SIZE) {
            val sqroot = Math.sqrt(BOARD_SIZE.toDouble())
            val offset = sqroot.toInt()
            // use modulo to get to a square and remain within it
            if(validOnRowCol(cell.row, cell.col, num) &&
                    validInSquare(cell.row - (cell.row % offset),
                            cell.col - (cell.col % offset), num)) {
                board[cell.row][cell.col] = num
                if (solve()) {
                    return true
                }
                board[cell.row][cell.col] = 0
            }
            ++num
        }
    }
    return false
}

// Returns an empty point on the Sudoku board
fun findEmpty(pt: Point): Point {
    var row = 0
    var col = 0
    while(row < BOARD_SIZE) {
        while(col < BOARD_SIZE) {
            if(board[row][col] == 0) {
                pt.row = row
                pt.col = col
                return pt
            }
            ++col
        }
        col = 0
        ++row
    }
    pt.row = BOARD_SIZE
    pt.col = BOARD_SIZE
    return pt
}

// Determines if position is a valid location for num on the row and column
// Returns true if position is safe for num, else returns false
fun validOnRowCol(row: Int, col: Int, num: Int): Boolean {
    // replace this will actual implementation
    return false
}

// Determines if position is a valid location for num in a 3x3 square
// Returns true if position is safe for num, else returns false
fun validInSquare(row: Int, col: Int, num: Int): Boolean {
    // replace this will actual implementation
    return false
}

// Include some function to record the running time of the program???