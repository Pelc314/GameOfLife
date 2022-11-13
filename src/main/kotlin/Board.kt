class Board(var gamearea: Array<Array<Cell>>) {
    fun iteration(): Array<Array<Cell>> {
        return arrayOf(
            arrayOf(Cell(false), Cell(false), Cell(false)),
            arrayOf(Cell(false), Cell(false), Cell(false)),
            arrayOf(Cell(false), Cell(false), Cell(false))
        )
    }
}