//C11 = 2131%11 = 8; Визначити клас меблі, який складається як мінімум з 5-и полів.

//Створимо клас меблів
class Furniture{
  constructor({model, width, height, length, price}) {     //об'єкт класа буде створений на основі об'єкта для зручості, тому використовуємо деструктороване присвоєння, щоб не брати зайве.
    this.model = model;
    this.width = width;
    this.height = height;
    this.length = length;
    this.price = price;
  }
}

//Створимо об'єкти майбутніх об'єктів класу меблі

const chair = {
  model: 'chair',
  width: 1,
  length: 1,
  height: 1,
  price: 500,
};

const table = {
  model: 'table',
  width: 3,
  length: 2,
  height: 1.5,
  price: 1000,
};

const wardrobe = {
  model: 'wardrobe',
  width: 5,
  length: 1,
  height: 3,
  price: 750,
};

//Створимо масив що складається з об'єктів класу
const furniture = [new Furniture(wardrobe), new Furniture(chair), new Furniture(table)];

//Відсрортуємо масив за алфавітним порядком;
console.log(furniture.sort((first, second) => first.model > second.model ? 1 : first.model < second.model ? -1 : 0));
//Відсортуємл масив за ціною за спаданням
console.log(furniture.sort((first, second) => second.price - first.price));