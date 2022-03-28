public class OffByOne implements CharacterComparator{

    @Override
    public boolean equalChars(char x1, char x2){
        return Math.abs((x1-x2))==1;
    }



}
