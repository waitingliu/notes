
import sys
#使用sys模块
print 'The command line args are:'

#sys.argv 输出命令行参数
#脚本的名称总是sys.argv列表的第一个参数 sys.argv[0]=using_sys.py
for i in sys.argv:
	print i

print '\n\nThe Python path is',sys.path,'\n'

