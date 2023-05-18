using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Furniture
    {
        // 5 полів
        private string type;
        private string material;
        private string color;
        private int price;
        private int amount;

        // конструктор з атрибутами
        public Furniture(string type, string material, string color, int price, int amount)
        {
            this.type = type;
            this.material = material;
            this.color = color;
            this.price = price;
            this.amount = amount;
        }

        // методи для повернення атрибутів
        public string getType()
        {
            return type;
        }

        public string getMaterial()
        {
            return material;
        }

        public string getColor()
        {
            return color;
        }

        public int getPrice()
        {
            return price;
        }

        public int getAmount()
        {
            return amount;
        }

        public static void Main(string[] args)
        {

            Furniture[] furnitureArr = {
                new Furniture("шафа", "дерево", "коричневий", 5000, 2),
                new Furniture("стiл", "скло", "чорний", 3000, 3),
                new Furniture("лiжко", "метал", "срiблястий", 8000, 1),
                new Furniture("диван", "тканина", "сiрий", 10000, 2),
                new Furniture("стiлець", "метал", "синій", 500, 4)
            };


            // Сортування масиву за ціною за зростанням
            var sorted = furnitureArr.OrderBy(ob => ob.price).ToArray();
            // Вивести відсортований масив
            Console.WriteLine("Вiдсортований за цiною (за зростанням):");
            foreach (Furniture f in sorted)
            {
                Console.WriteLine(f.getType() + " - " + f.getPrice() + " грн;");
            }
            Console.WriteLine(' ');
            // Сортування масиву за кількістю за спаданням
            var sortedReversery = furnitureArr.OrderBy(ob => ob.amount).ToArray().Reverse();
            // Вивести відсортований масив
            Console.WriteLine("Вiдсортований за кiлькiстю (за спаданням):");
            foreach (Furniture f in sortedReversery)
            {
                Console.Write($"{f.getType()} - {f.getAmount()}; " );
            }
            Console.WriteLine(' ');
        }
    }
}