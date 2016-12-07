import os
from shutil import make_archive

files = ["Deque.java", "RandomizedQueue.java", "Subset.java"]
name = "queues"
zipfile = name + ".zip"

for file in files:
    lines = open("..\..\src\main\java\week2\queues\\" + file).readlines()
    open("src\\" + file, "w").write("".join(lines[2:]))

try:
    os.remove(zipfile)
    print "Remove '%s' successfully." % zipfile
except:
    pass

make_archive(name, "zip", root_dir="src")
print "Create '%s' successfully." % zipfile
