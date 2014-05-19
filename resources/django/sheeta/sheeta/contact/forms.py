from django import forms

# Define your classes here.
class ContactForm(forms.Form):
    subject = forms.CharField(max_length = 100)
    email = forms.EmailField(required = False)
    message = forms.CharField(widget = forms.Textarea)
    
    def clean_message(self):
        message = self.cleaned_data['message']
        num = len(message.split())
        if num < 4:
            raise forms.ValidationError("Comment too short.")
        
        return message