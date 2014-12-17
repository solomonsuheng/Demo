#coding=utf8

try:
	fh = open("test","w")
	fh.write("he")
except IOError:
	print "Error cant find it"
else:
	print "Written success"
	fh.close()
