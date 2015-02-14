package main

import "fmt"

func makeEventGenerator() func() uint{
	i := uint(0)
	return func() (ret uint){
		ret = i
		i += 2
		return 
	}
}

func main(){
	nextEvent := makeEventGenerator()
	fmt.Println(nextEvent())
	fmt.Println(nextEvent())
	fmt.Println(nextEvent())
}
