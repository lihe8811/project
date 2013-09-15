#!/usr/bin/python
from django.conf.urls.defaults import *
from myTestSite.view import *

# Uncomment the next two lines to enable the admin:
# from django.contrib import admin
# admin.autodiscover()

urlpatterns = patterns('',
    # Examples:
    # url(r'^$', 'myTestSite.views.home', name='home'),
    # url(r'^myTestSite/', include('myTestSite.foo.urls')),

    # Uncomment the admin/doc line below to enable admin documentation:
    # url(r'^admin/doc/', include('django.contrib.admindocs.urls')),

    # Uncomment the next line to enable the admin:
    # url(r'^admin/', include(admin.site.urls)),

    ('^clock/$', myClock),
)
