/* Objetivo: Realizar uma soma e exibir na tela.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 18/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1001
 * Nome    : Extremamente Básico
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1001
 */

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	
	scanner.Scan()
	text1 := scanner.Text()
	num1, _ := strconv.Atoi(text1)

	scanner.Scan()
	text2 := scanner.Text()
	num2, _ := strconv.Atoi(text2)
	
	soma := num1 + num2
	fmt.Printf("X = %d\n", soma)
}