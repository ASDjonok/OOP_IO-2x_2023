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
        // Create a list of Wagons
        List<Wagons> wagons = new List<Wagons>();

        // Add some wagons to the list
        wagons.Add(new Wagons.PassengerWagons("Пасажирський", 100, 100, "Вищий", 10));
        wagons.Add(new Wagons.PassengerWagons("Пасажирський", 50, 48, "Середнiй", 20));
        wagons.Add(new Wagons.PassengerWagons("Пасажирський", 20, 15, "Низький", 30));
        wagons.Add(new Wagons.FreightWagons("Вантажний", 10, 10));
        wagons.Add(new Wagons.FreightWagons("Вантажний", 20, 20));
        wagons.Add(new Wagons.FreightWagons("Вантажний", 30, 30));

        // Display the list of wagons
        Console.WriteLine("Усi вагони:");

        foreach (Wagons wagon in wagons)
        {
            Console.WriteLine(wagon.GetType() + ": " + wagon.GetPassengers() + " пасажирiв(-а), " + wagon.GetBaggage() +
                              " валiз/контейнерiв, " + wagon.GetComfort() + ", " + wagon.GetAmount() + ";");
        }

        int amountOfPassangers = 0;
        foreach (Wagons p in wagons)
        {
            amountOfPassangers += p.GetPassengers();
        }

        //Array.Sort(wagons, Comparer<Wagons>.Create((x, y) => x.GetComfort.CompareTo(y.GetComfort())));

        var sorted = wagons.OrderByDescending(ob => ob.GetComfort()).ToArray();
        
        Console.WriteLine("\nКiлькiсть пасажирiв у пасажирському вагонi: " + amountOfPassangers + ";");
        Console.WriteLine("\nВеддiть мiнiмальну кiлькiсть пасажирiв: ");
        var minPassangers = Convert.ToInt32(Console.ReadLine());
        Console.WriteLine("Веддiть максимальну кiлькiсть пасажирiв: ");
        var maxPassangers = Convert.ToInt32(Console.ReadLine());
        foreach (Wagons t in wagons)
        {
            if (t.GetPassengers() != null && t.GetPassengers() >= minPassangers && t.GetPassengers() <= maxPassangers)
            {
                Console.Write(t.GetType() + " - " + t.GetPassengers()+"; ");
            }
            else
            {
                throw (new InvalidOperationException("Немає такого вагону;"));
                break;
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

        public Wagons(string type, int? passengers, int? baggage, string comfort, int amount)
        {
            this.type = type;
            this.passengers = Convert.ToInt32(passengers);
            this.baggage = Convert.ToInt32(baggage);
            this.comfort = comfort;
            this.amount = amount;
        }

        public string GetType()
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

        // підклас Пасажирський вагон
        public class PassengerWagons : Wagons
        {
            public PassengerWagons(string type, int passengers, int baggage, string comfort, int amount) : base(type,
                passengers, baggage, comfort, amount)
            {
            }
        }

        // підклас Вантажний вагон
        public class FreightWagons : Wagons
        {
            public FreightWagons(string type, int baggage, int amount) : base(type, null, baggage, null, amount)
            {
            }
        }
    }
}
