# GameOfBlobs
compile: javac gob.java
run: java gob

On a discrete grid Blobs greedily will try to eat each other. They target the closest blob that's smaller than them but the largest 
of possible prey.

1) Movement
   Calculates what direction to move in on the X or Y axis.

2) Find closest blob
    Finds the largest blob the current blob can eat

3) Apply movement
    When all blobs know their next move if any, this will apply that movement
    
4) Merge
    If a blob has the same coordinates as another blob thats smaller it will eat that blob

NOTE: The class files in this repository were included on accident. They are old versions of the program.
