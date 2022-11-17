class StateController(private val cell: Cell) {
    /*
    * Changes state of the cell depending on number of neighbours provided
    * */
    fun stateChanger(neighbourCount: Int) {
        if (cell.isAlive) this.cell.isAlive = (neighbourCount == 2 || neighbourCount == 3)
        else this.cell.isAlive = (neighbourCount == 3)
    }
}