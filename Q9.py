#Hero has two arrays,
#A and B, each containing the same number of integers.
#He wants to change A into an array that will resemble B as closely as possible.
# More precisely, the difference between two arrays of equal length is the
#number of indices where the two arrays differ.
#Hero wants to minimize the distance between the modified array A and the
#original array B. Hero can only modify A by using stickers.
#He has a collection of stickers. Each sticker contains a single integer.
# Each sticker can be used to cover a single element of A.
#Hero must use each sticker exactly once, and he cannot use multiple
#stickers on the same element of A.
#You are given the original arrays in the s A and B, and the
#collection of stickers in the F. Return the smallest possible difference
#between A and B after all stickers from F have been used to
# replace some elements of A.
#0)
#{1,1,1}
#{2,2,2}
#{2}
# Returns: 2
# 1)
# {1,1,1}
# {2,2,1}
# {2,2}
# Returns: 0
# 2)
# {1,2,3}
# {3,2,1}
# {}
# Returns: 2
# Hero has no stickers. The given arrays A and B differ on two positions: on 0-based indices 0 and 2.
# 3)
# {2,2,2}
# {2,2,2}
# {1,2,3}
# Returns: 2
# Note that Hero must use all the stickers. Originally the two arrays are the same, but applying all the stickers creates two differences, regardless of the order in which you use them.
# 4)
# {1,3,3,3}
# {2,3,3,3}
# {2,2}
# Returns: 1

# algo
# 1)initialze i=0
# 2) while f is not empty loop
# 3) if a[i]!=b[i] then replace a[i] with value in f if f contains b[i]
# 4) else do nothing
# 5) if i = a.size and f is not empty then replace a[i] with f[i] and decrement if i
# 6) finally check how many elements are different in a and b
# 7) O(n)


def stickerReplace(a,b,f):
    if len(a)!=len(b) or len(a)==0 or len(b)==0:
        return -1
    if f is None:
        return 0
    mindiff=0
    index=0

    if(f is not None):
        while  len(f)>0 and index<len(a):
            if  index < len(a) and (a[index]!=b[index]):
                if(b[index] in f):
                    x=f.index(b[index])
                    a[index]=f[x]
                    del f[x]
            index=index+1

        if (len(f)>0 and index==len(a)):
            index=index-1
            n=len(f)-1
            while len(f)>0:

                a[index]=f[n]
                del f[n]
                n=n-1
                index=index-1
    p=0
    while p<len(a):
        if a[p]!=b[p]:
            mindiff=mindiff+1
        p=p+1
    return mindiff
