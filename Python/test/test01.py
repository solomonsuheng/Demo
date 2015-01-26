import urllib2

req = urllib2.Request('http://localhost:8080/index.jsp')
response = urllib2.urlopen(req)
the_page = response.read()
print the_page
