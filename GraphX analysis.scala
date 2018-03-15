// Databricks notebook source
//https://docs.databricks.com/spark/latest/graph-analysis/graphframes/graph-analysis-tutorial.html
val mass = sqlContext.sql("SELECT * FROM mass_train")

// COMMAND ----------

display(mass)

// COMMAND ----------

mass.printSchema()

// COMMAND ----------

import org.apache.spark.sql._
import org.apache.spark.sql.functions._

import org.graphframes._

// COMMAND ----------

val pathologyVertices = mass
  .withColumnRenamed("pathology", "id")
  .distinct()

// COMMAND ----------

val abnormalityEdges = mass
  .withColumnRenamed("abnormality id", "src")
  .withColumnRenamed("breast_density", "dst")
  .distinct()

// COMMAND ----------

val massGraph = GraphFrame(pathologyVertices, abnormalityEdges)

abnormalityEdges.cache()
pathologyVertices.cache()

// COMMAND ----------

println("Total Number of pathology: " + massGraph.vertices.count)
println("Total Number of Trips in abnormality: " + massGraph.edges.count)

// COMMAND ----------

val ranks = massGraph.pageRank.resetProbability(0.15).maxIter(10).run()

display(ranks.vertices.orderBy(desc("pagerank")))

// COMMAND ----------

val inDeg = massGraph.inDegrees
display(inDeg.orderBy(desc("inDegree")).limit(5))

// COMMAND ----------

val outDeg = massGraph.outDegrees
display(outDeg.orderBy(desc("outDegree")).limit(5))

// COMMAND ----------

val degreeRatio = inDeg.join(outDeg, inDeg.col("id") === outDeg.col("id"))
  .drop(outDeg.col("id"))
  .selectExpr("id", "double(inDegree)/double(outDegree) as degreeRatio")

degreeRatio.cache()

display(degreeRatio.orderBy(desc("degreeRatio")).limit(10))

// COMMAND ----------

display(degreeRatio.orderBy(asc("degreeRatio")).limit(10))

// COMMAND ----------


