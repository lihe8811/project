#!/usr/bin/env python2.7

# Copyright (c) 2013 @WalmartLabs.
# @author: He Li
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import os
import sys
from oauth2client.client import flow_from_clientsecrets
from oauth2client.file import Storage

SCOPE = 'https://www.googleapis.com/auth/youtube'
APPLICATION_REDIRECT_URI = 'http://localhost' 

FLOW = flow_from_clientsecrets(
    'client_secrets.json', scope = SCOPE, 
    redirect_uri = APPLICATION_REDIRECT_URI)

authorize_url = FLOW.step1_get_authorize_url()

code = "4/ReO4V2TXptfWn6lNQlETr4MPuDhN.oonKC1_uwmYYMqTmHjyTFGNuoefGjQI"

credentials = FLOW.step2_exchange(code)
storage = Storage('youtube_token_file')
storage.put(credentials)
