from django.conf.urls import patterns, include, url

# Uncomment the next two lines to enable the admin:
from django.contrib import admin
admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'sheeta.views.home', name='home'),
    # url(r'^sheeta/', include('sheeta.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    url(r'^admin/', include(admin.site.urls)),
)

urlpatterns += patterns('sheeta.views',
    url(r'^date/$', 'dateToday'),
)

urlpatterns += patterns('sheeta.books.views',
    url(r'^search-form/$', 'search_form'),
    url(r'^search/$', 'search'),
)

urlpatterns += patterns('sheeta.contact.views',
    url(r'^contact-us/$', 'contact'),
)
