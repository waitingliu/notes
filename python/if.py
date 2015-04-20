number = 23
guess = int(raw_input('Enter an integer:'))

if guess == number:
	print 'yes!'
	print 'congratulations!'
elif guess < number:
	print 'No!'
	print 'a little higher than that'
else:
	print 'No!'
	print 'a little lower than that'

print 'Done'
