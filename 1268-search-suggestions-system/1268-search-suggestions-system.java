class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        

        for(int i=0;i<searchWord.length();i++){
            String common_prefix = searchWord.substring(0,i+1);
            List<String> suggestions = new ArrayList<>();

            for(String product:products){
                if(product.startsWith(common_prefix)){
                    suggestions.add(product);
                }
                if(suggestions.size()>=3)
                {
                        break;
                }
            }

            result.add(suggestions);
        }

        return result;
    }
}