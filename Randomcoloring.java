/* program to print color randomly
till the boundry is reached
*/


//importing header files
import java.awt.*;
import java.util.*;

public class Randomcoloring
{
	/*Canvas width and Hieght*/
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;

	/* x and y represent the current panelpixel location
	color represent the current color
	Since they are class variables, they can be accessed from
	any method in this class
	*/

	//setting value of x and y as half to get middle point initial point
	public static int x = 150;
	public static int y = 150;
	public static Color color;

	//this method update color randomly independent of everything

	public static void updateColor(){
		Random rand = new Random();
		color = new Color( rand.nextInt(200), rand.nextInt(150),rand.nextInt(175));
	}

	public static void main(String[] args) {

		//to get random value which decide position
		Random rand_position = new Random();

		//to store the number of moves
		int moves = 0;

		//to store the number of pixels having valid color (other than white)
		int count = 0;

		//new panel
		DrawingPanel canvas = new DrawingPanel(WIDTH , HEIGHT);

		//condition decides the loop termination
		//true if x and y less than boundary condition
		Boolean condition = true;

		//required while loop
		while( condition )
		{
			//update the current color
			updateColor();

			//check if the pixel is already colored
			//if colored the count is decremented as we are recoloring it
			if( canvas.getPixel( x, y).equals(new Color( 255, 255, 255)) == false){

				//increment count
				count = count - 1;

			}


			// set the canvas with color
			canvas.setPixel( x , y , color);

			//check if color is white. If not increment the cunt
			if( canvas.getPixel( x, y).equals(new Color( 255, 255, 255)) == false){

				//increment count
				count = count + 1;

			}

			/* To find the next position we find a random value betweem
			0 - 3. The next position is decided accoding to the value of this
			ie.., left if value is 0, right if 1, top if 2 and bottom is 3.
			*/

			int position_value_decider = rand_position.nextInt(4);

			//set next position as left if 0
			if( position_value_decider == 0)
			{
				//x changes and becomes x-1
				//y remains the same
				x = x - 1;
			}
			//right if 1
			else if( position_value_decider == 1)
			{
				//x changes and becomes x+1
				//y remains the same
				x = x + 1;
			}
			//top if 2
			else if( position_value_decider == 2)
			{
				//y changes and becomes y+1
				//x remains the same
				y = y + 1;
			}
			//buttom if 3
			else if( position_value_decider == 3)
			{
				//y changes and becomes y-1
				//x remains the same
				y = y - 1;
			}

			//Check for termination condition

			if( x >= 300 || y >= 300 || x < 0 || y < 0 )
			{
				condition = false;
				
			}
			//otherwise increment the moves by one
			else
				moves = moves + 1;

			//sleep for 5 millisecond to see draw with human eye
			//canvas.sleep(1);
		}

		// Calculate and Printing the percentage
		//perentage = (count *100 )/ total number of pixels = 300*300 =90000
		double percentage = (count *100) / 90000;
		/* print using printf

		System.out.printf("%d percent of canvas is colored\n", percentage);

		printing number of moves
		System.out.printf("Drawing Completed in %d moves\n",moves);	 */

		//printing using println

		System.out.println(percentage +" percent of canvas is colored");

		//printing number of moves
		System.out.println("Drawing Completed in " + moves + "moves");	

		

	}


}
