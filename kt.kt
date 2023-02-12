data class Item(val weight: Int, val value: Int)

fun knapsack(items: List<Item>, capacity: Int): Int {
    // Sorting the items by value/weight ratio in descending order
    val sortedItems = items.sortedWith(compareByDescending<Item> { it.value.toDouble() / it.weight })
    var totalValue = 0
    var totalWeight = 0
    for (item in sortedItems) {
        if (totalWeight + item.weight <= capacity) {
            totalValue += item.value
            totalWeight += item.weight
        }
    }
    return totalValue
}

fun main() {
    val items = listOf(Item(2, 3), Item(3, 4), Item(4, 5), Item(5, 6))
    val capacity = 5
    println("The maximum value that can be obtained is: ${knapsack(items, capacity)}")
}
