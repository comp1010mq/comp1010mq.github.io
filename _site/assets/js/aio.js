function aio(collectionURLs) {
    var xmlHttp = [];  /* Required since we are going to query every episode. */
    for (i=0; i < collectionURLs.length; i++) {
      xmlHttp[i] = new XMLHttpRequest();
      xmlHttp[i].episode = collectionURLs[i];  /* To enable use this later. */
      xmlHttp[i].onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        var article_here = document.getElementById(this.episode);
        var parser = new DOMParser();
        var htmlDoc = parser.parseFromString(this.responseText,"text/html");
        var htmlDocArticle = htmlDoc.getElementsByTagName("article")[0];
        article_here.innerHTML = htmlDocArticle.innerHTML;
        }
      }
      episode_url = collectionURLs[i];
      xmlHttp[i].open("GET", episode_url);
      xmlHttp[i].send(null);
    }

}
