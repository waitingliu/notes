
number = 23
running = True

while running:
	guess = int(raw_input('Enter an integer:'))

	if guess == number:
		print 'yes!'
		print 'congratulations!'
		running = False
	elif guess < number:
		print 'No!'
		print 'a little higher than that'
	else:
		print 'No!'
		print 'a little lower than that'

else:
	print 'loop over..'
print 'Done'
