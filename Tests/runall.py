#!/usr/local/bin/python3


from os import listdir
from os import system
import os
import sys
import getpass

if __name__ == '__main__':
	testdir = "/Users/" + getpass.getuser() +"/IdeaProjects/XQuery-Evaluation-Engine/Tests"
	jarfile = "/Users/" + getpass.getuser() +"/IdeaProjects/XQuery-Evaluation-Engine/out/artifacts/XQuery_Evaluation_Engine_jar/XQuery-Evaluation-Engine.jar"

	cases = listdir()
	cases.sort()

	separator = "\n========================"

	failures = 0
	faillist = []
	total = 0
	for case in cases:
		if case.endswith(".py") \
		or case.startswith(".") \
		or not os.path.isfile(testdir + "/" + case) \
		or case == "toy.txt":
			continue
		total += 1
		print(separator)
		print(case + ": \n")
		if "rewrite" in case.lower():
			if system("java -jar " + jarfile + " " + testdir + "/" + case + " -rx") != 0:
				failures += 1
				faillist.append(case)
		else:
			if system("java -jar " + jarfile + " " + testdir + "/" + case + " -x") != 0:
				failures += 1
				faillist.append(case)

	print("\n\n\n*********** Summary ***********")
	print("* Failures: " + str(failures) + "/" + str(total))
	for i in range(len(faillist)):
		print("# " + str(i+1) + ":\t" + faillist[i])
		





	
