using System;

namespace Sort_Recursivo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] a = new int[] { 59, 10100, 72, 2 };
            Sort(a);

            foreach (int num in a)
            {
                Console.Write(num + " ");
            }
        }

        public static void Sort(int[] a)
        {
            Sort1(0, a);
        }

        private static void Min(int k, int[] a, ref int j)
        {
            if (k < a.Length)
            {
                if (a[k] < a[j])
                {
                    j = k;
                }
                Min(k + 1, a, ref j);
            }
        }

        private static void Sort1(int i, int[] a)
        {
            int j, t;

            if (i < (a.Length - 1))
            {
                j = i;
                Min(i + 1, a, ref j);
                t = a[i];
                a[i] = a[j];
                a[j] = t;
                Sort1(i + 1, a);
            }
        }
    }
}