import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class PredictionReducer extends Reducer<IntWritable, Text, IntWritable, DoubleWritable> {
@Override
protected void reduce(final IntWritable key, final Iterable<Text> values, final Context context) throws IOException, InterruptedException {
int targetPeriod =2014;
Predict participant = new Predict(values,targetPeriod);
double projectedScoreAtTargetPeriod = participant.getProjectedScoreAtTargetPeriod();
context.write(new IntWritable(targetPeriod), new DoubleWritable(projectedScoreAtTargetPeriod));

}
}