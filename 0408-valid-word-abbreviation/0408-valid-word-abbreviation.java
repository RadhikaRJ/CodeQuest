class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPointer = 0, abbrPointer = 0;
        int abbrLen = abbr.length();
        int wordLen = word.length();
        if (abbrLen > wordLen) {
            return false;
        }

        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
        // h i
        // w
        // 2 i
        //

        while (abbrPointer < abbrLen && wordPointer < wordLen) {
            if (word.charAt(wordPointer) == abbr.charAt(abbrPointer)) {
                ++abbrPointer;
                ++wordPointer;
                continue;
            }
            if(abbr.charAt(abbrPointer) <= '0' || abbr.charAt(abbrPointer) > '9'){
                return false;
            }
            if (Character.isDigit(abbr.charAt(abbrPointer))) {
                StringBuilder sb = new StringBuilder();
                while (abbrPointer < abbrLen && Character.isDigit(abbr.charAt(abbrPointer))) {
                    sb.append(abbr.charAt(abbrPointer));
                    abbrPointer++;
                }
                int number = Integer.parseInt(sb.toString());
                wordPointer = wordPointer + number;
                System.out.println(number);
               

            }
           
        }

        
        return wordPointer == wordLen && abbrPointer == abbrLen;

    }
}