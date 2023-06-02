using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Formats.Asn1;

// Визначити ієрархію рухомого складу залізничного транспорту.Створити пасажирський потяг.Порахувати загальну чисельність пасажирів і багажу в потязі.
// Провести сортування вагонів потягу за рівнем комфортності. Знайти вагон в потязі, що відповідає заданому діапазону кількості пасажирів.


class Lab6
{
    public static void Main(string[] args)
    {
        List<Wagons> wagons = new List<Wagons>(); //створюємо лист-список вагонів;                      

        // Додаємо вагони за допомогою класу Wagons;
        wagons.Add(new Wagons.PassengerWagons("Пасажирський", 100, 100, "Вищий", 10));
        wagons.Add(new Wagons.PassengerWagons("Пасажирський", 50, 48, "Середнiй", 20));
        wagons.Add(new Wagons.PassengerWagons("Пасажирський", 20, 15, "Низький", 30));
        wagons.Add(new Wagons.FreightWagons("Вантажний", 10, 10));
        wagons.Add(new Wagons.FreightWagons("Вантажний", 20, 20));
        wagons.Add(new Wagons.FreightWagons("Вантажний", 30, 30));

        
        Console.WriteLine("Усi вагони:");  //відображення всіх вагонів;

        foreach (Wagons wagon in wagons)
        {
            Console.WriteLine(wagon.GetType() + ": " + wagon.GetPassengers() + " пасажирiв(-а), " + wagon.GetBaggage() +
                              " валiз/контейнерiв, " + wagon.GetComfort() + ", " + wagon.GetAmount() + ";");
        }

        int amountOfPassangers = 0;  //обчислення загальної кількості пасажирів;
        foreach (Wagons p in wagons)
        {
            amountOfPassangers += p.GetPassengers();
        }

        var sorted = wagons.OrderByDescending(ob => ob.GetComfort()).ToArray(); //сортування вагонів за рівнем комфорту;
        
        Console.WriteLine("\nКiлькiсть пасажирiв у пасажирському вагонi: " + amountOfPassangers + ";");
        Console.WriteLine("\nВеддiть мiнiмальну кiлькiсть пасажирiв: ");
        var minPassangers = Convert.ToInt32(Console.ReadLine());
        Console.WriteLine("Веддiть максимальну кiлькiсть пасажирiв: ");
        var maxPassangers = Convert.ToInt32(Console.ReadLine());
        foreach (Wagons t in wagons)
        {
            if (t.GetPassengers() != null && t.GetPassengers() >= minPassangers && t.GetPassengers() <= maxPassangers) //пошук вагону за кількістю пасажирів;
            {
                Console.Write(t.GetType() + " - " + t.GetPassengers()+"; ");
            }
            else
            {
                throw (new InvalidOperationException("Немає такого вагону;"));
                
            }

        }

    }

    class Wagons
    {
        private string type; // тип вагону
        private int passengers; // кількість пасажирів
        private int baggage; // кількість багажу в тоннах
        private string comfort; // рейтиг комфорту вагону
        private int amount; // кількість вагонів

        public Wagons(string type, int? passengers, int? baggage, string comfort, int amount)   //конструктор вагонів;
        {
            this.type = type;
            this.passengers = Convert.ToInt32(passengers);
            this.baggage = Convert.ToInt32(baggage);
            this.comfort = comfort;
            this.amount = amount;
        }

        public string GetType()         //геттери атрибутів класу;
        {
            return type;
        }

        public int GetPassengers()
        {
            return passengers;
        }

        public int? GetBaggage()
        {
            return baggage;
        }

        public string GetComfort()
        {
            return comfort;
        }

        public int GetAmount()
        {
            return amount;
        }

        // підклас Пасажирський вагон який наслідує батьківський клас Вагони;
        public class PassengerWagons : Wagons
        {
            public PassengerWagons(string type, int passengers, int baggage, string comfort, int amount) : base(type,
                passengers, baggage, comfort, amount)
            {
            }
        }

        // підклас Вантажний вагон який наслідує батьківський клас Вагони;
        public class FreightWagons : Wagons
        {
            public FreightWagons(string type, int baggage, int amount) : base(type, null, baggage, null, amount)
            {
            }
        }
    }
}
