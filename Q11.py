#given rotated sorted array. find how many times it was rotated.
#eg=[4,5,2,3]
#output=2
def find_Num_Of_Rotations(num_list):
    #o(log n) algorithm
    if(num_list is not None and len(num_list)>1):
        low=0
        high=len(num_list)-1
       
        length=len(num_list)
        while(low<=high):
            mid=int((low+high)/2)
            print (num_list[(mid-1)%length],num_list[(mid+1)%length],num_list[mid])
            if(((num_list[mid]<num_list[(mid-1)%length]) and   num_list[mid]<=num_list[(mid+1)%length])):
                return mid
            if(num_list[mid]<num_list[high]):
                high=mid-1
            else:
                low=mid+1
        return 0   
    return 0
