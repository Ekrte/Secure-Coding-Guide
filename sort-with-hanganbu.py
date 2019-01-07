import untangle
import codecs
import sys
import datetime

RULE_NUM = 47

header = """<?xml version=\"1.0\" encoding=\"UTF-8\"?>

<BugCollection version="3.1.7-SNAPSHOT" sequence="0" timestamp="1540343521983" analysisTimestamp="1540469320838" release="">"""
footer = "</BugCollection>"
# f = open('Result.xml', "w")
# Korean needs utf-8 encoding, while a default file API does not support Korean
f = codecs.open(str(datetime.datetime.now()).replace(' ', '-').replace(':', "-") + '.xml', 'w', 'utf8')

def print_indent(num):
    for i in range(0, num):
        print(" ", end='')
        f.write(" ")


def print_element(rule, Element, indent):
    #print(BugInstance)
    print_indent(indent)
    print("<", end='')
    f.write("<")
    print(Element._name, end='')
    f.write(Element._name)

    for key in Element._attributes:
        print(" ", end='')
        f.write(" ")
        print(key, end='')
        f.write(key)
        print("=\"", end='')
        f.write("=\"")
        if indent==4 and Element._name == "SourceLine" and key == "classname":
            print(rule, end='')
            f.write(rule)
        elif Element._name == "String":
            Prepared = Element._attributes['value'].replace("<init>", "&lt;init&gt;")
            f.write(Prepared)
        elif Element._name == "Method" and key == "name":
            Prepared = Element._attributes[key].replace("<init>", "&lt;init&gt;")
            f.write(Prepared)
        else:
            print(Element._attributes[key], end='')
            f.write(Element._attributes[key])
        print("\"", end='')
        f.write("\"")

    if Element.children != []:
        print(">\n", end='')
        f.write(">\n")
        for child in Element.children:
            if child._name == "Method":
                rule = rule + "." + child['name'].replace("<init>", "&lt;init&gt;")
            print_element(rule, child, indent+2)

        print_indent(indent)
        print("</", end='')
        f.write("</")
        print(Element._name, end='')
        f.write(Element._name)
        print(">\n", end='')
        f.write(">\n")
    else:
        print("/>\n", end='')
        f.write("/>\n")
        
if __name__=="__main__":
    Ruleset = untangle.parse('Pattern mapping.xml')
    print(header + "\n", end='')
    f.write(header)
    '''
    rule = "06.05 Private 배열에 Public 데이터 할당"
    filename = "result\\" + rule + ".xml"
    result_xml = untangle.parse(filename)
    
    for x in result_xml.BugCollection.BugInstance:
        print_element(rule, x, 2)
    '''
    start = 0
    end = RULE_NUM

    if len(sys.argv) > 1:
        start = int(sys.argv[1]) - 1
        end = int(sys.argv[1])

    for i in range(start, end):
        rule = Ruleset.root.Detector[i]['class']
        filename = "result\\" + rule +".xml"
        print(filename)
        if i== 25 or i == 30 or i == 38:
            continue
        analysis_xml = untangle.parse(filename)
        
        Bug_pattern = Ruleset.root.Detector[i]['reports'].split(", ")
        for Bug_pattern in Bug_pattern:
            for x in analysis_xml.BugCollection.BugInstance:
                if Bug_pattern == x['type']:
                    print_element(rule, x, 2)

    print(footer, end='')
    f.write(footer)