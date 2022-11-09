
class Engine(val cell: Cell) {
    fun stateChanger(neihbourCount:Int){
        cell.isAlive = true
    }
}