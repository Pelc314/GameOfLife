import org.junit.jupiter.api.Assertions.* // ktlint-disable no-wildcard-imports
import org.junit.jupiter.api.Test

internal class StateControllerTest {
    @Test
    fun livingCellWithLessThanTwoNeighboursDies() {
        val cell = Cell(true)
        val stateControllerTest = StateController(cell)
        var tmp = 0
        while (tmp < 2) {
            stateControllerTest.stateChanger(tmp)
            assertEquals(false, cell.isAlive)
            tmp++
        }
    }

    @Test
    fun livingCellWithTwoOrThreeNeighboursSurvives() {
        val cell = Cell(true)
        val stateControllerTest = StateController(cell)
        var tmp = 2
        while (tmp < 4) {
            stateControllerTest.stateChanger(tmp)
            assertEquals(true, cell.isAlive)
            tmp++
        }
    }

    @Test
    fun livingCellWithFourOrMoreNeighboursDies() {
        val cell = Cell(true)
        val stateControllerTest = StateController(cell)
        var tmp = 4
        while (tmp < 9) {
            stateControllerTest.stateChanger(tmp)
            assertEquals(false, cell.isAlive)
            tmp++
        }
    }

    @Test
    fun deadCellWithThreeNeighboursIsRevived() {
        val cell = Cell(false)
        val stateControllerTest = StateController(cell)
        stateControllerTest.stateChanger(3)
        assertEquals(true, cell.isAlive)
    }

    @Test
    fun deadCellWithLessThanThreeNeighboursStaysDead() {
        val cell = Cell(false)
        val stateControllerTest = StateController(cell)
        var tmp = 0
        while (tmp < 3) {
            stateControllerTest.stateChanger(tmp)
            assertEquals(false, cell.isAlive)
            tmp++
        }
    }

    @Test
    fun deadCellWithFourOrMoreNeighbourStaysDead() {
        val cell = Cell(false)
        val stateControllerTest = StateController(cell)
        var tmp = 4
        while (tmp < 9) {
            stateControllerTest.stateChanger(tmp)
            assertEquals(false, cell.isAlive)
            tmp++
        }
    }
}
