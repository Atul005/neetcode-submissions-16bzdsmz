class Solution {
    public boolean makesquare(int[] m) {
        int sum=0;
        for(int i=0;i<m.length;i++){
            sum+=m[i];
        }

        if(sum % 4 != 0){
            return false;
        }
        int side = sum/4;

        Arrays.sort(m);
        reverse(m);
        int[] sides = new int[4];
        return isSquare(0, m, sides, side);
        
    }

    public boolean isSquare(int index, int[] m, int[] sides, int side){
        if(index == m.length){
            return sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side;
        }

        for(int i=0;i<4;i++){
            if(sides[i] + m[index] > side){
                continue;
            }

            sides[i] = sides[i] + m[index];

            if(isSquare(index+1, m, sides, side)){
                return true;
            }
            sides[i] = sides[i] - m[index];
        }
        return false;        
    }

    public void reverse(int[] m){
        for(int i=0;i<m.length/2;i++){
            int temp = m[i];
            m[i] = m[m.length - i -1];
            m[m.length -i - 1] = temp;
        }
    }

}