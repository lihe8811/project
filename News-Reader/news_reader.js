var ECONOMIST = 'www.economist.com';
var GOOGLE = 'www.google.com';
var SEARCH = 'http://www.google.com/#safe=off&q=';
var LOG_TAG = 'LOGGER:';

if (window.location.hostname == ECONOMIST) {
  var articles = document.getElementsByTagName('article')
  for (i = 0; i < articles.length; i++) {
    var anchor = articles[i].getElementsByTagName('a')[0];
    if (anchor.hasAttribute('href')) {
      var link = SEARCH + anchor.href;
      anchor.setAttribute('href', link);
    }
  }
  console.log(LOG_TAG.concat('All the articles are processed.'));
} else if (window.location.hostname == GOOGLE) {
  var referrer = document.referrer.replace(
      /http[s]*:/g, '').replace(/\/*/g, '');
  if (referrer == ECONOMIST) {
    var target = document.getElementsByClassName('r')[0].firstElementChild;
    var click = document.createEvent('MouseEvents');
    click.initMouseEvent('click', true, true, window, 0, 0, 0, 0, 0,
      false, false, false, false, 0, null);
    target.dispatchEvent(click);
    console.log(LOG_TAG.concat('Success. Enjoy reading.'));
  }
}
