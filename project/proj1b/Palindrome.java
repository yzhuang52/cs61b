public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> result = new LinkedListDeque<>();
        for(int i=0;i<word.length();i++){
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word){
        if(word.length()==1 || word.length() == 0){
            return true;
        }
        Deque<Character> temp = wordToDeque(word);
        if(word.length()%2==1){
            while(temp.size()!=1) {
                Character left = temp.removeFirst();
                Character right = temp.removeLast();
                if (left != right) {
                    return false;
                }
            }
            return true;
        }else{
            while(!temp.isEmpty()){
                Character left = temp.removeFirst();
                Character right = temp.removeLast();
                if(left!=right){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length()==1 || word.length() == 0){
            return true;
        }
        Deque<Character> temp = wordToDeque(word);
        if(word.length()%2==1){
            while(temp.size()!=1) {
                Character left = temp.removeFirst();
                Character right = temp.removeLast();
                if (cc.equalChars(left, right)) {
                    return false;
                }
            }
            return true;
        }else{
            while(!temp.isEmpty()){
                Character left = temp.removeFirst();
                Character right = temp.removeLast();
                if(cc.equalChars(left, right)){
                    return false;
                }
            }
            return true;
        }
    }
}
