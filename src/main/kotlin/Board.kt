/*
Holds information about the whole board of the game of life. Is also responsible for performing operations on it.
 */
class Board(var gamearea: Array<Array<Cell>>) {
    private var tmpArea =
        gamearea.map { arrayOfCells -> arrayOfCells.map { it.deepCopy() }.toTypedArray() }.toTypedArray()
/*
Iterates on the 2d table.
 */
    private fun iteration() {
        tmpArea = gamearea.map { arrayOfCells -> arrayOfCells.map { it.deepCopy() }.toTypedArray() }.toTypedArray()

        for (i in tmpArea.indices) {
            for (j in tmpArea[i].indices) {
                val stateControllerInstance = StateController(tmpArea[i][j])
                stateControllerInstance.stateChanger(aliveNeighbourCounter(gamearea, i, j))
            }
        }
        gamearea = tmpArea.map { arrayOfCells -> arrayOfCells.map { it.deepCopy() }.toTypedArray() }.toTypedArray()
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
        println("                   END OF THE GAME OF LIFE")
    }
/*
prints the game to the console
 */
    private fun printFunction() {
        for (i in gamearea.indices) {
            for (j in gamearea[i].indices) {
                print("|")
                if (gamearea[i][j].isAlive) {
                    print("#")
                } else print("O")
                print("|")
            }
            println()
        }
    }
//    private fun printTmpAreaFunction() { //Function for checking the behaviour of tmparea
//        println("PRINTING THE TMP AREA")
//        for (i in tmpArea.indices) {
//            for (j in tmpArea[i]!!.indices) {
//                print("|")
//                if (tmpArea[i]!![j].isAlive) {
//                    print("#")
//                } else print("O")
//                print("|")
//            }
//            println()
//        }
//    }
}