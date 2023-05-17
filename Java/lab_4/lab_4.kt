package OOP.Java.lab_4

fun main() {
    val furnitureArray = arrayOf(
        Furniture("Chair", "Wood", 10, 5, 5, 10),
        Furniture("Counter-top", "Marble", 1_000, 10, 5, 1),
        Furniture("Dinner table", "Glass", 500, 15, 10, 1),
        Furniture("Office table", "Wood", 200, 10, 7, 1),
        Furniture("Refrigerator", "Stainless steel", 20_000, 8, 4, 10)
    )

    val maxNameWidth = furnitureArray.maxWith(Comparator.comparingInt { it.name.length }).name.length
    val maxMaterialWidth = furnitureArray.maxWith(Comparator.comparingInt { it.material.length }).material.length
    val maxPriceWidth = furnitureArray.maxWith(Comparator.comparingInt { it.price }).price.toString().length

    println("\nUnsorted array:")
    for (item in furnitureArray) item.print(maxNameWidth, maxMaterialWidth, maxPriceWidth)

    println("\nSorted alphabetically by name:")
    furnitureArray.sortBy { it.name }
    for (item in furnitureArray) item.print(maxNameWidth, maxMaterialWidth, maxPriceWidth)

    println("\nSorted alphabetically by material:")
    furnitureArray.sortBy { it.material }
    for (item in furnitureArray) item.print(maxNameWidth, maxMaterialWidth, maxPriceWidth)
}