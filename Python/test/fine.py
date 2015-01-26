import urllib2
import urllib

page = 1
for page in range(1,71):
	url = "http://www.pythontip.com/coding/ojRank?page="+str(page)
	res = urllib2.urlopen(url)
	page_content = res.read()
	if page_content.count("solomonsu_heng")>0:
		print "Is there:" + str(page)
		break;
	else:
		print "NOT ON Page:" + str(page)
