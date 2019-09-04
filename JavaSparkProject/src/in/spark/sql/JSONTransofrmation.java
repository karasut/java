package in.spark.sql;

import java.util.ArrayList;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class JSONTransofrmation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SparkConf sparkConf = new SparkConf().setAppName("test").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
		Dataset<Row> df = sqlContext.read().json(".//resources//card.json");
		String[] columnNames = df.columns();
		df.show();
		Dataset<Row> newDF = df.toDF("uid","uname","utitle");
		newDF.show();
	}

}
