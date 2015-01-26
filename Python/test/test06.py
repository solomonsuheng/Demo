import urllib2

old_url = 'http://localhost:8080/data.do'
req = urllib2.Request(old_url)
response = urllib2.urlopen(req)
print "old_url: "+old_url
print response.geturl()
