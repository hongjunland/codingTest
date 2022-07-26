def solution():
    cnt = 4
    for i in range(0, 2):
        for j in range(1, 10):
            for k in range(2+cnt*i, 5+cnt*i+1):
                print('{0} * {1} = {2} '.format(k,j,j*k), end='\t')
            print()
        print()

if __name__ == '__main__':
    solution()