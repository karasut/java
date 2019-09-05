package in.spark.sql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import in.spark.model.Profile;

public class JSONBeanTransformation {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf().setAppName("test").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(sparkConf);
		SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
		Encoder<Profile> personEncoder = Encoders.bean(Profile.class);
		Dataset<Profile> df = sqlContext.read().json(".//resources//profile.json").as(personEncoder);
		df.show(false);
		df.javaRDD().collect().forEach(x -> System.out.println(x.getProfile().getAddress().get(0).getCity()));

	}

}