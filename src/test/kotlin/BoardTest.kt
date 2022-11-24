import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class BoardTest {
    private val arrayOfDeadCells = arrayOf(
        arrayOf(Cell(false), Cell(false), Cell(false)),
        arrayOf(Cell(false), Cell(false), Cell(false)),
        arrayOf(Cell(false), Cell(false), Cell(false))
    )

    @Test
    fun checkIfArraysOfDeadCellsIsReturned() {
        val board = Board(
            arrayOf(
                arrayOf(Cell(false), Cell(false), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false))
            )
        )
        assertEquals(true, checkIfBoardsAreEqual(arrayOfDeadCells, board.gameArea))
    }

    @Test
    fun checkIfOneLivingCellDiesAfterOneIterationOfTheGame() {
        val board = Board(
            arrayOf(
                arrayOf(Cell(false), Cell(false), Cell(false)),
                arrayOf(Cell(false), Cell(true), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false))
            )
        )
        board.playGame(1)
        assertEquals(true, checkIfBoardsAreEqual(arrayOfDeadCells, board.gameArea))
    }

    @Test
    fun checkIfTwoLivingCellsDieAfterOneIterationOfTheGame() {
        val board = Board(
            arrayOf(
                arrayOf(Cell(true), Cell(false), Cell(false)),
                arrayOf(Cell(false), Cell(true), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false))
            )
        )
        board.playGame(1)
        assertEquals(true, checkIfBoardsAreEqual(arrayOfDeadCells, board.gameArea))
    }

    @Test
    fun checkIfThreeLivingCellsSpawnNewCellAfterOneIterationOfTheGame() {
        val resultOfOneIteration = arrayOf(
            arrayOf(Cell(true), Cell(true), Cell(false)),
            arrayOf(Cell(true), Cell(true), Cell(false)),
            arrayOf(Cell(false), Cell(false), Cell(false))
        )
        val board = Board(
            arrayOf(
                arrayOf(Cell(true), Cell(true), Cell(false)),
                arrayOf(Cell(false), Cell(true), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false))
            )
        )
        board.playGame(1)
        assertEquals(true, checkIfBoardsAreEqual(resultOfOneIteration, board.gameArea))
    }

    @Test
    fun checkThreeScatteredCellsDieBirthingAnother() {
        val resultOfOneIteration = arrayOf(
            arrayOf(Cell(false), Cell(false), Cell(false)),
            arrayOf(Cell(false), Cell(true), Cell(false)),
            arrayOf(Cell(false), Cell(false), Cell(false))
        )
        val board = Board(
            arrayOf(
                arrayOf(Cell(true), Cell(false), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(true)),
                arrayOf(Cell(false), Cell(true), Cell(false))
            )
        )
        board.playGame(1)
        assertEquals(true, checkIfBoardsAreEqual(resultOfOneIteration, board.gameArea))
    }

    @Test
    fun checkIfOscillationHappens() {
        val resultOfOneIteration = arrayOf(
            arrayOf(Cell(false), Cell(true), Cell(false)),
            arrayOf(Cell(false), Cell(true), Cell(false)),
            arrayOf(Cell(false), Cell(true), Cell(false))
        )
        val board = Board(
            arrayOf(
                arrayOf(Cell(false), Cell(false), Cell(false)),
                arrayOf(Cell(true), Cell(true), Cell(true)),
                arrayOf(Cell(false), Cell(false), Cell(false))
            )
        )

        board.playGame(5)

        assertEquals(true, checkIfBoardsAreEqual(resultOfOneIteration, board.gameArea))
    }

    @Test
    fun checkIfDeepCopyCopiesObjects() {

        val board = Board(
            arrayOf(
                arrayOf(Cell(false), Cell(false), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false))
            )
        )
        val resultBoard =  board.deepCopyArray(board.gameArea)
        //Cell location on the board which we want to alter
        val row = 1
        val column = 1

        resultBoard[row][column].isAlive = true
        println(resultBoard[row][column].isAlive)
        println(board.gameArea[row][column].isAlive)

        assertEquals(false, checkIfBoardsAreEqual(resultBoard,board.gameArea))
    }

    //===========================================================================
    private fun checkIfBoardsAreEqual(firstBoard: Array<Array<Cell>>, secondBoard: Array<Array<Cell>>): Boolean {

        if (firstBoard.size == secondBoard.size) {
            for (i in firstBoard.indices) {
                for (j in firstBoard[i].indices) {
                    if (firstBoard[i][j].isAlive != secondBoard[i][j].isAlive) {
                        return false
                    }
                }
            }
        } else return false
        return true
    }
}