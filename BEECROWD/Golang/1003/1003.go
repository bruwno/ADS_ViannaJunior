/* Objetivo: Ler dois valores inteiros, realizar a soma e exibir na tela.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 12/03/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1003
 * Nome    : Soma Simples
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1003
 */

package main

import (
	"fmt"
)

func main() {
	var a, b int
	fmt.Scan(&a, &b)
	fmt.Printf("SOMA = %d\n", a+b)
}

// SOLUÇÃO USANDO bufio
// package main

// import (
// 	"bufio"
// 	"fmt"
// 	"os"
// 	"strconv"
// )

// func main() {
// 	scanner := bufio.NewScanner(os.Stdin)

// 	scanner.Scan()
// 	a, _ := strconv.Atoi(scanner.Text())

// 	scanner.Scan()
// 	b, _ := strconv.Atoi(scanner.Text())

// 	var sum int = a + b

// 	fmt.Printf("SOMA = %d\n", sum)
// }

// SOLUÇÃO INCOMPATÍVEL COM Go 1.20
// package main

// import (
// 	"bufio"
// 	"fmt"
// 	"os"
// 	"strconv"
// )

// func main() {
// 	scanner := bufio.NewScanner(os.Stdin)
// 	sum := 0

// 	values := [2]int{}
// 	for i := range 2 {
// 		scanner.Scan()
// 		values[i], _ = strconv.Atoi(scanner.Text())
// 	}

// 	for j := range len(values) { // Beecrowd usa Go 1.20, icompatível com essa sintaxe.
// 		sum += values[j]
// 	}

// 	fmt.Printf("SOMA = %d\n", sum)
// }
