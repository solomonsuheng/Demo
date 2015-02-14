package main

import "fmt"


func main(){
	var x string = "hello"
	var y string = "world"
	fmt.Println(x==y)

	y = "hello"
	fmt.Println(x==y)

	y = `hello`
	fmt.Println(x==y)

	x = "hello\n"
	y = `hello\n`
	fmt.Println("x="+x)
	fmt.Println("y="+y)
	fmt.Println(x==y)
}
