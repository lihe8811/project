#!/usr/bin/python

from django.http import HttpResponse
import datetime

def myClock(request):
  time = datetime.datetime.now()
  html = "<html><body>Time: %s</body></html>" % time
  return HttpResponse(html)
