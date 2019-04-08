/**
 * Solver definition for the 8 Puzzle challenge
 * Construct a tree of board states using A* to find a path to the goal
 */

import java.util.*;

public class Solver {

    public int minMoves = -1;
    private State solutionState;
    private boolean solved = false;
    private State init;
    private List<State> visited = new LinkedList<>();

    /**
     * State class to make the cost calculations simple
     * This class holds a board state and all of its attributes
     */
    private class State {
        // Each state needs to keep track of its cost and the previous state
        private Board board;
        private int moves; // equal to g-cost in A*
        public int cost; // equal to f-cost in A*
        private State prev;

        public State(Board board, int moves, State prev) {
            compy comparator = new compy();
            this.board = board;
            this.moves = moves;
            this.prev = prev;
            // TODO
            cost = board.manhattan() + moves;
            if (prev == null) {
                init = this;
            }
        }

        @Override
        public boolean equals(Object s) {
            if (s == this) return true;
            if (s == null) return false;
            if (!(s instanceof State)) return false;
            return ((State) s).board.equals(this.board);
        }

        private class compy implements Comparator<State> {
            @Override
            public int compare(State lop, State pop) {
                return pop.cost - lop.cost;
            }
        }
    }

    /*
     * Return the root state of a given state
     */
    private State root(State state) {
        // TODO: Your code here
        return init;
    }

    /*
     * A* Solver
     * Find a solution to the initial board using A* to generate the state tree
     * and a identify the shortest path to the the goal state
     */

    public Solver(Board initial) {
        // TODO: Your code here
        solutionState = new State(initial,0,null);
        State.compy vamoos = solutionState.new compy();
        PriorityQueue<State> options = new PriorityQueue(vamoos);
        if(isSolvable()) {
            while (!solutionState.board.isGoal()) {
                for (Board bitch : solutionState.board.neighbors()) {
                    options.add(new State(bitch,solutionState.moves+1,solutionState));
                }
                visited.add(solutionState);
                solutionState = options.poll();
                minMoves+=1;
            }
        }
        if(solutionState.board.isGoal()){
            solved=true;
        }
    }

    /*
     * Is the input board a solvable state
     * Research how to check this without exploring all states
     */
    public boolean isSolvable() {
        // TODO: Your code here
        if(solutionState.board.solvable()){
            return true;
        }
        return false;
    }

    /*
     * Return the sequence of boards in a shortest solution, null if unsolvable
     */
    public Iterable<Board> solution() {
        // TODO: Your code here
        List<Board> steps = new LinkedList<>();
        for (State s: visited){
            steps.add(s.board);
        }
        return steps;
    }

    public State find(Iterable<State> iter, Board b) {
        for (State s : iter) {
            if (s.board.equals(b)) {
                return s;
            }
        }
        return null;
    }

    /*
     * Debugging space
     */
    public static void main(String[] args) {
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        Board initial = new Board(initState);

        Solver solver = new Solver(initial);
    }


}
