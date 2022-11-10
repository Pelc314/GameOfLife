class Engine(private val cell: Cell) {
    fun stateChanger(neighbourCount: Int) {
        if (cell.isAlive) this.cell.isAlive = (neighbourCount == 2 || neighbourCount == 3)
        else this.cell.isAlive = (neighbourCount == 3)
    }
}