import urllib2
import urllib

data = {"TextBox1":"41009050201","TextBox2":"81979197","RadioButtonList1":"2","Button1":"","lbLanguage":"","__VIEWSTATE":"dDwtMTcyNDQ4MTQ0ODs7PpKYCWhcxjpbo8FvrJR9siL4DQwX"}

postdata = urllib.urlencode(data)
url = "http://202.200.206.54/(ufiiyvrxlcebaq45o0tzflis)/Default2.aspx"
req = urllib2.Request(url,postdata)
result = urllib2.urlopen(req)
print result.read()
