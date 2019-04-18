import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


// this is our implementation of a rubiks cube. It is your job to use A* or some other search algorithm to write a
// solve() function
public class RubiksCube {

    private char rot;

    private BitSet cube;

    // initialize a solved rubiks cube
    public RubiksCube() {
        // 24 colors to store, each takes 3 bits
        cube = new BitSet(24 * 3);
        for (int side = 0; side < 6; side++) {
            for (int i = 0; i < 4; i++) {
                setColor(side * 4 + i, side);
            }
        }
    }

    private class State{
        int cost;
        State prev;
        char rot;
        RubiksCube rubie;
        int moves;

        public State(RubiksCube cobe,int moves, State pre) {
            this.cost =cobe. heur() + moves;
            this.prev=pre;
            this.rot= cobe.rot;
            this.rubie=new RubiksCube(cobe);
            this.moves = moves;
        }

        private class comparator implements Comparator<State>{
            @Override
            public int compare(State A, State B){
                return A.cost-B.cost;
            }
        }
    }
    // initialize a rubiks cube with the input bitset
    private RubiksCube(BitSet s) {
        cube = (BitSet) s.clone();
    }

    // creates a copy of the rubics cube
    public RubiksCube(RubiksCube r) {
        cube = (BitSet) r.cube.clone();
    }

    // return true if this rubik's cube is equal to the other rubik's cube
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RubiksCube))
            return false;
        RubiksCube other = (RubiksCube) obj;
        return other.cube.equals(cube);
    }

    public int heur(){
        int huer=0;
        for (int side = 0; side < 6; side++) {
            for (int block = 0; block < 4; block++) {
                int index = side*4+block;
                for (int bit = 0; bit < 3; bit++) {
                    if(side==getColor(index * 3 + bit)){
                        return 0;
                    }
                    huer = Math.abs(side-getColor(index * 3 + bit));
                    if(huer==3){
                        huer+=2;
                    }
                    else{
                        huer+=1;
                    }
                }
            }
        }
        return huer;

    }

    /**
     * return a hashCode for this rubik's cube.
     *
     * Your hashCode must follow this specification:
     *   if A.equals(B), then A.hashCode() == B.hashCode()
     *
     * Note that this does NOT mean:
     *   if A.hashCode() == B.hashCode(), then A.equals(B)
     */
    @Override
    public int hashCode() {
        return cube.hashCode();
    }

    public boolean isSolved() {
        return this.equals(new RubiksCube());
    }


    // takes in 3 bits where bitset.get(0) is the MSB, returns the corresponding int
    private static int bitsetToInt(BitSet s) {
        int i = 0;
        if (s.get(0)) i |= 4;
        if (s.get(1)) i |= 2;
        if (s.get(2)) i |= 1;
        return i;
    }

    // takes in a number 0-5, returns a length-3 bitset, where bitset.get(0) is the MSB
    private static BitSet intToBitset(int i) {
        BitSet s = new BitSet(3);
        if (i % 2 == 1) s.set(2, true);
        i /= 2;
        if (i % 2 == 1) s.set(1, true);
        i /= 2;
        if (i % 2 == 1) s.set(0, true);
        return s;
    }

    // index from 0-23, color from 0-5
    private void setColor(int index, int color) {
        BitSet colorBitset = intToBitset(color);
        for (int i = 0; i < 3; i++)
            cube.set(index * 3 + i, colorBitset.get(i));
    }


    // index from 0-23, returns a number from 0-5
    private int getColor(int index) {
        return bitsetToInt(cube.get(index * 3, (index + 1) * 3));
    }

    // given a list of rotations, return a rubik's cube with the rotations applied
    public RubiksCube rotate(List<Character> c) {
        RubiksCube rub = this;
        for (char r : c) {
            rub = rub.rotate(r);
        }
        return rub;
    }

    // Given a character in ['u', 'U', 'r', 'R', 'f', 'F'], return a new rubik's cube with the rotation applied
    // Do not modify this rubik's cube.
    public RubiksCube rotate(char c) {
        int[] faceFrom = null;
        int[] faceTo = null;
        int[] sidesFrom = null;
        int[] sidesTo = null;
        // colors move from the 'from' variable to the 'to' variable
        rot = c;
        switch (c) {
            case 'u': // clockwise
            case 'U': // counterclockwise
                faceFrom = new int[]{0, 1, 2, 3};
                faceTo = new int[]{1, 2, 3, 0};
                sidesFrom = new int[]{4, 5, 8, 9, 17, 16, 21, 20};
                sidesTo = new int[]{21, 20, 4, 5, 8, 9, 17, 16};
                break;
            case 'r':
            case 'R':
                faceFrom = new int[]{8, 9, 10, 11};
                faceTo = new int[]{9, 10, 11, 8};
                sidesFrom = new int[]{6, 5, 2, 1, 17, 18, 13, 14};
                sidesTo = new int[]{2, 1, 17, 18, 13, 14, 6, 5};
                break;
            case 'f':
            case 'F':
                faceFrom = new int[]{4, 5, 6, 7};
                faceTo = new int[]{5, 6, 7, 4};
                sidesFrom = new int[]{3, 2, 8, 11, 14, 15, 23, 20};
                sidesTo = new int[]{8, 11, 14, 15, 23, 20, 3, 2};
                break;
            default:
                assert false;
        }
        // if performing a counter-clockwise rotation, swap from and to
        if (Character.isUpperCase(c)) {
            int[] temp;
            temp = faceFrom;
            faceFrom = faceTo;
            faceTo = temp;
            temp = sidesFrom;
            sidesFrom = sidesTo;
            sidesTo = temp;
        }
        RubiksCube res = new RubiksCube(cube);
        for (int i = 0; i < faceFrom.length; i++) res.setColor(faceTo[i], this.getColor(faceFrom[i]));
        for (int i = 0; i < sidesFrom.length; i++) res.setColor(sidesTo[i], this.getColor(sidesFrom[i]));
        return res;
    }

    // returns a random scrambled rubik's cube by applying random rotations
    public static RubiksCube scrambledCube(int numTurns) {
        RubiksCube r = new RubiksCube();
        char[] listTurns = getScramble(numTurns);
        for (int i = 0; i < numTurns; i++) {
            r= r.rotate(listTurns[i]);
        }
        return r;
    }

    public static char[] getScramble(int size){
        char[] listTurns = new char[size];
        for (int i = 0; i < size; i++) {
            switch (ThreadLocalRandom.current().nextInt(0, 6)) {
                case 0:
                    listTurns[i] = 'u';
                    break;
                case 1:
                    listTurns[i] = 'U';
                    break;
                case 2:
                    listTurns[i] = 'r';
                    break;
                case 3:
                    listTurns[i] = 'R';
                    break;
                case 4:
                    listTurns[i] = 'f';
                    break;
                case 5:
                    listTurns[i] = 'F';
                    break;
            }
        }
        return listTurns;
    }

    public Iterable<RubiksCube> neighbors(RubiksCube init){
        char[] bleh = {'u','U','r','R','f','F'};
        ArrayList<RubiksCube> fucker = new ArrayList<>();
        for(int i = 0; i<bleh.length;i++){
            RubiksCube temp = new RubiksCube(init);
            temp.rotate(bleh[i]);
            fucker.add(temp);
        }
        return fucker;
    }
    // return the list of rotations needed to solve a rubik's cube
    public List<Character> solve() {
        // TODO
        List <Character> fuck = new ArrayList<>();
        State sol = new State(scrambledCube(10),0,null);
        State.comparator balance = sol.new comparator();
        PriorityQueue<State> options = new PriorityQueue(balance);
        HashMap<State,State> open = new HashMap<>();
        HashMap<State,State> closed = new HashMap<>();
        while (!sol.rubie.isSolved()) {
            if(sol.rubie.isSolved()){
                return fuck;
            }
            for (RubiksCube bitch: neighbors(sol.rubie)) {
                RubiksCube bleh = new RubiksCube(bitch);
                State killa = new State(bleh,sol.moves+1,sol);
                if(open.containsKey(killa)){
                    if(open.get(killa).cost>sol.cost){
                        closed.put(killa,open.get(killa));
                        open.put(killa,killa);
                        options.add(killa);
                        continue;
                    }
                }
                else if(closed.containsKey(killa)){
                    if(closed.get(killa).cost>sol.cost){
                        open.put(killa,killa);
                        options.add(killa);
                        continue;
                    }
                }
                else {
                    open.put(killa, killa);
                    options.add(killa);
                }
            }
            if(options.size()>0) {
                sol = options.poll();
                open.remove(sol);
                closed.put(sol,sol);
            }
        }
        State temp = new State(new RubiksCube(sol.rubie),sol.moves,sol.prev);
        while(temp!=null){
            fuck.add(temp.rot);
            temp=temp.prev;
        }
        return fuck;
    }

}