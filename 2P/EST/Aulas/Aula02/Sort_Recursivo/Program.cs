using System;
using System.Globalization;

namespace Sort_Iterativo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] a = new int[] { 1002, 1, 59, 10100, 45, 72, 2, 5 };
            Sort(a);
        }

        public static void Sort(int[] a)
        {
            Sort1(0, a);
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

            // Console.WriteLine(a);
        }

        private static void Min(int k, int[] a, ref int j)
        {
            if (k < a.Length)
            {
            }
            if (a[k] < a[j])
            {
                j = k;
            }
            Min(k + 1, a, ref j);
        }
    }
}