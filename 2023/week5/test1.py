def getFinalString(s):
    SUB = 'AWS'
    while SUB in s:
        s = s.split(SUB)
        s = ''.join(s)
    if s == '':
        s = '-1'
    return s

if __name__ == '__main__':
    print(getFinalString('AAWSWS'))