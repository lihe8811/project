#!/usr/bin/env python2.7

# Copyright (c) 2013 @He Li.
# @author: He Li
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import multiprocessing
import time

def worker(num):
    """Worker calculate (input + 1).
    """
    pass
    
    time.sleep(20 - 2 * num)
    print (num + 1)

if __name__ == "__main__":
    pool = multiprocessing.Pool(processes = 5)
    result = []
    for i in range(5):
        result.append(pool.apply_async(worker, (i, )))
    pool.close()
    pool.join()