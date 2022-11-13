import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CellTest {

    @Test
    fun deadCellIsCreated() {
        val cell = Cell(false)
        assertEquals(false, cell.isAlive)
    }
    @Test
    fun aliveCellIsCreated() {
        val cell = Cell(true)
        assertEquals(true, cell.isAlive)
    }
}
