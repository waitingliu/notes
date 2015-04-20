shop = ['ppd','banana','apple','carrot','mango']

print 'length:',len(shop)

for item in shop:
	print item

shop.append('rice')
print 'shop list is now',shop

shop.sort()
print 'sorted shop list',shop

print 'shop[0]=',shop[0]

olditem = shop[0]
del shop[0]
print olditem
print shop
