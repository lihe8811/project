from django.shortcuts import render_to_response
from django.http import HttpResponseRedirect
from django.core.mail import send_mail
from sheeta.contact.forms import ContactForm

# Create your views here.
def contact(request):
    
    errors = []
    if request.method == 'POST':
        form = ContactForm(request.POST)
        
        if form.is_valid():
            data = form.cleaned_data
            send_mail(data['subject'],
                    data['message'],
                    data.get('email', 'noreply@example.com'),
                    ['siteowner@example.com'],)
            return HttpResponseRedirect('/contact/thanks/')
    else:
        form = ContactForm()
            
    return render_to_response('contact_form.html', locals())
    