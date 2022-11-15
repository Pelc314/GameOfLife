class Board(var gamearea: Array<Array<Cell>>) {
    fun iteration(){
        for (i in gamearea.indices) {
            for (k in gamearea[i].indices) {
                val cellStateChanger = StateController(gamearea[i][k])
                cellStateChanger.stateChanger(aliveNeighbourCounter(gamearea, i, k))
            }
        }
    }

    private fun aliveNeighbourCounter(twoDArrayOfCells: Array<Array<Cell>>, row: Int, column: Int): Int {
        var counter = 0

        if (row - 1 > -1) {
            if (column - 1 > -1) if (twoDArrayOfCells[row - 1][column - 1].isAlive) counter++
            if (twoDArrayOfCells[row - 1][column].isAlive) counter++
            if (column + 1 < twoDArrayOfCells[row].size) if (twoDArrayOfCells[row - 1][column + 1].isAlive) counter++
        }

        if (column - 1 > -1) if (twoDArrayOfCells[row][column - 1].isAlive) counter++
        if (column + 1 < twoDArrayOfCells[row].size) if (twoDArrayOfCells[row][column + 1].isAlive) counter++

        if (row + 1 < twoDArrayOfCells.size) {
            if (column - 1 > -1) if (twoDArrayOfCells[row + 1][column - 1].isAlive) counter++
            if (twoDArrayOfCells[row + 1][column].isAlive) counter++
            if (column + 1 < twoDArrayOfCells[row].size) if (twoDArrayOfCells[row + 1][column + 1].isAlive) counter++
        }
        return counter
    }
}