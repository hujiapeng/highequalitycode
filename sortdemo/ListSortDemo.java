package hqcode.sortdemo;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class ListSortDemo {

    @Test
    public void func(){
        String[] names={"张三(Z)","李四(L)","王五(W)"};
        Arrays.sort(names);
        System.out.println(toUnicode('张'));
        System.out.println(toUnicode('李'));
        System.out.println(toUnicode('王'));
        System.out.println(StringUtils.join(names));

        //Java推荐使用Collator类进行排序
        Comparator comparator=Collator.getInstance(Locale.CHINA);
        Arrays.sort(names,comparator);
        System.out.println(StringUtils.join(names));
    }

    private String toUnicode(char c){
        String hex=Integer.toHexString(c);
        if(hex.length()<=2){
            hex="00"+hex;
        }
        return hex;
    }

    private String unicodeToChar(String hex){
        char c= (char) Integer.parseInt(hex,16);
        return new Character(c).toString();
    }

    @Test
    public void chineseToPinyin() throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinOutputFormat format=new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
//        format.setToneType(HanyuPinyinToneType.WITH_TONE_MARK);
//        format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
        String[] pinyin=PinyinHelper.toHanyuPinyinStringArray('长',format);
        System.out.println(StringUtils.join(pinyin,","));
    }

}
