import re
import glob

counter = 0

def fixImgTag(path):
    file = open(path, 'r')
    content = file.read()

    print(path)
    p = re.compile(r'(\\<img)(.*?)(/\\>)', re.DOTALL)

    fileName = path[path.find('/') + 1: path.rfind('/')] # Find middle folder name - will match fig name

    def fixedImg(m): # Dirty solution for sequential file numbering
        m = m.group(0).replace("“", "\"")
        m = m.replace("”", "\"")
        return (m[1:])[:-3] + '/>'


    content = re.sub(p, fixedImg, content)

    # Additional cleaning

    p = re.compile(r'(0.1cm|0.5cm|\.{3})', re.DOTALL)
    content = re.sub(p, '<p> &nbsp; </p>', content)

    file.close()

    newFileName = path[path.rfind('/') + 1:]
    file = open('outputMD/{}'.format(newFileName), 'w+')
    file.write(content)
    file.close()


for filename in glob.iglob('convertedMarkdownFiles/**.md', recursive=True):
    fixImgTag(filename)
