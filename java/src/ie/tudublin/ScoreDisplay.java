package ie.tudublin;

import java.util.ArrayList;
import ddf.minim.*;
import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	// Note[] notes;
	//String score = "dEFGBcdDDF";
	ArrayList<Note> notes = new ArrayList<Note>();
	Minim minim;
	AudioOutput playNote;

	public void settings()
	{
		size(1000, 500);

		
		// // How to convert a character to a number
		// char c = '7'; // c holds the character 7 (55)
		// int i = c - '0'; // i holds the number 7 (55 - 48) 
		// println(i);
	}

	public void setup() 
	{
		minim = new Minim(this);
		playNote = minim.getLineOut();
		loadScore();
		printScore();
		//drawNotes();
	}

	public void draw()
	{
		background(255);
		float border = 0.1f * width;
		int circleSize = 15;
		// Displaying 5 Strave Lines
		stroke(0);
		for (int i = 0; i < 5; i ++)
		{
			float y = map(i, 0, 5, border * 2, height - border);
			line(border, y, width - border, y);
		}
		
		// Displaying Score
		for (int i = 0; i < score.length(); i ++)
		{
			fill(0, 0, 0);
			stroke(0, 0 ,0);
			Note displayString = notes.get(i);
			char displayNote= displayString.getNote();
			float x = map(i, 0, score.length(), border, width - border);
			if ( displayNote != '2')
			{
				text(displayNote, x, height/3);
			}			
		}

		// Displaying and playing Notes
		for (int i = 0; i < score.length(); i ++)
		{
			colorMode(RGB);
			float x = map(i, 0, score.length(), border, width - border) + 10;
			Note displayString = notes.get(i);
			char displayNote = displayString.getNote();
			float y;
			fill(0);
			stroke(0);
			switch(displayNote)
			{
				case 'D':
				{
					
					y = map(1, 0, 10, height - border, border * 2);
					
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "D");
					}

					break;
				}
				case 'E':
				{
					
					y = map(2, 0, 10, height - border, border * 2);

					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "E");
					}

					break;
				}
				case 'F':
				{
					
					y = map(3, 0, 10, height - border, border * 2);

					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "F");
					}
					
					break;
				}
				case 'G':
				{
					y = map(4, 0, 10, height - border, border * 2);
					
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "G");
					}
					
					break;
				}
				case 'A':
				{
					y = map(5, 0, 10, height - border, border * 2);
					
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "A");
					}
					
					break;
				}
				case 'B':
				{
					y = map(6, 0, 10, height - border, border * 2);
					
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, "B");
					}
					
					break;
				}
				case 'c':
				{
					y = map(7, 0, 10, height - border, border * 2);
					
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, 523);
					}
					
					break;
				}
				case 'd':
				{
					y = map(8, 0, 10, height - border, border * 2);
					
					if ( mouseX < x + circleSize && mouseY < y + circleSize &&  mouseX > x - circleSize && mouseY > y - circleSize)
					{
						fill(255, 0, 0);
						stroke(255, 0, 0);
						playNote.playNote(0, 1, 587);
					}
					
					break;
				}
				default:
				{
					y = 0;
				}
			}
			//float y = map(i, 0, 10, height - border, border * 2);
			
				//System.out.println(y);
				if (y != 0)
				{
					circle(x, y, circleSize);
					line(x + circleSize / 2, y, x + circleSize / 2, y - 40);
					line(x + circleSize / 2, y - 40, x + circleSize , y - 20);
				}
				
		}
		
	}

	public void loadScore()
	{
		for (int i = 0; i < score.length(); i++)
		{
			
			char currentNote = score.charAt(i);

			if ( i != score.length() - 1)
			{
				if ( score.charAt(i) == 2)
				{
					notes.add(new Note(currentNote, 2, "Crotchet"));
					//notes.setDuration(2);
					i++;
				}
				else
				{
					notes.add(new Note(currentNote, 1, "Quaver"));
					//notes[i].setNote(currentNote);
					//notes[i].setDuration(1);
				}
			}
			else
			{
				notes.add(new Note(currentNote, 1, "Quaver"));
				//notes[i].setNote(currentNote);
				//notes[i].setDuration(1);
			}
			
		}
	}

	public void printScore()
	{
		for (int i = 0; i < notes.size(); i++)
		{
			System.out.println(notes.get(i));
			//System.out.println(notes[i].getNote() + "	" + notes[i].getDuration() + "	" + notes[i].getType());
		}

	}

}
