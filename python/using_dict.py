
ab = {
'liu':'huantian',
'yang':'peng',
'wang':'binghua'
}

xing = raw_input('input a xing:')
if xing in ab:
	print ab[xing]
else:
	print 'not exists..'

ab['li'] = 'bian'
print 'add li:',ab

del ab['wang']
print 'del wang:',ab

for xing,ming in ab.items():
	print '%s-%s' %(xing,ming)

