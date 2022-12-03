/*
Holds information about the whole board of the game of life. Is also responsible for performing operations on it.
 */
class Board(var gameArea: Array<Array<Cell>>) {
    /*
    Iterates on the 2d table.
     */
    private fun iteration() {
        val tmpArea = deepCopyArray(gameArea)
        for (i in tmpArea.indices) {
            for (j in tmpArea[i].indices) {
                val stateControllerInstance = StateController(tmpArea[i][j])
                stateControllerInstance.stateChanger(aliveNeighbourCounter(gameArea, i, j))
            }
        }
        gameArea = deepCopyArray(tmpArea)
    }

    fun deepCopyArray(original: Array<Array<Cell>>): Array<Array<Cell>> {
        val result = original.map { arrayOfCells -> arrayOfCells.map { it.copy() } }
        return result.map { arrayOfCells -> arrayOfCells.map { it.copy() }.toTypedArray() }.toTypedArray()
    }
    private fun aliveNeighbourCounter(twoDArrayOfCells: Array<Array<Cell>>, row: Int, column: Int): Int {
        var counter = 0

        if (row - 1 > -1) {
            if (column - 1 > -1 && twoDArrayOfCells[row - 1][column - 1].isAlive)counter++
            if (twoDArrayOfCells[row - 1][column].isAlive) counter++
            if (column + 1 < twoDArrayOfCells[row].size && twoDArrayOfCells[row - 1][column + 1].isAlive) counter++
        }

        if (column - 1 > -1 && twoDArrayOfCells[row][column - 1].isAlive) counter++
        if (column + 1 < twoDArrayOfCells[row].size && twoDArrayOfCells[row][column + 1].isAlive) counter++

        if (row + 1 < twoDArrayOfCells.size) {
            if (column - 1 > -1 && twoDArrayOfCells[row + 1][column - 1].isAlive) counter++
            if (twoDArrayOfCells[row + 1][column].isAlive) counter++
            if (column + 1 < twoDArrayOfCells[row].size && twoDArrayOfCells[row + 1][column + 1].isAlive) counter++
        }
        return counter
    }

    fun playGame(gameTime: Int) {
        var time = gameTime

        println("                   START OF THE GAME OF LIFE")
        while (time > 0) {
            Thread.sleep(500)
            time--
            printFunction()
            println("================================================================")
            iteration()
        }
        printFunction()
        println("                   END OF THE GAME OF LIFE")
    }

    /*
    prints the game to the console
     */
    private fun printFunction() {
        for (i in gameArea.indices) {
            for (j in gameArea[i].indices) {
                print("|")
                if (gameArea[i][j].isAlive) {
                    print("#")
                } else print("O")
                print("|")
            }
            println()
        }
    }
}
