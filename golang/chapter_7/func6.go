package main

import "fmt"

func main(){
	fmt.Println(add(1,2,3))

	xs:=[]int{1,2,3}
	fmt.Println(add(xs...))
}

func add(args ...int) int{
	total := 0
	for _,value := range args{
		total += value
	}

	return total
}
