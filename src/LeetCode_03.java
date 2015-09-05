import java.util.HashMap;
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
public class LeetCode_03 {
       public int maxPoints(Point[] points)
       {
    	   int maxP=0;
    	   int curMaxP=0;
    	   int parallelYP=0;
    	   int parallelXP=0;
    	   int sameP=0;
    	   HashMap<Double,Integer> kp=new HashMap<Double,Integer>();
    	   for (int i=0;i<points.length;i++)
    	   {
    		   curMaxP=0;
    		   parallelYP=0;
    		   parallelXP=0;
    		   sameP=1;
    		   kp.clear();
    		   for(int j=i+1;j<points.length;j++)
    		   {
    			   if(points[i].x==points[j].x && points[i].y==points[j].y)
    				    sameP++;
    			   else if(points[i].x==points[j].x)
    				   parallelYP++;
    			   else if(points[i].y==points[j].y)
    				   parallelXP++;
    			   else
    			   {
    				   double k=(double)((points[i].y-points[j].y))/(points[i].x-points[j].x);
    				   if(kp.containsKey(k))
    					    kp.put(k, kp.get(k)+1);
    				   else
    					   kp.put(k, 1);
    			   }
    		   }
    		   curMaxP=parallelYP;
    		   if(parallelXP>parallelYP)
    			   curMaxP=parallelXP;
    		   for(double key:kp.keySet())
    		   {
    			   if(kp.get(key)>curMaxP)
    				   curMaxP=kp.get(key);
    		   }
    		   if(curMaxP+sameP>maxP)
    			   maxP=curMaxP+sameP;
    	   }
    	   return maxP;
       }
       public static void main(String[] args)
       {
    	   Point[] p={new Point(2,3),new Point(3,3),new Point(-5,3)};
    	   System.out.println(new LeetCode_03().maxPoints(p));
       }
}
