# SPARK 

Data that can fit o a local computer, in the scale of 0-32 GB RAM. What can we do if we have a larger set of data?

* Try using SQL database to move storage onto hard drive instead of RAM.
* Use a distributed system, that distributes the data to multiple machines/computer.

## LOCAL vs DISTRIBUTED

* A local process will use the computation resources of a single machine.
* A distributed process has access to the computational resources across a number of machines connected through a network.
* It is easier to scale out to many lower CPU machines, than to try to scale up to a single machine with a high CPU.
* Distributed machines also have the advantage of easily scaling, you can just add more machines.
* Distributed machines include fault tolerance, if one machine fails, the whole network goes on.

## HADOOP
