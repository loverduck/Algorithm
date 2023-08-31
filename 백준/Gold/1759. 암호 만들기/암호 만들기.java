import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st = null;
	static StringBuilder output = new StringBuilder();
	
	static int l, c;
	static String[] word;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		word = new String[c];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < c; i++) {
			word[i] = st.nextToken();
		}
		
		Arrays.sort(word);
		
		combination(0, 0, new String[l], 0, 0);
		
		System.out.println(output);
	}
	
	static void combination(int nth, int startIdx, String[] choosed, int consonant, int vowel) {
		if(nth == choosed.length) {
			if(consonant >= 2 && vowel >= 1) {
				output.append(String.join("", choosed)).append("\n");				
			}
			return;
		}
		
		for(int i = startIdx; i < word.length; i++) {
			choosed[nth] = word[i];
			if("aieou".contains(word[i])) {
				combination(nth + 1, i + 1, choosed, consonant, vowel + 1);
			} else {
				combination(nth + 1, i + 1, choosed, consonant + 1, vowel);
			}
			
		}
	}

}