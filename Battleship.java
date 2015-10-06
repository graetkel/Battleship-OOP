import java.util.Random;
import java.util.Scanner;

public class Battleship {
    private static int MAX_SHIPS = 5;

    
    
    
    public static void main(String[] args) {
        BattleField playerField = new BattleField(10);
for (int ms = 1; ms <= MAX_SHIPS; ms++) {
        System.out.println("Get ready to place your ships.");
        System.out.println("You get 5 ships pick wisely");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter coordinates for Ship 1:"); 
        String coordinates = keyboard.nextLine();

        Point shipLocation = getPoint(coordinates);
        playerField.addShip(shipLocation.getX(),
            shipLocation.getY());
}
        System.out.println("Player's Field:");
        FieldDisplay playerDisplay = new FieldDisplay(playerField, true);
        playerDisplay.render();

        BattleField computerField = new BattleField(10);
        ShipDistributor.randomlyPlaceShips(computerField);

        System.out.println();
        System.out.println("Computer's Field:");
        boolean showComputerShips = (args.length > 0 && args[0].equals("--show-computer-ships"));
        FieldDisplay computerDisplay = new FieldDisplay(computerField, showComputerShips);
        computerDisplay.render();

    }

    private static Point getPoint(String coordinate) {
        coordinate = coordinate.toUpperCase();

        if (coordinate.length() == 2) {
            char letter = coordinate.charAt(0);
            char number = coordinate.charAt(1);
        
            int x = (letter - 'A');
            int y = Character.getNumericValue(number) - 1;

            return new Point(x, y);
        }
        else {
            return Point.INVALID_POINT;
        }
    }

}
