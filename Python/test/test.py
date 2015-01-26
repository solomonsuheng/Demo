# -*- coding:utf-8 -*-
ans = "中国"
print ans.decode("utf8")

numlist = ["零","壹","贰","叁","肆","伍","陆","柒","捌","玖"]
dwlist = ["佰","仟","万"]
negative = "负"
dicNum = {}
for i in range(0,10):
	dicNum[str(i)]=numlist[i]
dicNum["-"] = negative
print dicNum
print negative
print dwlist[1].decode("utf8")
print numlist[1].decode("utf8")

def getTrans(s):
	return dicNum[s] 

a = -1234212
result = []
for s in str(a):
	result.append(getTrans(s))

c = ''.join(result)
print a,c+"圆"
