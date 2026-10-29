// COMP2850 Portfolio: Week 4
// ToDoList class

import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer

class ToDoList() {
    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size
    val notStarted get() = items.count { it.status == ItemStatus.NotStarted }
    val inProgress get() = items.count { it.status == ItemStatus.InProgress }
    val done get() = items.count { it.status == ItemStatus.Done }
    val overdue get() = items.count { it.isOverdue() }

    constructor(filename: String): this() {
        load(filename)
    }

    fun load(filename: String) {
        items.clear()
        Path(filename).forEachLine { line ->
            if (line.isNotBlank()) {
                val (dueDate, status, description) = line.split(": ", limit = 3)
                items.add(ToDoItem(LocalDate.parse(dueDate), ItemStatus.valueOf(status), description))
            }
        }
    }

    fun save(filename: String) {
        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) = item.forEach { items.add(it) }

    fun deleteDone(): Boolean {
        return items.removeAll { it.status == ItemStatus.Done }
    }

    fun getItems(status: ItemStatus? = null): List<ToDoItem> {
        return if (status == null) items.toList() else items.filter { it.status == status }
    }

    fun getItemsDueOn(date: LocalDate): List<ToDoItem> {
        return items.filter { it.dueDate == date }
    }
}
