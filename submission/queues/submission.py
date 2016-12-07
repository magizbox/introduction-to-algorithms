import os

files = ["Deque.java", "RandomizedQueue.java", "Subset.java"]
for file in files:
    lines = open("..\..\src\main\java\week2\queues\\" + file).readlines()
    open("src\\" + file, " w ").write("".join(lines[2:]))

try:
    os.remove(".zip")
except:
    pass
from shutil import make_archive

make_archive("percolation", "zip", root_dir="src")
