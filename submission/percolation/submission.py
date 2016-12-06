lines = open("..\..\src\main\java\week1\percolation\Percolation.java").readlines()
open("src\Percolation.java", "w").write("".join(lines[2:]))
lines = open("..\..\src\main\java\week1\percolation\PercolationStats.java").readlines()
open("src\PercolationStats.java", "w").write("".join(lines[2:]))

import os
try:
	os.remove("percolation.zip")
except:
	pass
from shutil import make_archive
make_archive("percolation", "zip", root_dir="src")