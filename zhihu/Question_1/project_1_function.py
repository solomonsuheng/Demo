#-*- coding:utf-8 -*-
'''
/**
 * Author         :   _Suheng
 * Email          :   gesuheng@gmail.com
 * Last modified  :   2015-06-03 23:07
 * Filename       :   project_1_function.py
 */
'''

import hashlib
import random

#print random 1000 dict
def printDict(randomDict):
	for (k,v) in randomDict.items():
		print str(v)

#get random 1000 dict
def getRandomDict(filePath):
	random1000 = {}
	f = open(filePath,'r')
	isEnd = 0
	while not isEnd and len(random1000.keys())<=1000:
		line = f.readline().strip('\n')
		if 2 < random.choice([1,2,3,4,5,6]):
			if line!='':
				linemd5 = hashlib.md5(line).hexdigest()
				random1000[linemd5] = line
			else:
				isEnd = 1
	f.close()
	return random1000
