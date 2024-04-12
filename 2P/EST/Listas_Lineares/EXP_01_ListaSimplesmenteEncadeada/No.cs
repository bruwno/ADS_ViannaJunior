using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EXP_01_ListaSimplesmenteEncadeada
{
    public class No
    {
        private No proximo = null;

        public int Valor { get; set; }
        public No Proximo { get => proximo; set => proximo = value; }
    }
}