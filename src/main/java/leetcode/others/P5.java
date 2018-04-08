package leetcode.others;


/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */

public class P5 {

    public static void main(String[] args) {
        long a=System.currentTimeMillis();
//这里放需要测试执行时间的代码段。
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("babad"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("abaaaabaaaa"));
//        System.out.println(longestPalindrome("daomdukomcayjwgmmetypncdeixarhbectjcwftjjtwjrctixtrsehegwlfotpljeeqhntacfihecdjysgfmxxbjfeskvvfqdoedfxriujnoeteleftsjgdsagqvcgcdjbxgmguunhbjxyajutohgbdwqtjghdftpvidkbftqbpeahxbfyamonazvubzirhqseetaneptnpjbtrtitttxsyjckjvwtrmuwgidkofvobrwrffzrpnxbectsydbvswstfiqranjzhsebjnmprjoirqkgttahrivkcjtitdcpohwwerwgrdivqbltfnigavydxpmitttjjzyrmpaptkczzgnsovebvxezkkovgqegctxacvjfqwtiycnhartzczcgosiquhmdbljjzyrnmffcwnkyzytnsvyzayrieqyrfpxintbbiyrawxlguzaisedwabpzvevlejadztuclcpwvonehkhknicdksdcnjfaoeaqhcdkdtywilwewadcnaprcasccdcnvdgjdqirrsqwzhqqorlhbgpelpupdvuynzybcqkffnnpocidkkigimsa"));
        System.out.println(longestPalindrome("rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip"));
//        System.out.println(longestPalindrome("aaaabaaa"));
        System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");

    }

    public static String longestPalindrome(String s) {


        String temp  = null,result = null;
        int maxLen = 1,tmplen = 1;
        int len = s.length();

        for (int begin = 0; begin < len;) {


            for (int end = begin+maxLen; end <= len; end++) {
                temp = s.substring(begin,end);
                tmplen = isPalindrome(temp);
                if (tmplen>maxLen){
                    maxLen = tmplen;
                    result = temp;
                    continue;
                }

            }


            if (maxLen>2&&maxLen%2==0)
                begin += (maxLen/2 -1);
            else
                if (maxLen>1&&maxLen%2==1)
                    begin += maxLen/2;
                else
                    begin ++;
        }

        if (maxLen==1)
            return s.substring(0,1);

        return result;
    }

    public static int isPalindrome(String s){

        int len = s.length();
        int mid = (len +1)/2;
        int i = 0,j = len-1;
        while (i<=j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return 1;
            }

        }
        return len;
    }

}
