# SPARK 

* Spark is one of the latest technologies being used to quickly and easily handle Big Data
* It is an open source project on Apache
* It was first released in February 2013 and has exploded in popularity due to it’s ease of use and speed
* It was created at the AMPLab at UC Berkeley


Data that can fit o a local computer, in the scale of 0-32 GB RAM. What can we do if we have a larger set of data?

* Try using SQL database to move storage onto hard drive instead of RAM
* Use a distributed system, that distributes the data to multiple machines/computer

### LOCAL vs DISTRIBUTED

* A local process will use the computation resources of a single machine
* A distributed process has access to the computational resources across a number of machines connected through a network
* It is easier to scale out to many lower CPU machines, than to try to scale up to a single machine with a high CPU
* Distributed machines also have the advantage of easily scaling, you can just add more machines
* Distributed machines include fault tolerance, if one machine fails, the whole network goes on

### HADOOP

* Hadoop is a way to distribute a very large files across multiple machines
* It uses the Hadoop Distributed File System
* HDFS also duplicates block of data for fault tolerance
* It uses MapReduce which allows computations on the data

  #### HDFS
  * HDFS will use blocks of data, with a size of 128 MB by default
  * Each of these blocks is replicated 3 times
  * The blocks are distributed in a way to support fault tolerance
  * Smaller blocks provide more parallelization during processing
  * Multiple copies of a block prevent loss of data due to a failure of a node
  
  #### MapReduce
  * MapReduce is a way of splitting a computation task to a distributed set of files (such as HDFS)
  * It consists of a Job Tracker and multiple Task Trackers
  * The Job Tracker sends code to run on the Task Trackers
  * The Task trackers allocate CPU and memory for the tasks and monitor the tasks on the worker nodes
  
### SPARK vs MapReduce
* MapReduce requires files to be stored in HDFS, Spark does not!!
* Spark also can perform operations up to 100x faster than MapReduce
* MapReduce writes most data to disk after each map and reduce operation
* Spark keeps most of the data in memory after each transformation
* Spark can spill over to disk if the memory is filled

### SPARK RDD's
* At the core of Spark is the idea of a Resilient Distributed Dataset (RDD)
* Resilient Distributed Dataset (RDD) has 4 main features:
	* Distributed Collection of Data
	* Fault-tolerant
	* Parallel operation - partitioned
	* Ability to use many data sources
* RDDs are immutable, lazily evaluated, and cache-able
* There are two types of Spark operations:
	* Transformations
	* Actions
* Transformations are basically a recipe to follow
* Actions actually perform what the recipe says to do and returns something back
* With the release of Spark 2.0, Spark is moving towards a DataFrame based syntax, but keep in mind that the way files 
  are being distributed can still be thought of as RDDs,it is just the typed out syntax that is changing





  


