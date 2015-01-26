from urllib2 import Request,urlopen,URLError,HTTPError

req = Request("http://localhost:8080/data.dodd")

try:
	response = urlopen(req)
except HTTPError,e:
	print 'The server could\'t fullfill the request.'
	print 'Error code: ',e.code
except URLError,e:
	print 'We failed to reach a server.'
	print 'Reason: ',e.reason
else:
	print 'No exception was raised.'
