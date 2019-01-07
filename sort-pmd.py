import untangle
import codecs
import sys
import datetime
import re

RULE_NUM = 47

# f = open('Result.xml', "w")
# Korean needs utf-8 encoding, while a default file API does not support Korean
#f = codecs.open("pmd_" + str(datetime.datetime.now()).replace(' ', '-').replace(':', "-") + '.xml', 'w', 'utf8')

if __name__=="__main__":
    Ruleset = untangle.parse('Pattern mapping.xml')
        
    start = 0
    end = RULE_NUM
    #f.write("%-70s\t\tTrue Positive\t\tFalse Positive\n" % ("PMD"))

    if len(sys.argv) > 1:
        start = int(sys.argv[1]) - 1
        end = int(sys.argv[1])

    for i in range(start, end):
        rule = Ruleset.root.Detector[i]['rule']
        
        #filename = "result_pmd\\" + rule +".xml"
        filename = "result_pmd\\" + rule + ".xml"
        #print(filename)
        with open(filename, "rb") as input:
            data = input.read()
        
        try:
            data = data.decode('ANSI').encode('utf-8')
            with open(filename, "wb") as output:
                output.write(data)
        except UnicodeDecodeError as e:
            a = 1

        try:
            analysis_xml = untangle.parse(filename)
        except Exception as e:
            raise Exception("Unable to parse the XML : {}".format(e.message))
        
        #print("%-50s" % (rule), end='')
        print(rule + ":\t", end='')
        #f.write("%-70s" % (rule))
        TP = 0
        FP = 0
        MAIN = 0
        Bug_patterns = Ruleset.root.Detector[i]['pmd'].split(", ")
        for Bug_pattern in Bug_patterns:
            if analysis_xml.pmd.children == []:
                continue

            for x in analysis_xml.pmd.file:
                for y in x.violation:
                    if Bug_pattern == y['rule']:
                        re_bad = re.compile('bad.*')
                        re_good = re.compile('good.*')
                        #p = re.compile('bad')
                        TP += len(re_bad.findall(y['method']))
                        FP += len(re_good.findall(y['method']))
        print(str(TP) + "\t" + str(FP) + "\t" + str(MAIN))
        #f.write(str(TP) + "\t\t" + str(FP) + "\n")