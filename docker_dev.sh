docker run --name software_tech_dev -it --rm -p 4001:4000 -v "$(pwd)":/srv/jekyll jekyll/jekyll:latest "/usr/jekyll/bin/jekyll" "serve"
docker stop software_tech_dev