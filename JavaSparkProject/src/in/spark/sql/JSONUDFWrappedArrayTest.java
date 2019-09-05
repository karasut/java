package in.spark.sql;

import in.spark.model.Profile;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.sql.api.java.UDF1;
import org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema;
import org.apache.spark.sql.types.ArrayType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.List;

import static org.apache.spark.sql.functions.callUDF;

public class JSONUDFWrappedArrayTest {
        public static void main(String[] args) {
            SparkConf sparkConf = new SparkConf().setAppName("test").setMaster("local[*]");
            JavaSparkContext sc = new JavaSparkContext(sparkConf);
            SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
            Encoder<Profile> personEncoder = Encoders.bean(Profile.class);
            Dataset<Profile> df = sqlContext.read().option("multiLine", "true").json(".//resources//profile.json").as(personEncoder);
            df.show(false);
            df.javaRDD().collect().forEach(x -> System.out.println(x.getProfile().getAddress().get(0).getCity()));
            df.printSchema();
            //df.select( functions.explode(df.col("profile")).as("ADDRESS")).show();
            jsonTransformation(df,sqlContext).show();

        }
        public static Dataset<Row> jsonTransformation(Dataset<Profile> df, SQLContext sqlContext){
            UDF1 transformation = new UDF1<GenericRowWithSchema, GenericRowWithSchema>() {
                @Override
                public GenericRowWithSchema call(GenericRowWithSchema source) throws Exception {
                    return source;
                }
            };
            List<StructField> employeeFields = new ArrayList<>();
            List<StructField> addressFields = new ArrayList<>();
            addressFields.add(DataTypes.createStructField("city", DataTypes.StringType, true));
            addressFields.add(DataTypes.createStructField("primary", DataTypes.StringType, true));
            addressFields.add(DataTypes.createStructField("street", DataTypes.StringType, true));
            ArrayType addressStruct = DataTypes.createArrayType( DataTypes.createStructType(addressFields));

            employeeFields.add(DataTypes.createStructField("addresses", addressStruct, true));
            employeeFields.add(DataTypes.createStructField("emailAddress", DataTypes.StringType, true));
            employeeFields.add(DataTypes.createStructField("employeeCode", DataTypes.StringType, true));
            employeeFields.add(DataTypes.createStructField("firstName", DataTypes.StringType, true));

            employeeFields.add(DataTypes.createStructField("jobTitleName", DataTypes.StringType, true));
            employeeFields.add(DataTypes.createStructField("lastName", DataTypes.StringType, true));
            employeeFields.add(DataTypes.createStructField("phoneNumber", DataTypes.StringType, true));

            employeeFields.add(DataTypes.createStructField("preferredFullName", DataTypes.StringType, true));
            employeeFields.add(DataTypes.createStructField("region", DataTypes.StringType, true));
            employeeFields.add(DataTypes.createStructField("userId", DataTypes.StringType, true));

            StructType employeeSchema = DataTypes.createStructType(employeeFields);
            sqlContext.udf().register("jsonTranformation",transformation, employeeSchema);;
            Dataset<Row>df1 = df.withColumn("profile",callUDF("jsonTranformation",df.col("profile"))  );
            return  df1;
        }

    }
