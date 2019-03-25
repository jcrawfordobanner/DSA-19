package divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    public static class Point {
        public int x;
        public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        List<Point> poe = new ArrayList<>();
        if(B.length==0){
            return new ArrayList<>();
        }
        if(B.length==1){
            poe.add(new Point(B[0].l,B[0].h));
            poe.add(new Point(B[0].r,0));
            return poe;
        }
        List<Point> loosey = skyline(Arrays.copyOfRange(B,0,B.length/2));
        List<Point> goosey = skyline(Arrays.copyOfRange(B,B.length/2,B.length));
        return merge(loosey,goosey);
    }

    public static List<Point> merge(List<Point>loop, List<Point> pull){
        int i = 0;
        int j = 0;
        int high = 0;
        int lelast =0; int rilast=0;
        List<Point> fusionha=new ArrayList<>();
        while(loop.size()>i || j<pull.size()){
            if(j>=pull.size()){
                fusionha.add(loop.get(i));
                i++;
            }
            else if(i>=loop.size()){
                fusionha.add(pull.get(j));
                j++;
            }
            else if(loop.get(i).x>pull.get(j).x){
                if(pull.get(j).y>lelast){
                    high=pull.get(j).y;
                }
                else{
                    high=lelast;
                }
                fusionha.add(new Point(pull.get(j).x,high));
                rilast=pull.get(j).y;
                j++;
            }
            else if(loop.get(i).x<pull.get(j).x){
                if(loop.get(i).y>rilast){
                    high=loop.get(i).y;
                }
                else{
                    high=rilast;
                }
                fusionha.add(new Point(loop.get(i).x,high));
                lelast=loop.get(i).y;
                i++;
            }
            else{
                if(loop.get(i).y>pull.get(j).y){
                    high=loop.get(i).y;
                }
                else{
                    high=pull.get(j).y;
                }
                fusionha.add(new Point(loop.get(i).x,high));
                lelast=loop.get(i).y;
                rilast=pull.get(j).y;
                i++;
                j++;
            }
        }
        for(int k =0; k<fusionha.size();k++){
            while(k+1<fusionha.size() && fusionha.get(k+1).y==fusionha.get(k).y){
                fusionha.remove(k+1);
            }
        }
        return fusionha;
    }
}
