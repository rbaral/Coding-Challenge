def optimal_bst(p, q, n):
	# initialize the arrays e, w and root
	e=[]
	w=[]
	root=[]
	for i in range(0,n+2):
		e.append([0]*(n+1))
		w.append([0]*(n+1))
	for i in range(0,n):
		root.append([0]*n)
	#print p
	#print q
	for i in range(1,n+2):
		#print "adding element to e",i,i-1
		e[i][i-1]=q[i-1]
		w[i][i-1]=q[i-1]
	
	
	for l in range(1,n+1):
		for i in range(1,n-l+2):
			j=i+l-1
			e[i][j]=99999
			print "addint to index",i,j
			w[i][j]= w[i][j-1] +p[j-1]+q[j-1]
			for r in range(i,j+1):
				t= e[i][r-1] + e[r+1][j] +w[i][j]
				if t<e[i][j]:
					e[i][j] = t
					root[i-1][j-1] = r
	
	print e
	#print "*************"
	#print w
	#print "*************"
	#print root

p=[0.15,0.1,0.05,0.1,0.2]
q=[0.05,0.1,0.05,0.05,0.05,0.1]
n=5
optimal_bst(p, q, n)
	