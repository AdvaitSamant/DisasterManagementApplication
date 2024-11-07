package disasterManagement;

import java.util.Scanner;

public class Server {
	public static int dis;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Earthquake \t 2. Tsunami \t 3. Hurricane \t 4. Flood \t 5. Wildfire \t 6. Tornado \t 7. Hailstorm \t 8. Volcanic Eruption \t 9.Landslide \t 10. Avalanche \n Enter The Disaster: ");
		dis = sc.nextInt();
	}

}
