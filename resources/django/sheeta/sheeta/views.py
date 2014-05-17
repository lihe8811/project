from django.shortcuts import render_to_response
from datetime import date

def dateToday(request):
    
    day = date.today()
    
    # Set up templateand context
    template = 'date.html'
    
    return render_to_response(template, locals())
