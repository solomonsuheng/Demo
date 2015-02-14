package main

import "fmt"

func main(){
	var i int = 2
	switch i{
	case 0: fmt.Println("Zero")
	case 1: fmt.Println("One")
	case 2: fmt.Println("Two")
	default: fmt.Println("Unknow")
	}
}
