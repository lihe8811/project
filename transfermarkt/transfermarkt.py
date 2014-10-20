#!/usr/bin/python

import os
import re
import sys
import json
import urllib2
import calendar

from datetime import date
from league import league
from BeautifulSoup import BeautifulSoup
from optparse import OptionParser


def getTargetPage(player_id):
    
    # prepare urllib2 request
    url = "http://www.transfermarkt.co.uk/jumplist/profil/spieler/" + player_id
    headers = {"User-Agent": "Mozilla/5.0 (Windows; U; Windows NT 5.1; it; rv:1.9.1) Gecko/20090624 Firefox/3.5",\
            "Referer": 'http://www.baidu.com'}

    request = urllib2.Request(url, headers=headers)
    write_flag = 0

    try:
        urllib2.urlopen(request)

    except urllib2.HTTPError as err:

        if err.code == 404:
            with open(os.getcwd() + '/missing_record', 'a') as outfile:
                outfile.write(player_id)
            write_flag = 1

        return False

    if write_flag == 0:
        with open(os.getcwd() + '/output_' + player_id + '.html', 'w') as outfile:
            outfile.write(urllib2.urlopen(request).read())

        return True

def parsePlayerProfile(player_id):
 
    with open(os.getcwd() + '/output_' + player_id + '.html', 'r') as infile:
        content = BeautifulSoup(infile.read(), convertEntities=BeautifulSoup.HTML_ENTITIES)

    get_league = content.find('select', {'id': 'wettbewerb_select_breadcrumb'}).find('option', {'selected': 'selected'}).text
    if get_league in league:
        
        number = re.sub('[^0-9]', '', content.find('div', {'class': 'rueckennummer-profil'}).text).encode('utf-8')
        name = content.find('div', {'class': 'spielername-profil'}).text.encode('utf-8')

        playerProfile = {}
        profile = content.findAll('table', {'class': ['auflistung', 'profilheader']})
        for each in profile:
            for th, td in zip(each.findChildren('th'), each.findChildren('td')):
                playerProfile[re.sub('[\t\n\r\f\v]+', '', th.text).encode('utf-8')] = re.sub('[\t\n\r\f\v]+', '', td.text).encode('utf-8')

        
        first_name, last_name = name.rsplit(' ', 1)
        print first_name, last_name

        for record in content.findAll('div', {'class': 'responsive-table'})[0].find('tbody').findAll('tr'):
            season, date = record.findAll('td', {'class': 'zentriert'})[0].text, record.findAll('td', {'class': 'zentriert'})[1].text
            seller = record.findAll('td', {'class': 'no-border-rechts zentriert'})[0].find('a')['title']
            buyer = record.findAll('td', {'class': 'no-border-rechts zentriert'})[1].find('a')['title']

            if seller != 'Unknown' and buyer != 'Unknown':
                print "%s: %s -> %s" % (season, seller, buyer)



        """

        first_name, last_name = name.rsplit(' ', 1)
        full_name = playerProfile['Complete name:'] if playerProfile.has_key('Complete name:') else name
        nation_display = playerProfile['Current\xc2\xa0National player:'] if playerProfile.has_key('Current\xc2\xa0National player:') else 'Unknown'
        city_of_birth = playerProfile['Place of birth:'] if playerProfile.has_key('Place of birth:') else 'Unknown'
        height = re.sub('[^0-9]', '', playerProfile['Height:']) if playerProfile.has_key('Height:') else 0
        prefer_foot = playerProfile['Foot:'] if playerProfile.has_key('Foot:') else 'Unknown'
        current_club = playerProfile['Current club:'] if playerProfile.has_key('Current club:') else 'Unknown'
        club_number = number

        month = int(list(calendar.month_abbr).index(playerProfile['Date of birth:'].split(',')[0].split(' ')[0]))
        day = int(playerProfile['Date of birth:'].split(',')[0].split(' ')[1])
        year = int(playerProfile['Date of birth:'].split(',')[1])

        date_of_birth = date(year, month, day)

        output = "%s\t%s\t%s\t%s\t%s\t" % (first_name, last_name, full_name, nation_display, city_of_birth)
        output += "%s\t%s\t%s\t%s\t%s\n" % (date_of_birth, height, prefer_foot, current_club, club_number)

        with open(os.getcwd() + '/player_profile', 'a') as outfile:
            outfile.write(output)
        """

def main(options):
    
    if getTargetPage(options.id):
        parsePlayerProfile(options.id)

if __name__ == '__main__':
    
    parser = OptionParser()
    parser.add_option("-i", "--id", 
                    action="store", type="string", dest="id")
    
    (options, args) = parser.parse_args()
    
    main(options)
    
