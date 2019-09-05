package in.spark.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class JSONSeparator {
    public static void main(String[] args){
        SparkConf sparkConf = new SparkConf().setAppName("test").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
        Dataset<Row> df = sqlContext.read().json(".//resources//MultiJsonSeparator.json");
        df.show();
        Dataset<Row> df1 = sqlContext.read().option("multiLine","true").json(".//resources//MultiJsonSeparator.json");
        df1.show();
    }
}
