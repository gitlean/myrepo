package demo;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * 统计词频
 * https://blog.csdn.net/plasticplane/article/details/14001139
 * @author john
 * @date 2018年10月19日
 * @time 上午10:08:08
 * @describe:
 */
public class TestMain {

	public static Map<String, Integer> wordfre = new HashMap<String, Integer>();

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestMain ins=new TestMain();
		
		String str="在教育部要求高校要杜绝“水课”，严把质量关之后，我国高校开始在“严出”上采取行动。但是，不少舆论担心这是“应景式”从严，只抓几个淘汰不合格学生的典型。我国大学要普遍实行“严出”教育模式，必须深入推进学校办学改革，为“严出”模式提供制度保障。";
		ins.setfre(str);
		
		System.out.println(wordfre);

	}

	public  void setfre(String string) {

		StringReader reader = new StringReader(string);
		IKSegmenter ik = new IKSegmenter(reader, true);// 后一个变量决定是否消歧

		Lexeme lexeme = null;
		float count = 0;
		try {
			while ((lexeme = ik.next()) != null) {
				String word = lexeme.getLexemeText();
				count++;
				if (!this.wordfre.containsKey(word)) {
					this.wordfre.put(word, 1);
				} else {
					//same++;
					this.wordfre.put(word, this.wordfre.get(word) + 1);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
