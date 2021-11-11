bundle exec jekyll build
scp -v -r -P 2683 -i ~/.ssh/lappy _site/* mattrnet@s03cd.syd6.hostingplatform.net.au:~/public_html
