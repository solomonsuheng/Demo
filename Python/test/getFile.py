file_object = open("CommentWordCount.java")

file_content = file_object.read()
print type(file_content) 
print file_content.count(";")


