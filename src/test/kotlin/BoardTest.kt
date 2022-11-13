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
        assertEquals(true, checkIfBoardsAreEqual(arrayOfDeadCells, board.gamearea))
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
        board.gamearea = board.iteration()
        assertEquals(true, checkIfBoardsAreEqual(arrayOfDeadCells, board.gamearea))
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
        board.gamearea = board.iteration()
        assertEquals(true, checkIfBoardsAreEqual(arrayOfDeadCells, board.gamearea))
    }

    @Test
    fun checkIfThreeLivingCellsSpawnNewCellAfterOneIterationOfTheGame() {
        val board = Board(
            arrayOf(
                arrayOf(Cell(true), Cell(true), Cell(false)),
                arrayOf(Cell(false), Cell(true), Cell(false)),
                arrayOf(Cell(false), Cell(false), Cell(false))
            )
        )
        board.gamearea = board.iteration()
        assertEquals(false, checkIfBoardsAreEqual(arrayOfDeadCells, board.gamearea))
    }

    //===========================================================================
    private fun checkIfBoardsAreEqual(firstBoard: Array<Array<Cell>>, secondBoard: Array<Array<Cell>>): Boolean {

        if (firstBoard.size == secondBoard.size) {
            for (i in firstBoard.indices) {
                for (j in 0 until firstBoard[i].size) {
                    if (firstBoard[i][j].isAlive != secondBoard[i][j].isAlive) {
                        return false
                    }
                }
            }
        } else return false
        return true
    }
}