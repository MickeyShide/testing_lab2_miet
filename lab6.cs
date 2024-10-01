using System;
using System.Collections.Concurrent;
using System.Threading.Tasks;

class Program
{
    static void Main()
    {
        int N = 200000; // Верхняя граница диапазона чисел для разложения
        int numThreads = Environment.ProcessorCount; // Количество потоков равно количеству ядер процессора

        ConcurrentBag<string> results = new ConcurrentBag<string>(); // Для хранения результатов разложения

        Parallel.For(1, N + 1, new ParallelOptions { MaxDegreeOfParallelism = numThreads }, number =>
        {
            string factors = Factorize(number);
            results.Add($"{number}: {factors}");
        });

        // Вывод результатов
        foreach (var result in results)
        {
            Console.WriteLine(result);
        }
    }

    static string Factorize(int number)
    {
        string factors = "";
        int divisor = 2;

        while (number > 1)
        {
            if (number % divisor == 0)
            {
                factors += divisor + " ";
                number /= divisor;
            }
            else
            {
                divisor++;
            }
        }

        return factors.Trim();
    }
}
