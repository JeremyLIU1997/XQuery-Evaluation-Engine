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

	separator = "\n========================================================================"

	failures = 0
	faillist = []
	total = 0
	for case in cases:
		if case.endswith(".py") \
		or case.startswith(".") \
		or not os.path.isfile(testdir + "/" + case) \
		or case == "toy.txt" \
		or case == "eval_output.txt" \
		or case == "rewrite_output.txt":
			continue
		total += 1
		print(separator)
		print(case + ": \n")
		print("******** Left Deep ********")
		if system("java -jar " + jarfile + " " + testdir + "/" + case + " -Ls") != 0:
			failures += 1
			faillist.append(case + " --- L")
		print("******** Bushy ********")
		if system("java -jar " + jarfile + " " + testdir + "/" + case + " -Bs") != 0:
			failures += 1
			faillist.append(case + " --- B")
		

	print("\n\n\n*********** Summary ***********")
	print("* Failures: " + str(failures) + "/" + str(total*2))
	for i in range(len(faillist)):
		print("# " + str(i+1) + ":\t" + faillist[i])
		





	
