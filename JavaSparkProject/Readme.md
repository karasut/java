#This file will contains the details about the Source File
####JSONTransofrmation.java
	-> This file will read the card.json from the resources directory and it will change the datframe column name and can save json with new dataframe column name.

	
#### JSONBeanTransformation.java
	-> This file will show example how to read a JSON file with the Custom object and can convert the dataframe to rdd and read the JSON with bean field name.
	
	
#### JSONUDFWrappedArrayTest.java
	-> This file will demonstrate the below example:
		1. Spark UDF
		2. Struct Type
		3. Use of Encoder with Custom object
		4. How to send GenericRowWithSchema to UDF and return GenericRowWithSchema schema.
	Note : While sending and receiving the GenericRowWithSchema order of the Struct Type matters. If the order doesn't match it will return Scala.match exception. It is a RuntimeException.
	
#### JSONSeparator.java
	-> When we receive multiple JSONs with comma as a delimeter and no new line separator and if we use .option("multiLine", "true") at that point spark read it as a single line. In this particular scenario it will try to process the record as a single record and if the file is big enough to cross the memory limit then it will through OOM error.
	-> So in this case we no need to use option("multiLine", "true").
	-> In this example both the options are shown.