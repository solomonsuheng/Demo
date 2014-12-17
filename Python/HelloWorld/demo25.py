#coding=utf8

def printinfo(name,age=20):
	"打印任何传入的字符串"
	print "Name:",name
	print "Age:",age
	return

def printsuperinfo(name,*param):
	"打印任何传入的参数"
	print "Name:",name
	print type(param)
	for var in param:
		print var
	return


printinfo(age=20,name='a')
printinfo("Ge")

printsuperinfo("ge",1,2,3,4,5,"asd")
