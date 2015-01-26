import urllib2
import urllib

url = "http://localhost:8080/data.do?pwd=admin&name=admin"

req = urllib2.urlopen(url)
print "This is a Get Request", req.read()


url = "http://localhost:8080/data.do"
values = {'name':'admin','pwd':'admin'}
values = urllib.urlencode(values)
req = urllib2.Request(url,values)
response = urllib2.urlopen(req)
print "This is a Post Request",response.read()

print "_________,_______"
print values
req = urllib2.urlopen(url,values);
print req.read()
