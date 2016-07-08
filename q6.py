class Solution(object):

            
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
      
    
        fin=[]
        for i in range(1,n-k+2):
          arr=[]
          arr.append(i)
          x=i+1
          while arr:
            if(len(arr)==k):
              
              fin.append(arr[:])
              
              x=arr.pop()+1
            elif x>n:
              x=arr.pop()+1
            else:
              arr.append(x)
              x=x+1
             
        return fin
