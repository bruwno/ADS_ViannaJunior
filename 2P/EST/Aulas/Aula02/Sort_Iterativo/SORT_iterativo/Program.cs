using System;

namespace SORT_iterativo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] a = new int[] { 10, 5, 44, 1002, 17, 21 };
            Sort(a);
        }

        public static void Sort(int[] a)
        {
            int i, j, k, t;

            for (i = 0; i < (a.Length - 1); i++)
            {
                j = i;
                for (k = (i + 1); k < a.Length; k++)
                {
                    if (a[k] < a[j])
                    {
                        j = k;
                    }
                    t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }

            for (int z = 0; z < a.Length; z++)
            {
                Console.WriteLine(a[z]);
            }
        }
    }
}
