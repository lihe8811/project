#!/usr/bin/env python2.7

# Copyright (c) 2013
# @author: He Li
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import os
import sys
import json
import common
import logging
import smtplib
import httplib2

from urllib import urlencode
from optparse import OptionParser
from oauth2client.client import OAuth2Credentials
from oauth2client.file import Storage
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText

logging.basicConfig()

def searchYoutube(maxResults, query):
    
    # Load Google OAuth 2.0 token & authorize http instance
    storage = Storage('youtube_token_file')
    credentials = storage.get()

    http = httplib2.Http()
    http.disable_ssl_certificate_validation = True
    http = credentials.authorize(http)

    # POST data feed message
    base_uri = "https://www.googleapis.com/youtube/v3/search?part=snippet"
    uri = '''%s&maxResults=%s&q=%s''' % (base_uri, maxResults, query)
    
    headers = {'Content-Type': 'application/json; charset=UTF-8'}
    resp, content = http.request(uri=uri, method='GET', headers=headers) 
    
    if resp["status"] == '200':
        return json.loads(content)
    else:
        print resp["status"]
        exit(1)

def sendEmail(video_url, video_title):
    
    sender = "lihewp@gmail.com"
    recipient = "lihewp@gmail.com"
    subject = video_title
    
    message = MIMEMultipart('alternative')
    message['Subject'], message['From'], message['To'] = subject, sender, recipient
    body = MIMEText(video_url, 'html')
    message.attach(body)
    
    s = smtplib.SMTP('smtp.gmail.com:587')
    s.starttls()
    s.login(common.username, common.password)
    
    s.sendmail(sender, recipient, message.as_string())
    s.quit()

def main(options):
    
    response = searchYoutube(options.maxResults, options.query)
    for each in response["items"]:
        video_url = "http://www.youtube.com/watch?v=%s" % each["id"]["videoId"]
        video_title = each["snippet"]["title"]
        sendEmail(video_url, video_title)

if __name__ == '__main__':

    parser = OptionParser()
    parser.add_option("-q", "--query",
                        action="store", type="string", dest="query")
    parser.add_option("-m", "--maxResult",
                        action="store", type="string", dest="maxResults")
    
    (options, args) = parser.parse_args()

    main(options)
