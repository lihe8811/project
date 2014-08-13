#!/usr/bin/python

import os
import re
import sys
import json
import urllib2

from BeautifulSoup import BeautifulSoup
from optparse import OptionParser


def getTargetPage(player_id):
    
    # prepare urllib2 request
    url = "http://www.transfermarkt.co.uk/jumplist/profil/spieler/" + player_id
    headers = {"User-Agent": "Mozilla/5.0 (Windows; U; Windows NT 5.1; it; rv:1.9.1) Gecko/20090624 Firefox/3.5",\
            "Referer": 'http://www.baidu.com'}

    request = urllib2.Request(url, headers=headers)

    # save webpage
    with open(os.getcwd() + '/output_' + player_id + '.html', 'w') as outfile:
        outfile.write(urllib2.urlopen(request).read())

def parsePlayerProfile(player_id):
    
    with open(os.getcwd() + '/output_' + player_id + '.html', 'r') as infile:
        content = BeautifulSoup(infile.read(), convertEntities=BeautifulSoup.HTML_ENTITIES)
    
    number = re.sub('[^0-9]', '', content.find('div', {'class': 'rueckennummer-profil'}).text)
    name = content.find('div', {'class': 'spielername-profil'}).text

    playerProfile = {}
    profile = content.findAll('table', {'class': ['auflistung', 'profilheader']})
    for each in profile:
        for th, td in zip(each.findChildren('th'), each.findChildren('td')):
            playerProfile[re.sub('[\t\n\r\f\v]+', '', th.text)] = re.sub('[\t\n\r\f\v]+', '', td.text)
    
    print playerProfile

    for record in content.findAll('div', {'class': 'responsive-table'})[0].find('tbody').findAll('tr'):
        season, date = record.findAll('td', {'class': 'zentriert'})[0].text, record.findAll('td', {'class': 'zentriert'})[1].text
        seller = record.findAll('td', {'class': 'no-border-rechts zentriert'})[0].find('a')['title']
        buyer = record.findAll('td', {'class': 'no-border-rechts zentriert'})[1].find('a')['title']

        print "%s: %s -> %s" % (season, seller, buyer)

def main(options):
    
    getTargetPage(options.id)
    parsePlayerProfile(options.id)

if __name__ == '__main__':
    
    parser = OptionParser()
    parser.add_option("-i", "--id", 
                    action="store", type="string", dest="id")
    
    (options, args) = parser.parse_args()
    
    main(options)
    
