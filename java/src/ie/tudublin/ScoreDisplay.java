package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	// Note[] notes;
	ArrayList<Note> notes = new ArrayList<Note>();

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
		loadScore();
		printScore();
	}

	public void draw()
	{
		background(255);
		
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


	void drawNotes()
	{

	}
}
