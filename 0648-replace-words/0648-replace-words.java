class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
       String[] words = sentence.split(" ");
       Set<String> dictSet = new HashSet<>(dictionary);

       for(int i=0;i<words.length;i++){
        words[i] = shortestRoot(words[i], dictSet);
       }

       return String.join(" ", words); //join the array of words separated by a space

    }

    private String shortestRoot(String word, Set<String> dictSet){
        for(int i=1;i<=word.length();i++){
            String root = word.substring(0,i); //form word appending one char at a time
            if(dictSet.contains(root)){ //check if this is present as a root, it will be shortest
                return root; //shortest root is returned for the word
            }
        }

        return word;//return original word
    }
}