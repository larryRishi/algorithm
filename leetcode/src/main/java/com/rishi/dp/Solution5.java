package com.rishi.dp;

/**
 * @author liuhx
 * @desc TODO
 * @date 2019/12/13
 **/
public class Solution5 {


    public static void main(String[] args) {
        String str = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
        System.out.println(new Solution5().longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        //使用动态规划来实现
        //根据回串的定义我们可知，
        /**
         我们定义pand(i, j) = 0/1来确定其是否是回文串，0-不是，1-是
         如果pand(i, j) = 1的时候，那么pand(i + 1, j - 1) = 1,并且Si == Sj
         */
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        int[][] pand = new int[n][n];
        for (int i = 0; i < n; i++) {
            pand[i][i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                System.out.println();
                if (s.charAt(i) == s.charAt(j)
                        && (i + 1 > j - 1 || pand[i + 1][j - 1] == 1)) {
                    pand[i][j] = 1;
                }

            }
        }

        int len = 0, start = 0, end = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pand[i][j] == 1 && len < (j - i)) {
                    len = j - i;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
