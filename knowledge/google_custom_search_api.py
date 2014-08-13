#!/usr/bin/env python2.7

# Copyright (c) 2014.
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

from apiclient.discovery import build
from optparse import OptionParser

def customSearch(query):
	
	service = build("customsearch", "v1", developerKey = "AIzaSyCI8c7V-N1DoMZCArEKF0Cp8dojA90CXdY")
	cx = "011147251020824654611:sjnxu8vwige"

	res = service.cse().list(
		q = query,
		cx = cx
		).execute()

	return res

def main(options):
    
    response = customSearch(options.query)

    with open(os.getcwd() + '/output', 'w') as outfile:
    	json.dump(response, outfile)
    
if __name__ == '__main__':

    parser = OptionParser()
    parser.add_option("-q", "--query",
                        action="store", type="string", dest="query")
    
    (options, args) = parser.parse_args()

    main(options)
