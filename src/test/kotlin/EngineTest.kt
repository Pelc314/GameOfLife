import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class EngineTest {
    @Test
    fun livingCellWithZeroNeighboursDies() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(0)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun livingCellWithOneNeighbourDies() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(1)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun livingCellWithTwoNeighboursSurvives() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(2)
        assertEquals(true,cell.isAlive)
    }
    @Test
    fun livingCellWithThreeNeighboursSurvives() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(3)
        assertEquals(true,cell.isAlive)
    }
    @Test
    fun livingCellWithFourNeighboursDies() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(4)
        assertEquals(false,cell.isAlive)
    }

    @Test
    fun livingCellWithFiveNeighboursDies() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(5)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun livingCellWithSixNeighboursDies() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(6)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun livingCellWithSevenNeighboursDies() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(7)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun livingCellWithEightNeighboursDies() {
        val cell = Cell(true)
        val engineTest = Engine(cell)
        engineTest.stateChanger(8)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun deadCellWithThreeNeighboursIsRevived() {
        val cell = Cell(false)
        val engineTest = Engine(cell)
        engineTest.stateChanger(3)
        assertEquals(true,cell.isAlive)
    }
    @Test
    fun deadCellWithZeroNeighboursStaysDead() {
        val cell = Cell(false)
        val engineTest = Engine(cell)
        engineTest.stateChanger(0)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun deadCellWithOneNeighbourStaysDead() {
        val cell = Cell(false)
        val engineTest = Engine(cell)
        engineTest.stateChanger(1)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun deadCellWithTwoNeighbourStaysDead() {
        val cell = Cell(false)
        val engineTest = Engine(cell)
        engineTest.stateChanger(2)
        assertEquals(false,cell.isAlive)
    }
    @Test
    fun deadCellWithFourNeighbourStaysDead() {
        val cell = Cell(false)
        val engineTest = Engine(cell)
        engineTest.stateChanger(4)
        assertEquals(false,cell.isAlive)
    }
}
