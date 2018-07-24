/**
 *
 */
package sample.print2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mizuk
 *
 */
public class Programs {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 練習
		String[] listL = {"aaa","bbb","ccc","bbb","eee","hhhh"};
		String[] listR = {"bbb","ddd","eee","fff","ggg","iiii"};
		System.out.println("[left array] "+String.join(" ", listL));
		System.out.println("[right array] "+String.join(" ", listR));
		System.out.println("-------------------------------------------- ");

		List<String> tmpL = new ArrayList<String>();
		List<String> tmpR = new ArrayList<String>();
		List<String> tmpCommon = new ArrayList<String>();
		List<String> tmpALL = new ArrayList<String>();

		for(int i=0; i < listL.length ; i++) {
			String str = listL[i];
			if ( Arrays.asList(listR).contains(str)) {
				// 右側のリストに同様の文字列が含まれているため、共通である。
				tmpCommon.add(str);
			} else {
				// 左側のリストにのみ存在する文字列である。
				tmpL.add(str);
			}
			tmpALL.add(str);
		}

		for(int i=0; i < listR.length ; i++) {
			String str = listR[i];
			if ( Arrays.asList(listL).contains(str)) {
				// 右側のリストに同様の文字列が含まれているため、共通である。
				//tmpCommon.add(str);
			} else {
				// 左側のリストにのみ存在する文字列である。
				tmpR.add(str);
				tmpALL.add(str);
			}
		}
		// 重複除外
		tmpL = tmpL.stream().distinct().collect(Collectors.toList());
		tmpR = tmpR.stream().distinct().collect(Collectors.toList());
		tmpCommon = tmpCommon.stream().distinct().collect(Collectors.toList());
		tmpALL = tmpALL.stream().distinct().collect(Collectors.toList());

		// 描画
		System.out.println("[left only] "+String.join(" ", tmpL));
		System.out.println("[right only] "+String.join(" ", tmpR));
		System.out.println("[both] "+String.join(" ", tmpCommon));
		System.out.println("-------------------------------------------- ");
		System.out.println("[ALL] "+String.join(" ", tmpALL));

		// 並び替え表示（昇順でソート）
		Collections.sort(tmpALL);
		Collections.sort(tmpL);
		Collections.sort(tmpR);
		Collections.sort(tmpCommon);
		for(int i=0; i < tmpALL.size() ; i++) {
			String str = tmpALL.get(i);
			String strL = "";
			String strR = "";
			if ( tmpL.contains(str)) {
				strL = str;
			} else if ( tmpR.contains(str)) {
				strR = str;
			} else if ( tmpCommon.contains(str)) {
				strL = str;
				strR = str;
			}
			System.out.printf("%-5s | %-5s\n", strL , strR);
		}


	}

}
