import urllib2


url = "http://www.baidu.com"
req = urllib2.Request(url)
response = urllib2.urlopen(req)
data = response.info()
print data["Date"]
