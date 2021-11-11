
###ImageMagick Installation:

[https://www.imagemagick.org/script/download.php#macosx](https://www.imagemagick.org/script/download.php#macosx)

###Generic command for batch convert:

```
find ./ -name "*.png" -exec convert {} -trim outputfolder/{} \;
```

###Command to overwrite files:

```
find ./ -name "*.png" -exec convert {} -trim ./{} \;
```

#####Source of commands: 

[https://askubuntu.com/questions/351767/how-to-crop-borders-white-spaces-from-image#351772](https://askubuntu.com/questions/351767/how-to-crop-borders-white-spaces-from-image#351772)