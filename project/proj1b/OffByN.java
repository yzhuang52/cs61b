public class OffByN implements CharacterComparator{

    int allowed;


    public OffByN(int N){
        allowed = N;
    }
    @Override
    public boolean equalChars(char x1, char x2){
        return Math.abs((x1-x2)) == allowed;
    }
}
