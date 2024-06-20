using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EXC_Arvores
{
    public class Arvore<T>
    {
        private No<T> raiz = null;
        public No<T> Raiz { get => raiz; set => raiz = value; }
    }
}