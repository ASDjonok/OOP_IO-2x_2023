console.log(2131 % 13)

class Room {
  constructor(price, ...toys) {
    this.toys = toys;
    this.price = price;
    if (this.getCurrentPrice() > price) throw new SyntaxError('We haven`t money for this');
  }

  addToy(toy) {
    if (this.getCurrentPrice() + toy.getPrice() <= this.price) this.toys.push(toy);
    else throw new SyntaxError('We haven`t money for this');
  }

  getCurrentPrice() {
    let sum = 0;
    for (const toy of this.toys) {
      sum += toy.getPrice();
    }
    return sum;
  }

  getSortedToysByPrice() {
    const sortedToys = this.toys.copyWithin();
    return sortedToys.sort((firstToy, secondToy) => {
      return firstToy.getPrice() - secondToy.getPrice();
    });
  }

  getToyByPrice(lowerPrice, upperPrice) {
    return this.toys.find((toy) => lowerPrice <= toy.getPrice() && toy.getPrice() <= upperPrice);
  }
}
class Toy {

  constructor(type, price, group) {
    this.type = type;
    this.price = price;
    this.group = group;
  }

  getPrice() {
    return this.price;
  }
}

class Car extends Toy {
  constructor(price, group) {
    super('car', price, group);
  }
}

class Ball extends Toy {
  constructor(price, group) {
    super('ball', price, group);
  }
}

class Doll extends Toy {
  constructor(price, group) {
    super('doll', price, group);
  }
}


const doll = new Doll(200, 'middle');
const ball = new Ball(150, 'young');
const car = new Car(300, 'old');
const room = new Room(1000, doll, ball, car);
console.log(room.getSortedToysByPrice())
console.log(room.getToyByPrice(201, 301));
