fun main() {
    val timeOfTheGameInSeconds = 20 //Specifies the number of iterations that game of life should run

    /*
    2d array which specifies the placement of alive and dead cells.
    * */
    val board = arrayOf(
        arrayOf(Cell(false), Cell(false), Cell(false), Cell(false), Cell(false)),
        arrayOf(Cell(false), Cell(true), Cell(true), Cell(false), Cell(false)),
        arrayOf(Cell(false), Cell(true), Cell(true), Cell(false), Cell(false)),
        arrayOf(Cell(false), Cell(false), Cell(false), Cell(true), Cell(true)),
        arrayOf(Cell(false), Cell(false), Cell(false), Cell(true), Cell(true)),
    )
    val game = Board(board)
    game.playGame(timeOfTheGameInSeconds)
}