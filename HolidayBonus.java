
public class HolidayBonus extends java.lang.Object{
	
	public HolidayBonus() {
		
	}
	
	//Calculates the holiday bonus for each store
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[10];		
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				if(data[i][j]<=0) {
					continue;
				}
				else if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j)==i) {
					bonus[i]+=high;
				}
				else if(TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j)==i) {
					bonus[i]+=low;
				}
				else {
					bonus[i]+=other;
				}
			}
		}
		
		return bonus;
	}
	
	//Calculates the total holiday bonuses
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = new double[10];	
		double total=0;
		
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				if(data[i][j]<=0) {
					continue;
				}
				else if(TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j)==i) {
					bonus[i]+=high;
					total+=high;
				}
				else if(TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j)==i) {
					bonus[i]+=low;
					total+=low;
				}
				else {
					bonus[i]+=other;
					total+=other;
				}
			}
		}
		
		return total;
	}
}
