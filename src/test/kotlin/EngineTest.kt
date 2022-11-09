import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EngineTest {
    private val cell = Cell(false)
    private val engineTest = Engine(cell)

    @Test
    fun livingCellWithZeroNeighboursDies() {
        engineTest.stateChanger(0)
        assertEquals(false,cell.isAlive)
    }
}
