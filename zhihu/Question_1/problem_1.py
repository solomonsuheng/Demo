#-*- coding:utf-8 -*-
'''
/**
 * Author         :   _Suheng
 * Email          :   gesuheng@gmail.com
 * Last modified  :   2015-06-03 23:06
 * Filename       :   test.py
 */
'''

import project_1_function

'''
这段程序的思想如下:
	1.程序通过一行行从输入文件的文件路径对文件进行逐行读取，这样不会因为数据过大导致内存崩了
	2.通过判断读取的行是否为''判断是否文件读取完毕了（这里设置这个是因为使用了一个随机的random用来决定着一行读取还是不读取，达到题目要求的随机读取，这里设定的是2/3概率读取，可以通过设置[1,2,3,4,5,6]进行设置不同的概率）
	3.对于每一行读取的数据，使用迅雷下载文件的那种检验文件是否一致的方式(md5)对读取的行进行md5获取的值作为key,之后在将整行作为value存放到random1000的字典中

	＊程序中没有进行错误或者非法输入的检查，是程序还能够改进的地方
'''

#filePath = raw_input("please input the file path for me:")#You can delete this line for your own input file path, ^-^
filePath = "/Users/gesuheng/WorkSpace/testWorkSpace/zhihuProject/readme"

random1000 = project_1_function.getRandomDict(filePath)
project_1_function.printDict(random1000)
