def print_b(b,x,i,j):
	if i==0 or j==0:
		return
	if b[i][j]=='t':
		print_b(b,x,i-1,j-1)
		print i,x[i]
	elif b[i][j]=='u':
		print_b(b,x,i-1,j)
	else:
		print_b(b,x,i,j-1)

def printLCSWithCArray(c, x, y):
	i = len(x)-1
	j = len(y)-1
	lcs=[]
	while c[i][j] >0:
		#print "inside loop"
		if x[i]==y[j]:
			lcs.append(x[i])
			i-=1
			j-=1
		elif c[i-1][j] == c[i][j]:
			i-=1
		else:
			j-=1
	return lcs
		

def lcs_length(x, y):
	m =len(x)
	n =len(y)
	b=[]
	#b.append([])
	c=[]
	#c.append([])
	for i in range(0,m+1):
		c.append([0]*n)
	
	for i in range(0,m+1):
		b.append([0]*n)
	'''	
	for i in range(0,m+1):
		#c[i][0]=0
		c[i].append(0)
	
	for j in range(0,n+1):
		#c[0][j]=0
		c[j].append(0)
	print len(x),len(y)
	'''
	for i in range(0,m):
		for j in range(0,n):
			if x[i]==y[j]:
				c[i][j]=c[i-1][j-1]+1
				b[i][j]='t'
			elif c[i-1][j]>=c[i][j-1]:
				c[i][j]=c[i-1][j]
				b[i][j]='u'
			else:
				c[i][j]=c[i][j-1]
				b[i][j]='l'
	# the b and c lists are populated, now lets print them
	#print b
	#print_b(b,x,m-1,n-1)
	
	lcs = printLCSWithCArray(c, x, y)
	for index in range(0,len(lcs)):
		print lcs[-1-index]#print in reverse
	
x=['1','0','0','1','0','1','0','1']
y=['0','1','0','1','1','0','1','1','0']
#x=['A','B','C','B','D','A','B']
#y=['B','D','C','A','B','A']

lcs_length(x,y)