package main

import "fmt"

func main(){
	add := func(x int,y int) int{
		return x+y
	}

	fmt.Println(add(1,1))
}
