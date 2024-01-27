package prog42893;

import java.util.*;

/* 매칭 점수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42893
 */

public class MyMain {
    public static void main(String[] args) {
        String[] words = {
                "blind", "Muzi"
        };

        String[][] pageList = {
                { "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>",
                        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>",
                        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>" },
                { "   <html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>",
                        "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>" }

        };

        Solution mSol = new Solution();
        for (int i = 0; i < 2; i++) {
            System.out.println(mSol.solution(words[i], pageList[i]));
        }

    }
}

class Solution {
    public int solution(String word, String[] pages) {
        Page[] pageData = new Page[pages.length];

        for (int i = 0; i < pages.length; i++) {
            pageData[i] = getWordCount(word, pages[i]);
        }

        for (int i = 0; i < pages.length; i++) {
            for (String link : pageData[i].links) {
                for (int a = 0; a < pages.length; a++) {
                    if (pageData[a].myPage.equals(link)) {
                        pageData[a].linkPoint += pageData[i].basicPoint / pageData[i].links.size();
                    }
                }
            }
        }

        int answer = 0;
        Double maxSum = Double.MIN_VALUE;
        for (int i = 0; i < pages.length; i++) {
            if (maxSum < pageData[i].basicPoint + pageData[i].linkPoint) {
                maxSum = pageData[i].basicPoint + pageData[i].linkPoint;
                answer = i;
            }
        }

        // System.out.println(Arrays.toString(pageData));

        return answer;
    }

    Page getWordCount(String word, String page) {

        // System.out.println(page);

        // 단어 뽑기
        String wordpage = page.replaceAll("[^a-zA-Z]", "-");
        StringTokenizer words = new StringTokenizer(wordpage, "-");
        Page mPage = new Page();
        mPage.links = new ArrayList<>();
        while (words.hasMoreTokens()) {
            String wd = words.nextToken();
            if (word.equalsIgnoreCase(wd)) {
                mPage.basicPoint++;
            }
            // System.out.print(words.nextToken() + ",");
        }
        
        // System.out.println("======================");

        page = page.replaceAll(">", ">\n");

        StringTokenizer aa = new StringTokenizer(page, "\n");
        while (aa.hasMoreTokens()) {
            String senten = aa.nextToken();
            // System.out.println(senten);
            if (senten.contains("\"og:url\" content=\"https://")) {
                // System.out.println(senten);
                senten = senten.replaceAll(".*content=\"https://", "").replaceAll(" .*", "").replaceAll("\"/.*", "");
                // System.out.println(" -> " + senten);
                mPage.myPage = senten;
            } else if (senten.contains("a href=\"")) {
                // System.out.println(senten);
                senten = senten.replaceAll(".*href=\"https://", "").replaceAll(" .*", "").replaceAll("\">.*", "");
                senten = senten.replaceAll(" .*", "");
                // System.out.println(" -> " + senten);
                mPage.links.add(senten);
            }
        }
        return mPage;
    }

    class Page {
        String myPage;
        ArrayList<String> links;
        double basicPoint; /* 기본점수는 해당 웹페이지의 텍스트 중, 검색어가 등장하는 횟수 */
        double linkPoint; /* 해당 웹페이지로 링크가 걸린 다른 웹페이지의 기본점수 ÷ 외부 링크 수의 총합 */

        @Override
        public String toString() {
            return "<" + basicPoint + ", " + linkPoint + "> " + myPage + "\n" + links + "\n";
        }
    }
}