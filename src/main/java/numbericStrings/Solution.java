package numbericStrings;

/**
 * 面试题20 表示数值的字符串
 */
public class Solution {

    public boolean isNumberic(String str) {
        if(str == null)
            return false;

        MyString myStr = new MyString(str);
        boolean numberic = scanInteger(myStr);
        if(myStr.hasMore() && myStr.getChar() == '.') {
            myStr.forward();
            numberic = scanUnsignedInteger(myStr) || numberic;
        }

        if(myStr.hasMore() && (myStr.getChar()=='e' || myStr.getChar()=='E')) {
            myStr.forward();
            numberic = numberic && scanInteger(myStr);
        }

        return numberic && !myStr.hasMore();
    }

    private boolean scanInteger(MyString myStr) {
        int preIndex = myStr.getScanIndex();
        if(myStr.hasMore() && (myStr.getChar()=='+' || myStr.getChar()=='-'))
            myStr.forward();
        boolean numberic = scanUnsignedInteger(myStr);
        if(!numberic)
            myStr.setScanIndex(preIndex);

        return numberic;
    }

    private boolean scanUnsignedInteger(MyString myStr) {
        int preIndex = myStr.getScanIndex();
        while(myStr.hasMore() && myStr.getChar()>='0' && myStr.getChar()<='9') {
            myStr.forward();
        }

        return preIndex < myStr.getScanIndex();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.isNumberic("123"));
        System.out.println("测试用例2："+solution.isNumberic("-123."));
        System.out.println("测试用例3："+solution.isNumberic("+123.321"));
        System.out.println("测试用例4："+solution.isNumberic(".321"));
        System.out.println("测试用例5："+solution.isNumberic("123.E+123"));
        System.out.println("测试用例6："+solution.isNumberic("123.321E-123"));
        System.out.println("测试用例7："+solution.isNumberic("123.321E123"));
        System.out.println("测试用例8："+solution.isNumberic("123.321E123.321"));
        System.out.println("测试用例9："+solution.isNumberic("123.-321E123.321"));
        System.out.println("测试用例10："+solution.isNumberic("E123"));
        System.out.println("测试用例11："+solution.isNumberic("+.123E123"));
    }
}

class MyString {
    String str;
    int scanIndex;

    public MyString(String str) {
        this.str = str;
        scanIndex = 0;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getScanIndex() {
        return scanIndex;
    }

    public void setScanIndex(int scanIndex) {
        this.scanIndex = scanIndex;
    }

    public boolean hasMore() {
        return scanIndex < str.length();
    }

    public char getChar() {
        return str.charAt(scanIndex);
    }

    public void forward() {
        scanIndex++;
    }
}
