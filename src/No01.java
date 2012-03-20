import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class No01 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		No01 n = new No01();
		n.nameSum();
		
	}

	private void nameSum() {
		String strFileName01 = "/home/masaya/workspace/functional/input_files/data001.csv";
		Map<String, Integer> sumMap = new HashMap<>();
		String[] vals;
		int idx = 0;
		
		try{
			for(String s : Files.readAllLines(Paths.get(strFileName01), Charset.defaultCharset())){
				idx++;
				if (idx == 1){
					continue;
				}
				vals = s.split(",");
				System.out.println(vals[0]);
				if (sumMap.get(vals[0]) == null){
					sumMap.put(vals[0], Integer.valueOf(vals[2]));
				} else {
					sumMap.put(vals[0], Integer.valueOf(vals[2]) + sumMap.get(vals[0]));
				}
			}
			
			Set<String> keys = sumMap.keySet();
            for (String key : keys) {
                Integer sum_val = sumMap.get(key);

                System.out.println(key + " : " + sum_val.toString());
            }

		} catch(IOException ignored){
			
		}		
	}
}
