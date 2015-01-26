#author GeSuheng

file_object = open('CommentWordCount.java')

num_count = 0
for line in file_object:
	num_count += 1
	print "Line " + str(num_count) + ": " + line
