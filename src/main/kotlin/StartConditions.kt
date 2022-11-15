fun main() {
    val timeOfTheGameInSeconds = 15 //Here you need to determine how long do you want simulation to run
    //below you need to specify placement of alive cells in 2d array.
    val game = Board(
        arrayOf(
            arrayOf(Cell(false), Cell(true), Cell(false), Cell(false), Cell(false)),
            arrayOf(Cell(true), Cell(true), Cell(false), Cell(false), Cell(false)),
            arrayOf(Cell(false), Cell(false), Cell(false), Cell(true), Cell(false)),
            arrayOf(Cell(false), Cell(false), Cell(true), Cell(true), Cell(true)),
            arrayOf(Cell(false), Cell(false), Cell(true), Cell(true), Cell(false)),
        )
    )
    game.playGame(timeOfTheGameInSeconds)
}