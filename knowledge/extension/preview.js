// Copyright (c) 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

chrome.runtime.onConnect.addListener(function(port) {
	console.assert(port.name == "contentscript");
	port.onMessage.addListener(function(msg) {
 		alert(msg.content);
	});
});