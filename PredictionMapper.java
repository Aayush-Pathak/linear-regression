import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class PredictionMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
@Override
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
//Should add code to check to handle issues with the data
String line = value.toString();
String[] ScoreData = line.split("\t");
IntWritable year = new IntWritable(Integer.parseInt(ScoreData[0]));
Text values = new Text(ScoreData[0].toString()+" "+ScoreData[1].toString());

context.write(year, values);

}
}