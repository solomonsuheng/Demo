package main

import "fmt"


func main(){
	fmt.Println("Please input the number of the Fahrenheit")
	var input float64
	fmt.Scanf("%f",&input)

	fmt.Println((input-32)*5.0/9)
}
