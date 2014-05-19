from django.shortcuts import render_to_response
from sheeta.books.models import Book

# Create your views here.
def search(request):
    
    errors = []
    
    if 'query' in request.GET:
        query = request.GET['query']
        
        if not query:
            errors.append('Enter a search term.')
        elif len(query) > 20:
            error.append('Please enter at most 20 characters.')
        
        books = Book.objects.filter(title__icontains = query)
        
        template = 'search_result.html'
        return render_to_response(template, locals())
    else:
        error = True
        return render_to_response('search_form.html', locals())

def search_form(request):
    
    return render_to_response('search_form.html')
