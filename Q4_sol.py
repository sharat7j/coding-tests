import queue as Q
def checkDryers(next_dryer_avail_time,time):
	 for dryer_avail in next_dryer_avail_time:
	 	if (dryer_avail < time):
	 		return dryer_avail
	 return -1	

def optimaltime(L,N,M,D,W):
	print(L,N,M,D,W)
	
	next_dryer_avail_time=[0] * M
	dryerTimes=L
	time=0
	#put (Wi,i) in queue. pick one with least waiting time
	#also have list Ai  which is availability of dryer
	q = Q.PriorityQueue()
	for i in range(0 , N):
		
		q.put((W[i],i+1))
	
	while (L!=0):
		curWasher=q.get()
		time=curWasher[0]
		q.put((curWasher[0]+W[curWasher[1]-1],curWasher[1]))
		if(dryerTimes>0):
			dryer=checkDryers(next_dryer_avail_time,time) 
			if (dryer is not -1):
				next_dryer_avail_time[next_dryer_avail_time.index(dryer)]=dryer+D
				time=time+D
				dryerTimes=dryerTimes-1
		L=L-1
	if(dryerTimes>0):
		while (dryerTimes>0):
			dryer=checkDryers(next_dryer_avail_time,time) 
			if (dryer is not -1):
				next_dryer_avail_time[next_dryer_avail_time.index(dryer)]=dryer+D
				time=time+D
				dryerTimes=dryerTimes-1
	print (time)
inputs=input()

waiting=input()
L=int(inputs.split(' ')[0])
N=int(inputs.split(' ')[1])
M=int(inputs.split(' ')[2])
D=int(inputs.split(' ')[3])
W = tuple(map(int, waiting.split(' ')))
optimaltime(L,N,M,D,W)
