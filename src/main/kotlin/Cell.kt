import com.google.gson.Gson
/*
Data class which holds information about state of cells
 */
data class Cell(var isAlive: Boolean) {
    /*
    provides a way to serialize and deserialize an array, so it doesn't reference the same objects.
    This is needed to perform operations on the copied array so information isn't lost in the process of changing state of individual cells.
     */
    fun deepCopy(): Cell {
        val json = Gson().toJson(this)
        return Gson().fromJson(json, Cell::class.java)
    }
}