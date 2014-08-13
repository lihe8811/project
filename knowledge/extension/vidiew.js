// Copyright (c) 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

$(document).ready(function(){

	// prepare document style
	document.documentElement.style.height = '100%';
	document.body.style.height = '100%';
	document.documentElement.style.width = '100%';
	document.body.style.width = '100%';

	// setup vidiew button
	var btn = document.createElement('a');

	btn.id = 'vidiewButton';
	btn.class = 'round-button';
	btn.href = chrome.extension.getURL('preview.html');
	btn.target = '_blank';

	$('a#CartBtnLink').after(btn);
	
	// setup button image
	var image = document.createElement('img');

	image.id = 'vidiewImage';
	image.src = chrome.extension.getURL('Icon-20X20.png');
	$('a#vidiewButton').append(image);

	// test message communication
	if ($('h1.productTitle').length) {
		var product = $('h1.productTitle').html();

		var port = chrome.runtime.connect({name: "contentscript"});
		port.postMessage({content: product});
	}
});