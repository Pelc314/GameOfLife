class Board(var gamearea: Array<Array<Cell>>) {
    fun iteration(): Array<Array<Cell>> {
        var result = gamearea
        for (i in gamearea.indices) {
            for (k in gamearea[i].indices) {
                val cellStateChanger = StateController(gamearea[i][k])
                cellStateChanger.stateChanger(aliveNeighbourCounter(gamearea, i, k))
            }
        }
        return result
    }

    private fun aliveNeighbourCounter(twoDArrayOfCells: Array<Array<Cell>>, row: Int, column: Int): Int {

        for (i in twoDArrayOfCells.indices) {
            for (k in twoDArrayOfCells[i].indices) {
//TODO implement neighbour count here
            }
        }
        return 3
    }
}