a = 123

s = str(bin(a))

print s

count = 0
for ss in s:
	if ss=='1':
		count += 1
	
print count
