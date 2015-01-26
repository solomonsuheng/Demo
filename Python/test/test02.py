import urllib2
import urllib

url = 'http://localhost:8080/data.do'

values = {'name':'asdmin','pwd':'admin'}

data = urllib.urlencode(values)
req = urllib2.Request(url,data)
response = urllib2.urlopen(req)
the_page = response.read()

print the_page
