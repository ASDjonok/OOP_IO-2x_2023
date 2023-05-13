package OOP.Java.lab_4

class Furniture(val name: String, val material: String, val price: Int, val length: Int, val width: Int, val height: Int) {
    fun print(nameWidth: Int, materialWidth: Int, priceWidth: Int){
        print("Furniture stats: {")
        print("Name: ${this.name.padEnd(nameWidth)}   ")
        print("Material: ${this.material.padEnd(materialWidth)}   ")
        print("Price: ${(this.price.toString() + " cu").padEnd(priceWidth + 3)}   ")
        print("Size: ${this.length}×${this.width}×${this.height}};\n")
    }
}