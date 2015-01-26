import urllib2

request = urllib2.Request("http://localhost:8080/data.do")
request.add_header("User-Agent","I am WuYan bitch")
response = urllib2.urlopen(request)
print response.read()
