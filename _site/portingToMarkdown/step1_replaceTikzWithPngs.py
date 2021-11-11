import re
import glob

counter = 0

def updateToImg(path):
    file = open(path, 'r')
    content = file.read()

    print(path)

    # Works
    # (\\bgroup \\tikzset\{png export\} \\begin\{tikzpicture\})(.*?)(\\end\{tikzpicture\} \\egroup)
    p = re.compile(r'(\\bgroup \\tikzset\{png export\} \\begin\{tikzpicture\})(.*?)(\\end\{tikzpicture\} \\egroup)', re.DOTALL)

    # print(re.findall(p, content)) # TODO - Remove me; testing purposes
    # for x in re.findall(p, content):
    #    print(x)


    fileName = path[path.find('/') + 1: path.rfind('/')] # Find middle folder name - will match fig name

    def formatString(m, i = [-1]): # Dirty solution for sequential file numbering
        i [0] += 1
        return "<img src=\"./../fig/{}/{}-figure{}.png\" alt=\"Drawing\" width = \"400\"/>".format(fileName, fileName, i[0])


    content = re.sub(p, formatString, content)

    file.close()

    newFileName = path[path.rfind('/') + 1:]
    file = open('output/{}'.format(newFileName), 'w+')
    file.write(content)
    file.close()

for filename in glob.iglob('latexPackage/**/**.tex', recursive=True):
    updateToImg(filename)
