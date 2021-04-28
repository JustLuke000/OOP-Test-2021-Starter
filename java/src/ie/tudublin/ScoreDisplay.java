package ie.tudublin;

import java.util.ArrayList;
import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	//String score = "FAcEDEcEDEcDdcbAFAcEd"; // This is a little song I wrote (just now in two seconds)
	//String score = "dEFGBcdDDF";

	ArrayList<Note> notes = new ArrayList<Note>();
	Minim minim;
	AudioOutput playNote;

	public void settings()
	{
		size(1000, 500);
	}

	public void setup() 
	{
		minim = new Minim(this);
		playNote = minim.getLineOut();
		loadScore();
		printScore();

	}

	// Method: Draw
	// Illustrates:
	// 		Strave Lines
	// 		Note Symbols i.e (F)
	// 		Notes (Including Turning Red when hovered)
	public void draw()
	{
		background(255);
		float border = 0.1f * width;
		int circleSize = 15;
		stroke(0);

		// Displaying 5 Strave Lines
		for (int i = 0; i < 5; i ++)
		{
			float y = map(i, 0, 5, border * 2, height - border); 			// Plotting the lines equal distance apart (y)
			line(border, y, width - border, y);

		} 	// End if
		
		// Displaying Score
		for (int i = 0; i < score.length(); i ++)
		{
			fill(0, 0, 0);
			stroke(0, 0 ,0);

			Note displayString = notes.get(i);									// Reading Note Class from ArrayList
			char displayNote= displayString.getNote();							// Reading Note from Note Class
			float x = map(i, 0, score.length(), border, width - border);		// Plotting the Notes equal distance apart (x)

			if ( displayNote != '2')
			{
				text(displayNote, x, height/3);
			}	// End If		
		}// End For

		// Displaying and playing Notes
		for (int i = 0; i < score.length(); i ++)
		{
			colorMode(RGB);
			float x = map(i, 0, score.length(), border, width - border) + 10; 	// Spacing the Notes equal distance apart (x)
			Note displayString = notes.get(i); 									// Reading Note Class from ArrayList
			char displayNote = displayString.getNote(); 						// Reading Note from Note Class

			float y;
			fill(0);
			stroke(0);

			// Allocate each note to is respective position (y)
			switch(displayNote)
			{
				case 'D':
				{
					
					y = map(1, 0, 10, height - border, border * 2);
					
					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "D");
					}// End If

					break;
				}// End case "D"
				case 'E':
				{
					
					y = map(2, 0, 10, height - border, border * 2);

					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "E");
					}// End If

					break;
				}// End case "E"
				case 'F':
				{
					
					y = map(3, 0, 10, height - border, border * 2);

					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "F");
					}// End If
					
					break;
				}// End case "F"
				case 'G':
				{
					y = map(4, 0, 10, height - border, border * 2);
					
					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "G");
					}// End If
					
					break;
				}// End case "G"
				case 'A':
				{
					y = map(5, 0, 10, height - border, border * 2);
					
					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "A");
					}// End If
					
					break;
				}// End case "A"
				case 'B':
				{
					y = map(6, 0, 10, height - border, border * 2);
					
					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "B");
					}// End If
					
					break;
				}// End case "B"
				case 'c':
				{
					y = map(7, 0, 10, height - border, border * 2);
					
					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, 523);
					}// End If
					
					break;
				}// End case "c"
				case 'd':
				{
					y = map(8, 0, 10, height - border, border * 2);
					
					// If Statement: When Mouse is hovering over Circle/Note
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, 587);
					} // End If
					
					break;
				} // End case "d"
				default:
				{
					y = 0;
				}	// End Default
			}		// End Switch

			if (y != 0)
			{
				circle(x, y, circleSize);
				line(x + circleSize / 2, y, x + circleSize / 2, y - 40);
				line(x + circleSize / 2, y - 40, x + circleSize , y - 20);
			} 	// End If
		} 		// End For
	}// End Method: Draw

	// To Load score into Note ArrayList
	public void loadScore()
	{
		// For Loop to irerate through each note (Note notes)
		for (int i = 0; i < score.length(); i++)
		{
			int skipper = 0;
			char currentNote = score.charAt(i);
			if ( i != score.length() - 1)
			{
				if ( score.charAt(i + 1) == 2) 								// If the note is played Twice -- I am aware it should be (50) or '2', but this crashed the program
				{
					notes.add(new Note(currentNote, 2, "Crotchet"));		// Creates Note (with respective Characteristics) and is added to Array List
					skipper++;												// Skips past "2" -- x2 Duration
				} 															// End Inner If
				else
				{
					notes.add(new Note(currentNote, 1, "Quaver"));			// Creates Note (with respective Characteristics) and is added to Array List
				} 															// End Inner Else
				
			} 																// End If
			else
			{
				notes.add(new Note(currentNote, 1, "Quaver"));				// Creates Note (with respective Characteristics) and is added to Array List
			} 																// End Else

			if ( skipper == 1)
			{
				i = i + 1;
			}
		}	 																// End For
	}// End Method: loadScore()

	public void printScore()
	{
		for (int i = 0; i < notes.size(); i++)
		{
			System.out.println(notes.get(i));
		}// End For

	}// End Method: printScore

}// End Class: ScoreDisplay