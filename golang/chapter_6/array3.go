package main

import "fmt"

func main(){
	x := [6]float64{98,93,77,82,83}
	//	var x [5]float64 = [5]float64{98,93,77,82,83}

	var total float64 = 0
	for i,value := range x {
		total += value
		fmt.Println(x[i])
	}

	fmt.Println(total/float64(len(x)))
}
