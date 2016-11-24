package Medium;

/**
 * Created by Jokeria on 2016/11/22.
 */
public class BurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int count = n;
        for(int i = 1; i < n; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(points[j][0] == 0 && points[j][1] == 0) {
                    continue;
                }
                if(isCoincide(points[i], points[j])) {
                    points[j][0] = Math.max(points[i][0], points[j][0]);
                    points[j][1] = Math.min(points[i][1], points[j][1]);
                    points[i][0] = 0;
                    points[i][1] = 0;
                    count--;
                    break;
                }
            }
        }

        return count;
    }

    public boolean isCoincide(int[] a, int[] b) {
        return (Math.max(a[1], b[1]) - Math.min(a[0], b[0])) <= (a[1] - a[0] + b[1] - b[0]);
    }

    public static void main(String[] args) {
        BurstBalloons instance = new BurstBalloons();
        int[][] balloons = {{9,17},{4,12},{4,8},{4,8},{7,13},{3,4},{7,12},{9,15}};
        int res = instance.findMinArrowShots(balloons);
        System.out.println(res);
    }
}
